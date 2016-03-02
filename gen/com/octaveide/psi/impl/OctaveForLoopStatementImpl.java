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

public class OctaveForLoopStatementImpl extends OctaveStatementImpl implements OctaveForLoopStatement {

  public OctaveForLoopStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OctaveVisitor) ((OctaveVisitor)visitor).visitForLoopStatement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public OctaveExpr getExpr() {
    return findNotNullChildByClass(OctaveExpr.class);
  }

  @Override
  @NotNull
  public List<OctaveStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OctaveStatement.class);
  }

}
