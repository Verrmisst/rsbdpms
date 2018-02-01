package cn.net.inlink.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Update;

import cn.net.inlink.vo.Building;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.Employee;
import cn.net.inlink.vo.Goods;
import cn.net.inlink.vo.Room;

/**
 * 员工管理业务组件接口
 * @author Yz
 *
 */

public interface StaffManaService {
	
	//持久化宿舍人员数据
	public void saveEmp(Employee emp);
	
	//持久化宿舍人员性别信息
	public void saveEmpGender(Integer dictId,String empCode);
	
	//更新宿舍人员职务和部门信息
	public void editEmpDutyDept(Integer deptId,Integer dutyId,String empCode);
	
	//查询字典表的id，根据名称
	public Dictionary queryIdByDictName(String dictName);
	
	//查询宿舍楼id，根据名称
	public Building queryIdByBuildName(String buildingName);
	
	//持久化宿舍信息
	public void saveRoom(Room room);
	
	//更新宿舍所属宿舍楼信息
	public void editRommBuildId(Integer buildId,String roomCode);
	
	//持久化物品信息
	//public void saveGoods(Integer typeId,String code,Integer roomId,Integer empId);
	
	//更新物品信息
	@Update("UPDATE ssh_goods SET goods_fldroomid =#{param1} ,goods_fldcode =#{param2} WHERE goods_fldperson =#{param3} AND goods_fldtype=#{param4} ")
	//public void editGoods(Integer roomId,String goodsCode,Integer staffId,Integer goodsType);
	
	//查询人员id，根据编号
	public Employee queryIdByEmpCode(String empCode);
	
	//查询退宿人员
	public Employee queryCOEmpByEmpCode(String empCode);
	
	//删除退宿人员
	public void deleCOEmpByCode(String empCode);

	
	//查询宿舍id，根据宿舍编号
	public Room queryIdByRoomCode(String roomCode);
	
	//查询所有员工信息
	public List<Employee> queryEmps();
	
	//更新宿舍表
	public void editRoom(String content1,String content2,String classify,String roomCode,Integer buildId);

	//查询科室和职务结果集
	public List<Dictionary> queryDict(String dictType);
 }
