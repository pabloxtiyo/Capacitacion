package com.pportillo.localiza.config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.pportillo.localiza.model.repository")
public class DataConfig {


	@Bean
	public DataSource dataSource() {
		BoneCPDataSource datasource = new BoneCPDataSource();
		datasource.setDriverClass("org.postgresql.Driver");
		datasource.setJdbcUrl("jdbc:postgresql://localhost/prueba");
		datasource.setUsername("postgres");
		datasource.setPassword("0000");
		return datasource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource);
		lef.setJpaVendorAdapter(jpaVendorAdapter);
		lef.setJpaProperties(additionalProperties());
		lef.setPackagesToScan("com.pportillo.localiza.model.*");
		return lef;
	}

	@Bean
	public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(Boolean.parseBoolean("false"));
		hibernateJpaVendorAdapter.setGenerateDdl(Boolean.parseBoolean("false"));
		hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
		return hibernateJpaVendorAdapter;
	}

	Properties additionalProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;
			{ // Hibernate Specific:
				setProperty("hibernate.hbm2ddl.auto", "none");
				setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			}
		};
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

}
