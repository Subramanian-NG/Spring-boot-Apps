package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        try {
            http.authorizeHttpRequests(configurer -> configurer.requestMatchers(HttpMethod.GET, "api/employees")
                    .hasRole("EMPLOYEE").requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT, "api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("ADMIN"));

            http.httpBasic(Customizer.withDefaults());

            // usually csrf handling is not required when the client is a non-browser. since
            // we are developing rest api for clients like postman, we are disabling it now.
            // once we develop a web page for browser clients, we need to handle for csrf.
            // cross site resource forgery
            http.csrf(csrf -> csrf.disable());

            return http.build();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    // public InMemoryUserDetailsManager userDetailsManager() {
    // UserDetails user1 =
    // User.builder().username("user1").password("{noop}user1password").roles("EMPLOYEE").build();
    // UserDetails user2 =
    // User.builder().username("user2").password("{noop}user2password").roles("MANAGER").build();
    // UserDetails user3 =
    // User.builder().username("user3").password("{noop}user3password").roles("ADMIN").build();
    // return new InMemoryUserDetailsManager(user1, user2, user3);
    // }

    // public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
    // return new JdbcUserDetailsManager(dataSource);
    // }

}
