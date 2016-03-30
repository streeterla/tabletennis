package de.sms.tabletennis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = {"de.sms.tabletennis"})
@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@EnableJpaRepositories("de.sms.tabletennis.daos")
@EntityScan("de.sms.tabletennis.entities")
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Override 
    public void addResourceHandlers(ResourceHandlerRegistry registry) {     
        registry.addResourceHandler("/assets/**").addResourceLocations("/resources/"); 
    }

	@Configuration
    @EnableWebSecurity
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    	
    	@Autowired
    	private CustomUserDetailsService userDetailsService;

		private final Logger LOG = LoggerFactory.getLogger(getClass());

    	@Override
    	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			LOG.info("Login by auth");
    		auth.userDetailsService(userDetailsService);
    	}
    	
		@Override
		  protected void configure(HttpSecurity http) throws Exception {
			LOG.info("Login by http");
		    http.httpBasic().and()
		      .authorizeRequests()
		        .antMatchers("/index.html", "/home.html", "home.html", "/user", "sync", "/index.html#/login", "login", "/login", "login.html", "/login.html", "/js/all.js", "/js/email.js", "/js/fileupload.js", "/js/navigation.js").permitAll().anyRequest()
		        .authenticated().and()
		      .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
		      .csrf().csrfTokenRepository(csrfTokenRepository());
		  } 	
    	
		private CsrfTokenRepository csrfTokenRepository() {
			  HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
			  repository.setHeaderName("X-XSRF-TOKEN");
			  return repository;
			}
    	
    }

}
