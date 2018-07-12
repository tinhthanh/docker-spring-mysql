package com.pal.intern.config.websocket;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import com.pal.intern.config.security.websocket.ActiveUserService ;
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/queue", "/topic","/listen-change-res/change");
    config.setApplicationDestinationPrefixes("/app");
  }
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/chat", "/activeUsers").setAllowedOrigins("*").withSockJS();
  }
  @Override
  public void configureClientInboundChannel(ChannelRegistration channelRegistration) {
       channelRegistration.interceptors( securityFilter());
  }
  @Override
  public void configureClientOutboundChannel(ChannelRegistration channelRegistration) {
  }
  @Override
  public boolean configureMessageConverters(List<MessageConverter> converters) {
    return true;
  }
  @Bean
  public ActiveUserService activeUserService() {
    return new ActiveUserService();
  }
   @Bean 
    public  SecurityChannelInterceptor  securityFilter () {
    return new SecurityChannelInterceptor() ;
    }
}