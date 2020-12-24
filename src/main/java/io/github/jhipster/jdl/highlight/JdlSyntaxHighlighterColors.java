// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package io.github.jhipster.jdl.highlight;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

public final class JdlSyntaxHighlighterColors {
  public static final String JDL_ERROR = "JDL_ERROR";
  public static final String JDL_WARNING = "JDL_WARNING";
  public static final String JDL_HINT = "JDL_HINT";

  public static final String JDL_ANNOTATION = "JDL_ANNOTATION";
  public static final String JDL_CLASS = "JDL_CLASS";
  public static final String JDL_CONSTRUCTOR = "JDL_CONSTRUCTOR";

  public static final String JDL_DYNAMIC_LOCAL_VARIABLE_DECLARATION = "JDL_DYNAMIC_LOCAL_VARIABLE_DECLARATION";
  public static final String JDL_DYNAMIC_LOCAL_VARIABLE_REFERENCE = "JDL_DYNAMIC_LOCAL_VARIABLE_REFERENCE";
  public static final String JDL_DYNAMIC_PARAMETER_DECLARATION = "JDL_DYNAMIC_PARAMETER_DECLARATION";
  public static final String JDL_DYNAMIC_PARAMETER_REFERENCE = "JDL_DYNAMIC_PARAMETER_REFERENCE";

  public static final String JDL_ENUM = "JDL_ENUM";
  public static final String JDL_ENUM_CONSTANT = "JDL_ENUM_CONSTANT";
  public static final String JDL_FUNCTION_TYPE_ALIAS = "JDL_FUNCTION_TYPE_ALIAS";

  public static final String JDL_IDENTIFIER = "JDL_IDENTIFIER";
  public static final String JDL_INSTANCE_FIELD_DECLARATION = "JDL_INSTANCE_FIELD_DECLARATION";
  public static final String JDL_INSTANCE_FIELD_REFERENCE = "JDL_INSTANCE_FIELD_REFERENCE";
  public static final String JDL_INSTANCE_GETTER_DECLARATION = "JDL_INSTANCE_GETTER_DECLARATION";
  public static final String JDL_INSTANCE_GETTER_REFERENCE = "JDL_INSTANCE_GETTER_REFERENCE";
  public static final String JDL_INSTANCE_METHOD_DECLARATION = "JDL_INSTANCE_METHOD_DECLARATION";
  public static final String JDL_INSTANCE_METHOD_REFERENCE = "JDL_INSTANCE_METHOD_REFERENCE";
  public static final String JDL_INSTANCE_SETTER_DECLARATION = "JDL_INSTANCE_SETTER_DECLARATION";
  public static final String JDL_INSTANCE_SETTER_REFERENCE = "JDL_INSTANCE_SETTER_REFERENCE";

  public static final String JDL_IMPORT_PREFIX = "JDL_IMPORT_PREFIX";
  public static final String JDL_KEYWORD = "JDL_KEYWORD";
  public static final String JDL_LABEL = "JDL_LABEL";
  public static final String JDL_LIBRARY_NAME = "JDL_LIBRARY_NAME";

  public static final String JDL_LOCAL_FUNCTION_DECLARATION = "JDL_LOCAL_FUNCTION_DECLARATION";
  public static final String JDL_LOCAL_FUNCTION_REFERENCE = "JDL_LOCAL_FUNCTION_REFERENCE";
  public static final String JDL_LOCAL_VARIABLE_DECLARATION = "JDL_LOCAL_VARIABLE_DECLARATION";
  public static final String JDL_LOCAL_VARIABLE_REFERENCE = "JDL_LOCAL_VARIABLE_REFERENCE";

  public static final String JDL_PARAMETER_DECLARATION = "JDL_PARAMETER_DECLARATION";
  public static final String JDL_PARAMETER_REFERENCE = "JDL_PARAMETER_REFERENCE";

