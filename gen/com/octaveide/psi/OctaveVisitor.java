// This is a generated file. Not intended for manual editing.
package com.octaveide.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class OctaveVisitor extends PsiElementVisitor {

  public void visitAddExpr(@NotNull OctaveAddExpr o) {
    visitExpr(o);
  }

  public void visitAndExpr(@NotNull OctaveAndExpr o) {
    visitExpr(o);
  }

  public void visitAssignExpr(@NotNull OctaveAssignExpr o) {
    visitExpr(o);
  }

  public void visitColonExpr(@NotNull OctaveColonExpr o) {
    visitExpr(o);
  }

  public void visitElementAndExpr(@NotNull OctaveElementAndExpr o) {
    visitExpr(o);
  }

  public void visitElementOrExpr(@NotNull OctaveElementOrExpr o) {
    visitExpr(o);
  }

  public void visitExponentExpr(@NotNull OctaveExponentExpr o) {
    visitExpr(o);
  }

  public void visitExpr(@NotNull OctaveExpr o) {
    visitPsiElement(o);
  }

  public void visitIdentifierExpr(@NotNull OctaveIdentifierExpr o) {
    visitExpr(o);
  }

  public void visitLiteralExpr(@NotNull OctaveLiteralExpr o) {
    visitExpr(o);
  }

  public void visitMulExpr(@NotNull OctaveMulExpr o) {
    visitExpr(o);
  }

  public void visitOrExpr(@NotNull OctaveOrExpr o) {
    visitExpr(o);
  }

  public void visitParenExpr(@NotNull OctaveParenExpr o) {
    visitExpr(o);
  }

  public void visitPostfixExpr(@NotNull OctavePostfixExpr o) {
    visitExpr(o);
  }

  public void visitRelationalExpr(@NotNull OctaveRelationalExpr o) {
    visitExpr(o);
  }

  public void visitStatement(@NotNull OctaveStatement o) {
    visitPsiElement(o);
  }

  public void visitTransposeExpr(@NotNull OctaveTransposeExpr o) {
    visitExpr(o);
  }

  public void visitUnaryExpr(@NotNull OctaveUnaryExpr o) {
    visitExpr(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
