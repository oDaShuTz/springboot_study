package org.springboot_study.mybatis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    public void mybatisTest() throws Exception {

        User user = new User();
        user.setId(1);
        user.setName("O大叔Tz");

        userMapper.insert(user);
        user = userMapper.find(1);
        Assert.assertEquals("O大叔Tz", user.getName());

        user.setName("大叔");
        userMapper.update(user);
        user = userMapper.find(1);
        Assert.assertEquals("大叔", user.getName());

        userMapper.delete(1);
        user = userMapper.find(1);
        Assert.assertEquals(null, user);
    }

}
