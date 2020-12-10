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
import com.intellij.navigation.ItemPresentation;

public class JdlPropertyImpl extends JdlNamedElementImpl implements JdlProperty {

  public JdlPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JdlVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JdlVisitor) accept((JdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return JdlPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return JdlPsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return JdlPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return JdlPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return JdlPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return JdlPsiImplUtil.getPresentation(this);
  }

}
