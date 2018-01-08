package cn.net.inlink.utils;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 将实体对象或者集合对象转换成JSON格式的工具类
 * @author Yz
 *
 */
public class JSONUtil {
	
	//将实体对象转换成JSON格式字符串(封装javaBean)
	public static String BeanToJSON(Object obj){
		
		JSONObject jobj = JSONObject.fromObject(obj);
		
		String jsonStr = jobj.toString();
		
		return jsonStr;
	}
	
	//将集合对象转换成JSON格式字符串(封装list集合)
	public static <T> String ListToJSON(List<T> list){
		
		JSONArray jarray = JSONArray.fromObject(list);
		
		String jsonStr = jarray.toString();
		
		return jsonStr;
	}
	
	//将Map对象转换成JSON格式字符串
	public static  String MapToJSON(Map<?, ?> map){
		
		JSONObject jsonObject = JSONObject.fromObject(map); 
		
		String jsonStr = jsonObject.toString();
		return jsonStr;
	}
	
	 
}
