package kr.co.mindoll.hr.repository;

import java.util.List;

public interface EmpDetailsView {
	int countAll();  //전체 인원수세기 => 단일행 단일컬럼
	int getsalary(int employeeId);  // 특정 사원의 급여조회 => 단일행 단일컬럼
	EmployeeDetailVO getEmployee(int employeeId); // => 단일행 다중컬럼
	List<EmployeeDetailVO> getAll(); // => 다중행 다중 컬럼
	List<EmployeeDetailVO> getConditionEmp(int salary, int departmentId); //  => 다중행 다중컬럼
}
