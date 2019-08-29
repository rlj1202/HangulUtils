package redlaboratory.hangulutils;

public class HangulHelper {

    public static final int UNICODE_HANGUL_JAMO_BASE = 0x1100;
	public static final int UNICODE_HANGUL_COMPATIBILITY_JAMO_BASE = 0x3131;
	public static final int UNICODE_HANGUL_SYLLABLES_BASE = 0xAC00;

	public static final char[] UNICODE_HANGUL_COMPATIBILITY_JAMO_LIST = { // 52 elements
			// 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ',
			// 'ㅃ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ', 'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ',
			// 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ', 'ㅤ',
			'\u3131', '\u3132', '\u3133', '\u3134', '\u3135', '\u3136', '\u3137', '\u3138', '\u3139', '\u313a',
			'\u313b', '\u313c', '\u313d', '\u313e', '\u313f', '\u3140', '\u3141', '\u3142', '\u3143', '\u3144',
			'\u3145', '\u3146', '\u3147', '\u3148', '\u3149', '\u314a', '\u314b', '\u314c', '\u314d', '\u314e',
			'\u314f', '\u3150', '\u3151', '\u3152', '\u3153', '\u3154', '\u3155', '\u3156', '\u3157', '\u3158',
			'\u3159', '\u315a', '\u315b', '\u315c', '\u315d', '\u315e', '\u315f', '\u3160', '\u3161', '\u3162',
			'\u3163', '\u3164',
	};

	public static final char[] HANGUL_CONSONANTS = { // 19 elements
			// 'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ',
			// 'ㅎ',
			'\u3131', '\u3132', '\u3134', '\u3137', '\u3138', '\u3139', '\u3141', '\u3142', '\u3143', '\u3145',
			'\u3146', '\u3147', '\u3148', '\u3149', '\u314a', '\u314b', '\u314c', '\u314d', '\u314e',
	};
	public static final char[] HANGUL_VOWELS = { // 21 elements
			// 'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ',
			// 'ㅡ', 'ㅢ', 'ㅣ',
			'\u314f', '\u3150', '\u3151', '\u3152', '\u3153', '\u3154', '\u3155', '\u3156', '\u3157', '\u3158',
			'\u3159', '\u315a', '\u315b', '\u315c', '\u315d', '\u315e', '\u315f', '\u3160', '\u3161', '\u3162',
			'\u3163',
	};
	public static final char[] HANGUL_FINAL_CONSONANTS = { // 28 elements
			// 'ㅤ', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ',
			// 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ',
			'\u3164', '\u3131', '\u3132', '\u3133', '\u3134', '\u3135', '\u3136', '\u3137', '\u3139', '\u313a',
			'\u313b', '\u313c', '\u313d', '\u313e', '\u313f', '\u3140', '\u3141', '\u3142', '\u3144', '\u3145',
			'\u3146', '\u3147', '\u3148', '\u314a', '\u314b', '\u314c', '\u314d', '\u314e',
	};

	public static final char HANGUL_FILLER = '\u3164'; // represents empty jamo

	private static final char[][] LATIN_IDX_TO_HANGUL_JAMO = { // 2 * 26 elements
			// {
			//		'ㅁ', 'ㅠ', 'ㅊ', 'ㅇ', 'ㄷ', 'ㄹ', 'ㅎ', 'ㅗ', 'ㅑ', 'ㅓ', 'ㅏ', 'ㅣ', 'ㅡ', 'ㅜ', 'ㅐ', 'ㅔ',
			//		'ㅂ', 'ㄱ', 'ㄴ', 'ㅅ', 'ㅕ', 'ㅍ', 'ㅈ', 'ㅌ', 'ㅛ', 'ㅋ',
			// },
			// {
			// 		'ㅁ', 'ㅠ', 'ㅊ', 'ㅇ', 'ㄸ', 'ㄹ', 'ㅎ', 'ㅗ', 'ㅑ', 'ㅓ', 'ㅏ', 'ㅣ', 'ㅡ', 'ㅜ', 'ㅒ', 'ㅖ',
			// 		'ㅃ', 'ㄲ', 'ㄴ', 'ㅆ', 'ㅕ', 'ㅍ', 'ㅉ', 'ㅌ', 'ㅛ', 'ㅋ',
			// },
			{
					'\u3141', '\u3160', '\u314A', '\u3147', '\u3137', '\u3139', '\u314E', '\u3157', '\u3151', '\u3153',
					'\u314F', '\u3163', '\u3161', '\u315C', '\u3150', '\u3154', '\u3142', '\u3131', '\u3134', '\u3145',
					'\u3155', '\u314D', '\u3148', '\u314C', '\u315B', '\u314B',
			},
			{
					'\u3141', '\u3160', '\u314A', '\u3147', '\u3138', '\u3139', '\u314E', '\u3157', '\u3151', '\u3153',
					'\u314F', '\u3163', '\u3161', '\u315C', '\u3152', '\u3156', '\u3143', '\u3132', '\u3134', '\u3146',
					'\u3155', '\u314D', '\u3149', '\u314C', '\u315B', '\u314B',
			},
	};

