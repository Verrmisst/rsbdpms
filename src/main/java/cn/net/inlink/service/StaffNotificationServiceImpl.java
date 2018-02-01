package cn.net.inlink.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.dao.StaffNotificationDao;
import cn.net.inlink.vo.StaffNotification;

@Service(value="")
@Transactional(rollbackFor=Exception.class)
public class StaffNotificationServiceImpl implements StaffNotificationService{
	
	//属性依赖
	@Autowired
	private StaffNotificationDao dao;
	
	public StaffNotificationDao getDao() {
		return dao;
	}

	public void setDao(StaffNotificationDao dao) {
		this.dao = dao;
	}

	//添加员工通报
	@Override
	public void saveNotification(StaffNotification notification) {
		dao.insertIntoBreakRule(notification);
	}
	
	//查询所有通报信息
	@Override
	public List<StaffNotification> queryAllNotifications(RowBounds rb) {
		return dao.getAllNotifications(rb);
	}
	
	//查询所有通报信息的数量
	@Override
	public long queryAllCounts() {
		return dao.getAllCounts();
	}
	
	//根据编号查询通报信息
	@Override
	public List<StaffNotification> queryNotificationByCode(String staffCode) {
		return dao.getNotificationByCode(staffCode);
	}

}
