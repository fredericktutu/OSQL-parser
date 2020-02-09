package whu.oddb.parser;


public class DeputyAttr{ //ÐéÊôÐÔ
	public String name;//ÎÒÃÇ¸øËûµÄÐÂÃû×Ö
	public String originClass; //´ÓÄÄ¸öÔ­ÀàÀïÃæÕÒ
	public ExprNode switchRule;  //Ò»¸ö±í´ïÊ½£¬±ÈÈç price /50
	public DeputyAttr(String name, String originClass, ExprNode switchRule){
		this.name = name;
		this.originClass = originClass;
		this.switchRule = switchRule;
	}
}