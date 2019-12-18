package com.cifo.pla9_actividad.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SeguridadConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	//@Bean
	//public PasswordEncoder passwordEncoder() {
	//	return new BCryptPasswordEncoder();
	//}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll() /*página inicio,accesible todo mundo*/
		/* Se puede hacer que aquí compruebe el ROLE y envíe a la página que corresponda,
		 * habiendo de usar un controlador para cada vista ...*/
		/* Si hubiera unas reglas más espec�ficas que otras, las primeras deberían preceder las otras */		
		.antMatchers("/colaborador/**").hasRole("COLABORADOR")
		.antMatchers("/editor/**").hasRole("EDITOR")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.and().formLogin().loginPage("/formlogin")
		.loginProcessingUrl("/authenticateTheUser").permitAll()
		/* ... O tener un solo controlador que compruebe que ROLE est� logueando y
		 * que envíe a la vista que corresponda, según el mensaje del foro al respecto */
		//.defaultSuccessUrl("/compruebaROLE", true)	
		.and().logout().permitAll(); //.logoutUrl("/fin") no me ha funcionado, igual porque mandaba a index.jsp, y habría que hacerlo con PostMapping...
		/* Supongo que también podría usar .failureUrl() */
		/* Ahora ya no hace falta pues s�lo muestro los enlaces que cada ROLE puede visitar*/
		//.and().exceptionHandling().accessDeniedPage("/prohibido");
	}	

	





}
