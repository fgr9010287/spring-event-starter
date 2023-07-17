package cn.mashang.event.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.function.Supplier;

@Data
@SuperBuilder
public class BaseEventModel<T> {
    private String topic;

    private String source;

    private String type;

    private Supplier<T> supplier;
}
