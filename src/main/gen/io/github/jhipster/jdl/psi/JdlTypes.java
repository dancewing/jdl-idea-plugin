// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.jhipster.jdl.psi.impl.*;

public interface JdlTypes {

  IElementType APPLICATION_TYPE = new JdlElementType("APPLICATION_TYPE");
  IElementType APPLICATION_TYPE_BODY = new JdlElementType("APPLICATION_TYPE_BODY");
  IElementType APPLICATION_TYPE_BODY_INNER = new JdlElementType("APPLICATION_TYPE_BODY_INNER");
  IElementType APPLICATION_TYPE_DEFINITION = new JdlElementType("APPLICATION_TYPE_DEFINITION");
  IElementType ENTITY_TYPE = new JdlElementType("ENTITY_TYPE");
  IElementType ENTITY_TYPE_BODY = new JdlElementType("ENTITY_TYPE_BODY");
  IElementType ENTITY_TYPE_BODY_INNER = new JdlElementType("ENTITY_TYPE_BODY_INNER");
  IElementType ENTITY_TYPE_DEFINITION = new JdlElementType("ENTITY_TYPE_DEFINITION");
  IElementType TOP_LEVEL = new JdlElementType("TOP_LEVEL");
  IElementType TOP_LEVELS = new JdlElementType("TOP_LEVELS");
  IElementType TOP_LEVEL_ITEM = new JdlElementType("TOP_LEVEL_ITEM");

  IElementType BLANK = new JdlTokenType("BLANK");
  IElementType BLOCK_COMMENT = new JdlTokenType("BLOCK_COMMENT");
  IElementType IDENTIFIER = new JdlTokenType("identifier");
  IElementType KW_APPLICATION = new JdlTokenType("application");
  IElementType KW_ENTITY = new JdlTokenType("entity");
  IElementType KW_ENUM = new JdlTokenType("enum");
  IElementType LINEFEED = new JdlTokenType("\\n");
  IElementType ML_COMMENT = new JdlTokenType("block comment");
  IElementType NL = new JdlTokenType("new line");
  IElementType NUM_ANY_BLOB = new JdlTokenType("AnyBlob");
  IElementType NUM_BIG_DECIMAL = new JdlTokenType("BigDecimal");
  IElementType NUM_BLOB = new JdlTokenType("Blob");
  IElementType NUM_BOOELAN = new JdlTokenType("Boolean");
  IElementType NUM_DOUBLE = new JdlTokenType("Double");
  IElementType NUM_ENUM = new JdlTokenType("Enum");
  IElementType NUM_FLOAT = new JdlTokenType("Float");
  IElementType NUM_IMAGE_BLOB = new JdlTokenType("ImageBlob");
  IElementType NUM_INT = new JdlTokenType("Integer");
  IElementType NUM_LOCAL_DATE = new JdlTokenType("LocalDate");
  IElementType NUM_LONG = new JdlTokenType("Long");
  IElementType NUM_STRING = new JdlTokenType("String");
  IElementType NUM_TEXT_BLOB = new JdlTokenType("TextBlob");
  IElementType NUM_ZONED_DATE_TIME = new JdlTokenType("ZonedDateTime");
  IElementType SH_COMMENT = new JdlTokenType("shell comment");
  IElementType SL_COMMENT = new JdlTokenType("line comment");
  IElementType T_LBRACE = new JdlTokenType("{");
  IElementType T_LBRACK = new JdlTokenType("[");
  IElementType T_LPAREN = new JdlTokenType("(");
  IElementType T_RBRACE = new JdlTokenType("}");
  IElementType T_RBRACK = new JdlTokenType("]");
  IElementType T_RPAREN = new JdlTokenType(")");
  IElementType T_WRONG = new JdlTokenType("wrong token");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == APPLICATION_TYPE) {
        return new JdlApplicationTypeImpl(node);
      }
      else if (type == APPLICATION_TYPE_BODY) {
        return new JdlApplicationTypeBodyImpl(node);
      }
      else if (type == APPLICATION_TYPE_BODY_INNER) {
        return new JdlApplicationTypeBodyInnerImpl(node);
      }
      else if (type == APPLICATION_TYPE_DEFINITION) {
        return new JdlApplicationTypeDefinitionImpl(node);
      }
      else if (type == ENTITY_TYPE) {
        return new JdlEntityTypeImpl(node);
      }
      else if (type == ENTITY_TYPE_BODY) {
        return new JdlEntityTypeBodyImpl(node);
      }
      else if (type == ENTITY_TYPE_BODY_INNER) {
        return new JdlEntityTypeBodyInnerImpl(node);
      }
      else if (type == ENTITY_TYPE_DEFINITION) {
        return new JdlEntityTypeDefinitionImpl(node);
      }
      else if (type == TOP_LEVEL) {
        return new JdlTopLevelImpl(node);
      }
      else if (type == TOP_LEVELS) {
        return new JdlTopLevelsImpl(node);
      }
      else if (type == TOP_LEVEL_ITEM) {
        return new JdlTopLevelItemImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
