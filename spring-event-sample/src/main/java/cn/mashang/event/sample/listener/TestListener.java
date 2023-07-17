package cn.mashang.event.sample.listener;

import cn.mashang.event.annotation.VEventListener;
import cn.mashang.event.sample.model.TestEvent;
import cn.mashang.event.sample.model.TestEventData;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    @VEventListener(topic = "test")
    public void testEventData(TestEventData eventData){
        System.out.println(eventData);
        eventData.setSupplier(()-> "test事件数据成功回调");
    }

    @VEventListener(topic = "other")
    public void testEventDataOther(TestEventData eventData){
        System.out.println(eventData);
        eventData.setSupplier(()-> "other事件数据成功回调");
    }

    @VEventListener(topic = "test")
    public void testEvent(TestEvent event){
        System.out.println(event.getName());
        event.setSupplier(()-> "test事件成功回调");
    }

    @VEventListener(topic = "other")
    public void testEventOther(TestEvent event){
        System.out.println(event.getName());
        event.setSupplier(()-> "other事件成功回调");
    }
}
