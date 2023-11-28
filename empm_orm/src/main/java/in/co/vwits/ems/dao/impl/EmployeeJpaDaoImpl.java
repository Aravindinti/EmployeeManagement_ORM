package in.co.vwits.ems.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;
@Repository
public class EmployeeJpaDaoImpl implements EmployeeDao{
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public Optional<Employee> findByID(int id) {
	
		Employee s = em.find(Employee.class, id); //This fires select query.
		
		return Optional.of(s);
	}

	@Override
	public void Insert(Employee e) {
		

		em.persist(e); 
		
		
	}

	@Override
	public void deleteById(int id) {
		
		em.remove(em.find(Employee.class, id)); 
		
	}

	@Override
	public List<Employee> sortingByName(int key) {
		
		String jpql="";
		if(key==1) {
		 jpql="FROM Employee ORDER BY name";
		}
		else  {
			jpql="FROM Employee ORDER BY name DESC";
		}
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
	
		em.close();
		return employeeList;

	}

	@Override
	public List<Employee> sortingBySalary(int key) {
		
		String  jpql="";
		if(key==1) {
		jpql="FROM Employee ORDER BY salary";
		}
		else {
			jpql="FROM Employee ORDER BY salary DESC";
		}
		
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		
		return employeeList;
	}

	@Override
	public void UpdateBySalary(Employee e) {
		//
		em.merge(e);
	}

	@Override
	public List<Employee> findAll() {
		
		String jpql="FROM Employee";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
				return employeeList;
	}

	@Override
	public void UpdatePerById(int roll, double sal) {
		// TODO Auto-generated method stub
		 Employee s=new Employee();
		 //s.setName(s.getName());
		    s.setSalary(sal);
		    em.merge(s);
		
	}


}