  public static final String JDL_STATIC_FIELD_DECLARATION = "JDL_STATIC_FIELD_DECLARATION";
  public static final String JDL_STATIC_GETTER_DECLARATION = "JDL_STATIC_GETTER_DECLARATION";
  public static final String JDL_STATIC_GETTER_REFERENCE = "JDL_STATIC_GETTER_REFERENCE";
  public static final String JDL_STATIC_METHOD_DECLARATION = "JDL_STATIC_METHOD_DECLARATION";
  public static final String JDL_STATIC_METHOD_REFERENCE = "JDL_STATIC_METHOD_REFERENCE";
  public static final String JDL_STATIC_SETTER_DECLARATION = "JDL_STATIC_SETTER_DECLARATION";
  public static final String JDL_STATIC_SETTER_REFERENCE = "JDL_STATIC_SETTER_REFERENCE";

  public static final String JDL_TOP_LEVEL_FUNCTION_DECLARATION = "JDL_TOP_LEVEL_FUNCTION_DECLARATION";
  public static final String JDL_TOP_LEVEL_FUNCTION_REFERENCE = "JDL_TOP_LEVEL_FUNCTION_REFERENCE";
  public static final String JDL_TOP_LEVEL_GETTER_DECLARATION = "JDL_TOP_LEVEL_GETTER_DECLARATION";
  public static final String JDL_TOP_LEVEL_GETTER_REFERENCE = "JDL_TOP_LEVEL_GETTER_REFERENCE";
  public static final String JDL_TOP_LEVEL_SETTER_DECLARATION = "JDL_TOP_LEVEL_SETTER_DECLARATION";
  public static final String JDL_TOP_LEVEL_SETTER_REFERENCE = "JDL_TOP_LEVEL_SETTER_REFERENCE";
  public static final String JDL_TOP_LEVEL_VARIABLE_DECLARATION = "JDL_TOP_LEVEL_VARIABLE_DECLARATION";

  public static final String JDL_TYPE_NAME_DYNAMIC = "JDL_TYPE_NAME_DYNAMIC";
  public static final String JDL_TYPE_PARAMETER = "JDL_TYPE_PARAMETER";
  public static final String JDL_UNRESOLVED_INSTANCE_MEMBER_REFERENCE = "JDL_UNRESOLVED_INSTANCE_MEMBER_REFERENCE";

  private static final String JDL_BLOCK_COMMENT = "JDL_BLOCK_COMMENT";
  private static final String JDL_DOC_COMMENT = "JDL_DOC_COMMENT";
  private static final String JDL_LINE_COMMENT = "JDL_LINE_COMMENT";

  private static final String JDL_NUMBER = "JDL_NUMBER";
  private static final String JDL_STRING = "JDL_STRING";
  private static final String JDL_VALID_STRING_ESCAPE = "JDL_VALID_STRING_ESCAPE";
  private static final String JDL_INVALID_STRING_ESCAPE = "JDL_INVALID_STRING_ESCAPE";
  private static final String JDL_OPERATION_SIGN = "JDL_OPERATION_SIGN";
  private static final String JDL_PARENTH = "JDL_PARENTH";
  private static final String JDL_BRACKETS = "JDL_BRACKETS";
  private static final String JDL_BRACES = "JDL_BRACES";
  private static final String JDL_COMMA = "JDL_COMMA";
  private static final String JDL_DOT = "JDL_DOT";
  private static final String JDL_SEMICOLON = "JDL_SEMICOLON";
  private static final String JDL_COLON = "JDL_COLON";
  private static final String JDL_FAT_ARROW = "JDL_FAT_ARROW";
  private static final String JDL_BAD_CHARACTER = "JDL_BAD_CHARACTER";
  private static final String JDL_SYMBOL_LITERAL = "JDL_SYMBOL_LITERAL";

  public static final TextAttributesKey ERROR = createTextAttributesKey(JDL_ERROR, CodeInsightColors.ERRORS_ATTRIBUTES);
  public static final TextAttributesKey WARNING = createTextAttributesKey(JDL_WARNING, CodeInsightColors.WARNINGS_ATTRIBUTES);
  public static final TextAttributesKey HINT = createTextAttributesKey(JDL_HINT, CodeInsightColors.WEAK_WARNING_ATTRIBUTES);

