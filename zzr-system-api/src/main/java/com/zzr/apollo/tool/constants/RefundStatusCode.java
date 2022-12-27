package com.zzr.apollo.tool.constants;

/**
 * 退款状态值
 *
 * @author ZhouZhiRui , zzr@foxhis.com
 * @since 2022/9/9 13:23
 */
public class RefundStatusCode {
    /**
     * R 待审核
     */
    public static final String AUDIT = "R";
    /**
     * A 已审核
     */
    public static final String AUDITED = "A";
    /**
     * RJ 已拒绝
     */
    public static final String REFUSED = "RJ";
    /**
     * X 已取消
     */
    public static final String CANCELED = "X";
    /**
     * RE 已退款中
     */
    public static final String REFUNDING = "RE";
    /**
     * RC 已确认
     */
    public static final String CONFIRMING = "RC";
    /**
     * DI 执行中
     */
    public static final String DOING = "DI";
    /**
     * CO 已完成
     */
    public static final String COMPLETE = "CO";
}
