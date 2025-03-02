package com.vivy.mapper;

import com.vivy.pojo.Application;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicationMapper {

    void add(Application application);

    List<Application> selectAll();

    List<Application> selectByUser(@Param("name") String name, @Param("department") String department);

    List<Application> selectByPosition(@Param("department") String department,@Param("position") String position);

    Application selectById(int id);

    int update(Application application);

    void delete(int id);
}
