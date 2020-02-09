package whu.oddb.parser;
import java.util.ArrayList;

public class UpdateClass extends AST{
	//String NodeTag = "UpdateClass";
	public String className;
	public ArrayList<String> attrNames;
	public ArrayList<String> values;
	public ExprNode whereClause;


	public UpdateClass(String className, ArrayList<String> attrNames, ArrayList<String> values, ExprNode whereClause){
        super("UpdateClass");
        this.className = className;
		this.attrNames = attrNames;
		this.values = values;
		this.whereClause = whereClause;
	}
}