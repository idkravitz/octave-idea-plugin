// This is a generated file. Not intended for manual editing.
package com.octaveide.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OctaveBinaryExpr extends OctaveExpr {

  @NotNull
  List<OctaveExpr> getExprList();

  @NotNull
  OctaveExpr getLeft();

  @Nullable
  OctaveExpr getRight();

}
