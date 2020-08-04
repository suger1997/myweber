package com.sy.myweber.controller;


import com.sy.myweber.model.Userinfo;
import com.sy.myweber.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author suger
 * @since 2020-08-04
 */
@RestController
@RequestMapping("/userinfo")
public class UserinfoController {
    @Autowired
    private IUserinfoService iUserinfoService;


    @RequestMapping("/selectById")
    public Userinfo selectById(String id){
        return iUserinfoService.selectById(id);
    }


    @RequestMapping("/Sel")
    public Userinfo Sel(String id){

        System.out.println(id);
        return  iUserinfoService.Sel(id);
    }
}
