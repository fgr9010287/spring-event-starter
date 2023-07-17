package cn.mashang.event.publish;

import cn.mashang.event.listener.VApplicationListenerMethodAdapter;
import cn.mashang.event.model.BaseEvent;
import cn.mashang.event.model.BaseEventModel;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

import java.util.Iterator;
import java.util.concurrent.Executor;

public class VEventPublisher extends SimpleApplicationEventMulticaster {

    @Override
    public void multicastEvent(ApplicationEvent event, @Nullable ResolvableType eventType) {
        ResolvableType type = eventType != null ? eventType : this.resolveDefaultEventType(event);
        Executor executor = this.getTaskExecutor();
        Iterator var5 = this.getApplicationListeners(event, type).iterator();
        String topic = null;
        if(event instanceof PayloadApplicationEvent) {
            Object payload = ((PayloadApplicationEvent<?>) event).getPayload();
            if(payload instanceof BaseEventModel) {
                topic = ((BaseEventModel) payload).getTopic();
            }
        } else if(event instanceof BaseEvent){
            topic = ((BaseEvent) event).getTopic();
        }

        while(var5.hasNext()) {
            ApplicationListener<?> listener = (ApplicationListener)var5.next();
            if(listener instanceof VApplicationListenerMethodAdapter) {
                String anTopic = ((VApplicationListenerMethodAdapter) listener).getTopic();

                if(!anTopic.equalsIgnoreCase(topic)) {
                    continue;
                }
            }
            if (executor != null) {
                executor.execute(() -> {
                    this.invokeListener(listener, event);
                });
            } else {
                this.invokeListener(listener, event);
            }
        }
    }

    private ResolvableType resolveDefaultEventType(ApplicationEvent event) {
        return ResolvableType.forInstance(event);
    }
}
