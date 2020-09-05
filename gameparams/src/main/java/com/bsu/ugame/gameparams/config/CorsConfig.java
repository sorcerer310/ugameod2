package com.bsu.ugame.gameparams.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 处理前端跨域
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration corsConfig(){
        CorsConfiguration cc = new CorsConfiguration();
        cc.setAllowedOrigins(Arrays.asList("http://47.94.234.28:8380","http://localhost:8188","http://0.0.0.0:8080","http://kaifa1.ugamesoft.net:8380"));
        cc.setAllowCredentials(true);                                                                                   //websocket使用
        cc.addAllowedMethod("*");
        cc.addAllowedHeader("*");
        return cc;
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfig());
        return new CorsFilter(source);
    }
}
