package com.cyexm.cyzhit.SecurityConfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter {


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//    }

    @Resource
    private DetaiImpl detai;

    @Resource
    private DataSource dataSource;

    @Resource
    private PersistentTokenRepository repository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .usernameParameter("tel")
                .loginProcessingUrl("/toLogin")
//                .loginPage("/login.html")
                .loginPage("/login")
                .successForwardUrl("/toLogin")
                .failureForwardUrl("/toFail");
//        .and().formLogin().permitAll()
//                .and()
//                .sessionManagement()
//                .maximumSessions(1)
//                .maxSessionsPreventsLogin(false)
//        .expiredUrl("/index");

        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(false).expiredUrl("/index");



        http.authorizeRequests()
                .antMatchers("/modifyResume","/find","/login","/logon","/index","/toText","/","/show/**","/text","/publish","/toLogon").permitAll()
                .antMatchers("/font1/**","/font0/**","/image/**","/JS/**","/CSS/**","/font/**").permitAll()
//                .antMatchers("/index").hasAuthority("ROLE_ANONYMOUS")
                .anyRequest().authenticated();

        http.logout()
                .logoutSuccessUrl("/index");

        http.rememberMe()
                .userDetailsService(detai)
                .tokenRepository(repository)
                .tokenValiditySeconds(300);

        http.csrf().disable();
    }

    @Bean
    public PersistentTokenRepository getRepository()
    {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
}
