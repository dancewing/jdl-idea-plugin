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

public class JdlRelationshipDefinitionImpl extends JdlPsiCompositeElementImpl implements JdlRelationshipDefinition {

  public JdlRelationshipDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JdlVisitor visitor) {
    visitor.visitRelationshipDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JdlVisitor) accept((JdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<JdlRelationshipItems> getRelationshipItemsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JdlRelationshipItems.class);
  }

  @Override
  @NotNull
  public JdlRelationshipType getRelationshipType() {
    return findNotNullChildByClass(JdlRelationshipType.class);
  }

}
