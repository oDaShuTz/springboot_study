package org.springboot_study.restful;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUserController() throws Exception {
        // 测试UserController
        RequestBuilder request = null;

        // 1、get查一下user列表，应该为空
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

        // 2、post提交一个user
        request = post("/users/")
                .param("id", "1")
                .param("name", "O大叔Tz");
        mockMvc.perform(request)
                .andExpect(content().string("success"));

        // 3、get获取user列表，应该有刚才插入的数据
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"O大叔Tz\"}]"));

        // 4、put修改id为1的user
        request = put("/users/1")
                .param("name", "大叔");
        mockMvc.perform(request)
                .andExpect(content().string("success"));

        // 5、get一个id为1的user
        request = get("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string("{\"id\":1,\"name\":\"大叔\"}"));

        // 6、del删除id为1的user
        request = delete("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string("success"));

        // 7、get查一下user列表，应该为空
        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

    }
}