package com.zzr.base.support;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Page
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 14:35
 */
@Data
public class Page<T> implements Serializable {
    private static final Long serialVersionUID = 1L;
    private List<T> records = Collections.emptyList();
    private Long current = 1L;
    private Long size = 10L;
    private Long total = 0L;

    public static <T> Page<T> of(List<T> records, Long current, Long size, Long total) {
        Page<T> page = new Page();
        page.setRecords(records);
        page.setCurrent(current);
        page.setSize(size);
        page.setTotal(total);
        return page;
    }
}
