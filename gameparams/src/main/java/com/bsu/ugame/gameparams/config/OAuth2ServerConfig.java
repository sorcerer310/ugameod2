package com.bsu.ugame.gameparams.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
public class OAuth2ServerConfig {
    private static final String DEMO_RESOURCE_ID="param";


    /**
     * 资源服务器
     */
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//            super.configure(resources);
            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers(HttpMethod.POST,"**").permitAll()
                    .antMatchers(HttpMethod.PUT,"**").permitAll()
                    .antMatchers(HttpMethod.DELETE,"**").permitAll()
                    .antMatchers(HttpMethod.OPTIONS,"**").permitAll()
                    .antMatchers("/control/**").permitAll()
                    .antMatchers("/game/**").permitAll()
                    .antMatchers("/helper/**").permitAll()
                    .antMatchers("/more/**").permitAll()
                    .antMatchers("/share/**").permitAll()
                    .antMatchers("/user/**").permitAll()
                    .antMatchers("/moregame/**").permitAll()
                    .antMatchers("/paramsvalue/**").permitAll()
                    .anyRequest()
                    .authenticated();

        }
    }

    /**
     * 鉴权服务器
     */
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
        @Autowired
        AuthenticationManager authenticationManager;
        @Autowired
        RedisConnectionFactory redisConnectionFactory;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            String finalSecret = new BCryptPasswordEncoder().encode("ugame_qwERzX");

            //配置一个password认证的客户端
            clients.inMemory().withClient("client1")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .secret(finalSecret)
                    .authorizedGrantTypes("password","refresh_token")
                    .scopes("select")
                    .authorities("oauth2")
                    .accessTokenValiditySeconds(60*60*24*1)
                    .refreshTokenValiditySeconds(60*60*24*3);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(new RedisTokenStore(redisConnectionFactory))
                    .authenticationManager(authenticationManager)
                    .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST,HttpMethod.OPTIONS, HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.HEAD);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//            super.configure(security);
            //允许表单认证
            security.allowFormAuthenticationForClients();
        }

    }
}
