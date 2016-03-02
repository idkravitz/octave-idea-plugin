// This is a generated file. Not intended for manual editing.
package com.octaveide.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.octaveide.psi.impl.*;

public interface OctaveTypes {

  IElementType ADD_EXPR = new OctaveElementType("ADD_EXPR");
  IElementType AND_EXPR = new OctaveElementType("AND_EXPR");
  IElementType ASSIGN_EXPR = new OctaveElementType("ASSIGN_EXPR");
  IElementType COLON_EXPR = new OctaveElementType("COLON_EXPR");
  IElementType ELEMENT_AND_EXPR = new OctaveElementType("ELEMENT_AND_EXPR");
  IElementType ELEMENT_OR_EXPR = new OctaveElementType("ELEMENT_OR_EXPR");
  IElementType EXPONENT_EXPR = new OctaveElementType("EXPONENT_EXPR");
  IElementType EXPR = new OctaveElementType("EXPR");
  IElementType EXPR_STATEMENT = new OctaveElementType("EXPR_STATEMENT");
  IElementType FOR_LOOP_STATEMENT = new OctaveElementType("FOR_LOOP_STATEMENT");
  IElementType FUNC_CALL_EXPR = new OctaveElementType("FUNC_CALL_EXPR");
  IElementType FUNC_DECL_STATEMENT = new OctaveElementType("FUNC_DECL_STATEMENT");
  IElementType IDENTIFIER_EXPR = new OctaveElementType("IDENTIFIER_EXPR");
  IElementType LITERAL_EXPR = new OctaveElementType("LITERAL_EXPR");
  IElementType MUL_EXPR = new OctaveElementType("MUL_EXPR");
  IElementType OR_EXPR = new OctaveElementType("OR_EXPR");
  IElementType PAREN_EXPR = new OctaveElementType("PAREN_EXPR");
  IElementType POSTFIX_EXPR = new OctaveElementType("POSTFIX_EXPR");
  IElementType RELATIONAL_EXPR = new OctaveElementType("RELATIONAL_EXPR");
  IElementType STATEMENT = new OctaveElementType("STATEMENT");
  IElementType TRANSPOSE_EXPR = new OctaveElementType("TRANSPOSE_EXPR");
  IElementType UNARY_EXPR = new OctaveElementType("UNARY_EXPR");

