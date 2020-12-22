// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import io.github.jhipster.jdl.psi.JdlId;
import io.github.jhipster.jdl.psi.JdlNamedElement;
import javax.swing.Icon;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class JdlNamedElementImpl extends JdlPsiCompositeElementImpl implements JdlNamedElement {

  public JdlNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public PsiElement setName(@NonNls @NotNull String newElementName) throws IncorrectOperationException {
    final JdlId identifier = getId();
//    final JdlId identifierNew = DartElementGenerator.createIdentifierFromText(getProject(), newElementName);
//
//    if (identifierNew != null) {
//      getNode().replaceChild(identifier.getNode(), identifierNew.getNode());
//    }

    return this;
  }

  @Override
  public String getName() {
    return getId().getText();
  }

  @Override
  @Nullable
  public ItemPresentation getPresentation() {
    final PsiElement parent = getParent();
    if (parent instanceof NavigationItem) {
      return ((NavigationItem)parent).getPresentation();
    }
    return null;
  }

  @Override
  public Icon getIcon(int flags) {
    final ItemPresentation presentation = getPresentation();
    return presentation == null ? super.getIcon(flags) : presentation.getIcon(true);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return this;
  }

  @NotNull
  @Override
  public JdlId getId() {
    return PsiTreeUtil.getChildOfType(this, JdlId.class);
  }
}
