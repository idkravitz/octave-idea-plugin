package com.octaveide;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.octaveide.psi.OctaveTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;


public class OctaveSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEMICOLON = createTextAttributesKey("OCTAVE_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey OPERATOR = createTextAttributesKey("OCTAVE_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("OCTAVE_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("OCTAVE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("OCTAVE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

//    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
//    private static final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[]{SEMICOLON};
//    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
//    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
//    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
//    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();

    static {
        fillMap(ATTRIBUTES, OctaveParserDefinition.OPERATORS, OPERATOR);
        fillMap(ATTRIBUTES, OctaveParserDefinition.COMMENTS, COMMENT);
        fillMap(ATTRIBUTES, OctaveParserDefinition.NUMBERS, NUMBER);
        fillMap(ATTRIBUTES, SEMICOLON, OctaveTypes.SEMICOLON);
        fillMap(ATTRIBUTES, BAD_CHARACTER, TokenType.BAD_CHARACTER);
    }


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new OctaveLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
            return pack(ATTRIBUTES.get(tokenType));
    }
}
