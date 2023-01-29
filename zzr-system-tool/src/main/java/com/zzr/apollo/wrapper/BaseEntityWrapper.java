package com.zzr.apollo.wrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzr.apollo.support.Page;

import java.util.List;
import java.util.stream.Collectors;

/**
 * BaseEntityWrapper
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 14:26
 */
public abstract class BaseEntityWrapper<E, V> {
    /**
     * DO -> VO
     *
     * @param entity
     * @return
     */
    public abstract V entityVO(E entity);

    /**
     * VO -> DO
     *
     * @param entity
     * @return
     */
    public abstract E voEntity(V entity);

    /**
     * 列表 DO -> VO
     *
     * @param list
     * @return
     */
    public List<V> listVO(List<E> list) {
        return list.stream().map(this::entityVO).collect(Collectors.toList());
    }

    /**
     * 列表 VO -> DO
     *
     * @param list
     * @return
     */
    public List<E> listEntity(List<V> list) {
        return list.stream().map(this::voEntity).collect(Collectors.toList());
    }

    /**
     * 分页 DO -> VO
     *
     * @param pages
     * @return
     */
    public Page<V> pageVO(IPage<E> pages) {
        List<V> records = this.listVO(pages.getRecords());
        return Page.of(records, pages.getCurrent(), pages.getSize(), pages.getTotal());
    }
}
