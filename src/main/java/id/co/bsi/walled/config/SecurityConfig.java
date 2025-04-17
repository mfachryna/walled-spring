//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Bean
//SecurityFilterChain SecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
//    return httpSecurity.authorizeHttpRequests(requests -> requests
//            .requestMatchers("/api/v1/users/auth/login", "/api/v1/users/auth/register").permitAll()
//            .anyRequest().authenticated()
//
//    ).formLogin(Customizer.withDefaults()).build();
//}
