package com.zzr.apollo.mp.injector;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.zzr.apollo.mp.injector.method.ChangeStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * sql注入器
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/29 14:04
 */
public class AppSqlInjector extends DefaultSqlInjector {
    public AppSqlInjector() {
    }

    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = new ArrayList<>();
        methodList.add(new ChangeStatus());
        methodList.add(new AlwaysUpdateSomeColumnById(i -> i.getFieldFill() == FieldFill.UPDATE));
        methodList.addAll(super.getMethodList(mapperClass, tableInfo));
        return Collections.unmodifiableList(methodList);
    }
}
