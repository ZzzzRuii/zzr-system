package com.zzr.base.mp.injector;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.zzr.base.mp.injector.method.ChangeStatus;

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

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        methodList.add(new ChangeStatus());
        methodList.add(new AlwaysUpdateSomeColumnById(i -> i.getFieldFill() == FieldFill.UPDATE));
        return Collections.unmodifiableList(methodList);
    }
}
