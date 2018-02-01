package cn.net.inlink.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.RoomGoods;
import cn.net.inlink.vo.UploadRoom;
import cn.net.inlink.vo.UploadStaff;

/**
 * 管理宿舍的DAO
 * @author Yz
 *
 */
public interface DormManaDao {
	
	//查询所有入住人员信息
	public List<UploadStaff> getAllEmps(RowBounds rb);
	
	//查询总记录数
	@Select("select count(*) from ssh_staffinfo where staff_fldflag = 0")
	public long getCounts();
	
	//查询所有已退宿人员信息（分页）
	public List<UploadStaff> getAllCheckouts(RowBounds rb);
	
	//查询所有已退宿人员信息（不分页）
	public List<UploadStaff> getAllCheckoutsNoPaging();
	
	//查询所有已退宿人员记录数
	@Select("select count(*) from ssh_staffinfo where staff_fldflag = 1")
	public long getCheckoutCounts();
	
	//根据员工编号查询人员信息
	public UploadStaff getStaffByCode(String staffCode);
 	
	//更新员工状态
	@Update("update ssh_staffinfo set staff_fldflag = 1,staff_fldcheckoutdate = to_char(sysdate,'yyyy/mm/dd') where staff_fldpersoncode=#{param}")
	public void updateStaffFlag(String staffCode);

	//更改员工状态
	@Update("update ssh_person set person_fldflag=1 where person_fldcode =#{param}")
	public void updateEmpFlag(String empCode);
	
	//更新人员入住情况
	@Update("update ssh_staffinfo set staff_fldbuild = #{param1},staff_fldroomcode = #{param2},staff_fldbednum=#{param3},staff_fldwardrobenum = #{param4}," +
			"staff_flddesknum=#{param5},staff_fldshopboxnum = #{param6} , staff_fldexchangedate =#{param7} where staff_fldpersoncode=#{param8}")
	public void updateStaffDormInfo(String build, String roomCode,
			String bedNum, String wardrobeNum, String deskNum, String shopboxNum,String livingDate,String staffCode);
	
	//查询宿舍配置信息
	public List<UploadRoom> getAllRooms(String buildName,RowBounds rb);
	
	//查询宿舍配置信息条数
	@Select("select count(*) from ssh_roomset where roomset_fldbuildname=#{param}")
	public long getRoomCounts(String buildName);
	
	//根据宿舍号查询宿舍配置信息
	public UploadRoom getRoomSetByCode(String roomCode,String buildName);

	//更新宿舍配置信息
	@Update("update ssh_roomset set roomset_fldsize=#{param1},roomset_fldclassify=#{param2},roomset_fldcontent=#{param3},roomset_fldcontent2=#{param4},roomset_fldcontent3=#{param5} where roomset_fldroomcode=#{param6}")
	public void updateRoomSet(String size,String classify,String content,String content2,String content3,String roomCode);
	
	//调宿更新宿舍信息中可住人数(+1)
	@Update("update ssh_roomset set roomset_fldocc = roomset_fldocc+1 where roomset_fldroomcode=#{param1} and roomset_fldbuildname=#{param2}")
	public void updateOccupy(String roomCode,String buildName);
	
	//删除已退宿人员
	@Delete("delete from ssh_staffinfo where staff_fldflag = 1 and staff_fldpersoncode=#{param}")
	public void deleCOStaff(String staffCode);
	
	//退宿宿舍信息更新可住人数(-1)
	@Update("update ssh_roomset set roomset_fldocc = roomset_fldocc-1 where roomset_fldroomcode=#{param1} and roomset_fldbuildname=#{param2}")
	public void updateOccupycut(String roomCode,String buildName);
	
	//根据宿舍楼名和房间号查询入住信息
	public List<UploadStaff> getEmpRomeSet(String buildName,String roomCode);

	//增加宿舍配置信息
	@Insert("insert into ssh_roomset values(seq_roomset.nextval,#{roomCode},#{size},#{occupy},#{classify},#{content1},#{content2},#{buildName},#{content3})")
	public void insertRoomSet(UploadRoom room);
	
	//查询宿舍剩余空床信息
	public List<RoomGoods> getSurplusGoods(String buildName,String roomCode);
}
