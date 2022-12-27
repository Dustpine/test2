package kr.co.mindoll.hr.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDetailViewRepository implements EmpDetailsView {
	private JdbcTemplate template;
	private RowMapper<EmployeeDetailVO> rm = new RowMapper<EmployeeDetailVO>() {
		
		@Override
		public EmployeeDetailVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeDetailVO vo = new EmployeeDetailVO();
			vo.setCity(rs.getString("city"));
			vo.setCommissionPct(rs.getDouble("commission_pct"));
			vo.setCountryId(rs.getString("country_id"));
			vo.setCountryName(rs.getString("country_name"));
			vo.setDepartmentId(rs.getInt("department_id"));
			vo.setDepartmentName(rs.getString("department_name"));
			vo.setEmployeeId(rs.getInt("employee_id"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setJobTitle(rs.getString("job_title"));
			vo.setJobId(rs.getString("job_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setLocationId(rs.getInt("location_id"));
			vo.setManagerId(rs.getInt("manager_id"));
			vo.setRegionName(rs.getString("region_name"));
			vo.setSalary(rs.getDouble("salaey"));
			vo.setStarteProvince(rs.getString("state_province"));
			return vo;
		}
	};
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return template.queryForObject("select count(*) from emp_details_view", Integer.class);
	}

	@Override
	public int getsalary(int employeeId) {
		return template.queryForObject("select salary from emp_details_view where employee_id = ?",
				new Object[] {employeeId}, 
				Integer.class);
	}

	@Override
	public EmployeeDetailVO getEmployee(int employeeId) {
		return template.queryForObject("select * from emp_details_view where employee_id = ?",
				new Object[] {employeeId}, 
				rm);
	}

	@Override
	public List<EmployeeDetailVO> getAll() {
		return template.query("select * from emp_details_view ", rm);
	}

	@Override
	public List<EmployeeDetailVO> getConditionEmp(int salary, int departmentId) {
		return template.query("select * from emp_details_view where salary >= ? and department_id = ?",
				new Object[] {salary, departmentId},
				rm);
	}

}
