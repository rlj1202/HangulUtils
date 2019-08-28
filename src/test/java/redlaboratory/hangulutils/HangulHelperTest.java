package redlaboratory.hangulutils;

import org.junit.Test;
import static org.junit.Assert.*;
import static redlaboratory.hangulutils.HangulHelper.*;

public class HangulHelperTest {

    @Test
    public void testCondition() {
        assertTrue(isHangulJamo('ㅇ'));
        assertTrue(isConsonantJamo('ㅇ'));
        assertTrue(isFinalConsonantJamo('ㅇ'));
    }

    @Test
    public void testConversion() {
        assertEquals(convertToHangulJamo('a'), 'ㅁ');
        assertEquals(convertToHangulJamo('s'), 'ㄴ');
        assertEquals(convertToHangulJamo('d'), 'ㅇ');
        assertEquals(convertToHangulJamo('f'), 'ㄹ');

        assertEquals(convertToHangulJamo('Q'), 'ㅃ');
        assertEquals(convertToHangulJamo('W'), 'ㅉ');
        assertEquals(convertToHangulJamo('E'), 'ㄸ');
        assertEquals(convertToHangulJamo('R'), 'ㄲ');

        assertEquals(convertToHangulJamo('O'), 'ㅒ');
        assertEquals(convertToHangulJamo('P'), 'ㅖ');
    }

    @Test
    public void testCombination() {
        assertEquals(combineHanguls(new char[] {'ㅎ', 'ㅏ', 'ㄴ'}), '한');
        assertArrayEquals(splitHangul('한'), new char[] {'ㅎ', 'ㅏ', 'ㄴ'});

        assertEquals(combineHanguls(new char[] {'ㅂ', 'ㅞ', 'ㄺ'}), '뷁');
        assertArrayEquals(splitHangul('뷁'), new char[] {'ㅂ', 'ㅞ', 'ㄺ'});

        assertEquals(combineHanguls(new char[] {'ㄱ', 'ㅏ', HANGUL_FILLER}), '가');
        assertArrayEquals(splitHangul('가'), new char[] {'ㄱ', 'ㅏ', HANGUL_FILLER});

        assertEquals(combineVowelJamo('ㅗ', 'ㅣ'), 'ㅚ');
        assertArrayEquals(splitVowelJamo('ㅚ'), new char[] {'ㅗ', 'ㅣ'});

        assertEquals(combineFinalConsonantJamo('ㅂ', 'ㅅ'), 'ㅄ');
        assertArrayEquals(splitFinalConsonantJamo('ㅄ'), new char[] {'ㅂ', 'ㅅ'});
    }

}
