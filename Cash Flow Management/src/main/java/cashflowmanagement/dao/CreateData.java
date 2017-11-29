package cashflowmanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateData {
	
	public CreateData() throws Exception {
		SessionFactory sessFact = HibernateSessionConfiguration.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		Employee emp = new Employee();
		emp.setEmpName("John Bruno");
		emp.setEmpMobileNos("888");
		emp.setEmpAddress("Delhi - India");
		session.save(emp);
		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();
	}
	
	public static void main(String[] args) {
		try {
			new CreateData();
//			new GetAllData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}