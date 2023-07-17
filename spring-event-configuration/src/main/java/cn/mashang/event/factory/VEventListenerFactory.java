package cn.mashang.event.factory;

import cn.mashang.event.listener.VApplicationListenerMethodAdapter;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListenerFactory;
import org.springframework.core.Ordered;

import java.lang.reflect.Method;

public class VEventListenerFactory implements EventListenerFactory, Ordered {

    private int order = Integer.MAX_VALUE - 1;

    @Override
    public boolean supportsMethod(Method method) {
        return true;
    }

    @Override
    public ApplicationListener<?> createApplicationListener(String beanName, Class<?> type, Method method) {
        return new VApplicationListenerMethodAdapter(beanName, type, method);
    }

    @Override
    public int getOrder() {
        return this.order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
}

