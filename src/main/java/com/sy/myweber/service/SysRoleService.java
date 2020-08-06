package com.sy.myweber.service;

import com.sy.myweber.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author supersuger
 * @since 2020-08-06
 */
public interface SysRoleService extends IService<SysRole> {

    List<SysRole> getRolesByUserId(Integer id);
}
