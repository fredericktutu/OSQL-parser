package whu.oddb.parser;


import java.util.HashMap;

public class ComputeExprNode extends ExprNode {
    String tmpType = "float";
    boolean hasAttr;
	public float eval(HashMap dic)throws OpException,TypeException{
        float left_value,right_value;
        boolean nl_hasAttr,nr_hasAttr;
        String nl_tmpType,nr_tmpType;
        try{
        if(this.left.exprType == "value"){
            ValueNode nl = (ValueNode) this.left;
            left_value = (float)nl.eval(dic);
            nl_hasAttr = nl.hasAttr;
            nl_tmpType = nl.tmpType;
        }else{
            ComputeExprNode nl = (ComputeExprNode)this.left;
            left_value = (float)nl.eval(dic);
            nl_hasAttr = nl.hasAttr;
            nl_tmpType = nl.tmpType;
        }
        if(this.right.exprType == "value"){
            ValueNode nr = (ValueNode) this.right;
            right_value = (float)nr.eval(dic);
            if(nr.tmpType == "string"){
                throw new OpException();
            }
            nr_hasAttr = nr.hasAttr;
            nr_tmpType = nr.tmpType;
        }else{
            ComputeExprNode nr = (ComputeExprNode)this.right;
            right_value = (float)nr.eval(dic);
            nr_hasAttr = nr.hasAttr;
            nr_tmpType = nr.tmpType;
        }
        this.tmpType = nl_hasAttr? nl_tmpType : nr_tmpType;
        this.hasAttr = nl_hasAttr || nr_hasAttr;
        switch(this.op){
            case "+": return left_value + right_value;
            case "-": return left_value - right_value;
            case "*": return left_value * right_value;
            case "/": return left_value / right_value; 
            default: return (float) 0;
        }
        }catch(TypeException e){
            throw e;
        }
        catch(ClassCastException e){
            throw new OpException();
        }
	}
	public ComputeExprNode(String op, ExprNode left, ExprNode right){
		super("compute", op, left, right);
	}
}