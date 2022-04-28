package com.roger.mybatis;

import com.github.pagehelper.PageHelper;
import com.roger.mybatis.bean.User;
import com.roger.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DemoMain {

    private static final SqlSessionFactory sqlSessionFactory;

    static {
        //读取MyBatis的核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    }

    public int insertUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.insertUser();
    }

    public User selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.getById(id);
    }

    public List<User> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.getAll();
    }

    public List<User> pageSelect(int pageNum, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(pageNum, pageSize);
        return mapper.getAll();
    }

}
