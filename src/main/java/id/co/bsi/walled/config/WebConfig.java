//package id.co.bsi.walled.config;
//
//import id.co.bsi.walled.middleware.TokenFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private TokenFilter tokenFilter;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenFilter)
//                .addPathPatterns("/api/v1/users/transactions/**","/api/v1/users/auth/logout","/api/v1/users/profile","/api/v1/users/account")
//                .excludePathPatterns("/api/v1/users/auth/login","/api/v1/users/auth/register");
//    }
//}
