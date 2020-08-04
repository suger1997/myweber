package com.sy.myweber.mapper;

import com.sy.myweber.model.Userinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author suger
 * @since 2020-08-04
 */
@Repository
public interface UserinfoMapper extends BaseMapper<Userinfo> {
    Userinfo Sel(String id);
}
