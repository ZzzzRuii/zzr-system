package com.zzr.apollo.wrapper;

import com.zzr.apollo.model.XxDO;
import com.zzr.apollo.vo.XxVO;
import com.zzr.base.wrapper.BaseEntityWrapper;

/**
 * XxWrapper
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 13:34
 */
public class XxWrapper extends BaseEntityWrapper<XxDO, XxVO> {
    public static XxWrapper build() {
        return new XxWrapper();
    }

    /**
     * DO -> VO
     *
     * @param entity
     * @return
     */
    @Override
    public XxVO entityVO(XxDO entity) {
        return null;
    }

    /**
     * VO -> DO
     *
     * @param entity
     * @return
     */
    @Override
    public XxDO voEntity(XxVO entity) {
        return null;
    }
}
