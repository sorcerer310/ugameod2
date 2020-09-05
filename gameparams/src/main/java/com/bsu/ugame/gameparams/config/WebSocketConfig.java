package com.bsu.ugame.gameparams.config;

import com.bsu.ugame.gameparams.api.helper.websocket.STOMPConnectEventListener;
import com.bsu.ugame.gameparams.api.helper.websocket.SocketSessionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created by fc on 18/12/07
 * 通过EnableWebSocketMessageBroker开启使用STOMP协议来传输基于代理（message broker）的消息，
 * 此时浏览器支持使用@MessageMapping
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //设置服务器广播消息的前缀路径；（表示服务端向客户端广播消息，可以用topic这个路径）
        //客户端订阅广播公告stomClient.subscribe('/topic/topic-all',function(){})时的路径
        registry.enableSimpleBroker("/topic");
        //设置客户端订阅消息的基础路径（可不设置)；（表示客户端向服务端发消息，要用app作为前缀）
        //客户端发送消息使用stompClient.send("/app/to-all",{},JSON.stringify(wm));
        registry.setApplicationDestinationPrefixes("/app");
        //点对点使用的订阅前缀（客户端订阅路径体现），不设置的话，默认是/user/；（表示服务端向客户端发消息，指定用户一对一发送消息时的前缀）
        //服务端可使用@SendToUser("/topic/to-one")向用户发送消息，客户端用stompClient.subscribe('/user/topic/to-one',function(msg){})订阅
        registry.setUserDestinationPrefix("/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //处理跨域问题
        //客户端在new SockJS('http://127.0.0.1:8188/ws')时设置的路径
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
    }

    @Bean
    public SocketSessionRegistry SocketSessionRegistry(){
        return new SocketSessionRegistry();
    }

    @Bean
    public STOMPConnectEventListener STOMPConnectEventListener(){
        return new STOMPConnectEventListener();
    }

    /*
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        //添加拦截器，处理客户端发来的请求
//        registration.interceptors(new WebSocketHandleInterceptor());

    }
    */
}
