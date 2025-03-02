package com.vivy.mapper;

import com.vivy.pojo.Application;
import com.vivy.pojo.Cost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CostMapper {

    void add(Cost cost);

    List<Cost> selectByUser(@Param("name") String name, @Param("department") String department);

    Cost selectById(int id);

    int update(Cost cost);
}
