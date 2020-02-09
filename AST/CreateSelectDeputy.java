package whu.oddb.parser;

import java.util.ArrayList;

public class CreateSelectDeputy extends AST{
	//String NodeTag = "CreateSelectDeputy";
	public String className; //´úÀíÀàµÄÃû×Ö
	public String originClass;  //ÐéÊôÐÔ´ÓÄÄÀï¼Ì³Ð¶øÀ´
	public ArrayList<DeputyAttr> deputyAttrs; //ÐéÊôÐÔ±í
	public ArrayList<RealAttr> realAttrs; //ÊµÊôÐÔ±í
	public ExprNode deputyRule;
	//deputyrule, this should be a expr,
	public CreateSelectDeputy(String className, String originClass, ArrayList<DeputyAttr> deputyAttrs, ArrayList<RealAttr> realAttrs, ExprNode deputyRule){
        super("CreateSelectDeputy");
        this.className = className;
		this.originClass = originClass;
		this.deputyAttrs = deputyAttrs;
		this.realAttrs = realAttrs;
		this.deputyRule = deputyRule;
	}
}
