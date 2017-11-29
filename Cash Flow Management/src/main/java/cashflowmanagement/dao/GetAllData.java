package cashflowmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetAllData {
	
	public GetAllData() throws Exception {

//		SessionFactory sessFact = HibernateSessionConfiguration.getSessionFactory();
//		Session session = sessFact.getCurrentSession();
//		org.hibernate.Transaction tr = session.beginTransaction();
//		CriteriaQuery cq = session.getCriteriaBuilder().createQuery(Employee.class);
//		cq.from(Employee.class);
//		List<Employee> employeeList = session.createQuery(cq).getResultList();
//		for (Employee employee : employeeList) {
//			System.out.println("ID: " + employee.getId());
//			System.out.println("Name: " + employee.getEmpName());
//		}
//		tr.commit();
//		System.out.println("Data printed");
//		sessFact.close();
		
		SessionFactory sessFact = HibernateSessionConfiguration.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Employee> pessoas = session.createCriteria(Employee.class).list();
		for (Employee p : pessoas) {
			System.out.println(p.getId() + " - " + p.getEmpName());
		}
		tr.commit();
		sessFact.close();
	}
	
}