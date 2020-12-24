package io.github.jhipster.jdl.highlight;

import com.intellij.codeInsight.highlighting.HighlightErrorFilter;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiFile;
import io.github.jhipster.jdl.JdlLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JdlHighlightingErrorFilter extends HighlightErrorFilter {
  @Override
  public boolean shouldHighlightErrorElement(@NotNull final PsiErrorElement element) {
    if (!(element.getLanguage() == JdlLanguage.INSTANCE)) return true;

    return true;
/*    final VirtualFile file = getRealVirtualFile(element.getContainingFile());
    if (file != null && file.isInLocalFileSystem() && ProjectFileIndex.getInstance(element.getProject()).isInContent(file)) {
      return false;
    }

    return true;*/
  }

  @Nullable
  public static VirtualFile getRealVirtualFile(PsiFile psiFile) {
    return psiFile != null ? psiFile.getOriginalFile().getVirtualFile() : null;
  }
}
