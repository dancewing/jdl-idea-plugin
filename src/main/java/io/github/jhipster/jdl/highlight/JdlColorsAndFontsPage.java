package io.github.jhipster.jdl.highlight;

import static io.github.jhipster.jdl.highlight.JdlSyntaxHighlighterColors.*;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import io.github.jhipster.jdl.JdlBundle;
import io.github.jhipster.jdl.JdlFileType;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;

public class JdlColorsAndFontsPage implements ColorSettingsPage {
  private static final AttributesDescriptor[] ATTRS;

  private static final Map<String, TextAttributesKey> PREVIEW_TAGS = new HashMap<>();
  private static final String PREVIEW_TEXT =
    "<JDL_KEYWORD>library</JDL_KEYWORD> <JDL_LIBRARY_NAME>libraryName</JDL_LIBRARY_NAME>;\n" +
    "<JDL_KEYWORD>import</JDL_KEYWORD> \"dart:html\" <JDL_KEYWORD>as</JDL_KEYWORD> <JDL_IMPORT_PREFIX>html</JDL_IMPORT_PREFIX>;\n" +
    "// Comment. <ERROR>Error.</ERROR> <WARNING>Warning.</WARNING> <HINT>Hint.</HINT>\n" +
    "<JDL_TYPE_NAME_DYNAMIC>dynamic</JDL_TYPE_NAME_DYNAMIC> <JDL_TOP_LEVEL_VARIABLE_DECLARATION>topLevelVariable</JDL_TOP_LEVEL_VARIABLE_DECLARATION> = \"Escape sequences: <JDL_VALID_STRING_ESCAPE>\\n</JDL_VALID_STRING_ESCAPE> <JDL_VALID_STRING_ESCAPE>\\xFF</JDL_VALID_STRING_ESCAPE> <JDL_VALID_STRING_ESCAPE>\\u1234</JDL_VALID_STRING_ESCAPE> <JDL_VALID_STRING_ESCAPE>\\u{2F}</JDL_VALID_STRING_ESCAPE>\";\n" +
    "<JDL_KEYWORD>get</JDL_KEYWORD> <JDL_TOP_LEVEL_GETTER_DECLARATION>topLevelGetter</JDL_TOP_LEVEL_GETTER_DECLARATION> { <JDL_KEYWORD>return</JDL_KEYWORD> <JDL_TOP_LEVEL_GETTER_REFERENCE>topLevelVariable</JDL_TOP_LEVEL_GETTER_REFERENCE>; }\n" +
    "<JDL_KEYWORD>set</JDL_KEYWORD> <JDL_TOP_LEVEL_SETTER_DECLARATION>topLevelSetter</JDL_TOP_LEVEL_SETTER_DECLARATION>(<JDL_CLASS>bool</JDL_CLASS> <JDL_PARAMETER_DECLARATION>parameter</JDL_PARAMETER_DECLARATION>) { <JDL_TOP_LEVEL_FUNCTION_REFERENCE>print</JDL_TOP_LEVEL_FUNCTION_REFERENCE>(<JDL_PARAMETER_REFERENCE>parameter</JDL_PARAMETER_REFERENCE>); }\n" +
    "<JDL_KEYWORD>void</JDL_KEYWORD> <JDL_TOP_LEVEL_FUNCTION_DECLARATION>topLevelFunction</JDL_TOP_LEVEL_FUNCTION_DECLARATION>(<JDL_DYNAMIC_PARAMETER_DECLARATION>dynamicParameter</JDL_DYNAMIC_PARAMETER_DECLARATION>) {\n" +
    "  <JDL_LOCAL_FUNCTION_DECLARATION>localFunction</JDL_LOCAL_FUNCTION_DECLARATION>() {}\n" +
    "  <JDL_CLASS>num</JDL_CLASS> <JDL_LOCAL_VARIABLE_DECLARATION>localVar</JDL_LOCAL_VARIABLE_DECLARATION> = \"Invalid escape sequences: <JDL_INVALID_STRING_ESCAPE>\\xZZ</JDL_INVALID_STRING_ESCAPE> <JDL_INVALID_STRING_ESCAPE>\\uXYZZ</JDL_INVALID_STRING_ESCAPE> <JDL_INVALID_STRING_ESCAPE>\\u{XYZ}</JDL_INVALID_STRING_ESCAPE>\";\n" +
    "  <JDL_KEYWORD>var</JDL_KEYWORD> <JDL_DYNAMIC_LOCAL_VARIABLE_DECLARATION>dynamicLocalVar</JDL_DYNAMIC_LOCAL_VARIABLE_DECLARATION> = <JDL_DYNAMIC_PARAMETER_REFERENCE>dynamicParameter</JDL_DYNAMIC_PARAMETER_REFERENCE> + <JDL_LOCAL_VARIABLE_REFERENCE>localVar</JDL_LOCAL_VARIABLE_REFERENCE> + <JDL_LOCAL_FUNCTION_REFERENCE>localFunction</JDL_LOCAL_FUNCTION_REFERENCE>();\n" +
    "  <JDL_TOP_LEVEL_SETTER_REFERENCE>topLevelSetter</JDL_TOP_LEVEL_SETTER_REFERENCE> = <JDL_DYNAMIC_LOCAL_VARIABLE_REFERENCE>dynamicLocalVar</JDL_DYNAMIC_LOCAL_VARIABLE_REFERENCE> + <JDL_TOP_LEVEL_GETTER_REFERENCE>topLevelGetter</JDL_TOP_LEVEL_GETTER_REFERENCE> + <JDL_TOP_LEVEL_FUNCTION_REFERENCE>topLevelFunction</JDL_TOP_LEVEL_FUNCTION_REFERENCE>(<JDL_KEYWORD>null</JDL_KEYWORD>);\n" +
    "  <JDL_LABEL>label</JDL_LABEL><JDL_COLON>:</JDL_COLON> <JDL_KEYWORD>while</JDL_KEYWORD> (<JDL_KEYWORD>true</JDL_KEYWORD>) { <JDL_KEYWORD>if</JDL_KEYWORD> (<JDL_IDENTIFIER>identifier</JDL_IDENTIFIER>) <JDL_KEYWORD>break</JDL_KEYWORD> <JDL_LABEL>label</JDL_LABEL>; }\n" +
    "}\n" +
    "/* block comment */\n" +
    "<JDL_KEYWORD>class</JDL_KEYWORD> <JDL_CLASS>Foo</JDL_CLASS><<JDL_TYPE_PARAMETER>K</JDL_TYPE_PARAMETER>, <JDL_TYPE_PARAMETER>V</JDL_TYPE_PARAMETER>> {\n" +
    "  <JDL_KEYWORD>static</JDL_KEYWORD> <JDL_KEYWORD>var</JDL_KEYWORD> <JDL_STATIC_FIELD_DECLARATION>staticField</JDL_STATIC_FIELD_DECLARATION> = <JDL_STATIC_GETTER_REFERENCE>staticGetter</JDL_STATIC_GETTER_REFERENCE>;\n" +
    "  <JDL_CLASS>List</JDL_CLASS> <JDL_INSTANCE_FIELD_DECLARATION>instanceField</JDL_INSTANCE_FIELD_DECLARATION> = [566];\n" +
    "  <JDL_ANNOTATION>@<JDL_TOP_LEVEL_GETTER_REFERENCE>deprecated</JDL_TOP_LEVEL_GETTER_REFERENCE></JDL_ANNOTATION> <JDL_CLASS>Foo</JDL_CLASS>.<JDL_CONSTRUCTOR>constructor</JDL_CONSTRUCTOR>(<JDL_KEYWORD>this</JDL_KEYWORD>.<JDL_INSTANCE_FIELD_REFERENCE>instanceField</JDL_INSTANCE_FIELD_REFERENCE>) { <JDL_INSTANCE_METHOD_REFERENCE>instanceMethod</JDL_INSTANCE_METHOD_REFERENCE>(); }\n" +
    "  <JDL_INSTANCE_METHOD_DECLARATION>instanceMethod</JDL_INSTANCE_METHOD_DECLARATION>() { <JDL_TOP_LEVEL_FUNCTION_REFERENCE>print</JDL_TOP_LEVEL_FUNCTION_REFERENCE>(<JDL_INSTANCE_GETTER_REFERENCE>instanceField</JDL_INSTANCE_GETTER_REFERENCE> + <JDL_INSTANCE_GETTER_REFERENCE>instanceGetter</JDL_INSTANCE_GETTER_REFERENCE>); }\n" +
    "  <JDL_KEYWORD>get</JDL_KEYWORD> <JDL_INSTANCE_GETTER_DECLARATION>instanceGetter</JDL_INSTANCE_GETTER_DECLARATION> { <JDL_INSTANCE_SETTER_REFERENCE>instanceSetter</JDL_INSTANCE_SETTER_REFERENCE> = <JDL_KEYWORD>true</JDL_KEYWORD>; }\n" +
    "  <JDL_KEYWORD>set</JDL_KEYWORD> <JDL_INSTANCE_SETTER_DECLARATION>instanceSetter</JDL_INSTANCE_SETTER_DECLARATION>(<JDL_DYNAMIC_PARAMETER_DECLARATION>_</JDL_DYNAMIC_PARAMETER_DECLARATION>) { <JDL_STATIC_SETTER_REFERENCE>staticSetter</JDL_STATIC_SETTER_REFERENCE> = <JDL_KEYWORD>null</JDL_KEYWORD>; }\n" +
    "  <JDL_KEYWORD>static</JDL_KEYWORD> <JDL_STATIC_METHOD_DECLARATION>staticMethod</JDL_STATIC_METHOD_DECLARATION>() <JDL_FAT_ARROW>=></JDL_FAT_ARROW> <JDL_STATIC_GETTER_REFERENCE>staticField</JDL_STATIC_GETTER_REFERENCE>.<JDL_UNRESOLVED_INSTANCE_MEMBER_REFERENCE>unresolved</JDL_UNRESOLVED_INSTANCE_MEMBER_REFERENCE>();\n" +
    "  <JDL_KEYWORD>static</JDL_KEYWORD> <JDL_KEYWORD>get</JDL_KEYWORD> <JDL_STATIC_GETTER_DECLARATION>staticGetter</JDL_STATIC_GETTER_DECLARATION> { <JDL_KEYWORD>return</JDL_KEYWORD> <JDL_STATIC_METHOD_REFERENCE>staticMethod</JDL_STATIC_METHOD_REFERENCE>(); }\n" +
    "  <JDL_KEYWORD>static</JDL_KEYWORD> <JDL_KEYWORD>set</JDL_KEYWORD> <JDL_STATIC_SETTER_DECLARATION>staticSetter</JDL_STATIC_SETTER_DECLARATION>(<JDL_CLASS>Foo</JDL_CLASS> <JDL_PARAMETER_DECLARATION>param</JDL_PARAMETER_DECLARATION>) { <JDL_SYMBOL_LITERAL>#Enum.EnumConstant</JDL_SYMBOL_LITERAL>; }\n" +
    "}\n" +
    "/// documentation for [<JDL_ENUM>Enum</JDL_ENUM>]\n" +
    "<JDL_KEYWORD>enum</JDL_KEYWORD> <JDL_ENUM>Enum</JDL_ENUM> { <JDL_ENUM_CONSTANT>EnumConstant</JDL_ENUM_CONSTANT> }\n" +
    "<JDL_KEYWORD>typedef</JDL_KEYWORD> <JDL_CLASS>int</JDL_CLASS> <JDL_FUNCTION_TYPE_ALIAS>FunctionTypeAlias</JDL_FUNCTION_TYPE_ALIAS>(<JDL_DYNAMIC_PARAMETER_DECLARATION>x</JDL_DYNAMIC_PARAMETER_DECLARATION>, <JDL_DYNAMIC_PARAMETER_DECLARATION>y</JDL_DYNAMIC_PARAMETER_DECLARATION>); ```";

