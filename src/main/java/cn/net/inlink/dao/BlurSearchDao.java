package cn.net.inlink.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.RoomGoods;
import cn.net.inlink.vo.UploadStaff;

/**
 * 模糊查询的Dao
 * @author Yz
 *
 */

public interface BlurSearchDao {
	
	//多条件模糊查询
	public List<UploadStaff> getStaffsByBlur(UploadStaff staff,RowBounds rb);
	
	//多条件模糊查询记录数量
	public List<UploadStaff> getStaffsCountByBlur(UploadStaff staff);
	
	//多条件模糊查询床位情况
	public List<RoomGoods> getRoomSutiation(RoomGoods roomGoods);
	
	//根据静雅苑和房间号查询床位情况
	public List<RoomGoods> getRoomSutiationByJingYa(List<String> roomCodes);

	//根据闻博轩和房间号查询床位情况
	public List<RoomGoods> getRoomSutiationByWenBo(List<String> roomCodes);
	
	//多条件查询退宿人员信息
	public List<UploadStaff> getCheckoutStaffs(String roomCode,String buildName,String beginDate,String endDate,String livingbegin,String livingend,String exchangebegin,String exchangeend);

	//查询所有入住人员信息
	public List<RoomGoods> getAllStaffs();
}