	private static final int[] JAMO_IDX_TO_CONSONANT_IDX = {
			 0,  1, -1,  2, -1, -1,  3,  4,  5, -1, -1, -1, -1, -1, -1, -1,  6,  7,
			 8, -1,  9, 10, 11, 12, 13, 14, 15, 16, 17, 18, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
	};
	private static final int[] JAMO_IDX_TO_VOWEL_IDX = {
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0,  1,  2,  3,  4,  5,
			 6,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, -1,
	};
	private static final int[] JAMO_IDX_TO_FINAL_CONSONANT_IDX = {
			 1,  2,  3,  4,  5,  6,  7, -1,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17,
			-1, 18, 19, 20, 21, 22, -1, 23, 24, 25, 26, 27, -1, -1, -1, -1, -1, -1,
			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0,
	};

	public static final char[] MULTI_VOWER_JAMO = {
			// 'ㅗ', 'ㅏ', 'ㅘ',
			// 'ㅗ', 'ㅐ', 'ㅙ',
			// 'ㅗ', 'ㅣ', 'ㅚ',
			// 'ㅜ', 'ㅓ', 'ㅝ',
			// 'ㅜ', 'ㅔ', 'ㅞ',
			// 'ㅜ', 'ㅣ', 'ㅟ',
			// 'ㅡ', 'ㅣ', 'ㅢ',
			'\u3157', '\u314f', '\u3158',
			'\u3157', '\u3150', '\u3159',
			'\u3157', '\u3163', '\u315a',
			'\u315c', '\u3153', '\u315d',
			'\u315c', '\u3154', '\u315e',
			'\u315c', '\u3163', '\u315f',
			'\u3161', '\u3163', '\u3162',
	};
	public static final char[] MULTI_FINAL_CONSONANT_JAMO = {
			// 'ㄱ', 'ㅅ', 'ㄳ',
			// 'ㄴ', 'ㅈ', 'ㄵ',
			// 'ㄴ', 'ㅎ', 'ㄶ',
			// 'ㄹ', 'ㄱ', 'ㄺ',
			// 'ㄹ', 'ㅁ', 'ㄻ',
			// 'ㄹ', 'ㅂ', 'ㄼ',
			// 'ㄹ', 'ㅅ', 'ㄽ',
			// 'ㄹ', 'ㅌ', 'ㄾ',
			// 'ㄹ', 'ㅍ', 'ㄿ',
			// 'ㄹ', 'ㅎ', 'ㅀ',
			// 'ㅂ', 'ㅅ', 'ㅄ',
			'\u3131', '\u3145', '\u3133',
			'\u3134', '\u3148', '\u3135',
			'\u3134', '\u314e', '\u3136',
			'\u3139', '\u3131', '\u313a',
			'\u3139', '\u3141', '\u313b',
			'\u3139', '\u3142', '\u313c',
			'\u3139', '\u3145', '\u313d',
			'\u3139', '\u314c', '\u313e',
			'\u3139', '\u314d', '\u313f',
			'\u3139', '\u314e', '\u3140',
			'\u3142', '\u3145', '\u3144',
	};

	private HangulHelper() { }

	/**
	 * Convert latin character to korean character
	 *
	 * @param latin it should be latin character
	 * @return corresponding korean character
	 */
	public static char convertToHangulJamo(char latin) {
		if (isLatinLower(latin)) {
			return LATIN_IDX_TO_HANGUL_JAMO[0][latin - 'a'];
		} else {
		    return LATIN_IDX_TO_HANGUL_JAMO[1][latin - 'A'];
		}
	}

	public static boolean isLatinLower(char c) {
		return 'a' <= c && c <= 'z';
	}

	public static boolean isLatinUpper(char c) {
		return 'A' <= c && c <= 'Z';
	}

	public static boolean isLatinLetter(char c) {
		return isLatinLower(c) || isLatinUpper(c);
	}

	public static boolean isHangulSyllable(char c) {
		return UNICODE_HANGUL_SYLLABLES_BASE <= c && c <= 0xD7AF;
	}

	public static boolean isHangulJamo(char c) {
		//return UNICODE_HANGUL_COMPATIBILITY_JAMO_BASE <= c && c <= 0x318E;
		return isConsonantJamo(c) || isVowelJamo(c) || isFinalConsonantJamo(c);
	}

	public static int getConsonantIndex(char jamo) {
		int idx = jamo - UNICODE_HANGUL_COMPATIBILITY_JAMO_BASE;
		if (idx < 0 || 52 <= idx) return -1;
		return JAMO_IDX_TO_CONSONANT_IDX[idx];
	}

	public static int getVowelIndex(char jamo) {
		int idx = jamo - UNICODE_HANGUL_COMPATIBILITY_JAMO_BASE;
		if (idx < 0 || 52 <= idx) return -1;
		return JAMO_IDX_TO_VOWEL_IDX[idx];
	}

