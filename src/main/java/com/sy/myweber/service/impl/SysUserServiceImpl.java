package com.sy.myweber.service.impl;

import com.sy.myweber.entity.SysUser;
import com.sy.myweber.dao.SysUserDao;
import com.sy.myweber.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author supersuger
 * @since 2020-08-05
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
    @Autowired
    SysUserDao sysUserDao;

    @Override
    public SysUser selectById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public SysUser selectByUser(SysUser sysUser) {
        return sysUserDao.selectByUser(sysUser);
    }

    @Override
    public void updatestatus(SysUser sysUser) {
        sysUserDao.updatestatus(sysUser);
    }

    @Override
    public SysUser getUserByUsername(String username) {
        return null;
    }
}
