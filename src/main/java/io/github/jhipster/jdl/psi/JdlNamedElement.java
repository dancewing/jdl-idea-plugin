// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl.psi;

import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;

public interface JdlNamedElement extends JdlPsiCompositeElement, PsiNamedElement, NavigationItem, PsiNameIdentifierOwner {
  JdlId getId();
}
