// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package io.github.jhipster.jdl;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import io.github.jhipster.jdl.psi.JdlFile;
import io.github.jhipster.jdl.psi.JdlProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JdlUtil {

  /**
   * Searches the entire project for Simple language files with instances of the Simple property with the given key.
   *
   * @param project current project
   * @param key     to check
   * @return matching properties
   */
  public static List<JdlProperty> findProperties(Project project, String key) {
    List<JdlProperty> result = new ArrayList<>();
    Collection<VirtualFile> virtualFiles =
            FileTypeIndex.getFiles(JdlFileType.INSTANCE, GlobalSearchScope.allScope(project));
    for (VirtualFile virtualFile : virtualFiles) {
      JdlFile simpleFile = (JdlFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (simpleFile != null) {
        JdlProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, JdlProperty.class);
        if (properties != null) {
          for (JdlProperty property : properties) {
            if (key.equals(property.getKey())) {
              result.add(property);
            }
          }
        }
      }
    }
    return result;
  }

  public static List<JdlProperty> findProperties(Project project) {
    List<JdlProperty> result = new ArrayList<>();
    Collection<VirtualFile> virtualFiles =
            FileTypeIndex.getFiles(JdlFileType.INSTANCE, GlobalSearchScope.allScope(project));
    for (VirtualFile virtualFile : virtualFiles) {
      JdlFile simpleFile = (JdlFile) PsiManager.getInstance(project).findFile(virtualFile);
      if (simpleFile != null) {
        JdlProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, JdlProperty.class);
        if (properties != null) {
          Collections.addAll(result, properties);
        }
      }
    }
    return result;
  }

}
