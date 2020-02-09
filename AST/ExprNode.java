package whu.oddb.parser;

import java.util.HashMap;

public class ExprNode{
    String exprType;
    String op;
    String resType;
    ExprNode left;
    ExprNode right;
    public String toString(){
        switch(this.exprType){
            case "value":{
                ValueNode vn = (ValueNode)this;
                if(vn.valueType.equals("attr")){
                    return vn.attrContext.attrName;
                }else{
                    return vn.valueContent;
                }
            }
            case "condition":{
                if(this.op == "NOT"){
                    return this.op + this.left.toString();
                }else{
                    return this.left.toString() + this.op + this.right.toString();
                }
            }
            case "compute":{
                return this.left.toString() + this.op + this.right.toString();
            }
            default:
                return "error";
        }
    }

    public ExprNode(String exprType){
        this.exprType = exprType;
    }
    public ExprNode(String exprType, String op, ExprNode left, ExprNode right){
        this.exprType = exprType;
        this.op = op;
        this.left = left;
        this.right = right;
    }
    public static ValueNode toValueNode(ExprNode expr){
        return (ValueNode) expr;
    }
    public AttrValue evalCompute(HashMap<String, AttrValue> dic)throws OpException,TypeException{
        Object res;
        AttrValue realRes;
        try{
            if(this.exprType == "value")
            {
                res = ((ValueNode)this).eval(dic);
                this.resType = ((ValueNode)this).tmpType;
                realRes = new AttrValue(res.toString(),this.resType);
                return realRes;

            }
            else
            {
                res = ((ComputeExprNode)this).eval(dic);
                this.resType = ((ComputeExprNode)this).tmpType;
                realRes = new AttrValue(res.toString(),this.resType);
                return realRes;
            }
        }catch(OpException e){
            throw e;
        }catch(TypeException e){
            throw e;
        }
    }


}