package io.github.jhipster.jdl.highlight;

import com.intellij.ide.highlighter.EmbeddedTokenHighlighter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.MultiMap;
import io.github.jhipster.jdl.JdlElementType;
import io.github.jhipster.jdl.lexer.JdlLexer;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import static io.github.jhipster.jdl.JdlTokenTypes.*;
import static io.github.jhipster.jdl.psi.JdlTypes.*;

public class JdlSyntaxHighlighter extends SyntaxHighlighterBase implements EmbeddedTokenHighlighter {

  private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

  static {

    fillMap(ATTRIBUTES, RESERVED_WORDS, JdlSyntaxHighlighterColors.KEYWORD);

    fillMap(ATTRIBUTES, OPTIONS, JdlSyntaxHighlighterColors.ANNOTATION);

    fillMap(ATTRIBUTES, CONFIG_ITEMS, JdlSyntaxHighlighterColors.STATIC_FIELD_DECLARATION);

    ATTRIBUTES.put(ENUM_CONSTANT_DECLARATION, JdlSyntaxHighlighterColors.ENUM_CONSTANT);

    fillMap(ATTRIBUTES, FIELD_TYPES, JdlSyntaxHighlighterColors.INSTANCE_METHOD_DECLARATION);

    ATTRIBUTES.put(QUEST, JdlSyntaxHighlighterColors.OPERATION_SIGN);

    ATTRIBUTES.put(HEX_NUMBER, JdlSyntaxHighlighterColors.NUMBER);
    ATTRIBUTES.put(NUMBER, JdlSyntaxHighlighterColors.NUMBER);

    ATTRIBUTES.put(LPAREN, JdlSyntaxHighlighterColors.PARENTHS);
    ATTRIBUTES.put(RPAREN, JdlSyntaxHighlighterColors.PARENTHS);

    ATTRIBUTES.put(LBRACE, JdlSyntaxHighlighterColors.BRACES);
    ATTRIBUTES.put(RBRACE, JdlSyntaxHighlighterColors.BRACES);

    ATTRIBUTES.put(LBRACKET, JdlSyntaxHighlighterColors.BRACKETS);
    ATTRIBUTES.put(RBRACKET, JdlSyntaxHighlighterColors.BRACKETS);

    ATTRIBUTES.put(COMMA, JdlSyntaxHighlighterColors.COMMA);
    ATTRIBUTES.put(DOT, JdlSyntaxHighlighterColors.DOT);
    ATTRIBUTES.put(SEMICOLON, JdlSyntaxHighlighterColors.SEMICOLON);
    ATTRIBUTES.put(COLON, JdlSyntaxHighlighterColors.COLON);

    ATTRIBUTES.put(SINGLE_LINE_COMMENT, JdlSyntaxHighlighterColors.LINE_COMMENT);
    ATTRIBUTES.put(SINGLE_LINE_DOC_COMMENT, JdlSyntaxHighlighterColors.DOC_COMMENT);
    ATTRIBUTES.put(MULTI_LINE_COMMENT, JdlSyntaxHighlighterColors.BLOCK_COMMENT);
    ATTRIBUTES.put(MULTI_LINE_DOC_COMMENT, JdlSyntaxHighlighterColors.DOC_COMMENT);

    ATTRIBUTES.put(BAD_CHARACTER, JdlSyntaxHighlighterColors.BAD_CHARACTER);
  }

  @Override
  public @NotNull MultiMap<IElementType, TextAttributesKey> getEmbeddedTokenAttributes() {
    MultiMap<IElementType, TextAttributesKey> map = MultiMap.create();
    map.putAllValues(ATTRIBUTES);
    return map;
  }

  @Override
  public @NotNull Lexer getHighlightingLexer() {
    return new JdlLexer();
  }

  @Override
  public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
    return pack(ATTRIBUTES.get(tokenType));
  }
}
