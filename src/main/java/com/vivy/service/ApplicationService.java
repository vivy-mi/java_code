package com.vivy.service;

import com.vivy.mapper.ApplicationMapper;
import com.vivy.pojo.Application;
import com.vivy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ApplicationService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void add(Application application){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ApplicationMapper applicationMapper = sqlSession.getMapper(ApplicationMapper.class);

        applicationMapper.add(application);

        sqlSession.commit();
        sqlSession.close();
    }

    public  List<Application> selectAll(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ApplicationMapper applicationMapper = sqlSession.getMapper(ApplicationMapper.class);

        List<Application> applications = applicationMapper.selectAll();

        sqlSession.close();
        return applications;
    }

    public List<Application> selectByUser(String name,String department){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ApplicationMapper applicationMapper = sqlSession.getMapper(ApplicationMapper.class);

        List<Application> applications = applicationMapper.selectByUser(name, department);

        sqlSession.close();
        return applications;
    }

    public List<Application> selectByPosition(String department,String position){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ApplicationMapper applicationMapper = sqlSession.getMapper(ApplicationMapper.class);

        List<Application> applications = applicationMapper.selectByPosition(department, position);

        sqlSession.close();
        return applications;
    }

    public Application selectById(int id){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ApplicationMapper applicationMapper = sqlSession.getMapper(ApplicationMapper.class);

        Application application = applicationMapper.selectById(id);

        sqlSession.close();
        return application;
    }

    public void update(Application application){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ApplicationMapper applicationMapper = sqlSession.getMapper(ApplicationMapper.class);

        applicationMapper.update(application);


        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(int id){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ApplicationMapper applicationMapper = sqlSession.getMapper(ApplicationMapper.class);

        applicationMapper.delete(id);

        sqlSession.commit();
        sqlSession.close();
    }

}
