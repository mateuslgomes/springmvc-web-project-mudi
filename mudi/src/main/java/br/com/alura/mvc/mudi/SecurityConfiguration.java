package br.com.alura.mvc.mudi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.core.userdetails.User.builder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers("/home/**").permitAll()
                        .anyRequest().authenticated().and()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/usuario/pedido", true)
                        .permitAll()
                ).logout(logout -> {
                    logout.logoutUrl("/logout").logoutSuccessUrl("/home");
                })
                .csrf().disable();
        return http.build();
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserDetails user = builder()
                .username("user56")
                    .password(encoder.encode("senha"))
                .roles("ADM")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        return users;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
