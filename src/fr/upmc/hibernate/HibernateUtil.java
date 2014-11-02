package fr.upmc.hibernate;

import java.net.URI;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import fr.upmc.bean.*;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			
			
			
			URI dbUri = new URI(System.getenv("DATABASE_URL"));
			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
			//System.out.println(dbUrl);
			sessionFactory = new AnnotationConfiguration()
			.addPackage("fr.upmc.bean")
			.addAnnotatedClass(EvaluationBean.class)
			.addAnnotatedClass(MasterBEAN.class)
			.addAnnotatedClass(TempUserBean.class)
			.addAnnotatedClass(TransportBean.class)
			.addAnnotatedClass(TrasporteurBean.class)
			.addAnnotatedClass(VoyageBean.class)
			.addAnnotatedClass(Train.class)
			.setProperty("hibernate.connection.driver_class", "postgresql.Driver")
			.setProperty("hibernate.connection.url", dbUrl)
			.setProperty("hibernate.connection.username", username)
			.setProperty("hibernate.connection.password", password)
			.setProperty("hibernate.connection.pool_size", "true")
			.setProperty("hibernate.hbm2ddl.auto", "create")
			.setProperty("hibernate.format_sql", "true")
			.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
			.configure().buildSessionFactory();
			
			
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}