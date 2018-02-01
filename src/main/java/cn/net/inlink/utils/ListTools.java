package cn.net.inlink.utils;

import java.util.List;

/**
 * 处理集合的工具类
 * 
 * @author Yz
 * 
 */
public class ListTools {

	// 去除list中的重复元素
	public static List<?> removeDuplicate(List<?> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).equals(list.get(i))) {
					list.remove(j);
				}
			}
		}
		return list;
	}
}
