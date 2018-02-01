package cn.net.inlink.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.dao.StaffBorrowDao;
import cn.net.inlink.vo.StaffBorrow;

@Service(value = "")
@Transactional(rollbackFor = Exception.class)
public class StaffBorrowServiceImpl implements StaffBorrowService {

	// 属性依赖
	@Autowired
	private StaffBorrowDao dao;

	public StaffBorrowDao getDao() {
		return dao;
	}

	public void setDao(StaffBorrowDao dao) {
		this.dao = dao;
	}

	// 添加借用记录
	@Override
	public void saveBorrow(StaffBorrow borrow) {
		dao.insertIntoBorrow(borrow);
	}

	// 查询单个员工借用记录
	@Override
	public List<StaffBorrow> queryBorrowByCode(String staffCode) {

		return dao.getBorrowByCode(staffCode);
	}
	
	// 查询所有归还借用记录
	@Override
	public List<StaffBorrow> queryStaffGiveBackBorrows(RowBounds rb) {
		return dao.getAllGiveBackBorrows(rb);
	}

	// 归还借用记录数量
	@Override
	public long queryGiveBackCount() {
		return dao.getGiveBackCount();
	}

	// 查询所有未归还借用记录
	@Override
	public List<StaffBorrow> queryStaffNoGiveBackBorrows(RowBounds rb) {
		return dao.getAllNoGiveBackBorrows(rb);
	}

	// 未归还借用记录数量
	@Override
	public long queryNoGiveBackCount() {
		return dao.getNoGiveBackCount();
	}

	// 归还物品
	@Override
	public void editBorrowFlag(String endDate, Integer borrowId) {
		dao.updateBorrowFlag(endDate, borrowId);
	}

}
