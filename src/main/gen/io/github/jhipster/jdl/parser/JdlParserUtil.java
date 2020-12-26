package io.github.jhipster.jdl.parser;

import static io.github.jhipster.jdl.psi.JdlTypes.*;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.KeyWithDefaultValue;
import io.github.jhipster.jdl.JdlTokenTypes;
import java.util.Deque;
import com.intellij.openapi.util.Key;

public class JdlParserUtil extends GeneratedParserUtilBase {

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