  IElementType AND = new OctaveTokenType("&&");
  IElementType ASSIGN = new OctaveTokenType("=");
  IElementType ASSIGN_ELEMENT_AND = new OctaveTokenType("&=");
  IElementType ASSIGN_ELEMENT_L_DIV = new OctaveTokenType("./=");
  IElementType ASSIGN_ELEMENT_MULTIPLY = new OctaveTokenType(".*=");
  IElementType ASSIGN_ELEMENT_OR = new OctaveTokenType("|=");
  IElementType ASSIGN_ELEMENT_POW_1 = new OctaveTokenType(".^=");
  IElementType ASSIGN_ELEMENT_R_DIV = new OctaveTokenType(".\\=");
  IElementType ASSIGN_L_DIV = new OctaveTokenType("/=");
  IElementType ASSIGN_MINUS = new OctaveTokenType("-=");
  IElementType ASSIGN_MULTIPLY = new OctaveTokenType("*=");
  IElementType ASSIGN_PLUS = new OctaveTokenType("+=");
  IElementType ASSIGN_POW_1 = new OctaveTokenType("^=");
  IElementType ASSIGN_R_DIV = new OctaveTokenType("\\=");
  IElementType CC_TRANSPOSE = new OctaveTokenType("'");
  IElementType COLON = new OctaveTokenType(":");
  IElementType COMMA = new OctaveTokenType(",");
  IElementType COMMENT = new OctaveTokenType("COMMENT");
  IElementType CRLF = new OctaveTokenType("CRLF");
  IElementType DECREMENT = new OctaveTokenType("--");
  IElementType DOT = new OctaveTokenType(".");
  IElementType ELEMENT_AND = new OctaveTokenType("&");
  IElementType ELEMENT_L_DIV = new OctaveTokenType("./");
  IElementType ELEMENT_MINUS = new OctaveTokenType(".-");
  IElementType ELEMENT_MULTIPLY = new OctaveTokenType(".*");
  IElementType ELEMENT_OR = new OctaveTokenType("|");
  IElementType ELEMENT_PLUS = new OctaveTokenType(".+");
  IElementType ELEMENT_POW_1 = new OctaveTokenType(".^");
  IElementType ELEMENT_POW_2 = new OctaveTokenType(".**");
  IElementType ELEMENT_R_DIV = new OctaveTokenType(".\\");
  IElementType END = new OctaveTokenType("end");
  IElementType ENDFOR = new OctaveTokenType("endfor");
  IElementType ENDFUNCTION = new OctaveTokenType("endfunction");
  IElementType EQUAL = new OctaveTokenType("==");
  IElementType FLOAT = new OctaveTokenType("float");
  IElementType FOR = new OctaveTokenType("for");
  IElementType FUNCTION = new OctaveTokenType("function");
  IElementType GREATER_THAN = new OctaveTokenType(">");
  IElementType GREATER_THAN_OR_EQUAL = new OctaveTokenType(">=");
  IElementType IDENTIFIER = new OctaveTokenType("identifier");
  IElementType INCREMENT = new OctaveTokenType("++");
  IElementType INT = new OctaveTokenType("int");
  IElementType LESS_THAN = new OctaveTokenType("<");
  IElementType LESS_THAN_OR_EQUAL = new OctaveTokenType("<=");
  IElementType L_BRACE = new OctaveTokenType("{");
  IElementType L_DIV = new OctaveTokenType("/");
  IElementType L_PAREN = new OctaveTokenType("(");
  IElementType MINUS = new OctaveTokenType("-");
  IElementType MULTIPLY = new OctaveTokenType("*");
  IElementType NOT_1 = new OctaveTokenType("!");
  IElementType NOT_2 = new OctaveTokenType("~");
  IElementType NOT_EQUAL_1 = new OctaveTokenType("!=");
  IElementType NOT_EQUAL_2 = new OctaveTokenType("~=");
  IElementType OR = new OctaveTokenType("||");
  IElementType PLUS = new OctaveTokenType("+");
  IElementType POW_1 = new OctaveTokenType("^");
  IElementType POW_2 = new OctaveTokenType("**");
  IElementType R_BRACE = new OctaveTokenType("}");
  IElementType R_DIV = new OctaveTokenType("\\");
  IElementType R_PAREN = new OctaveTokenType(")");
  IElementType SEMICOLON = new OctaveTokenType(";");
  IElementType TRANSPOSE = new OctaveTokenType(".'");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ADD_EXPR) {
        return new OctaveAddExprImpl(node);
      }
      else if (type == AND_EXPR) {
        return new OctaveAndExprImpl(node);
      }
      else if (type == ASSIGN_EXPR) {
        return new OctaveAssignExprImpl(node);
      }
      else if (type == COLON_EXPR) {
        return new OctaveColonExprImpl(node);
      }
      else if (type == ELEMENT_AND_EXPR) {
        return new OctaveElementAndExprImpl(node);
      }
      else if (type == ELEMENT_OR_EXPR) {
        return new OctaveElementOrExprImpl(node);
      }
      else if (type == EXPONENT_EXPR) {
        return new OctaveExponentExprImpl(node);
      }
      else if (type == EXPR) {
        return new OctaveExprImpl(node);
      }
      else if (type == EXPR_STATEMENT) {
        return new OctaveExprStatementImpl(node);
      }
      else if (type == FOR_LOOP_STATEMENT) {
        return new OctaveForLoopStatementImpl(node);
      }
      else if (type == FUNC_CALL_EXPR) {
        return new OctaveFuncCallExprImpl(node);
      }
      else if (type == FUNC_DECL_STATEMENT) {
        return new OctaveFuncDeclStatementImpl(node);
      }
      else if (type == IDENTIFIER_EXPR) {
        return new OctaveIdentifierExprImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new OctaveLiteralExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new OctaveMulExprImpl(node);
      }
      else if (type == OR_EXPR) {
        return new OctaveOrExprImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new OctaveParenExprImpl(node);
      }
      else if (type == POSTFIX_EXPR) {
        return new OctavePostfixExprImpl(node);
      }
      else if (type == RELATIONAL_EXPR) {
        return new OctaveRelationalExprImpl(node);
      }
      else if (type == STATEMENT) {
        return new OctaveStatementImpl(node);
      }
      else if (type == TRANSPOSE_EXPR) {
        return new OctaveTransposeExprImpl(node);
      }
      else if (type == UNARY_EXPR) {
        return new OctaveUnaryExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
