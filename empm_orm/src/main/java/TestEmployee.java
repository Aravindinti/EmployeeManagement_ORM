import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import in.co.vwits.ems.model.Employee;
import in.co.vwits.ems.service.impl.EmployeeServiceImpl;
import in.co.vwits.service.EmployeeService;

public abstract class TestEmployee implements EmployeeService {
	
	
	public static void main(String[] args) {
		
		ApplicationContext container ;
		container=new AnnotationConfigApplicationContext(in.co.vwits.ems.ApplicationConfiguration.class);
		
		//EmployeeService sao=new EmployeeServiceImpl();
		
		EmployeeService sao=container.getBean(EmployeeService.class);
		Scanner sc=null;
		
		try {
			
			System.out.println("<-----Employee Management System---->");
			System.out.println("--->1.Find all The Employees");
			System.out.println("--->2.Find all The Employee By ID");
			System.out.println("--->3.Insert New Employee Details");
			System.out.println("--->4.Delete Employee Details By ID");
			System.out.println("--->5.Update Salary of a Employee By Using ID");
			System.out.println("--->6.Sort Employees By  Names");
			System.out.println("--->7.Sort Employess By Salary");
			
			sc=new Scanner(System.in);
			int option =1;
			do {
				System.out.println();
				System.out.println("Enter option");
					option=sc.nextInt() ;
	switch (option) 
          {
	case 1: 
		 System.out.println("All Employee Details \n");
		          List<Employee> emp=sao.findAll();
	                System.out.println(emp);
	                break;
	case 2:
		System.out.println("Enter Employee ID \n");
		Optional<Employee> emp2=sao.findByID(sc.nextInt());
		System.out.println(emp2);
		break;
		
	case 3: 
		System.out.println("Enter Employee Details to Insert(ID,NAME,SALARY) \n ");
		Employee e=new Employee();
		//System.out.println("ID:");
		//e.setId(sc.nextInt());
		System.out.println("Name:");
		e.setName(sc.next());
		System.out.println("salary:");
		e.setSalary(sc.nextInt());
		sao.Insert(e);
		System.out.println("Inserted");
		break;
		
	case 4:
		System.out.println("Enter EmployeeID to Delete \n");
		sao.deleteById(sc.nextInt());
	       System.out.println("Deleted");
	       break;
	       
	case 5:
		//sSystem.out.println("Enter Employee ID to which U Want to Update salary \n");
	//	sao.UpdateBySalary(sc.nextInt(), sc.nextDouble());
		
		 System.out.println("Enter Id  and salary to Update");
		  int roll=sc.nextInt();
	  Employee	 foundstudent1=Optional.ofNullable(sao.findByID(roll).get()).get();
		 //Student ss=foundstudent.get();
		  System.out.println("enter salary");
		  double sal=sc.nextDouble();
		  foundstudent1.setSalary(sal);
		  sao.UpdateBySalary(foundstudent1);
		 sao.UpdatePerById(roll,sal);
		
		break;
	 
	case 6:
		 System.out.println("enter 1 --> Sort Names in [A-Z] order /n 0--> Sort Names in [Z-A] order");		
		List<Employee> p=sao.sortingByName(sc.nextInt());
		System.out.println(p);
		break;
		
	case 7:
      System.out.println("enter 1 --> Sort Salary in Ascending /n 0--> Sort Salary in descending");
		List<Employee> p2=sao.sortingBySalary(sc.nextInt());
		System.out.println(p2);
		break;
		
	case -1:
		System.out.println("Thank You");
		break;
		
					
				}
			 }
		while(option!=-1);
		
	}
	finally
	{
	sc.close();	
	}

	 
	}

}
