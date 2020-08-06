package com.sy.myweber.controller;


import com.sy.myweber.entity.SysUser;
import com.sy.myweber.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author supersuger
 * @since 2020-08-05
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @RequestMapping("/selectById")
    public SysUser selectById(String id) {
        return sysUserService.selectById(id);
    }

    @RequestMapping("/selectByUser")
    public Object selectByUser(SysUser sysUser) {

        Map<String, Object> result = new HashMap<>();
        try {
            //根据用户查询--无结果，抛异常
            SysUser checkUser = sysUserService.selectByUser(sysUser);
            //检验密码
            if (sysUser.getPwd().equals(checkUser.getPwd())) {
                result.put("sysUser", checkUser);
                result.put("code", 0);
            } else {
                if(checkUser.getErrTimes()>=1){
                    //密码错误 设置密码输入次数
                    int err = 5;
                    err = checkUser.getErrTimes() - 1;
                    checkUser.setErrTimes(err);
                    sysUserService.updatestatus(checkUser);
                    result.put("code", 1);
                    result.put("msg","密码错误，密码输入剩余"+err+"次，请重新输入！");
                }else {
                    result.put("code",3);
                    result.put("msg","账户被冻结！请联系管理员！");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 2);
            result.put("msg","查无此用户");
        }
        return result;
    }

}

