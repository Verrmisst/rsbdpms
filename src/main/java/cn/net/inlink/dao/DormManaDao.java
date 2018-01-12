package cn.net.inlink.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

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
	
	//根据员工编号查询人员信息
	public UploadStaff getStaffByCode(String staffCode);
 	
	//更新员工状态
	@Update("update ssh_staffinfo set staff_fldflag = 1 where staff_fldpersoncode=#{param}")
	public void updateStaffFlag(String staffCode);
	
	//更新人员入住情况
	@Update("update ssh_staffinfo set staff_fldbuild = #{param1},staff_fldroomcode = #{param2},staff_fldbednum=#{param3},staff_fldwardrobenum = #{param4}," +
			"staff_flddesknum=#{param5},staff_fldshopboxnum = #{param6} , staff_fldlivingdate =#{param7} where staff_fldpersoncode=#{param8}")
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
	@Update("update ssh_roomset set roomset_fldcontent = #{param1},roomset_fldcontent2=#{param2},roomset_fldclassify=#{param3} where roomset_fldroomcode=#{param4}")
	public void updateRoomSet(String content1,String content2,String classify,String roomCode);
	
	//更新宿舍信息中可住人数
	@Update("update ssh_roomset set roomset_fldocc = roomset_fldocc+1 where roomset_fldroomcode=#{param1} and roomset_fldbuildname=#{param2}")
	public void updateOccupy(String roomCode,String buildName);
}
