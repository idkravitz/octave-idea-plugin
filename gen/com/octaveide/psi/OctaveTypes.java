// This is a generated file. Not intended for manual editing.
package com.octaveide.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.octaveide.psi.impl.*;

public interface OctaveTypes {

  IElementType ADD_EXPR = new OctaveElementType("ADD_EXPR");
  IElementType ASSIGN_EXPR = new OctaveElementType("ASSIGN_EXPR");
  IElementType EXPR = new OctaveElementType("EXPR");
  IElementType IDENTIFIER_EXPR = new OctaveElementType("IDENTIFIER_EXPR");
  IElementType LITERAL_EXPR = new OctaveElementType("LITERAL_EXPR");
  IElementType MUL_EXPR = new OctaveElementType("MUL_EXPR");
  IElementType STATEMENT = new OctaveElementType("STATEMENT");
  IElementType UNARY_EXPR = new OctaveElementType("UNARY_EXPR");

  IElementType ASSIGN = new OctaveTokenType("=");
  IElementType COMMENT = new OctaveTokenType("COMMENT");
  IElementType CRLF = new OctaveTokenType("CRLF");
  IElementType DIVIDE = new OctaveTokenType("/");
  IElementType FLOAT = new OctaveTokenType("float");
  IElementType IDENTIFIER = new OctaveTokenType("identifier");
  IElementType INT = new OctaveTokenType("int");
  IElementType MINUS = new OctaveTokenType("-");
  IElementType MULTIPLY = new OctaveTokenType("*");
  IElementType PLUS = new OctaveTokenType("+");
  IElementType SEMICOLON = new OctaveTokenType(";");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ADD_EXPR) {
        return new OctaveAddExprImpl(node);
      }
      else if (type == ASSIGN_EXPR) {
        return new OctaveAssignExprImpl(node);
      }
      else if (type == EXPR) {
        return new OctaveExprImpl(node);
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
      else if (type == STATEMENT) {
        return new OctaveStatementImpl(node);
      }
      else if (type == UNARY_EXPR) {
        return new OctaveUnaryExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
