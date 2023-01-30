package com.zzr.base.support;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * Condition
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 16:25
 */
@Data
public class Condition {
    public static <T> IPage<T> getPage(Query query) {
        return getPage(query, 10);
    }

    public static <T> IPage<T> getPage(Query query, Integer defaultSize) {
        Page<T> page = new Page(defaultParam(query.getCurrent(), 1), defaultParam(query.getSize(), defaultSize));
        String[] ascArr = StrUtil.splitToArray(query.getAsc(), ",");
        String[] descArr = ascArr;
        int var5 = ascArr.length;

        int var6;
        for (var6 = 0; var6 < var5; ++var6) {
            String asc = descArr[var6];
            page.addOrder(OrderItem.asc(asc));
        }

        descArr = StrUtil.splitToArray(query.getDesc(), ",");
        String[] var9 = descArr;
        var6 = descArr.length;

        for (int var10 = 0; var10 < var6; ++var10) {
            String desc = var9[var10];
            page.addOrder(OrderItem.desc(desc));
        }

        return page;
    }
    
    private static Long defaultParam(Integer param, Integer i) {
        if (param == null) {
            return NumberUtil.parseLong(i.toString());
        }
        return NumberUtil.parseLong(param.toString());
    }

    public static <T> QueryWrapper<T> getQueryWrapper(T entity) {
        return new QueryWrapper(entity);
    }
}
