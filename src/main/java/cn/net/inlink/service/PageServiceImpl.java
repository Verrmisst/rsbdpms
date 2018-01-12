package cn.net.inlink.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.dao.PageDao;
import cn.net.inlink.vo.Employee;

@Service(value = "pageService")
@Transactional(rollbackFor = Exception.class)
public class PageServiceImpl implements PageService {
	// 属性依赖
	@Autowired
	private PageDao dao;

	public PageDao getDao() {
		return dao;
	}

	public void setDao(PageDao dao) {
		this.dao = dao;
	}
	
	
	//分页查询
	@Override
	public List<Employee> pagingEmp(RowBounds rb) {
		return dao.getAllEmp(rb);
	}
	
	//查询总记录数
	@Override
	public long queryCount() {
		
		return dao.getSum();
	}
	
	//查询员工根据编号
	@Override
	public List<Employee> queryEmpByCode(String empCode) {
		return dao.getEmpByCode(empCode);
	}
}
