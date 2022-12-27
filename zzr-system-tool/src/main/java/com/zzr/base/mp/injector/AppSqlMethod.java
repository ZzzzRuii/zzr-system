package com.zzr.base.mp.injector;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AppSqlMethod
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/27 16:34
 */
@Getter
@AllArgsConstructor
public enum AppSqlMethod {
    INSERT_IGNORE_ONE("insertIgnore", "插入一条数据（选择字段插入）", "<script>\nINSERT IGNORE INTO %s %s VALUES %s\n</script>"),
    REPLACE_ONE("replace", "插入一条数据（选择字段插入）", "<script>\nREPLACE INTO %s %s VALUES %s\n</script>"),
    CHANGE_STATUS("changeStatus", "批量修改状态", "<script>\nUPDATE %s %s WHERE  %s=#{%s} %s\n</script>");

    private final String method;
    private final String desc;
    private final String sql;
}
