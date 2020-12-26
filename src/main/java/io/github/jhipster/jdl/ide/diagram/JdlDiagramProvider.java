package io.github.jhipster.jdl.ide.diagram;

import com.intellij.diagram.DiagramDataModel;
import com.intellij.diagram.DiagramElementManager;
import com.intellij.diagram.DiagramNodeContentManager;
import com.intellij.diagram.DiagramPresentationModel;
import com.intellij.diagram.DiagramProvider;
import com.intellij.diagram.DiagramRelationshipManager;
import com.intellij.diagram.DiagramVfsResolver;
import com.intellij.diagram.DiagramVisibilityManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsContexts.Label;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JdlDiagramProvider extends DiagramProvider<PsiNamedElement> {

  public static final String ID = "JDL Diagram";
  @Override
  public String getID() {
    return ID;
  }

  @Override
  public DiagramVisibilityManager createVisibilityManager() {
    return null;
  }

  @Override
  public DiagramNodeContentManager getNodeContentManager() {
    return null;
  }

  @Override
  public DiagramElementManager<PsiNamedElement> getElementManager() {
    return null;
  }

  @Override
  public DiagramVfsResolver<PsiNamedElement> getVfsResolver() {
    return null;
  }

  @Override
  public DiagramRelationshipManager<PsiNamedElement> getRelationshipManager() {
    return null;
  }

  @Override
  public @Label String getPresentableName() {
    return null;
  }

  @Override
  public DiagramDataModel<PsiNamedElement> createDataModel(@NotNull Project project, @Nullable PsiNamedElement psiNamedElement,
      @Nullable VirtualFile virtualFile, DiagramPresentationModel diagramPresentationModel) {
    return null;
  }
}
