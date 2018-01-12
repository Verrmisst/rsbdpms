package cn.net.inlink.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.UploadRoom;
import cn.net.inlink.vo.UploadStaff;

/**
 * 宿舍管理的业务组件接口
 * @author Yz
 *
 */
public interface DormManaService {
	
	//查询所有入住人员信息
	public List<UploadStaff> queryAllStaffs(RowBounds rb);
	
	//查询总记录数
	public long queryCount();
	
	//根据员工编号查询入住人员信息
	public UploadStaff queryStaffByCode(String staffCode);
	
	//员工退宿
	public void staffCheckOut(String staffCode);
	
	//员工调宿(根据员工编号)
	public void staffExchange(String staffCode,String build,String roomCode,String bedNum,String wardrobeNum,String deskNum,String shopboxNum,String livingDate);

	//查询宿舍信息
	public List<UploadRoom> queryRooms(String buildName,RowBounds rb);
	
	//查询宿舍配置信息数量
	public long queryRoomCount(String buildName);
	
	//根据房间号码查询配置信息
	public UploadRoom queryRoomByCode(String roomCode,String buildName);

	//根据房间编号更新房间信息
	public void editRoomSet(String content1,String content2,String classify,String roomCode);
	
	//更新可住人数
	public void editOccupy(String roomCode,String buildName);
}
