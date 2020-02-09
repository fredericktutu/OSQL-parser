package whu.oddb.parser;

import java.util.ArrayList;

public class AttrContext{  //ÔÚÑ¡ÔñµÄÊ±ºòÎÒÃÇÑ¡ÔñµÄÊôÐÔ£¬ÕâÀïÃæ°üÀ¨µÄÐÅÏ¢ÓÐ£¬À´×ÔÄÄ¸öÀà
	public String type;
	public String className;
	public String attrName;
	public ArrayList<String> crossClass; //¿çÀà²éÑ¯µÄÁÐ±í£¬´Ó×óµ½ÓÒÒÀ´ÎÊÇ¸¸Ààµ½×ÓÀàµ½Ëï×ÓÀà...
	public AttrContext(){
		this.crossClass = new ArrayList();
		this.type = "direct";
	}
}
