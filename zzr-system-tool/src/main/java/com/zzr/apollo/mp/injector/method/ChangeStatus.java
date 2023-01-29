package com.zzr.apollo.mp.injector.method;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
import com.zzr.apollo.mp.injector.AppSqlMethod;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * ChangeStatus
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/28 17:37
 */
public class ChangeStatus extends AbstractMethod {
    public ChangeStatus() {
        super(AppSqlMethod.CHANGE_STATUS.getMethod());
    }

    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        AppSqlMethod sqlMethod = AppSqlMethod.CHANGE_STATUS;
        String additional = this.optlockVersion(tableInfo) + tableInfo.getLogicDeleteSql(true, true);
        String sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), SqlScriptUtils.convertSet("<if test=\"et['status'] != null\">status=#{et.status},</if><if test=\"et['updateUser'] != null\">update_user=#{et.updateUser},</if>\n<if test=\"et['updateTime'] != null\">update_time=#{et.updateTime},</if>"), tableInfo.getKeyColumn(), "et." + tableInfo.getKeyProperty(), additional);
        SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, modelClass);
        return this.addUpdateMappedStatement(mapperClass, modelClass, sqlMethod.getMethod(), sqlSource);
    }
}
