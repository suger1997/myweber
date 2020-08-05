package com.sy.myweber.dao;

import com.sy.myweber.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author supersuger
 * @since 2020-08-05
 */
@Repository
public interface SysUserDao extends BaseMapper<SysUser> {
    SysUser selectByUser(SysUser sysUser);
}
