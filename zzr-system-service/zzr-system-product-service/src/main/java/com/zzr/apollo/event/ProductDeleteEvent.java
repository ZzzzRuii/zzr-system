package com.zzr.apollo.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.HashMap;

/**
 * 产品消息发布类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/9 17:56
 */
@Getter
public class ProductDeleteEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private HashMap<String, String> productDO;

    public ProductDeleteEvent(Object source, HashMap<String, String> productDO) {
        super(source);
        this.productDO = productDO;
    }
}
