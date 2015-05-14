package com.bessadok.firas.soslight.morseutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum MorseCodeUtils {

    INSTANCE;

    public static final List EMPTY_LIST = new ArrayList();

    public static final int STANDARD_DELAY = 250;

    public static final int POINT_DELAY = STANDARD_DELAY;
    public static final int LINE_DELAY = STANDARD_DELAY * 3;

    public static final int BETWEEN_LETTERS_DELAY = LINE_DELAY;
    public static final int BETWEEN_WORDS_DELAY = STANDARD_DELAY * 5;

    private final Map<Character, MorseLetter> morseCode = new HashMap<Character, MorseLetter>();
    {
        morseCode.put('A', new MorseLetter(MorseCode.POINT, MorseCode.LINE));
        morseCode.put('B', new MorseLetter(MorseCode.LINE, MorseCode.POINT, MorseCode.POINT, MorseCode.POINT));
        morseCode.put('C', new MorseLetter(MorseCode.LINE, MorseCode.POINT, MorseCode.LINE, MorseCode.POINT));
        morseCode.put('D', new MorseLetter(MorseCode.LINE, MorseCode.POINT, MorseCode.POINT));
        morseCode.put('E', new MorseLetter(MorseCode.POINT));
        morseCode.put('F', new MorseLetter(MorseCode.POINT, MorseCode.POINT, MorseCode.LINE, MorseCode.POINT));
        morseCode.put('G', new MorseLetter(MorseCode.LINE, MorseCode.LINE, MorseCode.POINT));
        morseCode.put('H', new MorseLetter(MorseCode.POINT, MorseCode.POINT, MorseCode.POINT, MorseCode.POINT));
        morseCode.put('I', new MorseLetter(MorseCode.POINT, MorseCode.POINT));
        morseCode.put('J', new MorseLetter(MorseCode.POINT, MorseCode.LINE, MorseCode.LINE, MorseCode.LINE));
        morseCode.put('K', new MorseLetter(MorseCode.LINE, MorseCode.POINT, MorseCode.LINE));
        morseCode.put('L', new MorseLetter(MorseCode.POINT, MorseCode.LINE, MorseCode.POINT, MorseCode.POINT));
        morseCode.put('M', new MorseLetter(MorseCode.LINE, MorseCode.LINE));
        morseCode.put('N', new MorseLetter(MorseCode.LINE, MorseCode.POINT));
        morseCode.put('O', new MorseLetter(MorseCode.LINE, MorseCode.LINE, MorseCode.LINE));
        morseCode.put('P', new MorseLetter(MorseCode.POINT, MorseCode.LINE, MorseCode.LINE, MorseCode.POINT));
        morseCode.put('Q', new MorseLetter(MorseCode.LINE, MorseCode.LINE, MorseCode.POINT, MorseCode.LINE));
        morseCode.put('R', new MorseLetter(MorseCode.POINT, MorseCode.LINE, MorseCode.POINT));
        morseCode.put('S', new MorseLetter(MorseCode.POINT, MorseCode.POINT, MorseCode.POINT));
        morseCode.put('T', new MorseLetter(MorseCode.LINE));
        morseCode.put('U', new MorseLetter(MorseCode.POINT, MorseCode.POINT, MorseCode.LINE));
        morseCode.put('V', new MorseLetter(MorseCode.POINT, MorseCode.POINT, MorseCode.POINT, MorseCode.LINE));
        morseCode.put('W', new MorseLetter(MorseCode.POINT, MorseCode.LINE, MorseCode.LINE));
        morseCode.put('X', new MorseLetter(MorseCode.LINE, MorseCode.POINT, MorseCode.POINT, MorseCode.LINE));
        morseCode.put('Y', new MorseLetter(MorseCode.LINE, MorseCode.POINT, MorseCode.LINE, MorseCode.LINE));
        morseCode.put('Z', new MorseLetter(MorseCode.LINE, MorseCode.LINE, MorseCode.POINT, MorseCode.POINT));
        morseCode.put(' ', new MorseLetter(MorseCode.SPACE));
    }

    public List<MorseLetter> toMorseCode(String text) {
        if (text == null || text.isEmpty()) {
            return EMPTY_LIST;
        }
        List<MorseLetter> morseSequence = new ArrayList<MorseLetter>();
        for (Character character : text.toUpperCase().toCharArray()) {
            morseSequence.add(morseCode.get(character));
        }
        return morseSequence;
    }
}
