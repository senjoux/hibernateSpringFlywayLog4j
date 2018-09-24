 /***********************************************
 *                                              *
 *     Copyright (C) Azyrox Consulting          *
 *                                              *
 *             All rights reserved.             *
 *                                              *
 ***********************************************/
package com.de.hamza.hibernateSpringFlywayLog4j;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Definition file for :
 * <ul>
 * <li>LocalSessionFactoryBean</li>
 * <li>DataSource</li>
 * <li>PlatformTransactionManager</li>
 * <li>Hibernate properties</li>
 * </ul>
 * 
 * For using <strong>Flyway</strong> migration tool, I provided two approaches here :
 * <ul>
 * <li>Using the maven flyway plugin, where the necesary config. is located in
 * the respective plugin definition.</li>
 * <li>Usng Spring, by informing spring that the sessionFactory (LocalSessionFactoryBean) is
 * depending on the "flyway" bean, taking into account the migrate() method is
 * called whenever an instance of the "flyway" bean is created by spring. <br>
 * Note : uncomment to ACTIVATE, don't forget to remove the plugin section from the pom.xml file.
 * </li>
 * </ul>
 * 
 * @author {Hamza Hedhly}
 * @createDate {2018-09-09}
 */
@Configuration
@EnableTransactionManagement
public class AppConfig {

	private static final String DB_USERNAME = "hamza";
	private static final String DB_PASSWORD = "123";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/hibernate5demo";
	private static final String FLYWAY_MIGRATION_LOCATIONS[] = { "classpath:db.migration",
			"filesystem:src/main/resources/db/migration" };

	@Bean
	@DependsOn("flyway")
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.de.hamza.hibernateSpringFlywayLog4j.entity");
		sessionFactory.setHibernateProperties(buildHibernateProperties());
		return sessionFactory;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager
		= new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;
	}
	
	private Properties buildHibernateProperties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return properties;
	}
	
	@Bean(initMethod = "migrate")
	public Flyway flyway() {
	    Flyway flyway = new Flyway();
		flyway.setDataSource(dataSource());
		flyway.setBaselineOnMigrate(true);
		flyway.setLocations(FLYWAY_MIGRATION_LOCATIONS);
	    return flyway;
	}
}
