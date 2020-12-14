// This is a generated file. Not intended for manual editing.
package io.github.jhipster.jdl.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.jhipster.jdl.psi.JdlTypes.*;
import static io.github.jhipster.jdl.parser.JdlParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class JdlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return jdlFile(b, l + 1);
  }

  /* ********************************************************** */
  // << application_type_definition entity_end>>
  public static boolean application_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type")) return false;
    if (!nextTokenIs(b, KW_APPLICATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = application_type_definition(b, l + 1, JdlParser::entity_end);
    exit_section_(b, m, APPLICATION_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // '{' application_type_body_inner '}'  {
  // }
  public static boolean application_type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_body")) return false;
    if (!nextTokenIs(b, T_LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LBRACE);
    r = r && application_type_body_inner(b, l + 1);
    r = r && consumeToken(b, T_RBRACE);
    r = r && application_type_body_3(b, l + 1);
    exit_section_(b, m, APPLICATION_TYPE_BODY, r);
    return r;
  }

  // {
  // }
  private static boolean application_type_body_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // ()
  public static boolean application_type_body_inner(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, APPLICATION_TYPE_BODY_INNER, true);
    return true;
  }

  /* ********************************************************** */
  // 'application' application_type_body {
  // }
  public static boolean application_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "application_type_definition")) return false;
    if (!nextTokenIs(b, KW_APPLICATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_APPLICATION);
    r = r && application_type_body(b, l + 1);
    r = r && application_type_definition_2(b, l + 1);
    exit_section_(b, m, APPLICATION_TYPE_DEFINITION, r);
    return r;
  }

  // {
  // }
  private static boolean application_type_definition_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // BLANK
  static boolean blank(PsiBuilder b, int l) {
    return consumeToken(b, BLANK);
  }

  /* ********************************************************** */
  // <<eof>> | '}'
  static boolean entity_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_end")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eof(b, l + 1);
    if (!r) r = consumeToken(b, T_RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<entity_type_definition entity_end>>
  public static boolean entity_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type")) return false;
    if (!nextTokenIs(b, KW_ENTITY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entity_type_definition(b, l + 1, JdlParser::entity_end);
    exit_section_(b, m, ENTITY_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // '{' entity_type_body_inner '}' {
  // }
  public static boolean entity_type_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_body")) return false;
    if (!nextTokenIs(b, T_LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LBRACE);
    r = r && entity_type_body_inner(b, l + 1);
    r = r && consumeToken(b, T_RBRACE);
    r = r && entity_type_body_3(b, l + 1);
    exit_section_(b, m, ENTITY_TYPE_BODY, r);
    return r;
  }

  // {
  // }
  private static boolean entity_type_body_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // ()
  public static boolean entity_type_body_inner(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, ENTITY_TYPE_BODY_INNER, true);
    return true;
  }

  /* ********************************************************** */
  // 'entity' entity_type_body {
  // }
  public static boolean entity_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_type_definition")) return false;
    if (!nextTokenIs(b, KW_ENTITY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ENTITY);
    r = r && entity_type_body(b, l + 1);
    r = r && entity_type_definition_2(b, l + 1);
    exit_section_(b, m, ENTITY_TYPE_DEFINITION, r);
    return r;
  }

  // {
  // }
  private static boolean entity_type_definition_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // <<eof>>
  static boolean file_end(PsiBuilder b, int l) {
    return eof(b, l + 1);
  }

  /* ********************************************************** */
  // top_levels*
  static boolean jdlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jdlFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!top_levels(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "jdlFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '\n'*
  static boolean newLines(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newLines")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, LINEFEED)) break;
      if (!empty_element_parsed_guard_(b, "newLines", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // application_type | entity_type
  public static boolean top_level(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOP_LEVEL, "<top level>");
    r = application_type(b, l + 1);
    if (!r) r = entity_type(b, l + 1);
    exit_section_(b, l, m, r, false, JdlParser::top_level_recover);
    return r;
  }

  /* ********************************************************** */
  // <<eof>> | '}'
  static boolean top_level_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_end")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eof(b, l + 1);
    if (!r) r = consumeToken(b, T_RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<top_level_end top_level top_level_start>>
  public static boolean top_level_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOP_LEVEL_ITEM, "<top level item>");
    r = top_level_end(b, l + 1, JdlParser::top_level, JdlParser::top_level_start);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !('application' | 'entity' | 'enum')
  static boolean top_level_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !top_level_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'application' | 'entity' | 'enum'
  private static boolean top_level_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_recover_0")) return false;
    boolean r;
    r = consumeToken(b, KW_APPLICATION);
    if (!r) r = consumeToken(b, KW_ENTITY);
    if (!r) r = consumeToken(b, KW_ENUM);
    return r;
  }

  /* ********************************************************** */
  // 'application' | 'entity' | 'enum'
  static boolean top_level_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_level_start")) return false;
    boolean r;
    r = consumeToken(b, KW_APPLICATION);
    if (!r) r = consumeToken(b, KW_ENTITY);
    if (!r) r = consumeToken(b, KW_ENUM);
    return r;
  }

  /* ********************************************************** */
  // top_level_item (top_level_item?)*
  public static boolean top_levels(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_levels")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOP_LEVELS, "<top levels>");
    r = top_level_item(b, l + 1);
    r = r && top_levels_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (top_level_item?)*
  private static boolean top_levels_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_levels_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!top_levels_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "top_levels_1", c)) break;
    }
    return true;
  }

  // top_level_item?
  private static boolean top_levels_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "top_levels_1_0")) return false;
    top_level_item(b, l + 1);
    return true;
  }

}
