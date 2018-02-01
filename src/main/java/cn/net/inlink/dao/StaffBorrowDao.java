package cn.net.inlink.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.StaffBorrow;

/**
 * 员工借用dao
 * @author Yz
 *
 */
public interface StaffBorrowDao {
	
	//借用表增加记录
	@Insert("insert into ssh_borrow values(seq_borrow.nextval,#{staff.id},#{objectName},#{beginDate},#{endDate},#{content},#{flag})")
	public void insertIntoBorrow(StaffBorrow borrow);
	
	//查询借用记录（根据员工编号）
	public List<StaffBorrow> getBorrowByCode(String staffCode);
	
	//查询所有归还借用记录
	public List<StaffBorrow> getAllGiveBackBorrows(RowBounds rb);
	
	//查询归还记录的数量
	@Select("select count(*) from ssh_borrow where borrow_fldflag=1")
	public long getGiveBackCount();
	
	//查询所有未归还借用记录
	public List<StaffBorrow> getAllNoGiveBackBorrows(RowBounds rb);
	
	//查询未归还借用记录的数量
	@Select("select count(*) from ssh_borrow where borrow_fldflag=0")
	public long getNoGiveBackCount();
	
	//更改记录状态 为归还->已归还
	@Update("update ssh_borrow set borrow_fldflag=1,borrow_fldcontent='已归还',borrow_fldenddate=#{param1} where borrow_fldid = #{param2}")
	public void updateBorrowFlag(String endDate,Integer borrowId);
	
}
