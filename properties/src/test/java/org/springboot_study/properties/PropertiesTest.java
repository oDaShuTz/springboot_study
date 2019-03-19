package org.springboot_study.properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.SessionAttributes;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Autowired
    private Properties properties;

    @Test
    public void getTitle() {
        Assert.assertEquals(properties.getName(), "O大叔Tz");
    }
}