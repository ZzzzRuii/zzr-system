package com.zzr.apollo;

import com.alibaba.fastjson.JSON;
import com.zzr.apollo.constants.UnitTypeEnum;
import com.zzr.apollo.unit.dto.CreateSystemUnitChainInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ZzrSystemStartApplicationTests {

    @Test
    void contextLoads() {
        CreateSystemUnitChainInfoDTO dto = new CreateSystemUnitChainInfoDTO();
        dto.setTenantId("integ");
        dto.setCode("HZJD");
        dto.setParentId(0L);
        dto.setName("杭州景点");
        dto.setType(UnitTypeEnum.TENANT.getName());
        dto.setContacts("zzr");
        dto.setTelephone("15333333333");
        dto.setCountry("中国");
        dto.setCity("杭州");
        dto.setDistrict(" ");
        dto.setProvince("浙江");
        dto.setSort(1);
        dto.setAddress(" ");
        dto.setLocation(" ");

        log.info(JSON.toJSONString(dto));
    }

}
