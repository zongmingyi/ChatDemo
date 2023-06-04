package org.zmy.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.zmy.entity.UserInfo;
import org.zmy.exception.AccountDuplicateException;
import org.zmy.exception.RegisterException;
import org.zmy.mapper.RegisterMapper;
import org.zmy.redis.UserInfoRedisKey;
import org.zmy.service.IRegisterService;
import org.zmy.util.MD5Util;
import org.zmy.web.codeMSG.RegisterCodeMsg;

import java.util.Date;
import java.util.UUID;

@Service
public class RegisterServiceImpl implements IRegisterService {
    @Autowired
    private RegisterMapper registerMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void registerUser(UserInfo userInfo) {
        String account  = userInfo.getAccount();
        String result = registerMapper.selectByAccount(account);
        if(result != null){
            throw new AccountDuplicateException(RegisterCodeMsg.DUPLICATE_REGISTER);
        }
        //加密密码
        String salt = UUID.randomUUID().toString();
        salt = salt.replaceAll("-","");
        String newPassword = MD5Util.encoder(userInfo.getPassword(),salt);
        userInfo.setSalt(salt);
        userInfo.setPassword(newPassword);
        userInfo.setCreateUser(String.valueOf(userInfo.getAccount()));
        userInfo.setCreateTime(new Date());
        userInfo.setModifyUser(String.valueOf(userInfo.getAccount()));
        userInfo.setModifyTime(new Date());
        Integer row = registerMapper.insertAccount(userInfo);
        if(row != 1){
            throw new RegisterException(RegisterCodeMsg.REGISTER_FAIL);
        }
        //将注册信息存到redis中 用字符串类型
        String key = UserInfoRedisKey.USER_INFO_REDIS_KEY.getRealKey(userInfo.getAccount());
        String value = null;
        try {
            value = new ObjectMapper().writeValueAsString(userInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        redisTemplate.opsForValue().set(key,value);
    }
}
