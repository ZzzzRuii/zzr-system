package com.zzr.base.constants;

/**
 * FeignConstant
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/2/6 18:03
 */
public interface FeignConstants {
    String API_PREFIX = "/client";

    String CHANNEL = API_PREFIX + "/channel";
    String CHANNEL_PRODUCT_DAILY_AMOUNT = API_PREFIX + "/daily/amount";
    String CHANNEL_PRODUCT_DAILY_RATE = API_PREFIX + "/daily/rate";

    String PRODUCT_TICKET = API_PREFIX + "/product";

    String SYSTEM_UNIT_CHAIN_INFO = API_PREFIX + "/unit";

    String MASTER = API_PREFIX + "/master";
    String MASTER_ITEM = API_PREFIX + "/item";
    String MASTER_CANCEL_RULE = API_PREFIX + "/cancel";
    String MASTER_DEPOSIT_RULE = API_PREFIX + "/deposit";
    String MASTER_FACADE = API_PREFIX + "/facade";
    String MASTER_PAY = API_PREFIX + "/pay";
    String MASTER_VOUCHER = API_PREFIX + "/voucher";
    String MASTER_REFUND = API_PREFIX + "/refund";
    String MASTER_REFUND_ITEM = API_PREFIX + "/refund/item";
}
