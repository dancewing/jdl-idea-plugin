// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.jhipster.jdl.psi.JdlTypes.*;
import io.github.jhipster.jdl.psi.*;

public class JdlConfigItemImpl extends JdlPsiCompositeElementImpl implements JdlConfigItem {

  public JdlConfigItemImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JdlVisitor visitor) {
    visitor.visitConfigItem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JdlVisitor) accept((JdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public JdlConfigArrayItem getConfigArrayItem() {
    return findChildByClass(JdlConfigArrayItem.class);
  }

  @Override
  @Nullable
  public JdlConfigBooleanItem getConfigBooleanItem() {
    return findChildByClass(JdlConfigBooleanItem.class);
  }

  @Override
  @Nullable
  public JdlConfigNumberItem getConfigNumberItem() {
    return findChildByClass(JdlConfigNumberItem.class);
  }

  @Override
  @Nullable
  public JdlConfigStringItem getConfigStringItem() {
    return findChildByClass(JdlConfigStringItem.class);
  }

  @Override
  @Nullable
  public JdlPackageNameConfigItem getPackageNameConfigItem() {
    return findChildByClass(JdlPackageNameConfigItem.class);
  }

}
