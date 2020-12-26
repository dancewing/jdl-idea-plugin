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

public class JdlOptionDefinitionImpl extends AbstractJdlComponentImpl implements JdlOptionDefinition {

  public JdlOptionDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JdlVisitor visitor) {
    visitor.visitOptionDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JdlVisitor) accept((JdlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public JdlExcludeEntityNames getExcludeEntityNames() {
    return findChildByClass(JdlExcludeEntityNames.class);
  }

  @Override
  @Nullable
  public JdlIncludeEntityNames getIncludeEntityNames() {
    return findChildByClass(JdlIncludeEntityNames.class);
  }

  @Override
  @NotNull
  public JdlOptionName getOptionName() {
    return findNotNullChildByClass(JdlOptionName.class);
  }

  @Override
  @Nullable
  public JdlOptionTypeValue getOptionTypeValue() {
    return findChildByClass(JdlOptionTypeValue.class);
  }

}
