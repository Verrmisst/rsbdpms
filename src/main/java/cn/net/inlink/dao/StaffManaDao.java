package cn.net.inlink.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Update;

import cn.net.inlink.vo.Building;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.Employee;
import cn.net.inlink.vo.Room;

/**
 * 获取员工管理数据的DAO
 * 
 * @author Yz
 * 
 */
public interface StaffManaDao {

	// 宿舍人员表中插入数据:id，员工编号，员工姓名，创建日期
	public void insertIntoEmp(Employee emp);
	
	//根据人员编号，宿舍人员表中插入数据：员工性别(字典表id)
	public void updateIntoEmpGender(Integer dictId,String empCode);
	
	//根据人员编号，宿舍人员表中更新职务和科室字段
	public void updateEmpDutyDept(Integer deptId,Integer dutyId,String empCode);
	
	//根据字典名称查询字典id
	public Dictionary getIdByDictName(String dictName);
	
	//根据宿舍楼名称获取宿舍楼id
	public Building getIdByBuildName(String buildingName);
	
	// 宿舍表中插入数据：id，房间编号
	public void insertIntoRoom(Room room);
	
	//根据房间编号 更新宿舍楼字段信息
	public void updateRoomBuildId(Integer buildId,String roomCode);
	
	//物品表中插入数据
	public void insertIntoGoods(Integer typeId,String code,Integer roomId,Integer empId);
	
	//根据人员编号获取人员id
	public Employee getEmpIdByCode(String empCode);
	
	//根据宿舍编号获取宿舍id
	public Room getRoomIdByCode(String roomCode);
	
	//查询所有员工信息
	public List<Employee> getAllEmps();
	
	//根据员工编号查询员工
	public List<Employee> getEmpsByCodeOrDate(String empCode);
	
	//更新物品表
	@Update("UPDATE ssh_goods SET goods_fldroomid =#{param1} ,goods_fldcode =#{param2} WHERE goods_fldperson =#{param3} AND goods_fldtype=#{param4} ")
	public void updateGoods(Integer roomId,String goodsCode,Integer staffId,Integer goodsType);

	//更新宿舍表
	@Update("update ssh_room set room_fldcontent1=#{param1},room_fldcontent2=#{param2},room_fldclassify=#{param3} where room_fldcode = #{param4} and room_fldbuildid=#{param5}")
	public void updateRoom(String content1,String content2,String classify,String roomCode,Integer buildId);
}
