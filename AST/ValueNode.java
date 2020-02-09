package whu.oddb.parser;


import android.util.Log;

import java.util.HashMap;

public class ValueNode extends ExprNode{


    private static final String TAG = "ValueNode";

	String valueType; //char, string, int, float, attr
    String valueContent;  //??????char,string,int,float,бу???????????
    String tmpType; 
    boolean hasAttr; 
	AttrContext attrContext; //??????attr,?и░бу?attr??????????????????
	public Object eval(HashMap<String, AttrValue> dic) throws TypeException{
        if(this.valueType.equals("attr")){

            Log.d(TAG, "eval: dic = " + dic.get("name"));

            if(!dic.containsKey(this.attrContext.attrName)){
                throw new TypeException("attr dose not exist in tuple list");
            }
            this.tmpType = dic.get(this.attrContext.attrName).type;
            this.hasAttr = true;
            String result = dic.get(this.attrContext.attrName).value;
            switch(this.tmpType){
                case "int":{
                    return (Object) Float.parseFloat(result);
                }
                case "float":{
                    return (Object) Float.parseFloat(result);
                }
            }
            return (Object)result;
        }
        this.hasAttr = false;
        this.tmpType = this.valueType;
        switch(this.valueType){
            case "int":
            case "float":{
                return (Object) Float.parseFloat(this.valueContent);
            }
            case "string":{
                return (Object) this.valueContent;
            }
            default:{
                return (Object) this.valueContent;
            }
        }
    }
    
	public ValueNode(String valueType, String valueContent){
		super("value");
		this.valueType = valueType;
		this.valueContent = valueContent;
	}
	public ValueNode(String valueType, AttrContext attrContext){
		super("value");
		this.valueType = valueType;
		this.attrContext = attrContext;
	}
}