package cn.lai.myspringboot.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 反正目前加入这几个注解才能正常使用mockmvc。。。
 * 有点东西
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ExceptionTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 有点类似断言的感觉
     * @throws Exception
     */
    @Test
    public void should_return_400_if_param_not_valid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/exception/illegalArgumentException"))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("参数错误!"));
    }

    @Test
    public void should_return_404_if_resourse_not_found() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/exception/resourceNotFoundException"))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Sorry, the resourse not found!"));
    }
}
