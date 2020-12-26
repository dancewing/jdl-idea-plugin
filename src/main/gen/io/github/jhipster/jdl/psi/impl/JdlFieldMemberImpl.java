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

public class JdlFieldMemberImpl extends AbstractJdlComponentImpl implements JdlFieldMember {

  public JdlFieldMemberImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JdlVisitor visitor) {
    visitor.visitFieldMember(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JdlVisitor) accept((JdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public JdlComponentName getComponentName() {
    return findNotNullChildByClass(JdlComponentName.class);
  }

  @Override
  @NotNull
  public JdlFieldTypeDefinition getFieldTypeDefinition() {
    return findNotNullChildByClass(JdlFieldTypeDefinition.class);
  }

  @Override
  @Nullable
  public JdlFieldValidations getFieldValidations() {
    return findChildByClass(JdlFieldValidations.class);
  }

  @Override
  @NotNull
  public List<JdlMetadata> getMetadataList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JdlMetadata.class);
  }

}
