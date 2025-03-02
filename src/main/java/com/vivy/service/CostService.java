package com.vivy.service;

import com.vivy.mapper.ApplicationMapper;
import com.vivy.mapper.CostMapper;
import com.vivy.pojo.Application;
import com.vivy.pojo.Cost;
import com.vivy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CostService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void add(Cost cost){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CostMapper costmapper = sqlSession.getMapper(CostMapper.class);

        costmapper.add(cost);

        sqlSession.commit();
        sqlSession.close();
    }

    public List<Cost> selectByUser(String name,String department){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CostMapper costmapper = sqlSession.getMapper(CostMapper.class);

        List<Cost> costs = costmapper.selectByUser(name, department);


        sqlSession.close();
        return costs;
    }

    public Cost selectById(int id){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CostMapper costMapper = sqlSession.getMapper(CostMapper.class);

        Cost cost = costMapper.selectById(id);

        sqlSession.close();
        return cost;
    }

    public void update(Cost cost){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        CostMapper costMapper = sqlSession.getMapper(CostMapper.class);

        costMapper.update(cost);

        sqlSession.commit();
        sqlSession.close();
    }
}
