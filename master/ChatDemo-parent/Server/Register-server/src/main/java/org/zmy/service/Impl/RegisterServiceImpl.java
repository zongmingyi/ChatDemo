package org.zmy.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zmy.entity.UserInfo;
import org.zmy.exception.AccountDuplicateException;
import org.zmy.mapper.RegisterMapper;
import org.zmy.service.IRegisterService;
import org.zmy.web.codeMSG.RegisterCodeMsg;

@Service
public class RegisterServiceImpl implements IRegisterService {
    @Autowired
    private RegisterMapper registerMapper;
    @Override
    public void registerUser(UserInfo userInfo) {
        String account  = userInfo.getAccount();
        String result = registerMapper.selectByAccount(account);
        if(result != null){
            throw new AccountDuplicateException(RegisterCodeMsg.DUPLICATE_REGISTER);
        }


    }
}
