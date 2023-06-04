package org.zmy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo extends CommonField{
    private String account;//账户
    private String password;//密码
    private String salt;//盐值
    private String nickname;//昵称
    private Integer sex;//性别：为1时表示男性，为0时表示女性
    private Integer age;//年龄
}
