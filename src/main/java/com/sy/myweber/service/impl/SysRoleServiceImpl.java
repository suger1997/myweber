package com.sy.myweber.service.impl;

import com.sy.myweber.entity.SysRole;
import com.sy.myweber.dao.SysRoleDao;
import com.sy.myweber.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author supersuger
 * @since 2020-08-06
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    @Override
    public List<SysRole> getRolesByUserId(Integer id) {
        return (List<SysRole>) baseMapper.selectById(id);
    }
}
