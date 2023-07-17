package cn.mashang.event.model;

import org.springframework.context.ApplicationEvent;

import java.util.function.Supplier;
public class BaseEvent<T> extends ApplicationEvent {

    private String topic;

    private Supplier<T> supplier;

    public BaseEvent(Object source, String topic) {
        super(source);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Supplier<T> getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier<T> supplier) {
        this.supplier = supplier;
    }
}
