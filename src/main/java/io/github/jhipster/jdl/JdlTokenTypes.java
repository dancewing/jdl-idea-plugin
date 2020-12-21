package io.github.jhipster.jdl;

import static io.github.jhipster.jdl.psi.JdlTypes.NUM_INT;
import static io.github.jhipster.jdl.psi.JdlTypes.NUM_STRING;

import com.intellij.psi.tree.TokenSet;

public interface JdlTokenTypes {

  //TokenSet RESERVED_WORDS = TokenSet.create(ASSERT)

  TokenSet BUILT_IN_IDENTIFIERS = TokenSet.create(NUM_STRING,NUM_INT);

}
