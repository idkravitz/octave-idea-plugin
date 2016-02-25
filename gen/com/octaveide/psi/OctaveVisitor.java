// This is a generated file. Not intended for manual editing.
package com.octaveide.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class OctaveVisitor extends PsiElementVisitor {

  public void visitAddExpr(@NotNull OctaveAddExpr o) {
    visitBinaryExpr(o);
  }

  public void visitBinaryExpr(@NotNull OctaveBinaryExpr o) {
    visitExpr(o);
  }

  public void visitExpr(@NotNull OctaveExpr o) {
    visitPsiElement(o);
  }

  public void visitLiteral(@NotNull OctaveLiteral o) {
    visitPsiElement(o);
  }

  public void visitStatement(@NotNull OctaveStatement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
