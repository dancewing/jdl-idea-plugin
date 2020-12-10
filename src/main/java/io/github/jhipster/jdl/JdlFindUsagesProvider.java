// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import io.github.jhipster.jdl.psi.JdlProperty;
import io.github.jhipster.jdl.psi.JdlTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JdlFindUsagesProvider implements FindUsagesProvider {

  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return new DefaultWordsScanner(new JdlLexerAdapter(),
            TokenSet.create(JdlTypes.KEY),
            TokenSet.create(JdlTypes.COMMENT),
            TokenSet.EMPTY);
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
    return psiElement instanceof PsiNamedElement;
  }

  @Nullable
  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return null;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    if (element instanceof JdlProperty) {
      return "jdl property";
    } else {
      return "";
    }
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    if (element instanceof JdlProperty) {
      return ((JdlProperty) element).getKey();
    } else {
      return "";
    }
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    if (element instanceof JdlProperty) {
      return ((JdlProperty) element).getKey() + JdlAnnotator.SIMPLE_SEPARATOR_STR + ((JdlProperty) element).getValue();
    } else {
      return "";
    }
  }

}
