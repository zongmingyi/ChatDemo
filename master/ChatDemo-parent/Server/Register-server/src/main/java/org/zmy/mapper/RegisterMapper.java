package org.zmy.mapper;


import org.springframework.stereotype.Repository;
import org.zmy.entity.UserInfo;

@Repository
public interface RegisterMapper {

    /**
     * 查寻账户
     * @param Account 账户
     * @return 查询到的账户
     */
    String selectByAccount(String Account);

    /**
     * 插入注册用户
     * @param userInfo 注册用户信息
     * @return 影响行数
     */
    Integer insertAccount(UserInfo userInfo);
}
