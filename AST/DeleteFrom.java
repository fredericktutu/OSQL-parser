package whu.oddb.parser;


public class DeleteFrom extends AST{
	//String NodeTag = "DeleteFrom";
	public String className;
	public ExprNode whereClause;
	public DeleteFrom(String className, ExprNode whereClause){
        super("DeleteFrom");
        this.className = className;
		this.whereClause = whereClause;
	}
}
