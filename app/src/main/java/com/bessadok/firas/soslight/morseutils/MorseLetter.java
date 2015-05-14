package com.bessadok.firas.soslight.morseutils;

import java.util.ArrayList;
import java.util.List;

public class MorseLetter {

    private List<MorseCode> morseSequence = new ArrayList<MorseCode>();

    private MorseLetter() {}

    MorseLetter(MorseCode code) {
        morseSequence.add(code);
    }

    MorseLetter(MorseCode code1, MorseCode code2) {
        morseSequence.add(code1);
        morseSequence.add(code2);
    }

    MorseLetter(MorseCode code1, MorseCode code2, MorseCode code3) {
        morseSequence.add(code1);
        morseSequence.add(code2);
        morseSequence.add(code3);
    }

    MorseLetter(MorseCode code1, MorseCode code2, MorseCode code3, MorseCode code4) {
        morseSequence.add(code1);
        morseSequence.add(code2);
        morseSequence.add(code3);
        morseSequence.add(code4);
    }
}
