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

public class JdlRelationshipItemsImpl extends JdlPsiCompositeElementImpl implements JdlRelationshipItems {

  public JdlRelationshipItemsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JdlVisitor visitor) {
    visitor.visitRelationshipItems(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JdlVisitor) accept((JdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<JdlMetadata> getMetadataList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JdlMetadata.class);
  }

  @Override
  @NotNull
  public JdlRelationshipSourceType getRelationshipSourceType() {
    return findNotNullChildByClass(JdlRelationshipSourceType.class);
  }

  @Override
  @Nullable
  public JdlRelationshipSourceTypeOptions getRelationshipSourceTypeOptions() {
    return findChildByClass(JdlRelationshipSourceTypeOptions.class);
  }

  @Override
  @NotNull
  public JdlRelationshipTargetType getRelationshipTargetType() {
    return findNotNullChildByClass(JdlRelationshipTargetType.class);
  }

  @Override
  @Nullable
  public JdlRelationshipTargetTypeOptions getRelationshipTargetTypeOptions() {
    return findChildByClass(JdlRelationshipTargetTypeOptions.class);
  }

}
