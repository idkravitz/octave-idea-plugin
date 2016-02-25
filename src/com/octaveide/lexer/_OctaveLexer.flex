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
INT = (0|[1-9][0-9]*)
FLOAT = [0-9]+ [eE] [+-]? [0-9]+
//FLOAT = {INT}?.{INT} | {INT} ["eE"] ["+-"]? {INT}
IDENTIFIER = [:jletter:] ([:jletter:]|[:jdigit:])*


%%
<YYINITIAL> {
  {WHITE_SPACE}      { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

  {COMMENT}          { yybegin(YYINITIAL); return OctaveTypes.COMMENT; }
  {CRLF}             { yybegin(YYINITIAL); return OctaveTypes.CRLF; }
  {FLOAT}            { yybegin(YYINITIAL); return OctaveTypes.FLOAT; }
  {INT}              { yybegin(YYINITIAL); return OctaveTypes.INT; }
  {IDENTIFIER}       { yybegin(YYINITIAL); return OctaveTypes.IDENTIFIER; }

  "+"                { yybegin(YYINITIAL); return OctaveTypes.PLUS; }
  "-"                { yybegin(YYINITIAL); return OctaveTypes.MINUS; }
  "*"                { yybegin(YYINITIAL); return OctaveTypes.MULTIPLY; }
  "/"                { yybegin(YYINITIAL); return OctaveTypes.DIVIDE; }
  "="                { yybegin(YYINITIAL); return OctaveTypes.ASSIGN; }
  ";"                { yybegin(YYINITIAL); return OctaveTypes.SEMICOLON; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
