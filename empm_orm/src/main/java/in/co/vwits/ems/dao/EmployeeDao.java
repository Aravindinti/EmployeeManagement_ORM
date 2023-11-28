package in.co.vwits.ems.dao;

import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.model.Employee;

public interface EmployeeDao{
	public void save();

	public Optional<Employee> findByID(int id);

	public void Insert(Employee e);

	public void deleteById(int id);

	public List<Employee> sortingByName(int key);

	public List<Employee> sortingBySalary(int key);

	public void UpdateBySalary(Employee e);

	public List<Employee> findAll();

	public void UpdatePerById(int roll, double sal);
}
