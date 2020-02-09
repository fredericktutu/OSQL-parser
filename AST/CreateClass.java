package whu.oddb.parser;


import java.util.ArrayList;

public class CreateClass extends AST{
	public String className;
	public ArrayList<RealAttr> cols;
	public CreateClass(String className,ArrayList<RealAttr> cols){
        super("CreateClass");
		this.className = className;
		this.cols = cols;
	}
}