/* Generated By:JavaCC: Do not edit this line. OSQL.java */
package whu.oddb.parser;
import java.util.ArrayList;


public class OSQL implements OSQLConstants {

  final public AST start() throws ParseException {
    AST ast;
    if (jj_2_1(2)) {
      ast = create_class();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CREATE:
        ast = create_select_deputy();
        break;
      case SELECT:
        ast = select_from();
        break;
      case DELETE:
        ast = delete_from();
        break;
      case UPDATE:
        ast = update_class();
        break;
      case INSERT:
        ast = insert_into();
        break;
      case DROP:
        ast = drop_class();
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
        {if (true) return ast;}
    throw new Error("Missing return statement in function");
  }

  final public String value() throws ParseException {
        Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT_VALUE:
    case FLOAT_VALUE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT_VALUE:
        t = jj_consume_token(INT_VALUE);
        break;
      case FLOAT_VALUE:
        t = jj_consume_token(FLOAT_VALUE);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                {if (true) return t.image;}
      break;
    case STRING_VALUE:
    case CHAR_VALUE:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CHAR_VALUE:
        t = jj_consume_token(CHAR_VALUE);
        break;
      case STRING_VALUE:
        t = jj_consume_token(STRING_VALUE);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
        {if (true) return t.image.substring(1,t.image.length()-1);}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public CreateClass create_class() throws ParseException {
        Token className;
        ArrayList<RealAttr> cols;
    jj_consume_token(CREATE);
    jj_consume_token(CLASS);
    className = jj_consume_token(ID);
    jj_consume_token(LP);
    cols = rel_attr_list();
    jj_consume_token(RP);
    jj_consume_token(SEMI);
                {if (true) return new CreateClass(className.image, cols);}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<RealAttr> rel_attr_list() throws ParseException {
        Token id;
        Token type;
        ArrayList<RealAttr> cols = new ArrayList<RealAttr>();
    id = jj_consume_token(ID);
    type = jj_consume_token(TYPE);
                             cols.add(new RealAttr(id.image,type.image));
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_1;
      }
      jj_consume_token(COMMA);
      id = jj_consume_token(ID);
      type = jj_consume_token(TYPE);
                                             if(type.image == "char")type.image="string";cols.add(new RealAttr(id.image,type.image));
    }
                {if (true) return cols;}
    throw new Error("Missing return statement in function");
  }

  final public DropClass drop_class() throws ParseException {
        Token className;
    jj_consume_token(DROP);
    jj_consume_token(CLASS);
    className = jj_consume_token(ID);
    jj_consume_token(SEMI);
                {if (true) return new DropClass(className.image);}
    throw new Error("Missing return statement in function");
  }

  final public InsertClass insert_into() throws ParseException {
        Token className;
        ArrayList<String> attrs;
        ArrayList<String> values;
    jj_consume_token(INSERT);
    jj_consume_token(INTO);
    className = jj_consume_token(ID);
    jj_consume_token(LP);
    attrs = attr_list();
    jj_consume_token(RP);
    jj_consume_token(VALUES);
    jj_consume_token(LP);
    values = value_list();
    jj_consume_token(RP);
    jj_consume_token(SEMI);
                {if (true) return new InsertClass(className.image, attrs, values);}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> attr_list() throws ParseException {
        Token curAttr; //��һ��id
        ArrayList<String> attrs;
    curAttr = jj_consume_token(ID);
                     attrs = new ArrayList(); attrs.add(curAttr.image);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_2;
      }
      jj_consume_token(COMMA);
      curAttr = jj_consume_token(ID);
                                                                                               attrs.add(curAttr.image);
    }
                {if (true) return attrs;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> value_list() throws ParseException {
        String curValue;
        ArrayList<String> values;
    curValue = value();
                     values = new ArrayList();values.add(curValue);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      jj_consume_token(COMMA);
      curValue = value();
                                                                                               values.add(curValue);
    }
                {if (true) return values;}
    throw new Error("Missing return statement in function");
  }

  final public UpdateClass update_class() throws ParseException {
        String value;
        Token className;
        ArrayList<String> attrs = new ArrayList();
        ArrayList<String> values = new ArrayList();
        Token attr;
        ExprNode whereClause;
    jj_consume_token(UPDATE);
    className = jj_consume_token(ID);
    jj_consume_token(SET);
    attr = jj_consume_token(ID);
                                                 attrs.add(attr.image);
    jj_consume_token(EQ);
    value = value();
                                                                                            values.add(value);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_4;
      }
      jj_consume_token(COMMA);
      attr = jj_consume_token(ID);
                                                                                                                                    attrs.add(attr.image);
      jj_consume_token(EQ);
      value = value();
                                                                                                                                                                               values.add(value);
    }
    jj_consume_token(WHERE);
    whereClause = condition();
    jj_consume_token(SEMI);
                {if (true) return new UpdateClass(className.image, attrs, values, whereClause);}
    throw new Error("Missing return statement in function");
  }

  final public DeleteFrom delete_from() throws ParseException {
        Token className;
        ExprNode whereClause;
    jj_consume_token(DELETE);
    jj_consume_token(FROM);
    className = jj_consume_token(ID);
    jj_consume_token(WHERE);
    whereClause = condition();
    jj_consume_token(SEMI);
                {if (true) return new DeleteFrom(className.image, (ConditionExprNode)whereClause);}
    throw new Error("Missing return statement in function");
  }

  final public SelectFrom select_from() throws ParseException {
        ArrayList<AttrContext> attr_list = new ArrayList();
        AttrContext attr;
        Token className;
        ExprNode whereClause;
    jj_consume_token(SELECT);
    attr = attribute();
                                  attr_list.add(attr);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      jj_consume_token(COMMA);
      attr = attribute();
                                                                                  attr_list.add(attr);
    }
    jj_consume_token(FROM);
    className = jj_consume_token(ID);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WHERE:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_6;
      }
      jj_consume_token(WHERE);
      whereClause = condition();
                                         {if (true) return new SelectFrom(className.image, attr_list, (ConditionExprNode)whereClause);}
    }
    jj_consume_token(SEMI);
                whereClause = new ConditionExprNode("=",new ValueNode("int","1"),new ValueNode("int", "1"));
                {if (true) return new SelectFrom(className.image, attr_list, (ConditionExprNode)whereClause);}
    throw new Error("Missing return statement in function");
  }

  final public SelectDeputyFrom select_deputy_from() throws ParseException {
        ArrayList<DeputyAttr> attr_list;
        Token className;
        ExprNode whereClause;
    jj_consume_token(SELECT);
    attr_list = switch_list();
    jj_consume_token(FROM);
    className = jj_consume_token(ID);
    jj_consume_token(WHERE);
    whereClause = condition();
    jj_consume_token(SEMI);
                {if (true) return new SelectDeputyFrom(className.image, attr_list, (ConditionExprNode)whereClause);}
    throw new Error("Missing return statement in function");
  }

  final public CreateSelectDeputy create_select_deputy() throws ParseException {
        ArrayList<RealAttr> realAttrs = new ArrayList<RealAttr>();
        ArrayList<DeputyAttr> deputyAttrs;
        Token className;
        Token originClass;
        SelectDeputyFrom deputyInfo;
    jj_consume_token(CREATE);
    jj_consume_token(SELECTDEPUTY);
    className = jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LP:
      jj_consume_token(LP);
      realAttrs = rel_attr_list();
      jj_consume_token(RP);
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
    deputyInfo = select_deputy_from();
                {if (true) return new CreateSelectDeputy(className.image, deputyInfo.className, deputyInfo.attrs, realAttrs, deputyInfo.whereClause);}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<DeputyAttr> switch_list() throws ParseException {
        ExprNode switchRule; //�����ѯ�Ļ������switchrule�Ͳ����Ǽ�����ˣ�ֻ��һ��attr���͵�valueNode����ָ��һ��attrContext
        Token name;
        DeputyAttr attr;
        ArrayList<DeputyAttr> attr_list = new ArrayList();
    switchRule = computation();
                                 attr = new DeputyAttr("no name","no class", switchRule); attr_list.add(attr);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AS:
      jj_consume_token(AS);
      name = jj_consume_token(ID);
                                                                                                                                attr.name = name.image;
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_7;
      }
      jj_consume_token(COMMA);
      switchRule = computation();
                                                          attr = new DeputyAttr("no name","no class", switchRule);attr_list.add(attr);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AS:
        jj_consume_token(AS);
        name = jj_consume_token(ID);
                                                                                                                                                        attr.name = name.image;
        break;
      default:
        jj_la1[13] = jj_gen;
        ;
      }
    }
                {if (true) return attr_list;}
    throw new Error("Missing return statement in function");
  }

  final public ExprNode condition() throws ParseException {
        ExprNode expr;
    expr = or_condition();
                {if (true) return expr;}
    throw new Error("Missing return statement in function");
  }

  final public ExprNode or_condition() throws ParseException {
        ExprNode expr1;
        ExprNode expr2;
    expr1 = and_condition();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_8;
      }
      jj_consume_token(OR);
      expr2 = and_condition();
                                                         expr1 = new ConditionExprNode("OR",expr1, expr2);
    }
        {if (true) return expr1;}
    throw new Error("Missing return statement in function");
  }

  final public ExprNode and_condition() throws ParseException {
        ExprNode expr1;
        ExprNode expr2;
    expr1 = not_condition();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_9;
      }
      jj_consume_token(AND);
      expr2 = not_condition();
                                                          expr1 = new ConditionExprNode("AND",expr1, expr2);
    }
        {if (true) return expr1;}
    throw new Error("Missing return statement in function");
  }

  final public ExprNode not_condition() throws ParseException {
        ExprNode expr;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LP:
    case ID:
    case INT_VALUE:
    case FLOAT_VALUE:
    case STRING_VALUE:
    case CHAR_VALUE:
      expr = compare_condition();
                {if (true) return expr;}
      break;
    case NOT:
      jj_consume_token(NOT);
      expr = compare_condition();
                {if (true) return new ConditionExprNode("NOT", expr, null);}
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ExprNode compare_condition() throws ParseException {
        ExprNode expr1;
        ExprNode expr2;
        Token cop;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LP:
      jj_consume_token(LP);
      expr1 = or_condition();
      jj_consume_token(RP);
                {if (true) return expr1;}
      break;
    case ID:
    case INT_VALUE:
    case FLOAT_VALUE:
    case STRING_VALUE:
    case CHAR_VALUE:
      expr1 = atom_condition();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMPARE_OP:
        cop = jj_consume_token(COMPARE_OP);
        break;
      case EQ:
        cop = jj_consume_token(EQ);
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      expr2 = atom_condition();
                {if (true) return new ConditionExprNode(cop.image, expr1, expr2);}
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ExprNode atom_condition() throws ParseException {
        Token v;
        AttrContext attr;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING_VALUE:
      v = jj_consume_token(STRING_VALUE);
                {if (true) return new ValueNode("string",v.image.substring(1,v.image.length()-1));}
      break;
    case CHAR_VALUE:
      v = jj_consume_token(CHAR_VALUE);
                {if (true) return new ValueNode("char",v.image.substring(1,2));}
      break;
    case INT_VALUE:
      v = jj_consume_token(INT_VALUE);
                {if (true) return new ValueNode("int",v.image);}
      break;
    case FLOAT_VALUE:
      v = jj_consume_token(FLOAT_VALUE);
                {if (true) return new ValueNode("float",v.image);}
      break;
    case ID:
      attr = attribute();
                {if (true) return new ValueNode("attr", attr);}
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ExprNode computation() throws ParseException {
        ExprNode expr;
    expr = additive_expression();
                {if (true) return expr;}
    throw new Error("Missing return statement in function");
  }

  final public ExprNode additive_expression() throws ParseException {
        ExprNode expr1;
        ExprNode expr2;
    expr1 = multitive_expression();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 41:
      case 42:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 41:
        jj_consume_token(41);
        expr2 = multitive_expression();
                                                                   expr1 = new ComputeExprNode("+",expr1, expr2);
        break;
      case 42:
        jj_consume_token(42);
        expr2 = multitive_expression();
                                                                    expr1 = new ComputeExprNode("-",expr1, expr2);
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
        {if (true) return expr1;}
    throw new Error("Missing return statement in function");
  }

  final public ExprNode multitive_expression() throws ParseException {
        ExprNode expr1;
        ExprNode expr2;
    expr1 = primary_number();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 43:
      case 44:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_11;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 43:
        jj_consume_token(43);
        expr2 = primary_number();
                                                         expr1 = new ComputeExprNode("*",expr1, expr2);
        break;
      case 44:
        jj_consume_token(44);
        expr2 = primary_number();
                                                          expr1 = new ComputeExprNode("/",expr1, expr2);
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
        {if (true) return expr1;}
    throw new Error("Missing return statement in function");
  }

  final public ExprNode primary_number() throws ParseException {
        ExprNode expr;
        Token v;
        AttrContext attr;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT_VALUE:
      v = jj_consume_token(INT_VALUE);
                {if (true) return new ValueNode("int", v.image);}
      break;
    case FLOAT_VALUE:
      v = jj_consume_token(FLOAT_VALUE);
                {if (true) return new ValueNode("float", v.image);}
      break;
    case ID:
      attr = attribute();
                {if (true) return new ValueNode("attr", attr);}
      break;
    case LP:
      jj_consume_token(LP);
      expr = computation();
      jj_consume_token(RP);
                {if (true) return expr;}
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public AttrContext attribute() throws ParseException {
        Token cross;
        AttrContext attr = new AttrContext();
        Token name;
    if (jj_2_2(2)) {
      cross = jj_consume_token(ID);
                     attr.className = cross.image;attr.crossClass.add(cross.image);
      label_12:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ARROW:
          ;
          break;
        default:
          jj_la1[25] = jj_gen;
          break label_12;
        }
        jj_consume_token(ARROW);
        cross = jj_consume_token(ID);
                            attr.crossClass.add(cross.image);
      }
                                                                 attr.type = "indirect";
      jj_consume_token(DOT);
      name = jj_consume_token(ID);
                                                                                                                                                                                  attr.attrName = name.image; {if (true) return attr;}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        name = jj_consume_token(ID);
               attr.attrName = name.image; {if (true) return attr;}
        break;
      default:
        jj_la1[26] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_3_2() {
    if (jj_scan_token(ID)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_14()) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(DOT)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_13()) return true;
    return false;
  }

  private boolean jj_3R_14() {
    if (jj_scan_token(ARROW)) return true;
    return false;
  }

  private boolean jj_3R_13() {
    if (jj_scan_token(CREATE)) return true;
    if (jj_scan_token(CLASS)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public OSQLTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[27];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1b06000,0x60000000,0x0,0x60000000,0x20,0x20,0x20,0x20,0x20,0x80000,0x4,0x20000,0x20,0x20000,0x800,0x400,0x70001004,0x300,0x70000004,0x70000000,0x0,0x0,0x0,0x0,0x70000004,0x40,0x10000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x108,0x108,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x108,0x0,0x108,0x108,0x600,0x600,0x1800,0x1800,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[2];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public OSQL(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public OSQL(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new OSQLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public OSQL(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new OSQLTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public OSQL(OSQLTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(OSQLTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 27; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[45];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 27; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 45; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

/*
	public static void main(String[] args){
        InputStreamReader reader = new InputStreamReader(System.in);
        OSQL parser = new OSQL(reader);
        AST root;

        HashMap<String,AttrValue> m1 = new HashMap();
        m1.put("price", new AttrValue("100","int"));
        m1.put("name", new AttrValue("xiaoming","string"));
        while(true){
            try{
                System.out.println("input one line:");
                root = parser.start();
                System.out.println(root.NodeTag);
                switch(root.NodeTag){
                    case "CreateClass":{
                        CreateClass nroot = (CreateClass) root;break;
                    }
                    case "CreateSelectDeputy":{
                        CreateSelectDeputy nroot = (CreateSelectDeputy)root;break;
                    }
                    case "SelectFrom":{
                        SelectFrom nroot = (SelectFrom)root;
                        boolean testRes = ((ConditionExprNode)nroot.whereClause).eval(m1);
                        System.out.println("whereClause is: " + testRes);
                        if(testRes){
                            System.out.println("this tuple match the condition!");
                            for(int i=0;i<nroot.attrs.size();i++){
                                System.out.println("switch result [" + i + "] is: {" + nroot.attrs.get(i).switchRule.evalCompute(m1) + "}");
                                System.out.println("switch result [" + i + "] has type {" + nroot.attrs.get(i).switchRule.resType + "}");
                            }
                        }else{
                            System.out.println("this tuple dosen't match the condition!");
                        }
                        break;
                    }
                    case "DeleteFrom":{
                        DeleteFrom nroot = (DeleteFrom)root;
                        System.out.println("whereClause is:" + ((ConditionExprNode)nroot.whereClause).eval(m1));
                        break;
                    }
                    case "UpdateClass":{
                        UpdateClass nroot = (UpdateClass)root;break;
                    }
                    case "InsertClass":{
                        InsertClass nroot = (InsertClass)root;break;
                    }
                    case "DropClass":{
                        DropClass nroot = (DropClass)root;break;
                    }
                }
                System.out.println("-------------------------\n");
            }catch(OpException e){
                System.out.println("�������");
            }catch(TypeException e){
                System.out.println("���ʹ���");
            }catch(ParseException e){
                System.out.println("�﷨����");
                reader = new InputStreamReader(System.in);
                parser = new OSQL(reader);
            }
        }
	}
*/
}
