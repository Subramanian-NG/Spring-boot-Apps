package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer -> configurer.requestMatchers("/css/**").permitAll().requestMatchers("/")
                        .hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN").requestMatchers("/manager/**").hasRole("MANAGER")
                        .requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/loginPage").loginProcessingUrl("/authenticateUser").permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/accessDenied"));

        return http.build();
    }

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
        return userDetailsManager;
    }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {
    // UserDetails user1 =
    // User.builder().username("user1").password("{noop}user1password").roles("EMPLOYEE").build();
    // UserDetails user2 =
    // User.builder().username("user2").password("{noop}user2password").roles("MANAGER").build();
    // UserDetails user3 =
    // User.builder().username("user3").password("{noop}user3password").roles("ADMIN").build();
    // return new InMemoryUserDetailsManager(user1, user2, user3);
    // }

    // @Bean
    // public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
    // return new JdbcUserDetailsManager(dataSource);
    // }

}
