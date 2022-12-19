package ua.goit.hw8.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig{
    private final DataSource db;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()
                .authorizeHttpRequests((req) -> req
                        .requestMatchers("/user/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
                        .requestMatchers("/product/create").hasRole("ADMIN")
                        .requestMatchers("/product/update").hasRole("ADMIN")
                        .requestMatchers("/producer/create").hasRole("ADMIN")
                        .requestMatchers("/producer/update").hasRole("ADMIN")
                        .requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated()

                )
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email").passwordParameter("password")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .formLogin().defaultSuccessUrl("/welcome", true)
                .and()
                .build();
    }
}
