package cn.net.inlink.utils;

import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.UploadRoom;
import cn.net.inlink.vo.UploadStaff;

/**
 * 处理空值的工具类
 * 
 * @author Yz
 * 
 */

public class StaffValueUtil {

	// 空则返回""
	public static String getStringValue(String value) {

		return value == null ? "" : value;
	}
	
	public static Integer getIntegerValue(Integer value){
		
		return value==null?0:value;
	}

	// 对象为空则创建对象返回
	public static Dictionary getObject(Dictionary dict) {

		return dict == null ? new Dictionary() : dict;
	}

	// 对象为空则创建对象返回
	public static UploadRoom getRoom(UploadRoom room) {

		return room == null ? new UploadRoom() : room;
	}

	// 对象为空则创建对象返回
	public static UploadStaff getStaff(UploadStaff staff) {

		return staff == null ? new UploadStaff() : staff;
	}

}
