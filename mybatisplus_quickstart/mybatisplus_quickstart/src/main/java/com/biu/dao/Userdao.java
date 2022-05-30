package com.biu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.biu.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Userdao extends BaseMapper<User> {

}
