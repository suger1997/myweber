package com.sy.myweber.service;

import com.sy.myweber.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author supersuger
 * @since 2020-08-05
 */
public interface SysUserService extends IService<SysUser> {
    SysUser selectById(String id);
    SysUser selectByUser(SysUser sysUser);
    void updatestatus(SysUser sysUser);

    SysUser getUserByUsername(String username);
}
