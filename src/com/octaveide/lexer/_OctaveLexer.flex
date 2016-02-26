package com.octaveide.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.octaveide.psi.OctaveTypes.*;
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

  {COMMENT}          { yybegin(YYINITIAL); return COMMENT; }
  {CRLF}             { yybegin(YYINITIAL); return CRLF; }
  {FLOAT}            { yybegin(YYINITIAL); return FLOAT; }
  {INT}              { yybegin(YYINITIAL); return INT; }
  {IDENTIFIER}       { yybegin(YYINITIAL); return IDENTIFIER; }

  "("                { yybegin(YYINITIAL); return L_PAREN; }
  ")"                { yybegin(YYINITIAL); return R_PAREN; }
  "{"                { yybegin(YYINITIAL); return L_BRACE; }
  "}"                { yybegin(YYINITIAL); return R_BRACE; }
  "+="               { yybegin(YYINITIAL); return ASSIGN_PLUS; }
  "-="               { yybegin(YYINITIAL); return ASSIGN_MINUS; }
  "*="               { yybegin(YYINITIAL); return ASSIGN_MULTIPLY; }
  "/="               { yybegin(YYINITIAL); return ASSIGN_L_DIV; }
  "\\="              { yybegin(YYINITIAL); return ASSIGN_R_DIV; }
  "^="               { yybegin(YYINITIAL); return ASSIGN_POW_1; }
  ".*="              { yybegin(YYINITIAL); return ASSIGN_ELEMENT_MULTIPLY; }
  "./="              { yybegin(YYINITIAL); return ASSIGN_ELEMENT_L_DIV; }
  ".\\="             { yybegin(YYINITIAL); return ASSIGN_ELEMENT_R_DIV; }
  ".^="              { yybegin(YYINITIAL); return ASSIGN_ELEMENT_POW_1; }
  "|="               { yybegin(YYINITIAL); return ASSIGN_ELEMENT_OR; }
  "&="               { yybegin(YYINITIAL); return ASSIGN_ELEMENT_AND; }
  "+"                { yybegin(YYINITIAL); return PLUS; }
  "-"                { yybegin(YYINITIAL); return MINUS; }
  "/"                { yybegin(YYINITIAL); return L_DIV; }
  "\\"               { yybegin(YYINITIAL); return R_DIV; }
  "^"                { yybegin(YYINITIAL); return POW_1; }
  "**"               { yybegin(YYINITIAL); return POW_2; }
  "*"                { yybegin(YYINITIAL); return MULTIPLY; }
  "'"                { yybegin(YYINITIAL); return CC_TRANSPOSE; }
  ".'"               { yybegin(YYINITIAL); return TRANSPOSE; }
  "++"               { yybegin(YYINITIAL); return INCREMENT; }
  "--"               { yybegin(YYINITIAL); return DECREMENT; }
  "<="               { yybegin(YYINITIAL); return LESS_THAN_OR_EQUAL; }
  "<"                { yybegin(YYINITIAL); return LESS_THAN; }
  "=="               { yybegin(YYINITIAL); return EQUAL; }
  ">="               { yybegin(YYINITIAL); return GREATER_THAN_OR_EQUAL; }
  ">"                { yybegin(YYINITIAL); return GREATER_THAN; }
  "!="               { yybegin(YYINITIAL); return NOT_EQUAL_1; }
  "~="               { yybegin(YYINITIAL); return NOT_EQUAL_2; }
  "="                { yybegin(YYINITIAL); return ASSIGN; }
  ".+"               { yybegin(YYINITIAL); return ELEMENT_PLUS; }
  ".-"               { yybegin(YYINITIAL); return ELEMENT_MINUS; }
  "./"               { yybegin(YYINITIAL); return ELEMENT_L_DIV; }
  ".\\"              { yybegin(YYINITIAL); return ELEMENT_R_DIV; }
  ".^"               { yybegin(YYINITIAL); return ELEMENT_POW_1; }
  ".**"              { yybegin(YYINITIAL); return ELEMENT_POW_2; }
  ".*"               { yybegin(YYINITIAL); return ELEMENT_MULTIPLY; }
  "!"                { yybegin(YYINITIAL); return NOT_1; }
  "~"                { yybegin(YYINITIAL); return NOT_2; }
  "."                { yybegin(YYINITIAL); return DOT; }
  ":"                { yybegin(YYINITIAL); return COLON; }
  "&&"               { yybegin(YYINITIAL); return AND; }
  "||"               { yybegin(YYINITIAL); return OR; }
  "&"                { yybegin(YYINITIAL); return ELEMENT_AND; }
  "|"                { yybegin(YYINITIAL); return ELEMENT_OR; }
  ";"                { yybegin(YYINITIAL); return SEMICOLON; }

  [^] { return TokenType.BAD_CHARACTER; }
}
