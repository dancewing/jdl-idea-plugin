package io.github.jhipster.jdl.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import io.github.jhipster.jdl.psi.JdlComponent;
import io.github.jhipster.jdl.psi.JdlComponentName;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractJdlComponentImpl extends JdlPsiCompositeElementImpl implements JdlComponent {

  public AbstractJdlComponentImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public @Nullable PsiElement getNameIdentifier() {
    return null;
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
    return this;
  }
}
