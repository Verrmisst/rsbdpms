package cn.net.inlink.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.StaffNotification;

/**
 * 处理员工通报的业务组件接口
 * @author Yz
 *
 */
public interface StaffNotificationService {
	
	//添加员工通报
	public void saveNotification(StaffNotification notification);
	
	//查询所有通报信息
	public List<StaffNotification> queryAllNotifications(RowBounds rb);
	
	//查询所有通报信息的数量
	public long queryAllCounts();
	
	//根据编号查询通报信息
	public List<StaffNotification> queryNotificationByCode(String staffCode);
	
}
