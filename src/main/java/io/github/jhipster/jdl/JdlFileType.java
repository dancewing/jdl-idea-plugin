package io.github.jhipster.jdl;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class JdlFileType extends LanguageFileType {

  public static final JdlFileType INSTANCE = new JdlFileType();

  private JdlFileType() {
    super(JdlLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public String getName() {
    return "Jdl File";
  }

  @NotNull
  @Override
  public String getDescription() {
    return "Jdl language file";
  }

  @NotNull
  @Override
  public String getDefaultExtension() {
    return "jdl";
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return JdlIcons.FILE;
  }

}
