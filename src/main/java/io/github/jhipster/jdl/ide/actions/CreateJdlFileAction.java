package io.github.jhipster.jdl.ide.actions;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import io.github.jhipster.jdl.JdlBundle;
import io.github.jhipster.jdl.JdlIcons;
import org.jetbrains.annotations.NotNull;

public class CreateJdlFileAction extends CreateFileFromTemplateAction {
  public CreateJdlFileAction() {
    super(JdlBundle.messagePointer("action.title.jdl.file"),
        JdlBundle.messagePointer("action.description.create.jdl.file"),
          JdlIcons.FILE);
  }

  @Override
  protected boolean isAvailable(DataContext dataContext) {
    return super.isAvailable(dataContext);
  }

  @Override
  protected String getActionName(PsiDirectory directory, @NotNull String newName, String templateName) {
    return JdlBundle.message("title.create.dart.file.0", newName);
  }

  @Override
  protected void buildDialog(@NotNull Project project,
                             @NotNull PsiDirectory directory,
                             @NotNull CreateFileFromTemplateDialog.Builder builder) {
    builder
      .setTitle(JdlBundle.message("new.jdl.file.title"))
      .addKind(JdlBundle.message("list.item.jdl.file"), JdlIcons.FILE, "Jdl File");
  }
}
