package redlaboratory.koreancore;

public class KoreanCore {

	private static boolean koreanMode;
	private static boolean combiningMode;
	
	private static char[] canBeConvertedToKorean;
	private static char[] canBeConvertedToEnglish;

	private static char[] firstChar;
	private static char[] middleChar;
	private static char[] lastChar;

	private static char[] multiMiddleChar;
	private static char[] multiLastChar;

	static {
		koreanMode = false;
		combiningMode = false;
		
		canBeConvertedToKorean = new char[] {
				'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
				'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
				'z', 'x', 'c', 'v', 'b', 'n', 'm',

				'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
				'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L',
				'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
//		canBeConvertedToEnglish = new char[] {
//				'げ', 'じ', 'ぇ', 'ぁ', 'さ', 'に', 'づ', 'ち', 'だ', 'つ',
//				'け', 'い', 'し', 'ぉ', 'ぞ', 'で', 'っ', 'た', 'び',
//				'せ', 'ぜ', 'ず', 'そ', 'ば', 'ぬ', 'ぱ',
//
//				'こ', 'す', 'え', 'あ', 'ざ', 'に', 'づ', 'ち', 'ぢ', 'て',
//				'け', 'い', 'し', 'ぉ', 'ぞ', 'で', 'っ', 'た', 'び',
//				'せ', 'ぜ', 'ず', 'そ', 'ば', 'ぬ', 'ぱ',};
		canBeConvertedToEnglish = new char[] {
				'\u3142', '\u3148', '\u3137', '\u3131', '\u3145', '\u315b', '\u3155', '\u3151', '\u3150', '\u3154',
				'\u3141', '\u3134', '\u3147', '\u3139', '\u314e', '\u3157', '\u3153', '\u314f', '\u3163',
				'\u314b', '\u314c', '\u314a', '\u314d', '\u3160', '\u315c', '\u3161',

				'\u3143', '\u3149', '\u3138', '\u3132', '\u3146', '\u315b', '\u3155', '\u3151', '\u3152', '\u3156',
				'\u3141', '\u3134', '\u3147', '\u3139', '\u314e', '\u3157', '\u3153', '\u314f', '\u3163',
				'\u314b', '\u314c', '\u314a', '\u314d', '\u3160', '\u315c', '\u3161',};

//		firstChar = new char[] {'ぁ', 'あ', 'い', 'ぇ', 'え', 'ぉ', 'け', 'げ', 'こ', 'さ', 'ざ', 'し', 'じ', 'す', 'ず', 'せ', 'ぜ', 'そ', 'ぞ'};
//		middleChar = new char[] {'た', 'だ', 'ち', 'ぢ', 'っ', 'つ', 'づ', 'て', 'で', 'と', 'ど', 'な', 'に', 'ぬ', 'ね', 'の', 'は', 'ば', 'ぱ', 'ひ', 'び'};
//		lastChar = new char[] {' ', 'ぁ', 'あ', 'ぃ', 'い', 'ぅ', 'う', 'ぇ', 'ぉ', 'お', 'か', 'が', 'き', 'ぎ', 'く', 'ぐ', 'け', 'げ', 'ご', 'さ', 'ざ', 'し', 'じ', 'ず', 'せ', 'ぜ', 'そ', 'ぞ'};
		firstChar = new char[] {'\u3131', '\u3132', '\u3134', '\u3137', '\u3138', '\u3139', '\u3141', '\u3142', '\u3143', '\u3145', '\u3146', '\u3147', '\u3148', '\u3149', '\u314a', '\u314b', '\u314c', '\u314d', '\u314e',};
		middleChar = new char[] {'\u314f', '\u3150', '\u3151', '\u3152', '\u3153', '\u3154', '\u3155', '\u3156', '\u3157', '\u3158', '\u3159', '\u315a', '\u315b', '\u315c', '\u315d', '\u315e', '\u315f', '\u3160', '\u3161', '\u3162', '\u3163',};
		lastChar = new char[] {' ', '\u3131', '\u3132', '\u3133', '\u3134', '\u3135', '\u3136', '\u3137', '\u3139', '\u313a', '\u313b', '\u313c', '\u313d', '\u313e', '\u313f', '\u3140', '\u3141', '\u3142', '\u3144', '\u3145', '\u3146', '\u3147', '\u3148', '\u314a', '\u314b', '\u314c', '\u314d', '\u314e',};

//		multiMiddleChar = new char[] {
//				'で', 'た', 'と',
//				'で', 'だ', 'ど',
//				'で', 'び', 'な',
//				'ぬ', 'っ', 'ね',
//				'ぬ', 'つ', 'の',
//				'ぬ', 'び', 'は',
//				'ぱ', 'び', 'ひ'};
//		multiLastChar = new char[] {
//				'ぁ', 'さ', 'ぃ',
//				'い', 'じ', 'ぅ',
//				'い', 'ぞ', 'う',
//				'ぉ', 'ぁ', 'お',
//				'ぉ', 'け', 'か',
//				'ぉ', 'げ', 'が',
//				'ぉ', 'さ', 'き',
//				'ぉ', 'ぜ', 'ぎ',
//				'ぉ', 'そ', 'く',
//				'ぉ', 'ぞ', 'ぐ',
//				'げ', 'さ', 'ご'};
		multiMiddleChar = new char[] {
				'\u3157', '\u314f', '\u3158',
				'\u3157', '\u3150', '\u3159',
				'\u3157', '\u3163', '\u315a',
				'\u315c', '\u3153', '\u315d',
				'\u315c', '\u3154', '\u315e',
				'\u315c', '\u3163', '\u315f',
				'\u3161', '\u3163', '\u3162',};
		multiLastChar = new char[] {
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
				'\u3142', '\u3145', '\u3144',};
	}

	public static boolean switchInputMode() {
		return koreanMode = !koreanMode;
	}
	
	public static void switchCombiningMode(boolean combiningMode) {
		KoreanCore.combiningMode = combiningMode;
	}

	public static boolean isKoreanInputMode() {
		return koreanMode;
	}
	
	public static boolean isCombiningMode() {
		return combiningMode;
	}

	public static int getEnglishCharIndex(char c) {
		for (int i = 0; i < canBeConvertedToKorean.length; i++) {
			if (canBeConvertedToKorean[i] == c)
				return i;
		}

		return -1;
	}

	public static int getKoreanCharIndex(char c) {
		for (int i = 0; i < canBeConvertedToEnglish.length; i++) {
			if (canBeConvertedToEnglish[i] == c)
				return i;
		}

		return -1;
	}

	public static char getEnglishChar(int index) {
		return canBeConvertedToKorean[index];
	}

	public static char getKoreanChar(int index) {
		return canBeConvertedToEnglish[index];
	}

	public static boolean isAbleToBeConvertedToKorean(char c) {
		int index = getEnglishCharIndex(c);

		return (index != -1) ? true : false;
	}

	public static boolean isAbleToBeConvertedToEnglish(char c) {
		int index = getKoreanCharIndex(c);

		return (index != -1) ? true : false;
	}

	public static char converteToKorean(char c) {
		int index = getEnglishCharIndex(c);

		return getKoreanChar(index);
	}

	public static char converteToEnglish(char c) {
		int index = getKoreanCharIndex(c);

		return getEnglishChar(index);
	}

	public static boolean isKoreanChar(char c) {
		return (0xAC00 <= c && c <= 0xD7AF) ? true : false;
	}

	public static boolean isKoreanJamoChar(char c) {
		return (0x3130 <= c && c <= 0x318F) ? true : false;
	}

	public static char[] splitKoreanChar(char c) {
		int base = c - 0xAC00;

		/*
		 * How to combine korean chars
		 * 
		 * f = first char index m = middle char index l = last char index
		 * 
		 * (f * 21 * 28) + (m * 28) + l ((f * 21) + m) * 28 + l <= simpled code
		 * 
		 * 
		 * 588 = chosung code = 21 * 28 = firstChar.length * middleChar.length
		 * 28 = jungsung code = 28 = middleChar.length
		 */

		int firstCharIndex = base / 588;
		int middleCharIndex = (base - (588 * firstCharIndex)) / 28;
		int lastCharIndex = base - (588 * firstCharIndex) - (28 * middleCharIndex);
		
		return new char[] {
				firstChar[firstCharIndex],
				middleChar[middleCharIndex],
				lastChar[lastCharIndex]
						};
	}

	public static char combineKoreanChar(char[] chars) {
		if (chars[0] != ' ' && chars[1] == ' ' && chars[2] == ' ')
			return chars[0];
		if (chars[0] == ' ' && chars[1] != ' ' && chars[2] == ' ')
			return chars[1];
		if (chars[0] == ' ' && chars[1] == ' ' && chars[2] != ' ')
			return chars[2];

		int f = getFirstCharIndex(chars[0]);
		int m = getMiddleCharIndex(chars[1]);
		int l = getLastCharIndex(chars[2]);

		if (f == -1)
			f = 0;
		if (m == -1)
			m = 0;
		if (l == -1)
			l = 0;

		char c = (char) (0xAC00 + (((f * 21) + m) * 28 + l));

		return c;
	}

	public static int getFirstCharIndex(char c) {
		for (int i = 0; i < firstChar.length; i++) {
			if (firstChar[i] == c)
				return i;
		}

		return -1;
	}

	public static int getMiddleCharIndex(char c) {
		for (int i = 0; i < middleChar.length; i++) {
			if (middleChar[i] == c)
				return i;
		}

		return -1;
	}

	public static int getLastCharIndex(char c) {
		for (int i = 0; i < lastChar.length; i++) {
			if (lastChar[i] == c)
				return i;
		}

		return -1;
	}

	public static boolean isFirstChar(char c) {
		int i = getFirstCharIndex(c);

		return (i != -1) ? true : false;
	}

	public static boolean isMiddleChar(char c) {
		int i = getMiddleCharIndex(c);

		return (i != -1) ? true : false;
	}

	public static boolean isLastChar(char c) {
		int i = getLastCharIndex(c);

		return (i != -1) ? true : false;
	}

	public static char[] splitMiddleChar(char c) {
		char[] chars = null;

		for (int i = 0; i < multiMiddleChar.length / 3; i++) {
			if (multiMiddleChar[i * 3 + 2] == c) {
				return new char[] { multiMiddleChar[i * 3],
						multiMiddleChar[i * 3 + 1] };
			}
		}

		return chars;
	}

	public static char[] splitLastChar(char c) {
		char[] chars = null;

		for (int i = 0; i < multiLastChar.length / 3; i++) {
			if (multiLastChar[i * 3 + 2] == c) {
				return new char[] { multiLastChar[i * 3],
						multiLastChar[i * 3 + 1] };
			}
		}

		return chars;
	}

	public static char combineMiddleChar(char a, char b) {
		for (int m = 0; m < multiMiddleChar.length / 3; m++) {
			if (multiMiddleChar[m * 3] == a && multiMiddleChar[m * 3 + 1] == b) {
				return multiMiddleChar[m * 3 + 2];
			}
		}

		return ' ';
	}

	public static char combineLastChar(char a, char b) {
		for (int m = 0; m < multiLastChar.length / 3; m++) {
			if (multiLastChar[m * 3] == a && multiLastChar[m * 3 + 1] == b) {
				return multiLastChar[m * 3 + 2];
			}
		}

		return ' ';
	}

	public static boolean isEmpty(char[] chars) {
		if (chars == null) return true;
		if (chars[0] == ' ' && chars[1] == ' ' && chars[2] == ' ') return true;

		return false;
	}
	
	public static Result writeKorean(String str, int cursorPos, int selecPos, char c) {
		StringBuilder sb = new StringBuilder(str);
		int newCursorPos = cursorPos;
		int newSelecPos = selecPos;
		
		if (cursorPos == selecPos) {
			if (!koreanMode) {
				sb.insert(cursorPos, c);
				newCursorPos++;
				newSelecPos++;
				
				combiningMode = false;
			} else {
				if (!isAbleToBeConvertedToKorean(c)) {
					sb.insert(cursorPos, c);
					newCursorPos++;
					newSelecPos++;
					
					combiningMode = false;
				} else {
					char korChar = converteToKorean(c);// korean char
					
					if (cursorPos < 1) {
						sb.insert(0, korChar);
						newCursorPos = 1;
						newSelecPos = 1;
						
						combiningMode = true;
					} else {
						if (combiningMode) {
							int behCharIndex = cursorPos - 1;
							char behChar = sb.charAt(behCharIndex);// the char that is behind the cursorPos
							
							if (!isKoreanChar(behChar) && !isKoreanJamoChar(behChar)) {
								sb.insert(cursorPos, korChar);
								newCursorPos++;
								newSelecPos++;
							} else {
								if (isKoreanChar(behChar)) {
									char[] chars = splitKoreanChar(behChar);
									
									if (isMiddleChar(korChar)) {
										if (chars[2] == ' ') {
											char comChar = combineMiddleChar(chars[1], korChar);
											
											if (comChar == ' ') {
												sb.insert(cursorPos, korChar);
												newCursorPos++;
												newSelecPos++;
											} else {
												chars[1] = comChar;
												sb.setCharAt(behCharIndex, combineKoreanChar(chars));
											}
										} else {
											if (isFirstChar(chars[2])) {
												sb.insert(cursorPos, combineKoreanChar(new char[] {chars[2], korChar, ' '}));
												
												chars[2] = ' ';
												sb.setCharAt(behCharIndex, combineKoreanChar(chars));
												
												newCursorPos++;
												newSelecPos++;
											} else {
												char[] lastChars = splitLastChar(chars[2]);
												
												sb.insert(cursorPos, combineKoreanChar(new char[] {lastChars[1], korChar, ' '}));
												
												chars[2] = lastChars[0];
												sb.setCharAt(behCharIndex, combineKoreanChar(chars));
												
												newCursorPos++;
												newSelecPos++;
											}
										}
									} else if (isLastChar(korChar)) {
										if (chars[2] == ' ') {
											chars[2] = korChar;
											sb.setCharAt(behCharIndex, combineKoreanChar(chars));
										} else {
											char comChar = combineLastChar(chars[2], korChar);
											
											if (comChar == ' ') {
												sb.insert(cursorPos, korChar);
												newCursorPos++;
												newSelecPos++;
											} else {
												chars[2] = comChar;
												sb.setCharAt(behCharIndex, combineKoreanChar(chars));
											}
										}
									} else {
										sb.insert(cursorPos, korChar);
										newCursorPos++;
										newSelecPos++;
									}
								} else {
									if (isFirstChar(behChar)) {
										if (isMiddleChar(korChar)) {
											sb.setCharAt(behCharIndex, combineKoreanChar(new char[] {behChar, korChar, ' '}));
										} else {
											sb.insert(cursorPos, korChar);
											newCursorPos++;
											newSelecPos++;
										}
									} else if (isMiddleChar(behChar)) {
										char comChar = combineMiddleChar(behChar, korChar);// combined char
										
										if (comChar == ' ') {
											sb.insert(cursorPos, korChar);
											newCursorPos++;
											newSelecPos++;
										} else {
											sb.setCharAt(behCharIndex, comChar);
										}
									} else if (isLastChar(behChar)) {
										sb.insert(cursorPos, korChar);
										newCursorPos++;
										newSelecPos++;
									}
								}
							}
						} else {
							sb.insert(cursorPos, korChar);
							newCursorPos++;
							newSelecPos++;
							
							combiningMode = true;
						}
					}
				}
			}
		} else {
			if (koreanMode && isAbleToBeConvertedToKorean(c)) c = converteToKorean(c);
			
			int offset = (cursorPos < selecPos) ? cursorPos : selecPos;
			int length = Math.abs(cursorPos - selecPos);
			
			sb.delete(offset, offset + length);
			sb.insert(offset, c);
			
			newCursorPos = offset + 1;
			newSelecPos = offset + 1;
			
			combiningMode = false;
		}
		
		return new Result(sb.toString(), newCursorPos, newSelecPos);
	}

	public static Result deleteKorean(String str, int cursorPos, int selecPos) {
		StringBuilder sb = new StringBuilder(str);
		int newCursorPos = cursorPos;
		int newSelecPos = selecPos;
		
		if (cursorPos == selecPos) {
			if (cursorPos > 0) {
				int charIndex = cursorPos - 1;
				char c = sb.charAt(charIndex);

				if (isKoreanChar(c) && combiningMode) {
					char[] chars = splitKoreanChar(c);

					char[] middleChars = splitMiddleChar(chars[1]);
					char[] lastChars = splitLastChar(chars[2]);

					if (lastChars != null) {
						chars[2] = lastChars[0];
					} else {
						if (chars[2] != ' ') {
							chars[2] = ' ';
						} else {
							if (middleChars != null) {
								chars[1] = middleChars[0];
							} else {
								if (chars[1] != ' ') {
									chars[1] = ' ';
								} else {
									chars[0] = ' ';
								}
							}
						}
					}

					if (!isEmpty(chars)) {
						sb.setCharAt(charIndex, combineKoreanChar(chars));
						
						combiningMode = true;
					} else {
						sb.deleteCharAt(charIndex);
						newCursorPos--;
						newSelecPos--;
						
						combiningMode = false;
					}
				} else {
					sb.deleteCharAt(charIndex);
					newCursorPos--;
					newSelecPos--;
					
					combiningMode = false;
				}
			}
		} else {
			int offset = (cursorPos < selecPos) ? cursorPos : selecPos;
			int length = Math.abs(cursorPos - selecPos);
			
			sb.delete(offset, offset + length);
			
			newCursorPos = offset;
			newSelecPos = offset;
			
			combiningMode = false;
		}

		return new Result(sb.toString(), newCursorPos, newSelecPos);
	}

}
