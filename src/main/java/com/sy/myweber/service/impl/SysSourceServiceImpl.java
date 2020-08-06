package com.sy.myweber.service.impl;

import com.sy.myweber.entity.SysSource;
import com.sy.myweber.dao.SysSourceDao;
import com.sy.myweber.service.SysSourceService;
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
public class SysSourceServiceImpl extends ServiceImpl<SysSourceDao, SysSource> implements SysSourceService {

    @Override
    public List<SysSource> getMenusByUserId(Integer id) {
        return (List<SysSource>) baseMapper.selectById(id);
    }
}
