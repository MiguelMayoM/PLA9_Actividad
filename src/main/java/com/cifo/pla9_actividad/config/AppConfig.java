package com.cifo.pla9_actividad.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.datasource.init.DataSourceInitializer;
//import org.springframework.jdbc.datasource.init.DatabasePopulator;
//import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.cifo.pla9_actividad")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

	/* Cargamos la Base de Datos del Script*/
	//@Bean
	//public DataSourceInitializer dataSourceInitializer() {
	//	ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
	//  resourceDatabasePopulator.addScript(new ClassPathResource("/usuarios.sql"));

	//  DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
	//  dataSourceInitializer.setDataSource(securityDataSource());
	//  dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
	//  return dataSourceInitializer;
	//}
	
	//@Bean
	//public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
	//  final DataSourceInitializer initializer = new DataSourceInitializer();
	//  initializer.setDataSource(dataSource);
	//  initializer.setDatabasePopulator(databasePopulator());
	//  return initializer;
	//}
	//private DatabasePopulator databasePopulator() {
	//  final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	//  populator.addScript(new ClassPathResource("/usuarios.sql"));
	//  return populator;
	//}	
		
	@Bean
	public DataSource securityDataSource() {
	
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));

		} catch (PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));

		securityDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		securityDataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		securityDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		securityDataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		
		return securityDataSource;
	}	
}
