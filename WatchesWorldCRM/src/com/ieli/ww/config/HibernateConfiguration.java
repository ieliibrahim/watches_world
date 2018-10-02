package com.ieli.ww.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.ieli.ww" })
@EnableJpaRepositories({ "com.ieli.ww.repository" })
@PropertySource({ "classpath:application.properties" })
public class HibernateConfiguration {
	@Autowired
	private Environment environment;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan(new String[] { "com.ieli.ww.model" });
		entityManagerFactoryBean.setJpaProperties(hibernateProperties());
		return entityManagerFactoryBean;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(this.environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(this.environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(this.environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", this.environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", this.environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", this.environment.getRequiredProperty("hibernate.format_sql"));
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
