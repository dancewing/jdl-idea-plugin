package io.github.jhipster.jdl.psi;

import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.tree.IElementType;

public interface JdlPsiCompositeElement extends NavigatablePsiElement {
  IElementType getTokenType();
}
