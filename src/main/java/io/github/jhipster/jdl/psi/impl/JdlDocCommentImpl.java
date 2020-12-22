package io.github.jhipster.jdl.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.psi.tree.IElementType;
import io.github.jhipster.jdl.psi.JdlDocComment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JdlDocCommentImpl extends ASTWrapperPsiElement implements JdlDocComment {
  public JdlDocCommentImpl(@NotNull final ASTNode node) {
    super(node);
  }

  @Override
  @Nullable
  public PsiElement getOwner() {
    return null; // todo
  }

  @NotNull
  @Override
  public IElementType getTokenType() {
    return getNode().getElementType();
  }

  @Override
  public PsiReference @NotNull [] getReferences() {
    return ReferenceProvidersRegistry.getReferencesFromProviders(this);
  }
}
