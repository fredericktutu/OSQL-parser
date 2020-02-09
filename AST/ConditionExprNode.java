package whu.oddb.parser;


//import android.util.Log;

import android.util.Log;

import java.util.HashMap;

public class ConditionExprNode extends ExprNode{

    private static final String TAG = "ConditionExprNode";
    
	public boolean eval(HashMap<String, AttrValue> dic){

        Log.d(TAG, "eval: in eval");
        
        ValueNode left=null;
        ValueNode right=null;
        Object left_value=null,right_value=null;
        try{
            if(this.left.exprType.equals("value"))
            {
                left = toValueNode(this.left);
                left_value = left.eval(dic);
            }

            Log.d(TAG, "eval: first if");
            
            if(this.right != null && this.right.exprType.equals( "value"))
            {
                right = toValueNode(this.right);
                right_value = right.eval(dic);
            }

            Log.d(TAG, "eval: in switch");
            switch(this.op){
                case "=":{
                    Log.d(TAG, "eval: in case");
                    if(left.tmpType.equals("string"))
                    {
                        Log.d(TAG, "eval: in if");
                        return ((String)left_value).equals((String)right_value);
                    }
                    else
                    {
                        Log.d(TAG, "eval: in else");
                        Log.d(TAG, "eval: return = " + ((float)left_value == (float)right_value));
                        return (float)left_value == (float)right_value;
                    }
                }
                case "<>":{
                    if(left.tmpType .equals( "string"))
                    {
                        return !((String)left_value).equals((String)right_value);
                    }
                    else
                    {
                        return (float)left_value != (float)right_value;
                    }
                } 
                case ">=":{
                    return (float)left_value >= (float)right_value;
                }
                case "<=":{
                    return (float)left_value <= (float)right_value;
                }
                case ">":{
                    return (float)left_value > (float)right_value;
                }
                case "<":{
                    return (float)left_value < (float)right_value;
                }
                case "AND":{
                    return ((ConditionExprNode)this.left).eval(dic) && ((ConditionExprNode)this.right).eval(dic);
                }
                case "OR":{
                    return ((ConditionExprNode)this.left).eval(dic) || ((ConditionExprNode)this.right).eval(dic);
                }
                case "NOT":{
                    return !((ConditionExprNode)this.left).eval(dic);
                }
                default:{
                    return false;
                }
            }
        }catch(ClassCastException e){
            try {
                throw new OpException();
            } catch (OpException ex) {
                ex.printStackTrace();
            }
        }catch(TypeException e){
            try {
                throw e;
            } catch (TypeException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
	public ConditionExprNode(String op, ExprNode left, ExprNode right){
		super("condition", op, left, right);
	}
}