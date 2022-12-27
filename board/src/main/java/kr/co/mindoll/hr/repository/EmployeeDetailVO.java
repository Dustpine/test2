package kr.co.mindoll.hr.repository;

import lombok.Data;

@Data
public class EmployeeDetailVO {
	private Integer employeeId;
	private String jobId;
	private int managerId;
	private int departmentId;
	private int locationId;
	private String countryId;
	private String firstName;
	private String lastName;
	private Double salary;
	private Double commissionPct;
	private String departmentName;
	private String jobTitle;
	private String city;
	private String starteProvince;
	private String countryName;
	private String regionName;
	
	
}
