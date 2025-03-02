package com.vivy.mapper;

import com.vivy.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    User selectUser( @Param("userId")String userId, @Param("password") String password);

}
