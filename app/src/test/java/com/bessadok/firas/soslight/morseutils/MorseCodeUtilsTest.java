package com.bessadok.firas.soslight.morseutils;

import android.graphics.Point;

import junit.framework.TestCase;

import org.junit.Assert;
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
        sos.add(new MorseLetter(MorseCode.Point, MorseCode.Point, MorseCode.Point));
        sos.add(new MorseLetter(MorseCode.Line, MorseCode.Line, MorseCode.Line));
        sos.add(new MorseLetter(MorseCode.Point, MorseCode.Point, MorseCode.Point));

        assertEquals(sos, MorseCodeUtils.INSTANCE.toMorseCode("SOS"));
    }
}