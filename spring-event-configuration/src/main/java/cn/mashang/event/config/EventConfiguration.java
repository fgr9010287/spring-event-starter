package cn.mashang.event.config;

import cn.mashang.event.factory.VEventListenerFactory;
import cn.mashang.event.publish.VEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

@Configuration
public class EventConfiguration {

    @Bean("applicationEventMulticaster")
    public SimpleApplicationEventMulticaster simpleApplicationEventMulticaster(){
        return new VEventPublisher();
    }

    @Bean
    public VEventListenerFactory eventListenerFactory(){
        return new VEventListenerFactory();
    }
}
