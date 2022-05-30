package com.biu;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.biu.dao.Userdao;
import com.biu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisplusQuickstartApplicationTests {

    @Autowired
    private Userdao userdao;

    @Test
    void testSave(){
        User user=new User();
        user.setName("彪");
        user.setAge(18);
        user.setTel("13539024533");
        user.setPassword("123");
        userdao.insert(user);
    }

    @Test
    void testDelete(){
        userdao.deleteById(1530817241958928385L);
    }

    @Test
    void testUpdate(){
        User user=new User();
        user.setName("66688");
        user.setId(1L);


        userdao.updateById(user);
    }




    @Test
    void testGetAll() {
//        User user=new User();
//        user.setAge(30);
//        LambdaQueryWrapper<User> wrapper= new LambdaQueryWrapper<User>();
//        wrapper.lt(null!=user.getAge(),User::getAge,user.getAge());
//        List<User> users = userdao.selectList(wrapper);
//        System.out.println(users);

        QueryWrapper<User> wrapper= new QueryWrapper<User>();
        List<Map<String, Object>> users = userdao.selectMaps(wrapper);
        System.out.println(users);
    }

}
