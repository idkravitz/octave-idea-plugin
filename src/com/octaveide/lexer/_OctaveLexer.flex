package com.octaveide.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
//import static com.octaveide.psi.OctaveTypes.*;
import com.octaveide.psi.OctaveTypes;
import com.intellij.psi.TokenType;

%%

%{
  public _OctaveLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _OctaveLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

CRLF="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE={LINE_WS}+
COMMENT=("#"|"%")[^\r\n]*
NUMBER = (0|[1-9][0-9]*)


%%
<YYINITIAL> {
  {WHITE_SPACE}      { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

  {COMMENT}          { yybegin(YYINITIAL); return OctaveTypes.COMMENT; }
  {CRLF}             { yybegin(YYINITIAL); return OctaveTypes.CRLF; }
  {NUMBER}           { yybegin(YYINITIAL); return OctaveTypes.NUMBER; }

  "+"                { yybegin(YYINITIAL); return OctaveTypes.PLUS; }
  "-"                { yybegin(YYINITIAL); return OctaveTypes.MINUS; }
  ";"                { yybegin(YYINITIAL); return OctaveTypes.SEMICOLON; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
