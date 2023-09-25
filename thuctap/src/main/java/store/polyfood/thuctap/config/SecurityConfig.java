package store.polyfood.thuctap.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .formLogin()
                .and().httpBasic()
                .and()
                .authorizeHttpRequests()
                    .requestMatchers("/api/register").permitAll()
                .requestMatchers("/forgot_password").permitAll()
                .requestMatchers("/reset_password").permitAll()
                .requestMatchers("/api/account/getall").hasAuthority("ADMIN")
                .anyRequest().authenticated();
        return httpSecurity.build();
    }
}
