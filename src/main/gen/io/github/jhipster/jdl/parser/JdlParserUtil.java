package io.github.jhipster.jdl.parser;

import static io.github.jhipster.jdl.psi.JdlTypes.*;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import io.github.jhipster.jdl.JdlTokenTypes;

public class JdlParserUtil extends GeneratedParserUtilBase {

  public static boolean clearError(PsiBuilder builder, int level) {
    ErrorState.get(builder).currentFrame.errorReportedAt = -1;
    return true;
  }

  public static boolean withProtectedLastVariantPos(PsiBuilder builder, int level, Parser parser) {
    ErrorState state = ErrorState.get(builder);
    int prev = state.currentFrame.lastVariantAt;
    if (parser.parse(builder, level)) {
      return true;
    }
    else {
      state.currentFrame.lastVariantAt = prev;
      return false;
    }
  }

  public static boolean nonStrictID(PsiBuilder builder_, int level_) {
    final PsiBuilder.Marker marker_ = builder_.mark();
    final boolean result_ = consumeToken(builder_, IDENTIFIER);
    if (result_) {
      marker_.done(ID);
      return true;
    }
    else if (JdlTokenTypes.BUILT_IN_IDENTIFIERS.contains(builder_.getTokenType())) {
      builder_.advanceLexer();
      marker_.done(ID);
      return true;
    }
    marker_.rollbackTo();
    return false;
  }
}
