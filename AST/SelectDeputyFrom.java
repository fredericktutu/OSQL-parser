package whu.oddb.parser;

import java.util.ArrayList;

public class SelectDeputyFrom extends AST{
	String className;
	ArrayList<DeputyAttr> attrs;
	ExprNode whereClause;
	public SelectDeputyFrom(String className, ArrayList<DeputyAttr> attrs, ExprNode whereClause){
        super("SelectDeputyFrom");
        this.className = className;
		this.attrs = attrs;
		this.whereClause = whereClause;
	}
}