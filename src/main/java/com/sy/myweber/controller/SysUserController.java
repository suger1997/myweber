package com.sy.myweber.controller;


import com.sy.myweber.entity.SysUser;
import com.sy.myweber.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
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
    public SysUser selectById(String id){
        return sysUserService.selectById(id);
    }
    @RequestMapping("/selectByUser")
    public SysUser selectByUser(SysUser sysUser){
        return sysUserService.selectByUser(sysUser);
    }

}

