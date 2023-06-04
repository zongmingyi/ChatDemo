package org.zmy.redis;

import java.util.concurrent.TimeUnit;

public enum CommonRedisKey {

    USER_TOKEN("USER_TOKEN",TimeUnit.DAYS,7);
    CommonRedisKey(String prefix,TimeUnit unit,int expireTime){
        this.prefix = prefix;
        this.unit = unit;
        this.expireTime = expireTime;
    }
    CommonRedisKey(String prefix){
        this.prefix = prefix;
    }
    public String getRealKey(String key){
        return this.prefix + key;
    }
    private String prefix;//键的前置信息
    private TimeUnit unit;//时间单位
    private int expireTime;//持续时间

}
