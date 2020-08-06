package com.sy.myweber.service;

import com.sy.myweber.entity.SysSource;
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
public interface SysSourceService extends IService<SysSource> {

    List<SysSource> getMenusByUserId(Integer id);
}
