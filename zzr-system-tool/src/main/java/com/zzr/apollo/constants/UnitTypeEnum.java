package com.zzr.apollo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * UnitTypeEnum
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2023/1/29 15:05
 */
@Getter
@AllArgsConstructor
public enum UnitTypeEnum {
    /**
     * Tenant
     */
    TENANT("Tenant", 1),
    /**
     * Subsidiary
     */
    SUBSIDIARY("Subsidiary", 2),
    /**
     * Property
     */
    PROPERTY("Property", 3);

    final String name;
    final int category;
}
