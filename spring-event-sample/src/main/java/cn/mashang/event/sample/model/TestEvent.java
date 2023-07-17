package cn.mashang.event.sample.model;

import cn.mashang.event.model.BaseEvent;

public class TestEvent extends BaseEvent<String> {

    private String name;

    public TestEvent(Object source, String topic) {
        super(source, topic);
    }

    public TestEvent(Object source, String topic, String name) {
        super(source, topic);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
