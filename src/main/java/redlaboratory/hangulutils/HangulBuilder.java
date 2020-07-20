package redlaboratory.hangulutils;

import static redlaboratory.hangulutils.HangulHelper.*;

public class HangulBuilder {

    public class Result {

        public boolean flagUpdate;
        public boolean flagAdd;
        public char updatedLetter;
        public char addedLetter;

        public Result() {
            flagUpdate = false;
            flagAdd = false;
        }

        public Result(char updatedLetter, char addedLetter) {
            this.updatedLetter = updatedLetter;
            this.addedLetter = addedLetter;

            this.flagUpdate = updatedLetter != HANGUL_FILLER;
            this.flagAdd = addedLetter != HANGUL_FILLER;
        }

        @Override
        public String toString() {
            return "Result{flagUpdate: " + flagUpdate
                    + ", flagAdd: " + flagAdd
                    + ", updatedLetter: " + updatedLetter
                    + ", addedLetter: " + addedLetter
                    + "}";
        }

    }

    // states
    private char[] jamos;

    private boolean flagHangul;
    private boolean flagCombine;

    public HangulBuilder() {
        init();
    }

    public void init() {
        clearStates();
        flagHangul = false;
    }

    public void clearStates() {
        clearJamos();
        flagCombine = false;
    }

    public void clearJamos() {
        jamos = new char[] {HANGUL_FILLER, HANGUL_FILLER, HANGUL_FILLER};
    }

    public void toggleHangulMode() {
        flagHangul = !flagHangul;
    }

    /**
     * Returns whether build is on hangul mode or not
     *
     * <p>
     *     On hangul mode, builder regards latin strokes as hangul jamo strokes.
     * </p>
     *
     * @return flagHangul
     */
    public boolean isHangulMode() {
        return flagHangul;
    }

    /**
     * Returns hangul characters builder currently builds
     * @return
     */
    public char[] getBufferChars() {
        return jamos;
    }

    /**
     * Receives stroke and builds characters
     * @param c stroke character
     * @return Result
     */
    public Result add(char c) {
        if (!isLatinLetter(c) && !isHangulJamo(c)) {
            flagCombine = false;

            return new Result(HANGUL_FILLER, c);
        }

        if (isLatinLetter(c) && !flagHangul) { // regards latin strokes as hangul jamo strokes in hangul mode

            return new Result(HANGUL_FILLER, c);
        }

        char jamo = isHangulJamo(c) ? c : convertToHangulJamo(c);

        if (!flagCombine) {
            flagCombine = true;

            clearJamos();
            if (isConsonantJamo(jamo)) jamos[0] = jamo;
            else if (isVowelJamo(jamo)) jamos[1] = jamo;

            return new Result(HANGUL_FILLER, jamo);
        }

        // attempt to combine

        if (jamos[0] != HANGUL_FILLER && jamos[1] == HANGUL_FILLER && jamos[2] == HANGUL_FILLER) {
            if (isVowelJamo(jamo)) {
                jamos[1] = jamo;
                return new Result(combineHanguls(jamos), HANGUL_FILLER);
            }
        }

        if (jamos[1] != HANGUL_FILLER && jamos[2] == HANGUL_FILLER) {
            char combined;

            if (isVowelJamo(jamo) && (combined = combineVowelJamo(jamos[1], jamo)) != HANGUL_FILLER) {
                jamos[1] = combined;
                return new Result(combineHanguls(jamos), HANGUL_FILLER);
            }
        }

        if (jamos[0] != HANGUL_FILLER && jamos[1] != HANGUL_FILLER && jamos[2] == HANGUL_FILLER) {
            if (isConsonantJamo(jamo)) {
                jamos[2] = jamo;
                return new Result(combineHanguls(jamos), HANGUL_FILLER);
            }
        }

        if (jamos[0] != HANGUL_FILLER && jamos[1] != HANGUL_FILLER && jamos[2] != HANGUL_FILLER) {
            char combined;

            if (isConsonantJamo(jamo) && (combined = combineFinalConsonantJamo(jamos[2], jamo)) != HANGUL_FILLER) {
                jamos[2] = combined;
                return new Result(combineHanguls(jamos), HANGUL_FILLER);
            } else if (isVowelJamo(jamo)) {
                char[] finalConsonants = splitFinalConsonantJamo(jamos[2]);

                jamos[2] = finalConsonants[0];
                char[] newJamos = {finalConsonants[1], jamo, HANGUL_FILLER};

                Result result = new Result(combineHanguls(jamos), combineHanguls(newJamos));

                jamos = newJamos;

                return result;
            }
        }

        clearJamos();
        if (isConsonantJamo(jamo)) jamos[0] = jamo;
        else if (isVowelJamo(jamo)) jamos[1] = jamo;

        return new Result(HANGUL_FILLER, jamo);
    }

    /**
     * Performs backspace function
     * @return Result
     */
    public Result remove() {
        if (flagCombine) {
            if (jamos[2] != HANGUL_FILLER) {
                char[] finalConsonants = splitFinalConsonantJamo(jamos[2]);
                jamos[2] = finalConsonants[0];

                return new Result(combineHanguls(jamos), HANGUL_FILLER);
            } else if (jamos[1] != HANGUL_FILLER) {
                char[] vowels = splitVowelJamo(jamos[1]);

                if (jamos[0] != HANGUL_FILLER || vowels[0] != HANGUL_FILLER) {
                    jamos[1] = vowels[0];

                    return new Result(combineHanguls(jamos), HANGUL_FILLER);
                }
            }
        }

        flagCombine = false;

        return new Result();
    }

}
