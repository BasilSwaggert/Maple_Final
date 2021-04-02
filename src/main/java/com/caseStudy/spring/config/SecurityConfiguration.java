package com.caseStudy.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.caseStudy.spring.services.UsersService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsersService usersService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	
        httpSecurity.cors().and().csrf().disable();
        
        httpSecurity.authorizeRequests()
        			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        			.antMatchers("/employee/**").access("hasRole('ROLE_EMPLOYEE')")
        			.and()
        			.formLogin()
        			.loginPage("/login-panel")
        			.loginProcessingUrl("/login/process-login")
        			.defaultSuccessUrl("/login-panel/welcome")
        			.failureUrl("/login-panel/login?error")
        			.usernameParameter("username")
        			.passwordParameter("password")
        			.and()
        			.logout()
        			.logoutUrl("/process-logout")
        			.logoutSuccessUrl("/login-panel/login?logout")
        			.deleteCookies("JSESSIONID")
        			.and()
        			.exceptionHandling()
        			.accessDeniedPage("/login-panel/accessDenied");
    }
        
        

//        httpSecurity.authorizeRequests()
//                .antMatchers("/dashboard/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_USER')")
//
//                .antMatchers("/user/profile").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_USER')")
//                .antMatchers("/users/index/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/users/add/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/users/edit/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/users/delete/**").access("hasRole('ROLE_ADMIN')")
//
//                .antMatchers("/category/index/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/category/add/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/category/edit/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/category/delete/**").access("hasRole('ROLE_ADMIN')")
//
//                .antMatchers("/status/index/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/status/add/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/status/edit/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/status/delete/**").access("hasRole('ROLE_ADMIN')")
//
//                .and()
//                .formLogin()
//                .loginPage("/login-panel")
//                .loginProcessingUrl("/login/process-login")
//                .defaultSuccessUrl("/login-panel/welcome")
//                .failureUrl("/login-panel/login?error")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and().logout()
//                .logoutUrl("/process-logout")
//                .logoutSuccessUrl("/login-panel/login?logout")
//                .deleteCookies("JSESSIONID")
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/login-panel/accessDenied");
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(usersService);
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    
}
    
//  httpSecurity.authorizeRequests()
//	.antMatchers("/admin").hasRole("ROLE_ADMIN")
//	.antMatchers("/", "/dashboard").permitAll()
//	.anyRequest().hasRole("ROLE_USER")
//	.and()
//	.formLogin()
//	.loginPage("/login-panel")
//	.failureUrl("/login-panel/login?error")
//	.permitAll()
//	.and()
//	.logout()
//	.logoutSuccessUrl("/")
//	.permitAll();
//}