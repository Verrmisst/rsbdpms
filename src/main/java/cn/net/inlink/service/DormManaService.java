package cn.net.inlink.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.RoomGoods;
import cn.net.inlink.vo.UploadRoom;
import cn.net.inlink.vo.UploadStaff;

/**
 * 宿舍管理的业务组件接口
 * 
 * @author Yz
 * 
 */
public interface DormManaService {

	// 查询所有入住人员信息
	public List<UploadStaff> queryAllStaffs(RowBounds rb);

	// 查询总记录数
	public long queryCount();

	// 查询所有已退宿人员信息
	public List<UploadStaff> queryAllCheckouts(RowBounds rb);

	// 查询所有已退宿人员信息（不分页）
	public List<UploadStaff> queryAllCheckoutsNoPaging();

	// 查询所有已退宿人员记录数
	public long queryCheckoutCounts();

	// 根据员工编号查询入住人员信息
	public UploadStaff queryStaffByCode(String staffCode);

	// 员工退宿
	public void staffCheckOut(String staffCode);

	// 更改员工状态
	public void editEmpFlag(String empCode);

	// 员工调宿(根据员工编号)
	public void staffExchange(String staffCode, String build, String roomCode,
			String bedNum, String wardrobeNum, String deskNum,
			String shopboxNum, String livingDate);

	// 查询宿舍信息
	public List<UploadRoom> queryRooms(String buildName, RowBounds rb);

	// 查询宿舍配置信息数量
	public long queryRoomCount(String buildName);

	// 根据房间号码查询配置信息
	public UploadRoom queryRoomByCode(String roomCode, String buildName);

	// 根据房间编号更新房间信息
	public void editRoomSet(String size, String classify, String content1,
			String content2, String content3, String roomCode);

	// 更新可住人数(+1)
	public void editOccupy(String roomCode, String buildName);

	// 更新可住人数(-1)
	public void editOccupycut(String roomCode, String buildName);

	// //根据宿舍楼名和房间号查询入住信息
	public List<UploadStaff> queryEmpRomeSet(String buildName, String roomCode);

	// 增加宿舍配置信息
	public void saveRoomset(UploadRoom room);

	// 查询宿舍剩余空床信息
	public List<RoomGoods> querySurplusGoods(String buildName, String roomCode);

}
