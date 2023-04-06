package com.zzr.apollo.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.HashMap;

/**
 * 产品消息发布类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/9 17:55
 */
@Getter
public class ProductCreateEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private final HashMap<String, String> productDO;

    public ProductCreateEvent(Object source, HashMap<String, String> productDO) {
        super(source);
        this.productDO = productDO;
    }
}