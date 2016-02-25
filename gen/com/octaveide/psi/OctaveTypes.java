// This is a generated file. Not intended for manual editing.
package com.octaveide.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.octaveide.psi.impl.*;

public interface OctaveTypes {

  IElementType ADD_EXPR = new OctaveElementType("ADD_EXPR");
  IElementType EXPR = new OctaveElementType("EXPR");
  IElementType STATEMENT = new OctaveElementType("STATEMENT");

  IElementType COMMENT = new OctaveTokenType("COMMENT");
  IElementType CRLF = new OctaveTokenType("CRLF");
  IElementType MINUS = new OctaveTokenType("-");
  IElementType NUMBER = new OctaveTokenType("NUMBER");
  IElementType PLUS = new OctaveTokenType("+");
  IElementType SEMICOLON = new OctaveTokenType(";");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ADD_EXPR) {
        return new OctaveAddExprImpl(node);
      }
      else if (type == EXPR) {
        return new OctaveExprImpl(node);
      }
      else if (type == STATEMENT) {
        return new OctaveStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
