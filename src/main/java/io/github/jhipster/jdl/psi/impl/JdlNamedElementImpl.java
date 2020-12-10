// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import io.github.jhipster.jdl.psi.JdlNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class JdlNamedElementImpl extends ASTWrapperPsiElement implements JdlNamedElement {

  public JdlNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }

}
