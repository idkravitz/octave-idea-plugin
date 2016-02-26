// This is a generated file. Not intended for manual editing.
package com.octaveide.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.octaveide.psi.OctaveTypes.*;
import com.octaveide.psi.*;

public class OctaveIdentifierExprImpl extends OctaveExprImpl implements OctaveIdentifierExpr {

  public OctaveIdentifierExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OctaveVisitor) ((OctaveVisitor)visitor).visitIdentifierExpr(this);
    else super.accept(visitor);
  }

}
