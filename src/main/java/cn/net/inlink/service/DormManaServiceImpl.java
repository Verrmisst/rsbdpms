package cn.net.inlink.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.dao.DormManaDao;
import cn.net.inlink.vo.UploadRoom;
import cn.net.inlink.vo.UploadStaff;

/**
 * 宿舍管理业务组件接口实现类
 * @author Yz
 *
 */
@Service(value="dormManaService")
@Transactional(rollbackFor=Exception.class)
public class DormManaServiceImpl implements DormManaService {
	
	//属性依赖
	@Autowired
	private DormManaDao dao;
	
	
	public DormManaDao getDao() {
		return dao;
	}

	public void setDao(DormManaDao dao) {
		this.dao = dao;
	}

	//查询所有入住人员信息
	@Override
	public List<UploadStaff> queryAllStaffs(RowBounds rb) {
		
		return dao.getAllEmps(rb);
	}
	
	//根据编号查询
	@Override
	public UploadStaff queryStaffByCode(String staffCode) {
		
		return dao.getStaffByCode(staffCode);
	}
	
	//查询总记录数
	@Override
	public long queryCount() {
		
		return dao.getCounts();
	}
	
	//员工退宿
	@Override
	public void staffCheckOut(String staffCode) {
		dao.updateStaffFlag(staffCode);
	}
	
	//员工调宿
	@Override
	public void staffExchange(String staffCode, String build, String roomCode,
			String bedNum, String wardrobeNum, String deskNum, String shopboxNum,String livingDate) {
		
		dao.updateStaffDormInfo(build, roomCode, bedNum, wardrobeNum, deskNum, shopboxNum,livingDate,staffCode);
		
	}
	
	//宿舍信息
	@Override
	public List<UploadRoom> queryRooms(String buildName,RowBounds rb) {
		// TODO Auto-generated method stub
		return dao.getAllRooms(buildName,rb);
	}
	
	//宿舍配置信息数量
	@Override
	public long queryRoomCount(String buildName) {
		return dao.getRoomCounts(buildName);
	}
	
	//根据编号查询宿舍配置信息
	@Override
	public UploadRoom queryRoomByCode(String roomCode,String buildName) {
		return dao.getRoomSetByCode(roomCode,buildName);
	}
	
	//根据房间编号更新房间信息
	@Override
	public void editRoomSet(String content1, String content2, String classify,
			String roomCode) {
		dao.updateRoomSet(content1, content2, classify, roomCode);
	}
	
	//更新入住人数
	@Override
	public void editOccupy(String roomCode, String buildName) {
		dao.updateOccupy(roomCode, buildName);
	}
}
