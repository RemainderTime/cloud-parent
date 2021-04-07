package com.xf.cloud.cloudsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xf.cloud.cloudsystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *   user Mapper类  继承BaseMapper
 * </p>
 *
 * @author xf
 * @date 2021-04-07
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
