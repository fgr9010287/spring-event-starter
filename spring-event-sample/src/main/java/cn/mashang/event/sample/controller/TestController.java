package cn.mashang.event.sample.controller;


import cn.mashang.event.sample.model.TestEvent;
import cn.mashang.event.sample.model.TestEventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("/eventData/{topic}/{type}")
    public String testEventData(@PathVariable("topic") String topic, @PathVariable("type") String type){
        TestEventData eventData = TestEventData.builder().topic(topic)
                .type(type).name("test").source("controller").build();
        eventPublisher.publishEvent(eventData);
        return eventData.getSupplier().get();
    }

    @GetMapping("/event/{topic}/{name}")
    public String testEvent(@PathVariable("topic") String topic, @PathVariable("name") String name) {
        TestEvent event = new TestEvent(this, topic, name);
        eventPublisher.publishEvent(event);
        return event.getSupplier().get();
    }
}
