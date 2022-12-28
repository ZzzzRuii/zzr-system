package com.zzr.base.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Holder
 *
 * @author ZhouZhiRui
 * @version 1.0
 * @since 2022/12/28 10:38
 */
public class Holder {
    public static final Random RANDOM = new Random();
    public static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public Holder() {
    }
}
