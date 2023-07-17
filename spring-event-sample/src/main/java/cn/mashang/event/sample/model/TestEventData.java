package cn.mashang.event.sample.model;

import cn.mashang.event.model.BaseEventModel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString
public class TestEventData extends BaseEventModel<String> {

    private String name;
}
