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

public class JdlApplicationConfigImpl extends JdlPsiCompositeElementImpl implements JdlApplicationConfig {

  public JdlApplicationConfigImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JdlVisitor visitor) {
    visitor.visitApplicationConfig(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JdlVisitor) accept((JdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<JdlConfigArrayItem> getConfigArrayItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JdlConfigArrayItem.class);
  }

  @Override
  @NotNull
  public List<JdlConfigBooleanItem> getConfigBooleanItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JdlConfigBooleanItem.class);
  }

  @Override
  @NotNull
  public List<JdlConfigNumberItem> getConfigNumberItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JdlConfigNumberItem.class);
  }

  @Override
  @NotNull
  public List<JdlConfigStringItem> getConfigStringItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JdlConfigStringItem.class);
  }

  @Override
  @NotNull
  public List<JdlPackageNameConfigItem> getPackageNameConfigItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JdlPackageNameConfigItem.class);
  }

}