  static {
    PREVIEW_TAGS.put("ERROR", ERROR);
    PREVIEW_TAGS.put("WARNING", WARNING);
    PREVIEW_TAGS.put("HINT", HINT);

    PREVIEW_TAGS.put("JDL_ANNOTATION", ANNOTATION);
    PREVIEW_TAGS.put("JDL_CLASS", CLASS);
    PREVIEW_TAGS.put("JDL_CONSTRUCTOR", CONSTRUCTOR);

    PREVIEW_TAGS.put("JDL_DYNAMIC_LOCAL_VARIABLE_DECLARATION", DYNAMIC_LOCAL_VARIABLE_DECLARATION);
    PREVIEW_TAGS.put("JDL_DYNAMIC_LOCAL_VARIABLE_REFERENCE", DYNAMIC_LOCAL_VARIABLE_REFERENCE);
    PREVIEW_TAGS.put("JDL_DYNAMIC_PARAMETER_DECLARATION", DYNAMIC_PARAMETER_DECLARATION);
    PREVIEW_TAGS.put("JDL_DYNAMIC_PARAMETER_REFERENCE", DYNAMIC_PARAMETER_REFERENCE);

    PREVIEW_TAGS.put("JDL_ENUM", ENUM);
    PREVIEW_TAGS.put("JDL_ENUM_CONSTANT", ENUM_CONSTANT);
    PREVIEW_TAGS.put("JDL_FUNCTION_TYPE_ALIAS", FUNCTION_TYPE_ALIAS);

    PREVIEW_TAGS.put("JDL_IDENTIFIER", IDENTIFIER);
    PREVIEW_TAGS.put("JDL_INSTANCE_FIELD_DECLARATION", INSTANCE_FIELD_DECLARATION);
    PREVIEW_TAGS.put("JDL_INSTANCE_FIELD_REFERENCE", INSTANCE_FIELD_REFERENCE);
    PREVIEW_TAGS.put("JDL_INSTANCE_GETTER_DECLARATION", INSTANCE_GETTER_DECLARATION);
    PREVIEW_TAGS.put("JDL_INSTANCE_GETTER_REFERENCE", INSTANCE_GETTER_REFERENCE);
    PREVIEW_TAGS.put("JDL_INSTANCE_METHOD_DECLARATION", INSTANCE_METHOD_DECLARATION);
    PREVIEW_TAGS.put("JDL_INSTANCE_METHOD_REFERENCE", INSTANCE_METHOD_REFERENCE);
    PREVIEW_TAGS.put("JDL_INSTANCE_SETTER_DECLARATION", INSTANCE_SETTER_DECLARATION);
    PREVIEW_TAGS.put("JDL_INSTANCE_SETTER_REFERENCE", INSTANCE_SETTER_REFERENCE);

    PREVIEW_TAGS.put("JDL_IMPORT_PREFIX", IMPORT_PREFIX);
    PREVIEW_TAGS.put("JDL_KEYWORD", KEYWORD);
    PREVIEW_TAGS.put("JDL_LABEL", LABEL);
    PREVIEW_TAGS.put("JDL_LIBRARY_NAME", LIBRARY_NAME);

    PREVIEW_TAGS.put("JDL_LOCAL_FUNCTION_DECLARATION", LOCAL_FUNCTION_DECLARATION);
    PREVIEW_TAGS.put("JDL_LOCAL_FUNCTION_REFERENCE", LOCAL_FUNCTION_REFERENCE);
    PREVIEW_TAGS.put("JDL_LOCAL_VARIABLE_DECLARATION", LOCAL_VARIABLE_DECLARATION);
    PREVIEW_TAGS.put("JDL_LOCAL_VARIABLE_REFERENCE", LOCAL_VARIABLE_REFERENCE);

    PREVIEW_TAGS.put("JDL_PARAMETER_DECLARATION", PARAMETER_DECLARATION);
    PREVIEW_TAGS.put("JDL_PARAMETER_REFERENCE", PARAMETER_REFERENCE);

    PREVIEW_TAGS.put("JDL_STATIC_FIELD_DECLARATION", STATIC_FIELD_DECLARATION);
    PREVIEW_TAGS.put("JDL_STATIC_GETTER_DECLARATION", STATIC_GETTER_DECLARATION);
    PREVIEW_TAGS.put("JDL_STATIC_GETTER_REFERENCE", STATIC_GETTER_REFERENCE);
    PREVIEW_TAGS.put("JDL_STATIC_METHOD_DECLARATION", STATIC_METHOD_DECLARATION);
    PREVIEW_TAGS.put("JDL_STATIC_METHOD_REFERENCE", STATIC_METHOD_REFERENCE);
    PREVIEW_TAGS.put("JDL_STATIC_SETTER_DECLARATION", STATIC_SETTER_DECLARATION);
    PREVIEW_TAGS.put("JDL_STATIC_SETTER_REFERENCE", STATIC_SETTER_REFERENCE);

    PREVIEW_TAGS.put("JDL_TOP_LEVEL_FUNCTION_DECLARATION", TOP_LEVEL_FUNCTION_DECLARATION);
    PREVIEW_TAGS.put("JDL_TOP_LEVEL_FUNCTION_REFERENCE", TOP_LEVEL_FUNCTION_REFERENCE);
    PREVIEW_TAGS.put("JDL_TOP_LEVEL_GETTER_DECLARATION", TOP_LEVEL_GETTER_DECLARATION);
    PREVIEW_TAGS.put("JDL_TOP_LEVEL_GETTER_REFERENCE", TOP_LEVEL_GETTER_REFERENCE);
    PREVIEW_TAGS.put("JDL_TOP_LEVEL_SETTER_DECLARATION", TOP_LEVEL_SETTER_DECLARATION);
    PREVIEW_TAGS.put("JDL_TOP_LEVEL_SETTER_REFERENCE", TOP_LEVEL_SETTER_REFERENCE);
    PREVIEW_TAGS.put("JDL_TOP_LEVEL_VARIABLE_DECLARATION", TOP_LEVEL_VARIABLE_DECLARATION);

    PREVIEW_TAGS.put("JDL_TYPE_NAME_DYNAMIC", TYPE_NAME_DYNAMIC);
    PREVIEW_TAGS.put("JDL_TYPE_PARAMETER", TYPE_PARAMETER);
    PREVIEW_TAGS.put("JDL_UNRESOLVED_INSTANCE_MEMBER_REFERENCE", UNRESOLVED_INSTANCE_MEMBER_REFERENCE);

    PREVIEW_TAGS.put("JDL_BLOCK_COMMENT", BLOCK_COMMENT);
    PREVIEW_TAGS.put("JDL_DOC_COMMENT", DOC_COMMENT);
    PREVIEW_TAGS.put("JDL_LINE_COMMENT", LINE_COMMENT);

    PREVIEW_TAGS.put("JDL_NUMBER", NUMBER);
    PREVIEW_TAGS.put("JDL_STRING", STRING);
    PREVIEW_TAGS.put("JDL_VALID_STRING_ESCAPE", VALID_STRING_ESCAPE);
    PREVIEW_TAGS.put("JDL_INVALID_STRING_ESCAPE", INVALID_STRING_ESCAPE);
    PREVIEW_TAGS.put("JDL_OPERATION_SIGN", OPERATION_SIGN);
    PREVIEW_TAGS.put("JDL_PARENTH", PARENTHS);
    PREVIEW_TAGS.put("JDL_BRACKETS", BRACKETS);
    PREVIEW_TAGS.put("JDL_BRACES", BRACES);
    PREVIEW_TAGS.put("JDL_COMMA", COMMA);
    PREVIEW_TAGS.put("JDL_DOT", DOT);
    PREVIEW_TAGS.put("JDL_SEMICOLON", SEMICOLON);
    PREVIEW_TAGS.put("JDL_COLON", COLON);
    PREVIEW_TAGS.put("JDL_FAT_ARROW", FAT_ARROW);
    PREVIEW_TAGS.put("JDL_BAD_CHARACTER", BAD_CHARACTER);
    PREVIEW_TAGS.put("JDL_SYMBOL_LITERAL", SYMBOL_LITERAL);

    ATTRS = new AttributesDescriptor[]{
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.error"), ERROR),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.warning"), WARNING),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.hint"), HINT),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.block.comment"), BLOCK_COMMENT),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.doc.comment"), DOC_COMMENT),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.line.comment"), LINE_COMMENT),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.number"), NUMBER),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.string"), STRING),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.valid.string.escape"), VALID_STRING_ESCAPE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.invalid.string.escape"), INVALID_STRING_ESCAPE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.operator"), OPERATION_SIGN),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.parentheses"), PARENTHS),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.brackets"), BRACKETS),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.braces"), BRACES),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.comma"), COMMA),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.dot"), DOT),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.semicolon"), SEMICOLON),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.colon"), COLON),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.fat.arrow"), FAT_ARROW),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.bad.character"), BAD_CHARACTER),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.symbol.literal"), SYMBOL_LITERAL),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.annotation"), ANNOTATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.class"), CLASS),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.constructor"), CONSTRUCTOR),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.dynamic.local.variable.declaration"),
                               DYNAMIC_LOCAL_VARIABLE_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.dynamic.local.variable.reference"),
                               DYNAMIC_LOCAL_VARIABLE_REFERENCE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.dynamic.parameter.declaration"),
                               DYNAMIC_PARAMETER_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.dynamic.parameter.reference"),
                               DYNAMIC_PARAMETER_REFERENCE),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.enum"), ENUM),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.enum.constant"), ENUM_CONSTANT),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.function.type.alias"), FUNCTION_TYPE_ALIAS),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.identifier"), IDENTIFIER),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.instance.field.declaration"),
                               INSTANCE_FIELD_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.instance.field.reference"), INSTANCE_FIELD_REFERENCE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.instance.getter.declaration"),
                               INSTANCE_GETTER_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.instance.getter.reference"), INSTANCE_GETTER_REFERENCE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.instance.method.declaration"),
                               INSTANCE_METHOD_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.instance.method.reference"), INSTANCE_METHOD_REFERENCE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.instance.setter.declaration"),
                               INSTANCE_SETTER_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.instance.setter.reference"), INSTANCE_SETTER_REFERENCE),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.import.prefix"), IMPORT_PREFIX),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.keyword"), KEYWORD),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.label"), LABEL),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.library.name"), LIBRARY_NAME),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.local.function.declaration"),
                               LOCAL_FUNCTION_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.local.function.reference"), LOCAL_FUNCTION_REFERENCE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.local.variable.declaration"),
                               LOCAL_VARIABLE_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.local.variable.reference"), LOCAL_VARIABLE_REFERENCE),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.parameter.declaration"), PARAMETER_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.parameter.reference"), PARAMETER_REFERENCE),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.static.field.declaration"), STATIC_FIELD_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.static.getter.declaration"), STATIC_GETTER_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.static.getter.reference"), STATIC_GETTER_REFERENCE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.static.method.declaration"), STATIC_METHOD_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.static.method.reference"), STATIC_METHOD_REFERENCE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.static.setter.declaration"), STATIC_SETTER_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.static.setter.reference"), STATIC_SETTER_REFERENCE),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.top.level.function.declaration"),
                               TOP_LEVEL_FUNCTION_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.top.level.function.reference"),
                               TOP_LEVEL_FUNCTION_REFERENCE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.top.level.getter.declaration"),
                               TOP_LEVEL_GETTER_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.top.level.getter.reference"),
                               TOP_LEVEL_GETTER_REFERENCE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.top.level.setter.declaration"),
                               TOP_LEVEL_SETTER_DECLARATION),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.top.level.setter.reference"),
                               TOP_LEVEL_SETTER_REFERENCE),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.top.level.variable.declaration"),
                               TOP_LEVEL_VARIABLE_DECLARATION),

      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.type.name.dynamic"), TYPE_NAME_DYNAMIC),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.type.parameter"), TYPE_PARAMETER),
      new AttributesDescriptor(JdlBundle.message("jdl.color.settings.description.unresolved.instance.member.reference"),
                               UNRESOLVED_INSTANCE_MEMBER_REFERENCE),
    };
  }

  @Override
  public @NotNull String getDisplayName() {
    return JdlBundle.message("jdl.title");
  }

  @Override
  public Icon getIcon() {
    return JdlFileType.INSTANCE.getIcon();
  }

  @Override
  public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
    return ATTRS;
  }

  @Override
  public ColorDescriptor @NotNull [] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @Override
  public @NotNull SyntaxHighlighter getHighlighter() {
    return new JdlSyntaxHighlighter();
  }

  @Override
  public @NotNull String getDemoText() {
    return PREVIEW_TEXT;
  }

  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return PREVIEW_TAGS;
  }
}
