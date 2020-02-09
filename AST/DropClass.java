package whu.oddb.parser;

public class DropClass extends AST{
	//String NodeTag = "DropClass";
	public String className;
	public DropClass(String className){
        super("DropClass");
		this.className = className;
	}
}