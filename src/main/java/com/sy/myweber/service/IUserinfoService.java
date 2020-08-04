package com.sy.myweber.service;

import com.sy.myweber.model.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.catalina.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suger
 * @since 2020-08-04
 */
public interface IUserinfoService extends IService<Userinfo> {
    public Userinfo selectById(String id);
    Userinfo Sel(String id);
}
