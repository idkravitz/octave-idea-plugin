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
import org.jetbrains.annotations.NotNull;

public class OctaveParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(OctaveTypes.COMMENT);
    public static final TokenSet OPERATORS = TokenSet.create(OctaveTypes.PLUS, OctaveTypes.MINUS);

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
