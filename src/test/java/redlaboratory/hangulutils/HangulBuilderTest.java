package redlaboratory.hangulutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static redlaboratory.hangulutils.HangulHelper.*;
import static org.junit.Assert.*;

public class HangulBuilderTest {

    @Test
    public void test() {
        Logger logger = LogManager.getLogger("HangulBuilderTest");

        HangulBuilder hangulBuilder = new HangulBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        final char REMOVE = HANGUL_FILLER;
        final char TOGGLE = '\u3130';

        char[] strokes = {
                'ㅇ', 'ㅏ', 'ㄴ',
                'ㄴ', 'ㅕ', 'ㅇ',
                'ㅎ', 'ㅏ',
                'ㅅ', 'ㅔ',
                'ㅇ', 'ㅛ',
                ',', ' ',
                'ㅂ', 'ㅜ', 'ㅔ', 'ㄹ', 'ㄱ',
                'ㅂ', 'ㅏ', 'ㅇ', REMOVE, 'ㄴ',
                'ㄱ', 'ㅗ', 'ㅏ', REMOVE, REMOVE, 'ㅏ',
                REMOVE, REMOVE, REMOVE, REMOVE,
                'ㅎ', 'ㅔ', 'ㅇ', 'ㅣ',
                TOGGLE,
                'h', 'e', 'y', REMOVE, 'l', 'l', 'o', '!',
        };

        hangulBuilder.toggleHangulMode();

        assertTrue(hangulBuilder.isHangulMode());

        for (char stroke : strokes) {
            if (stroke == TOGGLE) {
                hangulBuilder.toggleHangulMode();
                hangulBuilder.clearStates();
                continue;
            }

            HangulBuilder.Result result;
            if (stroke != REMOVE) result = hangulBuilder.add(stroke);
            else result = hangulBuilder.remove();

            if (result.flagUpdate) {
                stringBuffer.setCharAt(stringBuffer.length() - 1, result.updatedLetter);
            }
            if (result.flagAdd) {
                stringBuffer.append(result.addedLetter);
            }
            if (!result.flagUpdate && !result.flagAdd) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }

            logger.info("current text : " + stringBuffer.toString());
        }
    }

}
