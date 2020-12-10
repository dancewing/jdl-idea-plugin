// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import io.github.jhipster.jdl.JdlFileType;

public class JdlElementFactory {

  public static JdlProperty createProperty(Project project, String name) {
    final JdlFile file = createFile(project, name);
    return (JdlProperty) file.getFirstChild();
  }

  public static JdlFile createFile(Project project, String text) {
    String name = "dummy.simple";
    return (JdlFile) PsiFileFactory.getInstance(project).createFileFromText(name, JdlFileType.INSTANCE, text);
  }

  public static JdlProperty createProperty(Project project, String name, String value) {
    final JdlFile file = createFile(project, name + " = " + value);
    return (JdlProperty) file.getFirstChild();
  }

  public static PsiElement createCRLF(Project project) {
    final JdlFile file = createFile(project, "\n");
    return file.getFirstChild();
  }

}
