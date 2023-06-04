package org.zmy.codeMSG;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CodeMSG implements Serializable {

    private Integer code;//返回代码
    private String msg;//返回消息

}
