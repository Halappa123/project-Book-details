/*
 * package com.example.config;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableGlobalMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * import lombok.var;
 * 
 * @Configuration
 * 
 * @EnableGlobalMethodSecurity(prePostEnabled = true) public class
 * SecurityConfig {
 * 
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception {
 * 
 * return http.httpBasic().and() .authorizeRequests() .anyRequest()
 * .authenticated()
 * 
 * .and() .build(); }
 * 
 * @Bean public UserDetailsService userDetailsService() {
 * 
 * var uds=new InMemoryUserDetailsManager(); var v1=User.withUsername("Halappa")
 * .password(passwordEncoder() .encode("1234")) .authorities("ADMIN") .build();
 * 
 * var v2=User.withUsername("chetan") .password(passwordEncoder()
 * .encode("1234")) .authorities("MANAGER") .build();
 * 
 * uds.createUser(v1); uds.createUser(v2);
 * 
 * return uds;
 * 
 * }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * }
 */