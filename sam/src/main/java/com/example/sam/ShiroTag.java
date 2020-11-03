package com.example.sam;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import java.net.Socket;

/**
 * ************************************
 * create by Intellij IDEA
 *
 * @author Francis.zz
 * @date 2018-06-29 09:42
 * @desc freemarker自定义标签方法
 * ************************************
 */
@Component
public class ShiroTag {
    /**
     * 是否拥有该权限
     *
     * @param permission  权限标识
     * @return
     */
    public boolean hasPermission(String permission) {
        Subject subject = SecurityUtils.getSubject();
        return subject != null && subject.isPermitted(permission);
    }

    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("localhost",8080);
    }
}
