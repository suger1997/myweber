package com.sy.myweber.service.impl;

import com.sy.myweber.model.Userinfo;
import com.sy.myweber.mapper.UserinfoMapper;
import com.sy.myweber.service.IUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author suger
 * @since 2020-08-04
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public Userinfo selectById(String id) {
        Userinfo userinfo = baseMapper.selectById(id);
        return userinfo;
    }

    @Override
    public Userinfo Sel(String id) {
        return userinfoMapper.Sel(id);
    }


}
