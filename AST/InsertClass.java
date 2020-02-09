package whu.oddb.parser;


import java.util.ArrayList;

public class InsertClass extends AST{
	//String NodeTag = "InsertClass";
	public String className;
	public ArrayList<String> attrNames;
	public ArrayList<String> attrValues;

	public InsertClass(	String className, ArrayList<String> attrNames, ArrayList<String> attrValues){
        super("InsertClass");
        this.className = className;
		this.attrNames = attrNames;
		this.attrValues = attrValues;
	}
}