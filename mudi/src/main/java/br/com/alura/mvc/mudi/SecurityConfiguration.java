package br.com.alura.mvc.mudi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                ).logout(logout -> logout.logoutUrl("/logout"));
        return http.build();
    }

        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username("root")
                    .password("root")
                    .roles("ADM")
                    .build();
            return new InMemoryUserDetailsManager(user);
        }
}