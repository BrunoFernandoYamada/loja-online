package br.com.lojaonlinebackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.firebirdsql.pool.FBWrappingDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"br.com.lojaonlinebackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/lojaonline";
	private final static String DATABASE_DRIVER= "org.h2.Driver";
	private final static String DATABASE_DIALECT= "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	@Bean
	public DataSource getDataSource() {
	
		BasicDataSource dataSource = new BasicDataSource();
		
		//Provendo as informações de conexão
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	
	}
	
	//A Fabrica de sessão (sessionFactory) estará disponível
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("br.com.lojaonlinebackend.dto");
		
		return builder.buildSessionFactory();
	}

	//Todas as propriedades do hibernate serão retornadas neste methodo
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("Hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	//Bean responsável por Gerenciar as Transações 
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
	}
	
	
}
