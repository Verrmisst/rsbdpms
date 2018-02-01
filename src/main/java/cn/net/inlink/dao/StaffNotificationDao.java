package cn.net.inlink.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.StaffNotification;

/**
 * 处理员工通报的dao
 * @author Yz
 *
 */

public interface StaffNotificationDao {
	
	//添加员工通报
	@Insert("insert into ssh_breakrule values(seq_breakrule.nextval,#{notificeType},#{notificeTime},#{notificeReason},#{notificeMoney},#{staff.id})")
	public void insertIntoBreakRule(StaffNotification notifice);
	
	//查询所有通报信息
	public List<StaffNotification> getAllNotifications(RowBounds rb);
	
	//查询所有通报信息的数量
	@Select("select count(*) from ssh_breakrule")
	public long getAllCounts();
	
	//根据编号查询通报信息
	public List<StaffNotification> getNotificationByCode(String staffCode);
}
