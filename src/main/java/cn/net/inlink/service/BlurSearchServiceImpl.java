package cn.net.inlink.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.dao.BlurSearchDao;
import cn.net.inlink.vo.RoomGoods;
import cn.net.inlink.vo.UploadStaff;

@Service(value = "blurSearchService")
@Transactional
public class BlurSearchServiceImpl implements BlurSearchService {

	// 属性依赖
	@Autowired
	private BlurSearchDao dao;

	public BlurSearchDao getDao() {
		return dao;
	}

	public void setDao(BlurSearchDao dao) {
		this.dao = dao;
	}

	// 多条件模糊查询
	@Override
	public List<UploadStaff> queryByBlur(UploadStaff staff,RowBounds rb) {
		return dao.getStaffsByBlur(staff,rb);
	}
	
	//多条件模糊查询记录数量
	@Override
	public List<UploadStaff> queryCountByBlur(UploadStaff staff) {
		
		return dao.getStaffsCountByBlur(staff);
	}
	
	// 多条件模糊查询床位情况
	@Override
	public List<RoomGoods> queryRoomSutiation(RoomGoods roomGoods) {
		return dao.getRoomSutiation(roomGoods);
	}
	//根据静雅苑和房间号查询床位情况
	@Override
	public List<RoomGoods> queryRoomSutiationByJY(List<String> roomCodes) {
		// TODO Auto-generated method stub
		return dao.getRoomSutiationByJingYa(roomCodes);
	}
	
	//根据闻博轩和房间号查询床位情况
	@Override
	public List<RoomGoods> queryRoomSutiationByWB(List<String> roomCodes) {
		// TODO Auto-generated method stub
		return dao.getRoomSutiationByWenBo(roomCodes);
	}
	
	//多条件查询退宿人员信息
	@Override
	public List<UploadStaff> queryCheckOuts(String roomCode, String buildName,
			String beginDate, String endDate,String livingbegin,String livingend,String exchangebegin,String exchangeend) {
		
		return dao.getCheckoutStaffs(roomCode, buildName, beginDate, endDate, livingbegin, livingend, exchangebegin, exchangeend);
				
	}
	
	//查询所有入住人员信息
	@Override
	public List<RoomGoods> queryAllStaffs() {
		return dao.getAllStaffs();
	}
}
