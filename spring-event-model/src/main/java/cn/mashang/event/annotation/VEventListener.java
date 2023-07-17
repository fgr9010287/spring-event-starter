package cn.mashang.event.annotation;


import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Indexed
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@EventListener
//@TransactionEventListener
public @interface VEventListener {

    String topic();

    @AliasFor(annotation = EventListener.class, value = "condition")
    String condition() default "";
}
