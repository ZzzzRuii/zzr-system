package com.zzr.apollo.service.impl;

import com.zzr.apollo.mapper.XxMapper;
import com.zzr.apollo.model.XxDO;
import com.zzr.apollo.service.IXxService;
import com.zzr.base.service.impl.ZzrServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * XxServiceImpl
 *
 * @author ZhouZhiRui
 * @since 2022/11/28 13:28
 */
@Service
@RequiredArgsConstructor
public class XxServiceImpl extends ZzrServiceImpl<XxMapper, XxDO> implements IXxService {
}
