package cn.net.inlink.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.dao.StaffManaDao;
import cn.net.inlink.vo.Building;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.Employee;
import cn.net.inlink.vo.Room;

/**
 * 员工管理业务接口实现类
 * @author Yz
 *
 */
@Service(value = "staffManaService")
@Transactional(rollbackFor = Exception.class)
public class StaffManaServiceImpl implements StaffManaService {
	
	//属性依赖
	private StaffManaDao dao;
	
	public StaffManaDao getDao() {
		return dao;
	}


	public void setDao(StaffManaDao dao) {
		this.dao = dao;
	}


	//持久化员工信息
	@Override
	public void saveEmp(Employee emp) {
		dao.insertIntoEmp(emp);
	}
	
	//持久化员工性别信息
	@Override
	public void saveEmpGender(Integer dictId,String empCode) {
		
		dao.updateIntoEmpGender(dictId,empCode);
	};
	
	//更新员工部门和职务信息
	@Override
	public void editEmpDutyDept(Integer deptId, Integer dutyId, String empCode) {
		
		dao.updateEmpDutyDept(deptId, dutyId, empCode);
	}
	
	//查询字典表id
	@Override
	public Dictionary queryIdByDictName(String dictName) {
		
		return dao.getIdByDictName(dictName);
	}
	
	//查询宿舍楼id
	@Override
	public Building queryIdByBuildName(String buildingName) {
		
		return dao.getIdByBuildName(buildingName);
	}
	
	//持久化宿舍信息
	@Override
	public void saveRoom(Room room) {
		dao.insertIntoRoom(room);
	}
	
	//更新宿舍所属大楼信息
	@Override
	public void editRommBuildId(Integer buildId, String roomCode) {
		dao.updateRoomBuildId(buildId, roomCode);
	}
	
	//持久化物品信息
	/*@Override
	public void saveGoods(Integer typeId,String code,Integer roomId,Integer empId) {
		dao.insertIntoGoods(typeId,code,roomId,empId);
	}*/
	
	//查询宿舍人员id
	@Override
	public Employee queryIdByEmpCode(String empCode) {
		return dao.getEmpIdByCode(empCode);
	}
	
	//查询退宿人员
	@Override
	public Employee queryCOEmpByEmpCode(String empCode) {
		return dao.getCOEmpIdByCode(empCode);
	}
	
	//删除退宿人员
	@Override
	public void deleCOEmpByCode(String empCode) {
		dao.deleCOEmpByCode(empCode);
	}
	
	
	//查询房间id
	@Override
	public Room queryIdByRoomCode(String roomCode) {
		return dao.getRoomIdByCode(roomCode);
	}
	
	//查询所有员工信息
	@Override
	public List<Employee> queryEmps() {
		
		return dao.getAllEmps();
	}

	
	//更新物品表
	/*@Override
	public void editGoods(Integer roomId, String goodsCode, Integer staffId,
			Integer goodsType) {
		dao.updateGoods(roomId, goodsCode, staffId, goodsType);
	}*/
	
	//更新宿舍表
	@Override
	public void editRoom(String contnt1, String content2, String classify,
			String roomCode,Integer buildId) {
		dao.updateRoom(contnt1, content2, classify, roomCode,buildId);
	}
	
	//查询科室和职务
	@Override
	public List<Dictionary> queryDict(String dictType) {
		return dao.getDeptOrDuty(dictType);
	}
}
