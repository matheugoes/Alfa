//package ages.alfa.config;
//
//import java.util.Arrays;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
///**
// * Configurações de segurança e requisições.
// */
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private String[] grantedOrigins =
//            {
//                "localhost",
//                "localhost:3000",
//                "localhost:4200",
//                "localhost:5000",
//                "localhost:8080",
//            };
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.setAllowCredentials(true);
//
//        Arrays.stream(grantedOrigins).forEach(origin -> {
//            corsConfig.addAllowedOrigin(origin.trim());
//        });
//
//        corsConfig.addAllowedHeader("Authorization");
//        corsConfig.addAllowedHeader("Content-Type");
//        corsConfig.addAllowedHeader("Accept");
//        corsConfig.addAllowedHeader("Origin");
//
//        corsConfig.addAllowedMethod("POST");
//        corsConfig.addAllowedMethod("GET");
//        corsConfig.addAllowedMethod("DELETE");
//        corsConfig.addAllowedMethod("PUT");
//        corsConfig.addAllowedMethod("OPTIONS");
//
//        source.registerCorsConfiguration("/**", corsConfig);
//
//        http.cors().configurationSource(source).and().authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .antMatchers("/swagger-ui.html",
//                        "/v2/api-docs", "/webjars/**", "/swagger-resources/**").permitAll()
//                .and().authorizeRequests().and().httpBasic();
//    }
//}
