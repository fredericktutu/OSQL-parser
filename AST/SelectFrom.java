package whu.oddb.parser;

import java.util.ArrayList;

public class SelectFrom extends AST{
	//String NodeTag="SelectFrom";
	public String className;
	public ArrayList<AttrContext> attrs;
	public ExprNode whereClause;

	public SelectFrom(String className, ArrayList<AttrContext> attrs, ExprNode whereClause){
        super("SelectFrom");
        this.className = className;
		this.attrs = attrs;
		this.whereClause = whereClause;
	}
}