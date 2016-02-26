package com.octaveide;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.octaveide.parser.OctaveParser;
import com.octaveide.psi.OctaveFile;
import com.octaveide.psi.OctaveTypes;
import static com.octaveide.psi.OctaveTypes.*;
import org.jetbrains.annotations.NotNull;

public class OctaveParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(COMMENT);
    public static final TokenSet OPERATORS = TokenSet.create(
            AND, ASSIGN, ASSIGN_ELEMENT_AND, ASSIGN_ELEMENT_L_DIV, ASSIGN_ELEMENT_MULTIPLY, ASSIGN_ELEMENT_OR, ASSIGN_ELEMENT_POW_1,
            ASSIGN_ELEMENT_R_DIV, ASSIGN_L_DIV, ASSIGN_MINUS, ASSIGN_MULTIPLY, ASSIGN_PLUS, ASSIGN_POW_1, ASSIGN_R_DIV,
            CC_TRANSPOSE, COLON, DECREMENT, DOT, ELEMENT_AND, ELEMENT_L_DIV, ELEMENT_MINUS, ELEMENT_MULTIPLY,
            ELEMENT_OR, ELEMENT_PLUS, ELEMENT_POW_1, ELEMENT_POW_2, ELEMENT_R_DIV, EQUAL, GREATER_THAN,
            GREATER_THAN_OR_EQUAL, INCREMENT, LESS_THAN, LESS_THAN_OR_EQUAL, L_BRACE, L_DIV, L_PAREN, MINUS, MULTIPLY,
            NOT_1, NOT_2, NOT_EQUAL_1, NOT_EQUAL_2, OR, PLUS, POW_1, POW_2, R_BRACE, R_DIV, R_PAREN, TRANSPOSE);
    public static final TokenSet NUMBERS = TokenSet.create(INT, FLOAT);

    public static final IFileElementType FILE = new IFileElementType(Language.<OctaveLanguage>findInstance(OctaveLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new OctaveLexerAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new OctaveParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY; // todo implement string literals
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {
        return OctaveTypes.Factory.createElement(astNode);
    }

    @Override
    public PsiFile createFile(FileViewProvider fileViewProvider) {
        return new OctaveFile(fileViewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
        return SpaceRequirements.MAY;
    }

}
