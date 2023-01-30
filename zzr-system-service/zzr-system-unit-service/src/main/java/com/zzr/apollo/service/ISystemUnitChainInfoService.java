package com.zzr.apollo.service;

import com.zzr.apollo.model.SystemUnitChainInfoDO;
import com.zzr.apollo.unit.dto.CreateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.QuerySystemUnitChainInfoDTO;
import com.zzr.apollo.unit.dto.UpdateSystemUnitChainInfoDTO;
import com.zzr.apollo.unit.vo.SystemUnitChainInfoVO;
import com.zzr.base.service.IZzrService;

import java.util.List;

/**
 * 组织架构 服务类
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/29 15:47
 */
public interface ISystemUnitChainInfoService extends IZzrService<SystemUnitChainInfoDO> {

    /**
     * 根据主键 查询详情
     *
     * @param id
     * @return
     */
    SystemUnitChainInfoDO detail(Long id);

    /**
     * 根据参数 查询数据
     * 树状
     *
     * @param unitChainInfoDTO
     * @return
     */
    List<SystemUnitChainInfoVO> selectTree(QuerySystemUnitChainInfoDTO unitChainInfoDTO);

    /**
     * 插入数据
     * 新检查数据是否传 ，存在返回ServiceException 异常
     * vo 对象检查必填是否有数据
     *
     * @param unitChainInfoDTO
     * @return
     */
    SystemUnitChainInfoDO create(CreateSystemUnitChainInfoDTO unitChainInfoDTO);

    /**
     * 根据主键 更新数据
     * 查询不到数据 ServiceException 异常
     *
     * @param unitChainInfoDTO
     * @param id
     * @return
     */
    Boolean update(UpdateSystemUnitChainInfoDTO unitChainInfoDTO, Long id);


    /**
     * 根据主键 删除数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean deleteById(Long id);

    /**
     * 根据主键 起草数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean draft(Long id);

    /**
     * 根据主键 存档数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean archived(Long id);

    /**
     * 根据主键 发布数据
     * 查询不到数据 ServiceException 异常
     *
     * @param id
     * @return
     */
    Boolean published(Long id);
}
