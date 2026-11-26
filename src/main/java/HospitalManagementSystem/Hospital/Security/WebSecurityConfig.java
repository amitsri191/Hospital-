package HospitalManagementSystem.Hospital.Security;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final JwtAuthFilter jwtAuthFilter;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionConfig->sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(hello->hello
                        .requestMatchers("/public/**","/auth/**").permitAll()
//                        .requestMatchers("/admin/**").authenticated()
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                                .requestMatchers("/doctor").hasAnyRole("DOCTOR","ADMIN")
                                .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .oauth2Login(oauth2->oauth2
                        .failureHandler((request, response, exception) -> {
                            log.error("oauth2 error: {}",exception.getMessage());
                        })
                        .successHandler(oAuth2SuccessHandler)
                );

        return http.build();
    }

//    UserDetailsService userDetailsService(){
//        UserDetails user1= User.withUsername("admin")
//                .password(passwordEncoder.encode("pass"))
//                .roles("PATIENT")
//                .build();
//        return new InMemoryUserDetailsManager(user1);
//    }
}
