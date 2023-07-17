package cn.mashang.event.listener;

import cn.mashang.event.annotation.VEventListener;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.event.ApplicationListenerMethodAdapter;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class VApplicationListenerMethodAdapter extends ApplicationListenerMethodAdapter {

    private final Method method;
    private final Method targetMethod;
    private String topic;

    public VApplicationListenerMethodAdapter(String beanName, Class<?> targetClass, Method method) {
        super(beanName, targetClass, method);
        this.method = BridgeMethodResolver.findBridgedMethod(method);
        this.targetMethod = !Proxy.isProxyClass(targetClass) ? AopUtils.getMostSpecificMethod(method, targetClass) : this.method;
        VEventListener ann = AnnotatedElementUtils.findMergedAnnotation(this.targetMethod, VEventListener.class);
        this.topic = ann != null ? ann.topic() : null;
    }
    public String getTopic() {
        return topic;
    }
}
