package cashflowmanagement.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionConfiguration {

	private static final SessionFactory sessionFactory;

	static {
		try { 
			Configuration configuration = new Configuration();
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
			configuration.configure();
			sessionFactory = configuration.buildSessionFactory(standardRegistry);
//			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
//			sessionFactory = metaData.getSessionFactoryBuilder().build();
		} catch (Throwable th) {
			throw new ExceptionInInitializerError(th);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}