	public static int getFinalConsonantIndex(char jamo) {
		int idx = jamo - UNICODE_HANGUL_COMPATIBILITY_JAMO_BASE;
		if (idx < 0 || 52 <= idx) return -1;
		return JAMO_IDX_TO_FINAL_CONSONANT_IDX[idx];
	}

	public static boolean isConsonantJamo(char c) {
		return getConsonantIndex(c) != -1;
	}

	public static boolean isVowelJamo(char c) {
		return getVowelIndex(c) != -1;
	}

	public static boolean isFinalConsonantJamo(char c) {
		return getFinalConsonantIndex(c) != -1;
	}

	/**
	 * Split korean character into three parts.
	 *
	 * <h1>How it works</h1>
	 * <p>
	 *     Let's say f, m, l as consonant, vowel, final consonant indices.
	 *     For example, f, m, l indices of '한' are 18, 0, 4 in zero-base.
	 *     Now we can calculate offset index of combined korean character.
	 *     Formula for calculate offset index is :
	 * </p>
	 * <p>
	 *     <code>offset = (f * 21 * 28) + (m * 28) + (l) = ((f * 21) + m) * 28 + l</code>
	 * </p>
	 * <p>
	 *     in which, 21 is the number of vowels and 28 is the number of final consonants.
	 *     By this fact, we can easily get each index by dividing offset by some constant,
	 *     21 * 28 = 588 for consonant and 28 for vowel.
	 * </p>
	 *
	 * @param c a korean character
	 * @return split korean characters
	 */
	public static char[] splitHangul(char c) {
		int offset = c - 0xAC00;

		int consonantIdx = offset / 588;
		int vowelIdx = (offset - (588 * consonantIdx)) / 28;
		int finalConsonantIdx = offset - (588 * consonantIdx) - (28 * vowelIdx);

		return new char[] {
				HANGUL_CONSONANTS[consonantIdx],
				HANGUL_VOWELS[vowelIdx],
				HANGUL_FINAL_CONSONANTS[finalConsonantIdx],
		};
	}

	/**
	 * Combine three korean characters, consonant, vowel, final consonant into complete form.
	 *
	 * @param chars split korean characters
	 * @return combined korean character
	 */
	public static char combineHanguls(char[] chars) {
		if (chars[0] != HANGUL_FILLER && chars[1] == HANGUL_FILLER && chars[2] == HANGUL_FILLER) return chars[0];
		if (chars[0] == HANGUL_FILLER && chars[1] != HANGUL_FILLER && chars[2] == HANGUL_FILLER) return chars[1];
		if (chars[0] == HANGUL_FILLER && chars[1] == HANGUL_FILLER && chars[2] != HANGUL_FILLER) return chars[2];

		int f = getConsonantIndex(chars[0]);
		int m = getVowelIndex(chars[1]);
		int l = getFinalConsonantIndex(chars[2]);

		if (f == -1) f = 0;
		if (m == -1) m = 0;
		if (l == -1) l = 0;

		char c = (char) (UNICODE_HANGUL_SYLLABLES_BASE + (((f * 21) + m) * 28 + l));

		return c;
	}

	public static boolean isEmpty(char[] chars) {
		if (chars == null) return true;
		if (chars[0] == HANGUL_FILLER && chars[1] == HANGUL_FILLER && chars[2] == HANGUL_FILLER) return true;

		return false;
	}

	public static char[] splitVowelJamo(char c) {
		for (int i = 0; i < MULTI_VOWER_JAMO.length / 3; i++) {
			if (MULTI_VOWER_JAMO[i * 3 + 2] == c)
				return new char[] { MULTI_VOWER_JAMO[i * 3], MULTI_VOWER_JAMO[i * 3 + 1] };
		}

		return new char[] { HANGUL_FILLER, c };
	}

	public static char[] splitFinalConsonantJamo(char c) {
		for (int i = 0; i < MULTI_FINAL_CONSONANT_JAMO.length / 3; i++) {
			if (MULTI_FINAL_CONSONANT_JAMO[i * 3 + 2] == c)
				return new char[] { MULTI_FINAL_CONSONANT_JAMO[i * 3], MULTI_FINAL_CONSONANT_JAMO[i * 3 + 1] };
		}

		return new char[] { HANGUL_FILLER, c };
	}

	public static char combineVowelJamo(char a, char b) {
		for (int m = 0; m < MULTI_VOWER_JAMO.length / 3; m++) {
			if (MULTI_VOWER_JAMO[m * 3] == a && MULTI_VOWER_JAMO[m * 3 + 1] == b)
				return MULTI_VOWER_JAMO[m * 3 + 2];
		}

		return HANGUL_FILLER;
	}

	public static char combineFinalConsonantJamo(char a, char b) {
		for (int m = 0; m < MULTI_FINAL_CONSONANT_JAMO.length / 3; m++) {
			if (MULTI_FINAL_CONSONANT_JAMO[m * 3] == a && MULTI_FINAL_CONSONANT_JAMO[m * 3 + 1] == b)
				return MULTI_FINAL_CONSONANT_JAMO[m * 3 + 2];
		}

		return HANGUL_FILLER;
	}

}