  public static final TextAttributesKey BLOCK_COMMENT = createTextAttributesKey(JDL_BLOCK_COMMENT, DefaultLanguageHighlighterColors.BLOCK_COMMENT);
  public static final TextAttributesKey DOC_COMMENT = createTextAttributesKey(JDL_DOC_COMMENT, DefaultLanguageHighlighterColors.DOC_COMMENT);
  public static final TextAttributesKey LINE_COMMENT = createTextAttributesKey(JDL_LINE_COMMENT, DefaultLanguageHighlighterColors.LINE_COMMENT);

  public static final TextAttributesKey NUMBER = createTextAttributesKey(JDL_NUMBER, DefaultLanguageHighlighterColors.NUMBER);
  public static final TextAttributesKey STRING = createTextAttributesKey(JDL_STRING, DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey VALID_STRING_ESCAPE = createTextAttributesKey(JDL_VALID_STRING_ESCAPE, DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE);
  public static final TextAttributesKey INVALID_STRING_ESCAPE = createTextAttributesKey(JDL_INVALID_STRING_ESCAPE, DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE);
  public static final TextAttributesKey OPERATION_SIGN = createTextAttributesKey(JDL_OPERATION_SIGN, DefaultLanguageHighlighterColors.OPERATION_SIGN);
  public static final TextAttributesKey PARENTHS = createTextAttributesKey(JDL_PARENTH, DefaultLanguageHighlighterColors.PARENTHESES);
  public static final TextAttributesKey BRACKETS = createTextAttributesKey(JDL_BRACKETS, DefaultLanguageHighlighterColors.BRACKETS);
  public static final TextAttributesKey BRACES = createTextAttributesKey(JDL_BRACES, DefaultLanguageHighlighterColors.BRACES);
  public static final TextAttributesKey COMMA = createTextAttributesKey(JDL_COMMA, DefaultLanguageHighlighterColors.COMMA);
  public static final TextAttributesKey DOT = createTextAttributesKey(JDL_DOT, DefaultLanguageHighlighterColors.DOT);
  public static final TextAttributesKey SEMICOLON = createTextAttributesKey(JDL_SEMICOLON, DefaultLanguageHighlighterColors.SEMICOLON);
  public static final TextAttributesKey COLON = createTextAttributesKey(JDL_COLON, DefaultLanguageHighlighterColors.OPERATION_SIGN);
  public static final TextAttributesKey FAT_ARROW = createTextAttributesKey(JDL_FAT_ARROW, DefaultLanguageHighlighterColors.OPERATION_SIGN);
  public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey(JDL_BAD_CHARACTER, HighlighterColors.BAD_CHARACTER);
  public static final TextAttributesKey SYMBOL_LITERAL = createTextAttributesKey(JDL_SYMBOL_LITERAL, DefaultLanguageHighlighterColors.KEYWORD);

  public static final TextAttributesKey ANNOTATION = createTextAttributesKey(JDL_ANNOTATION, DefaultLanguageHighlighterColors.METADATA);
  public static final TextAttributesKey CLASS = createTextAttributesKey(JDL_CLASS, DefaultLanguageHighlighterColors.CLASS_NAME);
  public static final TextAttributesKey ENUM = createTextAttributesKey(JDL_ENUM, DefaultLanguageHighlighterColors.CLASS_NAME);
  public static final TextAttributesKey ENUM_CONSTANT = createTextAttributesKey(JDL_ENUM_CONSTANT, DefaultLanguageHighlighterColors.INSTANCE_FIELD);
  public static final TextAttributesKey FUNCTION_TYPE_ALIAS = createTextAttributesKey(JDL_FUNCTION_TYPE_ALIAS, DefaultLanguageHighlighterColors.CLASS_NAME);
  public static final TextAttributesKey IDENTIFIER = createTextAttributesKey(JDL_IDENTIFIER, DefaultLanguageHighlighterColors.IDENTIFIER);

  public static final TextAttributesKey INSTANCE_FIELD_DECLARATION = createTextAttributesKey(JDL_INSTANCE_FIELD_DECLARATION, DefaultLanguageHighlighterColors.INSTANCE_FIELD);
  public static final TextAttributesKey INSTANCE_FIELD_REFERENCE = createTextAttributesKey(JDL_INSTANCE_FIELD_REFERENCE, DefaultLanguageHighlighterColors.INSTANCE_FIELD);
  public static final TextAttributesKey INSTANCE_GETTER_DECLARATION =
    createTextAttributesKey(JDL_INSTANCE_GETTER_DECLARATION, INSTANCE_FIELD_DECLARATION);
  public static final TextAttributesKey INSTANCE_GETTER_REFERENCE =
    createTextAttributesKey(JDL_INSTANCE_GETTER_REFERENCE, INSTANCE_FIELD_DECLARATION);
  public static final TextAttributesKey INSTANCE_METHOD_DECLARATION =
    createTextAttributesKey(JDL_INSTANCE_METHOD_DECLARATION, DefaultLanguageHighlighterColors.INSTANCE_METHOD);
  public static final TextAttributesKey INSTANCE_METHOD_REFERENCE =
    createTextAttributesKey(JDL_INSTANCE_METHOD_REFERENCE, DefaultLanguageHighlighterColors.FUNCTION_CALL);
  public static final TextAttributesKey INSTANCE_SETTER_DECLARATION =
    createTextAttributesKey(JDL_INSTANCE_SETTER_DECLARATION, INSTANCE_FIELD_DECLARATION);
  public static final TextAttributesKey INSTANCE_SETTER_REFERENCE =
    createTextAttributesKey(JDL_INSTANCE_SETTER_REFERENCE, INSTANCE_FIELD_DECLARATION);

  public static final TextAttributesKey IMPORT_PREFIX = createTextAttributesKey(JDL_IMPORT_PREFIX, DefaultLanguageHighlighterColors.IDENTIFIER);
  public static final TextAttributesKey KEYWORD = createTextAttributesKey(JDL_KEYWORD, DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey LABEL = createTextAttributesKey(JDL_LABEL, DefaultLanguageHighlighterColors.LABEL);
  public static final TextAttributesKey LIBRARY_NAME = createTextAttributesKey(JDL_LIBRARY_NAME, DefaultLanguageHighlighterColors.IDENTIFIER);
  public static final TextAttributesKey LOCAL_VARIABLE_DECLARATION = createTextAttributesKey(JDL_LOCAL_VARIABLE_DECLARATION, DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
  public static final TextAttributesKey LOCAL_VARIABLE_REFERENCE =
    createTextAttributesKey(JDL_LOCAL_VARIABLE_REFERENCE, DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
  public static final TextAttributesKey PARAMETER_DECLARATION =
    createTextAttributesKey(JDL_PARAMETER_DECLARATION, DefaultLanguageHighlighterColors.PARAMETER);
  public static final TextAttributesKey PARAMETER_REFERENCE =
    createTextAttributesKey(JDL_PARAMETER_REFERENCE, DefaultLanguageHighlighterColors.PARAMETER);

  public static final TextAttributesKey STATIC_FIELD_DECLARATION =
    createTextAttributesKey(JDL_STATIC_FIELD_DECLARATION, DefaultLanguageHighlighterColors.STATIC_FIELD);
  public static final TextAttributesKey STATIC_GETTER_DECLARATION =
    createTextAttributesKey(JDL_STATIC_GETTER_DECLARATION, STATIC_FIELD_DECLARATION);
  public static final TextAttributesKey STATIC_GETTER_REFERENCE =
    createTextAttributesKey(JDL_STATIC_GETTER_REFERENCE, STATIC_FIELD_DECLARATION);
  public static final TextAttributesKey STATIC_METHOD_DECLARATION =
    createTextAttributesKey(JDL_STATIC_METHOD_DECLARATION, DefaultLanguageHighlighterColors.STATIC_METHOD);
  public static final TextAttributesKey STATIC_METHOD_REFERENCE =
    createTextAttributesKey(JDL_STATIC_METHOD_REFERENCE, DefaultLanguageHighlighterColors.STATIC_METHOD);
  public static final TextAttributesKey STATIC_SETTER_DECLARATION =
    createTextAttributesKey(JDL_STATIC_SETTER_DECLARATION, STATIC_FIELD_DECLARATION);
  public static final TextAttributesKey STATIC_SETTER_REFERENCE =
    createTextAttributesKey(JDL_STATIC_SETTER_REFERENCE, STATIC_FIELD_DECLARATION);

  public static final TextAttributesKey TOP_LEVEL_VARIABLE_DECLARATION =
    createTextAttributesKey(JDL_TOP_LEVEL_VARIABLE_DECLARATION, DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);
  public static final TextAttributesKey TOP_LEVEL_FUNCTION_DECLARATION =
    createTextAttributesKey(JDL_TOP_LEVEL_FUNCTION_DECLARATION, DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
  public static final TextAttributesKey TOP_LEVEL_FUNCTION_REFERENCE =
    createTextAttributesKey(JDL_TOP_LEVEL_FUNCTION_REFERENCE, DefaultLanguageHighlighterColors.FUNCTION_CALL);
  public static final TextAttributesKey TOP_LEVEL_GETTER_DECLARATION =
    createTextAttributesKey(JDL_TOP_LEVEL_GETTER_DECLARATION, TOP_LEVEL_VARIABLE_DECLARATION);
  public static final TextAttributesKey TOP_LEVEL_GETTER_REFERENCE =
    createTextAttributesKey(JDL_TOP_LEVEL_GETTER_REFERENCE, TOP_LEVEL_VARIABLE_DECLARATION);
  public static final TextAttributesKey TOP_LEVEL_SETTER_DECLARATION =
    createTextAttributesKey(JDL_TOP_LEVEL_SETTER_DECLARATION, TOP_LEVEL_VARIABLE_DECLARATION);
  public static final TextAttributesKey TOP_LEVEL_SETTER_REFERENCE =
    createTextAttributesKey(JDL_TOP_LEVEL_SETTER_REFERENCE, TOP_LEVEL_VARIABLE_DECLARATION);

  public static final TextAttributesKey TYPE_NAME_DYNAMIC =
    createTextAttributesKey(JDL_TYPE_NAME_DYNAMIC, DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey TYPE_PARAMETER =
    createTextAttributesKey(JDL_TYPE_PARAMETER, DefaultLanguageHighlighterColors.CLASS_NAME);
  public static final TextAttributesKey UNRESOLVED_INSTANCE_MEMBER_REFERENCE =
    createTextAttributesKey(JDL_UNRESOLVED_INSTANCE_MEMBER_REFERENCE, DefaultLanguageHighlighterColors.IDENTIFIER);

  public static final TextAttributesKey CONSTRUCTOR = createTextAttributesKey(JDL_CONSTRUCTOR, INSTANCE_METHOD_DECLARATION);

  public static final TextAttributesKey DYNAMIC_LOCAL_VARIABLE_DECLARATION =
    createTextAttributesKey(JDL_DYNAMIC_LOCAL_VARIABLE_DECLARATION, LOCAL_VARIABLE_DECLARATION);
  public static final TextAttributesKey DYNAMIC_LOCAL_VARIABLE_REFERENCE =
    createTextAttributesKey(JDL_DYNAMIC_LOCAL_VARIABLE_REFERENCE, LOCAL_VARIABLE_REFERENCE);
  public static final TextAttributesKey DYNAMIC_PARAMETER_DECLARATION =
    createTextAttributesKey(JDL_DYNAMIC_PARAMETER_DECLARATION, PARAMETER_DECLARATION);
  public static final TextAttributesKey DYNAMIC_PARAMETER_REFERENCE =
    createTextAttributesKey(JDL_DYNAMIC_PARAMETER_REFERENCE, PARAMETER_REFERENCE);

  public static final TextAttributesKey LOCAL_FUNCTION_DECLARATION =
    createTextAttributesKey(JDL_LOCAL_FUNCTION_DECLARATION, LOCAL_VARIABLE_DECLARATION);
  public static final TextAttributesKey LOCAL_FUNCTION_REFERENCE =
    createTextAttributesKey(JDL_LOCAL_FUNCTION_REFERENCE, LOCAL_VARIABLE_REFERENCE);
}
