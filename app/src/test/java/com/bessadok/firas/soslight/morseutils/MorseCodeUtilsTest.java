package com.bessadok.firas.soslight.morseutils;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MorseCodeUtilsTest extends TestCase {

    @Test
    public void testToMorseCode_empty() throws Exception {
        assertEquals(MorseCodeUtils.EMPTY_LIST, MorseCodeUtils.INSTANCE.toMorseCode(""));
    }

    @Test
    public void testToMorseCode_SOS() throws Exception {
        List<MorseLetter> sos = new ArrayList<MorseLetter>();
        sos.add(new MorseLetter(MorseCode.POINT, MorseCode.POINT, MorseCode.POINT));
        sos.add(new MorseLetter(MorseCode.LINE, MorseCode.LINE, MorseCode.LINE));
        sos.add(new MorseLetter(MorseCode.POINT, MorseCode.POINT, MorseCode.POINT));

        assertEquals(sos, MorseCodeUtils.INSTANCE.toMorseCode("SOS"));
    }
}