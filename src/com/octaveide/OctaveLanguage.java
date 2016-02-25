package com.octaveide;

import com.intellij.lang.Language;

/**
 * Created by Дмитрий on 25.02.2016.
 */
public class OctaveLanguage extends Language {
    public static final OctaveLanguage INSTANCE = new OctaveLanguage();

    private OctaveLanguage() {
        super("Octave");
    }
}
