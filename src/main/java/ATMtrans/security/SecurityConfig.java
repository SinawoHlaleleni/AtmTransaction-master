package ATMtrans.security;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


        @Override
        protected void configure(AuthenticationManagerBuilder auth)
                throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("sinawo")
                    .password(encoder().encode("sinawo123"))
                    .roles("Manager")
                    .and()
                    .withUser("admin")
                    .password(encoder().encode("admin123"))
                    .roles("ADMIN");
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/AtmTransaction-master/lookup/**/create/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic()
                    .and()
                    .csrf().disable()
                   .formLogin().disable();
        }

        @Bean
        public PasswordEncoder encoder() {
            return new BCryptPasswordEncoder();
        }
    }
