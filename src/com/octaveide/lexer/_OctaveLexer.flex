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
LETTER = [:letter:] | "_"
DIGIT =  [:digit:]

IDENTIFIER = {LETTER} ({LETTER}|{DIGIT})*


%%
<YYINITIAL> {
  {WHITE_SPACE}      { return TokenType.WHITE_SPACE; }

  {COMMENT}          { return COMMENT; }
  {CRLF}             { return CRLF; }
  {FLOAT}            { return FLOAT; }
  {INT}              { return INT; }

  "("                { return L_PAREN; }
  ")"                { return R_PAREN; }
  "{"                { return L_BRACE; }
  "}"                { return R_BRACE; }
  "+="               { return ASSIGN_PLUS; }
  "-="               { return ASSIGN_MINUS; }
  "*="               { return ASSIGN_MULTIPLY; }
  "/="               { return ASSIGN_L_DIV; }
  "\\="              { return ASSIGN_R_DIV; }
  "^="               { return ASSIGN_POW_1; }
  ".*="              { return ASSIGN_ELEMENT_MULTIPLY; }
  "./="              { return ASSIGN_ELEMENT_L_DIV; }
  ".\\="             { return ASSIGN_ELEMENT_R_DIV; }
  ".^="              { return ASSIGN_ELEMENT_POW_1; }
  "|="               { return ASSIGN_ELEMENT_OR; }
  "&="               { return ASSIGN_ELEMENT_AND; }
  "+"                { return PLUS; }
  "-"                { return MINUS; }
  "/"                { return L_DIV; }
  "\\"               { return R_DIV; }
  "^"                { return POW_1; }
  "**"               { return POW_2; }
  "*"                { return MULTIPLY; }
  "'"                { return CC_TRANSPOSE; }
  ".'"               { return TRANSPOSE; }
  "++"               { return INCREMENT; }
  "--"               { return DECREMENT; }
  "<="               { return LESS_THAN_OR_EQUAL; }
  "<"                { return LESS_THAN; }
  "=="               { return EQUAL; }
  ">="               { return GREATER_THAN_OR_EQUAL; }
  ">"                { return GREATER_THAN; }
  "!="               { return NOT_EQUAL_1; }
  "~="               { return NOT_EQUAL_2; }
  "="                { return ASSIGN; }
  ".+"               { return ELEMENT_PLUS; }
  ".-"               { return ELEMENT_MINUS; }
  "./"               { return ELEMENT_L_DIV; }
  ".\\"              { return ELEMENT_R_DIV; }
  ".^"               { return ELEMENT_POW_1; }
  ".**"              { return ELEMENT_POW_2; }
  ".*"               { return ELEMENT_MULTIPLY; }
  "!"                { return NOT_1; }
  "~"                { return NOT_2; }
  "."                { return DOT; }
  ":"                { return COLON; }
  "&&"               { return AND; }
  "||"               { return OR; }
  "&"                { return ELEMENT_AND; }
  "|"                { return ELEMENT_OR; }
  ";"                { return SEMICOLON; }
  "for"              { return FOR; }
  "end"              { return END; }
  "endfor"           { return ENDFOR; }

  {IDENTIFIER}       { return IDENTIFIER; }


  [^] { return TokenType.BAD_CHARACTER; }
}
