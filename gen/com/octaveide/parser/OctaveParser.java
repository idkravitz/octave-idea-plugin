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
      r = expr(b, 0, 6);
    }
    else if (t == AND_EXPR) {
      r = expr(b, 0, 1);
    }
    else if (t == ASSIGN_EXPR) {
      r = expr(b, 0, -1);
    }
    else if (t == COLON_EXPR) {
      r = expr(b, 0, 5);
    }
    else if (t == ELEMENT_AND_EXPR) {
      r = expr(b, 0, 3);
    }
    else if (t == ELEMENT_OR_EXPR) {
      r = expr(b, 0, 2);
    }
    else if (t == EXPONENT_EXPR) {
      r = expr(b, 0, 9);
    }
    else if (t == EXPR) {
      r = expr(b, 0, -1);
    }
    else if (t == EXPR_STATEMENT) {
      r = expr_statement(b, 0);
    }
    else if (t == FOR_LOOP_STATEMENT) {
      r = for_loop_statement(b, 0);
    }
    else if (t == FUNC_CALL_EXPR) {
      r = func_call_expr(b, 0);
    }
    else if (t == FUNC_DECL_STATEMENT) {
      r = func_decl_statement(b, 0);
    }
    else if (t == IDENTIFIER_EXPR) {
      r = identifier_expr(b, 0);
    }
    else if (t == LITERAL_EXPR) {
      r = literal_expr(b, 0);
    }
    else if (t == MUL_EXPR) {
      r = expr(b, 0, 7);
    }
    else if (t == OR_EXPR) {
      r = expr(b, 0, 0);
    }
    else if (t == PAREN_EXPR) {
      r = paren_expr(b, 0);
    }
    else if (t == POSTFIX_EXPR) {
      r = expr(b, 0, 10);
    }
    else if (t == RELATIONAL_EXPR) {
      r = expr(b, 0, 4);
    }
    else if (t == STATEMENT) {
      r = statement(b, 0);
    }
    else if (t == TRANSPOSE_EXPR) {
      r = expr(b, 0, 9);
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
    create_token_set_(EXPR_STATEMENT, FOR_LOOP_STATEMENT, FUNC_DECL_STATEMENT, STATEMENT),
    create_token_set_(ADD_EXPR, AND_EXPR, ASSIGN_EXPR, COLON_EXPR,
      ELEMENT_AND_EXPR, ELEMENT_OR_EXPR, EXPONENT_EXPR, EXPR,
      FUNC_CALL_EXPR, IDENTIFIER_EXPR, LITERAL_EXPR, MUL_EXPR,
      OR_EXPR, PAREN_EXPR, POSTFIX_EXPR, RELATIONAL_EXPR,
      TRANSPOSE_EXPR, UNARY_EXPR),
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
  // identifier (',' identifier)
  static boolean arg_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_list")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && arg_list_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ',' identifier
  private static boolean arg_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '=' | '+=' | '-=' | '*=' | '/=' | '\=' | '^=' | '.*=' | './=' | '.\=' | '.^=' | '|=' | '&='
  static boolean assign_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_op")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, ASSIGN_PLUS);
    if (!r) r = consumeToken(b, ASSIGN_MINUS);
    if (!r) r = consumeToken(b, ASSIGN_MULTIPLY);
    if (!r) r = consumeToken(b, ASSIGN_L_DIV);
    if (!r) r = consumeToken(b, ASSIGN_R_DIV);
    if (!r) r = consumeToken(b, ASSIGN_POW_1);
    if (!r) r = consumeToken(b, ASSIGN_ELEMENT_MULTIPLY);
    if (!r) r = consumeToken(b, ASSIGN_ELEMENT_L_DIV);
    if (!r) r = consumeToken(b, ASSIGN_ELEMENT_R_DIV);
    if (!r) r = consumeToken(b, ASSIGN_ELEMENT_POW_1);
    if (!r) r = consumeToken(b, ASSIGN_ELEMENT_OR);
    if (!r) r = consumeToken(b, ASSIGN_ELEMENT_AND);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // terminator
  static boolean empty_statement(PsiBuilder b, int l) {
    return terminator(b, l + 1);
  }

  /* ********************************************************** */
  // '^' | '**' | '.^' | '.**'
  static boolean exponent_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exponent_op")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, POW_1);
    if (!r) r = consumeToken(b, POW_2);
    if (!r) r = consumeToken(b, ELEMENT_POW_1);
    if (!r) r = consumeToken(b, ELEMENT_POW_2);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr (terminator|<<eof>>)
  public static boolean expr_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<expr statement>");
    r = expr(b, l + 1, -1);
    r = r && expr_statement_1(b, l + 1);
    exit_section_(b, l, m, EXPR_STATEMENT, r, false, null);
    return r;
  }

  // terminator|<<eof>>
  private static boolean expr_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = terminator(b, l + 1);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // for identifier '=' expr terminator statement* (endfor|end)
  public static boolean for_loop_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_statement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, IDENTIFIER);
    r = r && consumeToken(b, ASSIGN);
    r = r && expr(b, l + 1, -1);
    r = r && terminator(b, l + 1);
    r = r && for_loop_statement_5(b, l + 1);
    r = r && for_loop_statement_6(b, l + 1);
    exit_section_(b, m, FOR_LOOP_STATEMENT, r);
    return r;
  }

  // statement*
  private static boolean for_loop_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_statement_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "for_loop_statement_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // endfor|end
  private static boolean for_loop_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_loop_statement_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENDFOR);
    if (!r) r = consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // function (retval '=')? identifier ( '(' arg_list? ')' )? terminator statement* (endfunction|end)
  public static boolean func_decl_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_decl_statement")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION);
    r = r && func_decl_statement_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && func_decl_statement_3(b, l + 1);
    r = r && terminator(b, l + 1);
    r = r && func_decl_statement_5(b, l + 1);
    r = r && func_decl_statement_6(b, l + 1);
    exit_section_(b, m, FUNC_DECL_STATEMENT, r);
    return r;
  }

  // (retval '=')?
  private static boolean func_decl_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_decl_statement_1")) return false;
    func_decl_statement_1_0(b, l + 1);
    return true;
  }

  // retval '='
  private static boolean func_decl_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_decl_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = retval(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( '(' arg_list? ')' )?
  private static boolean func_decl_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_decl_statement_3")) return false;
    func_decl_statement_3_0(b, l + 1);
    return true;
  }

  // '(' arg_list? ')'
  private static boolean func_decl_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_decl_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && func_decl_statement_3_0_1(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // arg_list?
  private static boolean func_decl_statement_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_decl_statement_3_0_1")) return false;
    arg_list(b, l + 1);
    return true;
  }

  // statement*
  private static boolean func_decl_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_decl_statement_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_decl_statement_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // endfunction|end
  private static boolean func_decl_statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_decl_statement_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENDFUNCTION);
    if (!r) r = consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> statement
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item__0(b, l + 1);
    r = r && statement(b, l + 1);
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

  /* ********************************************************** */
  // '*' | '/' | '\' | '.\' | '.*' | './'
  static boolean mul_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_op")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MULTIPLY);
    if (!r) r = consumeToken(b, L_DIV);
    if (!r) r = consumeToken(b, R_DIV);
    if (!r) r = consumeToken(b, ELEMENT_R_DIV);
    if (!r) r = consumeToken(b, ELEMENT_MULTIPLY);
    if (!r) r = consumeToken(b, ELEMENT_L_DIV);
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
  // expr (',' expr)*
  static boolean param_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1, -1);
    r = r && param_list_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' expr)*
  private static boolean param_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!param_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "param_list_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' expr
  private static boolean param_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '++' | '--'
  static boolean postfix_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_op")) return false;
    if (!nextTokenIs(b, "", INCREMENT, DECREMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INCREMENT);
    if (!r) r = consumeToken(b, DECREMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '<' | '<=' | '==' | '>=' | '>' | '!=' | '~='
  static boolean relational_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relational_op")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS_THAN);
    if (!r) r = consumeToken(b, LESS_THAN_OR_EQUAL);
    if (!r) r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, GREATER_THAN_OR_EQUAL);
    if (!r) r = consumeToken(b, GREATER_THAN);
    if (!r) r = consumeToken(b, NOT_EQUAL_1);
    if (!r) r = consumeToken(b, NOT_EQUAL_2);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  static boolean retval(PsiBuilder b, int l) {
    return consumeToken(b, IDENTIFIER);
  }

  /* ********************************************************** */
  // expr_statement
  //     | func_decl_statement
  //     | for_loop_statement
  //     | empty_statement
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, "<statement>");
    r = expr_statement(b, l + 1);
    if (!r) r = func_decl_statement(b, l + 1);
    if (!r) r = for_loop_statement(b, l + 1);
    if (!r) r = empty_statement(b, l + 1);
    exit_section_(b, l, m, STATEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ';'|CRLF|COMMENT
  static boolean terminator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "terminator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "'" | ".'"
  static boolean transpose_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "transpose_op")) return false;
    if (!nextTokenIs(b, "", CC_TRANSPOSE, TRANSPOSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CC_TRANSPOSE);
    if (!r) r = consumeToken(b, TRANSPOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-' | '++' | '--' | '~' | '!'
  static boolean unary_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_op")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, INCREMENT);
    if (!r) r = consumeToken(b, DECREMENT);
    if (!r) r = consumeToken(b, NOT_2);
    if (!r) r = consumeToken(b, NOT_1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: BINARY(assign_expr)
  // 1: BINARY(or_expr)
  // 2: BINARY(and_expr)
  // 3: BINARY(element_or_expr)
  // 4: BINARY(element_and_expr)
  // 5: BINARY(relational_expr)
  // 6: BINARY(colon_expr)
  // 7: BINARY(add_expr)
  // 8: BINARY(mul_expr)
  // 9: PREFIX(unary_expr)
  // 10: POSTFIX(transpose_expr) BINARY(exponent_expr)
  // 11: POSTFIX(postfix_expr)
  // 12: ATOM(func_call_expr) ATOM(paren_expr) ATOM(literal_expr) ATOM(identifier_expr)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = unary_expr(b, l + 1);
    if (!r) r = func_call_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
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
      if (g < 0 && assign_op(b, l + 1)) {
        r = expr(b, l, -1);
        exit_section_(b, l, m, ASSIGN_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, OR)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, OR_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, AND)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, AND_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, ELEMENT_OR)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, ELEMENT_OR_EXPR, r, true, null);
      }
      else if (g < 4 && consumeTokenSmart(b, ELEMENT_AND)) {
        r = expr(b, l, 4);
        exit_section_(b, l, m, ELEMENT_AND_EXPR, r, true, null);
      }
      else if (g < 5 && relational_op(b, l + 1)) {
        r = expr(b, l, 5);
        exit_section_(b, l, m, RELATIONAL_EXPR, r, true, null);
      }
      else if (g < 6 && consumeTokenSmart(b, COLON)) {
        r = expr(b, l, 6);
        exit_section_(b, l, m, COLON_EXPR, r, true, null);
      }
      else if (g < 7 && add_op(b, l + 1)) {
        r = expr(b, l, 7);
        exit_section_(b, l, m, ADD_EXPR, r, true, null);
      }
      else if (g < 8 && mul_op(b, l + 1)) {
        r = expr(b, l, 8);
        exit_section_(b, l, m, MUL_EXPR, r, true, null);
      }
      else if (g < 10 && transpose_op(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, TRANSPOSE_EXPR, r, true, null);
      }
      else if (g < 10 && exponent_op(b, l + 1)) {
        r = expr(b, l, 10);
        exit_section_(b, l, m, EXPONENT_EXPR, r, true, null);
      }
      else if (g < 11 && postfix_op(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, POSTFIX_EXPR, r, true, null);
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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = unary_op(b, l + 1);
    p = r;
    r = p && expr(b, l, 9);
    exit_section_(b, l, m, UNARY_EXPR, r, p, null);
    return r || p;
  }

  // identifier '(' param_list? ')'
  public static boolean func_call_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_expr")) return false;
    if (!nextTokenIsFast(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENTIFIER);
    r = r && consumeToken(b, L_PAREN);
    r = r && func_call_expr_2(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, FUNC_CALL_EXPR, r);
    return r;
  }

  // param_list?
  private static boolean func_call_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_expr_2")) return false;
    param_list(b, l + 1);
    return true;
  }

  // '(' expr ')'
  public static boolean paren_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr")) return false;
    if (!nextTokenIsFast(b, L_PAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, L_PAREN);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && consumeToken(b, R_PAREN) && r;
    exit_section_(b, l, m, PAREN_EXPR, r, p, null);
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
