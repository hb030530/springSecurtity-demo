package com.d5data.demotest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    /*
    * 基于内存的userdetailsService
    * */
    @Bean
public UserDetailsService userDetailsService(){
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(
            User.withUsername("test")
                    .password("{noop}123456")  //设置明文密码
                    .roles("ADMIN").build());
    return manager;
}
   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .csrf().disable();
        return http.build();
    }


}
