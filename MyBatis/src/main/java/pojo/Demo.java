package pojo;

import Mapper.UserMapper;


import org.apache.ibatis.session.SqlSession;

import util.SqlSessionUtil;

import java.io.IOException;

import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectAll();
        for (User user: userList){
            System.out.println(user);
        }
        sqlSession.close();


    }
}
