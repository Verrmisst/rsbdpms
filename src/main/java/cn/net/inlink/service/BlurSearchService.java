package cn.net.inlink.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.RoomGoods;
import cn.net.inlink.vo.UploadStaff;

/**
 * 模糊查询的业务组件接口
 * @author Yz
 *
 */

public interface BlurSearchService {
	
	//多条件模糊查询
	public List<UploadStaff> queryByBlur(UploadStaff staff,RowBounds rb);
	
	//多条件模糊查询记录数量
	public List<UploadStaff> queryCountByBlur(UploadStaff staff);
	
	////多条件模糊查询床位情况
	public List<RoomGoods> queryRoomSutiation(RoomGoods roomGoods);
	
	//根据静雅苑和房间号查询床位情况
	public List<RoomGoods> queryRoomSutiationByJY(List<String> roomCodes);
	
	//根据闻博轩和房间号查询床位情况
	public List<RoomGoods> queryRoomSutiationByWB(List<String> roomCodes);

	//多条件查询退宿人员信息
	public List<UploadStaff> queryCheckOuts(String roomCode,String buildName,String beginDate,String endDate,String livingbegin,String livingend,String exchangebegin,String exchangeend);

	//查询所有入住人员信息
	public List<RoomGoods> queryAllStaffs();
}
