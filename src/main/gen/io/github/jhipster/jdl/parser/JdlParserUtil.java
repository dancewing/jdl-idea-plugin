package io.github.jhipster.jdl.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;

public class JdlParserUtil extends GeneratedParserUtilBase {

  public static boolean clearError(PsiBuilder builder, int level) {
    ErrorState.get(builder).currentFrame.errorReportedAt = -1;
    return true;
  }

}
