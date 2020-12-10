// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import io.github.jhipster.jdl.JdlIcons;
import io.github.jhipster.jdl.psi.JdlElementFactory;
import io.github.jhipster.jdl.psi.JdlProperty;
import io.github.jhipster.jdl.psi.JdlTypes;
import javax.swing.Icon;
import org.jetbrains.annotations.Nullable;

public class JdlPsiImplUtil {

  public static String getKey(JdlProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(JdlTypes.KEY);
    if (keyNode != null) {
      // IMPORTANT: Convert embedded escaped spaces to simple spaces
      return keyNode.getText().replaceAll("\\\\ ", " ");
    } else {
      return null;
    }
  }

  public static String getValue(JdlProperty element) {
    ASTNode valueNode = element.getNode().findChildByType(JdlTypes.VALUE);
    if (valueNode != null) {
      return valueNode.getText();
    } else {
      return null;
    }
  }

  public static String getName(JdlProperty element) {
    return getKey(element);
  }

  public static PsiElement setName(JdlProperty element, String newName) {
    ASTNode keyNode = element.getNode().findChildByType(JdlTypes.KEY);
    if (keyNode != null) {
      JdlProperty property = JdlElementFactory.createProperty(element.getProject(), newName);
      ASTNode newKeyNode = property.getFirstChild().getNode();
      element.getNode().replaceChild(keyNode, newKeyNode);
    }
    return element;
  }

  public static PsiElement getNameIdentifier(JdlProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(JdlTypes.KEY);
    if (keyNode != null) {
      return keyNode.getPsi();
    } else {
      return null;
    }
  }

  public static ItemPresentation getPresentation(final JdlProperty element) {
    return new ItemPresentation() {
      @Nullable
      @Override
      public String getPresentableText() {
        return element.getKey();
      }

      @Nullable
      @Override
      public String getLocationString() {
        PsiFile containingFile = element.getContainingFile();
        return containingFile == null ? null : containingFile.getName();
      }

      @Override
      public Icon getIcon(boolean unused) {
        return JdlIcons.FILE;
      }
    };
  }

}
