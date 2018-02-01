package cn.net.inlink.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.StaffBorrow;

/**
 * 处理员工借用的业务组件接口
 * @author Yz
 *
 */
public interface StaffBorrowService {
	
	//添加借用记录
	public void saveBorrow(StaffBorrow borrow);
	
	//查询单个员工借用记录
	public List<StaffBorrow> queryBorrowByCode(String staffCode);
	
	//查询所有归还借用记录
	public List<StaffBorrow> queryStaffGiveBackBorrows(RowBounds rb);
	
	//查询归还记录数量
	public long queryGiveBackCount();
	
	//查询所有未归还借用记录
	public List<StaffBorrow> queryStaffNoGiveBackBorrows(RowBounds rb);
	
	//查询未归还借用记录
	public long queryNoGiveBackCount();
	
	//归还物品
	public void editBorrowFlag(String endDate,Integer borrowId);
}
