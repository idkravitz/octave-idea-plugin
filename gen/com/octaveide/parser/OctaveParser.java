// This is a generated file. Not intended for manual editing.
package com.octaveide.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.octaveide.psi.OctaveTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class OctaveParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ADD_EXPR) {
      r = expr(b, 0, 0);
    }
    else if (t == ASSIGN_EXPR) {
      r = expr(b, 0, -1);
    }
    else if (t == EXPR) {
      r = expr(b, 0, -1);
    }
    else if (t == IDENTIFIER_EXPR) {
      r = identifier_expr(b, 0);
    }
    else if (t == LITERAL_EXPR) {
      r = literal_expr(b, 0);
    }
    else if (t == MUL_EXPR) {
      r = expr(b, 0, 1);
    }
    else if (t == STATEMENT) {
      r = statement(b, 0);
    }
    else if (t == UNARY_EXPR) {
      r = unary_expr(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return octaveFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ADD_EXPR, ASSIGN_EXPR, EXPR, IDENTIFIER_EXPR,
      LITERAL_EXPR, MUL_EXPR, UNARY_EXPR),
  };

  /* ********************************************************** */
  // '+'|'-'
  static boolean add_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_op")) return false;
    if (!nextTokenIs(b, "", PLUS, MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> (statement|CRLF|COMMENT)
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item__0(b, l + 1);
    r = r && item__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>>
  private static boolean item__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // statement|CRLF|COMMENT
  private static boolean item__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '*'|'/'
  static boolean mul_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_op")) return false;
    if (!nextTokenIs(b, "", MULTIPLY, DIVIDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MULTIPLY);
    if (!r) r = consumeToken(b, DIVIDE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean octaveFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "octaveFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "octaveFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // expr (';'|CRLF|<<eof>>)
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<statement>");
    r = expr(b, l + 1, -1);
    r = r && statement_1(b, l + 1);
    exit_section_(b, l, m, STATEMENT, r, false, null);
    return r;
  }

  // ';'|CRLF|<<eof>>
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+'|'-'
  static boolean unary_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_op")) return false;
    if (!nextTokenIs(b, "", PLUS, MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: BINARY(assign_expr)
  // 1: BINARY(add_expr)
  // 2: BINARY(mul_expr)
  // 3: PREFIX(unary_expr)
  // 4: ATOM(literal_expr) ATOM(identifier_expr)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = unary_expr(b, l + 1);
    if (!r) r = literal_expr(b, l + 1);
    if (!r) r = identifier_expr(b, l + 1);
    p = r;
    r = r && expr_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expr_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && consumeTokenSmart(b, ASSIGN)) {
        r = expr(b, l, 0);
        exit_section_(b, l, m, ASSIGN_EXPR, r, true, null);
      }
      else if (g < 1 && add_op(b, l + 1)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, ADD_EXPR, r, true, null);
      }
      else if (g < 2 && mul_op(b, l + 1)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, MUL_EXPR, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  public static boolean unary_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expr")) return false;
    if (!nextTokenIsFast(b, PLUS, MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = unary_op(b, l + 1);
    p = r;
    r = p && expr(b, l, 3);
    exit_section_(b, l, m, UNARY_EXPR, r, p, null);
    return r || p;
  }

  // int | float
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    if (!nextTokenIsFast(b, FLOAT, INT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<literal expr>");
    r = consumeTokenSmart(b, INT);
    if (!r) r = consumeTokenSmart(b, FLOAT);
    exit_section_(b, l, m, LITERAL_EXPR, r, false, null);
    return r;
  }

  // identifier
  public static boolean identifier_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier_expr")) return false;
    if (!nextTokenIsFast(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENTIFIER);
    exit_section_(b, m, IDENTIFIER_EXPR, r);
    return r;
  }

}
