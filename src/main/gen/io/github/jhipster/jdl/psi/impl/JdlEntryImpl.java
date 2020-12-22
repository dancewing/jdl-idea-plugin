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

public class JdlEntryImpl extends JdlPsiCompositeElementImpl implements JdlEntry {

  public JdlEntryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JdlVisitor visitor) {
    visitor.visitEntry(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JdlVisitor) accept((JdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public JdlApplicationTypeDefinition getApplicationTypeDefinition() {
    return findChildByClass(JdlApplicationTypeDefinition.class);
  }

  @Override
  @Nullable
  public JdlDirectiveTypeDefinition getDirectiveTypeDefinition() {
    return findChildByClass(JdlDirectiveTypeDefinition.class);
  }

  @Override
  @Nullable
  public JdlEntityTypeDefinition getEntityTypeDefinition() {
    return findChildByClass(JdlEntityTypeDefinition.class);
  }

  @Override
  @Nullable
  public JdlEnumTypeDefinition getEnumTypeDefinition() {
    return findChildByClass(JdlEnumTypeDefinition.class);
  }

}
