package com.luandeptrai.log.controller;

import com.luandeptrai.log.service.TimeService;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.NotNull;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@WebMvcTest(TestingController.class)
public class TestingControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TimeService timeService;

    @Before
    public void setup() {
        Date currentDate = new Date();
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(currentDate);
        Mockito.when(timeService.getTimestampFromDate(new Date()))
                .thenReturn(timestamp);
    }

    @Test
    public void whenCallIndex_thenReturnJson() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Is.is("OK")));
    }

    @Test
    public void whenCallTimestamp_thenReturnCurrentTimestamp()  throws Exception  {
        mvc.perform(MockMvcRequestBuilders.get("/timestamp").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Is.is("OK")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", IsNull.notNullValue()));
    }
}
