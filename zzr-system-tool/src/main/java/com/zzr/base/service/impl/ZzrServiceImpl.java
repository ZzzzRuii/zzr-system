package com.zzr.base.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.zzr.base.mapper.ZzrMapper;
import com.zzr.base.model.entity.BaseDO;
import com.zzr.base.mp.injector.AppSqlMethod;
import com.zzr.base.service.IZzrService;
import jakarta.validation.constraints.NotEmpty;
import org.apache.ibatis.binding.MapperMethod;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * ZzrServiceImpl
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 14:49
 */
@Validated
public class ZzrServiceImpl<M extends ZzrMapper<T>, T extends BaseDO> extends ServiceImpl<M, T> implements IZzrService<T> {

    protected void beforeSave(T entity) {
    }

    public boolean save(T entity) {
        this.beforeSave(entity);
        this.resolveEntity(entity);
        boolean result = super.save(entity);
        return this.afterSave(entity, result);
    }

    protected boolean afterSave(T entity, boolean result) {
        return result;
    }

    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::resolveEntity);
        return super.saveBatch(entityList, batchSize);
    }

    public boolean updateById(T entity) {
        this.resolveUpdateEntity(entity);
        return super.updateById(entity);
    }

    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::resolveUpdateEntity);
        return super.updateBatchById(entityList, batchSize);
    }

    public boolean saveOrUpdate(T entity) {
        return entity.getId() == null ? this.save(entity) : this.updateById(entity);
    }

    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::resolveEntity);
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    public boolean removeByEntity(T entity) {
        if (!ObjectUtil.isNull(entity) && !ObjectUtil.isEmpty(entity.getId())) {
            int count = this.baseMapper.deleteById(entity.getId());
            return 1 == count;
        } else {
            this.log.error("参数无效");
            throw new IllegalArgumentException("参数无效");
        }
    }

    public boolean removeById(Serializable id) {
        T entity = this.baseMapper.selectById(id);
        return this.removeByEntity(entity);
    }
    
    public boolean changeStatus(T entity) {
        List<T> list = Arrays.asList(entity);
        return this.batchChangeStatus(list, AppSqlMethod.CHANGE_STATUS);
    }

    @Transactional(rollbackFor = {Exception.class})
    public boolean changeStatus(@NotEmpty List<Long> ids, String status) {
        List<T> list = new ArrayList();
        ids.forEach((id) -> {
            T entity = BeanUtils.instantiateClass(this.currentModelClass());

            entity.setUpdateTime(DateUtil.date());
            entity.setId(id);
            entity.setStatus(status);
            list.add(entity);
        });
        return super.updateBatchById(list);
    }

    private void resolveEntity(T entity) {
        entity.setStatus("I");
        entity.setDeleted(false);
        entity.setCreateTime(DateUtil.date());
        entity.setCreateUser(entity.getCreateUser());
    }

    private void resolveUpdateEntity(T entity) {
        entity.setUpdateUser(entity.getUpdateUser());
        entity.setUpdateTime(DateUtil.date());
    }

    private boolean batchChangeStatus(Collection<T> entityList, AppSqlMethod method) {
        String sqlStatement = this.appSqlStatement(method);
        this.executeBatch(entityList, 1000, (sqlSession, entity) -> {
            MapperMethod.ParamMap<T> param = new MapperMethod.ParamMap();
            entity.setUpdateTime(DateUtil.date());

            param.put("et", entity);
            sqlSession.update(sqlStatement, param);
        });
        return true;
    }

    protected String appSqlStatement(AppSqlMethod sqlMethod) {
        return SqlHelper.table(this.currentModelClass()).getSqlStatement(sqlMethod.getMethod());
    }
}
