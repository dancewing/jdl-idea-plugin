// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.jhipster.jdl.psi.impl.*;

public interface JdlTypes {

  IElementType PROPERTY = new JdlElementType("PROPERTY");

  IElementType COMMENT = new JdlTokenType("COMMENT");
  IElementType CRLF = new JdlTokenType("CRLF");
  IElementType KEY = new JdlTokenType("KEY");
  IElementType SEPARATOR = new JdlTokenType("SEPARATOR");
  IElementType VALUE = new JdlTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new JdlPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
