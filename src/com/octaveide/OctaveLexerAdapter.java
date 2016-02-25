package com.octaveide;

import com.intellij.lexer.FlexAdapter;
import com.octaveide.lexer._OctaveLexer;

import java.io.Reader;

public class OctaveLexerAdapter extends FlexAdapter {

    public OctaveLexerAdapter() {
        super(new _OctaveLexer((Reader) null));
    }
}
