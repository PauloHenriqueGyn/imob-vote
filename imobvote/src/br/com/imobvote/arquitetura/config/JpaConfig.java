package br.com.imobvote.arquitetura.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration 
@EnableTransactionManagement
@ComponentScan("br.com.imobvote")
public class JpaConfig {

	@Bean
    public DataSource dataSource() {
        return new JndiDataSourceLookup().getDataSource("java:jboss/datasources/IMOBVOTE");
    }

	@Bean(name="conexao-imobvote")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("br.com.imobvote.modelo");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
	}
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.put("hibernate.temp.use_jdbc_metadata_defaults","false");
        properties.put("hibernate.show_sql", "true");
//        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.enable_lazy_load_no_trans", "true");
//        properties.put("hibernate.generate_statistics", "true");
        
        return properties;
    }
	
	@Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
