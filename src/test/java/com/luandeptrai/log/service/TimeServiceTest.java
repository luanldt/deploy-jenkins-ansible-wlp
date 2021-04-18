package com.luandeptrai.log.service;

import com.luandeptrai.log.service.impl.TimeServiceImpl;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
public class TimeServiceTest {

    @Autowired
    private TimeService timeService;

    @TestConfiguration
    static class TimeServiceImplTestConfiguration {
        @Bean
        public TimeService timeService() {
            return new TimeServiceImpl() {
                // implement methods
            };
        }
    }

    @Test
    public void inputCurrentDate_whenGetTimestamp_thenReturnTimestampOfDate()  throws Exception  {
        Date currentDate = new Date();
        String timestampExpected = new SimpleDateFormat("yyyyMMddHHmmss").format(currentDate);
        String timestamp = timeService.getTimestampFromDate(currentDate);
        Assert.assertThat(timestamp, Is.is(timestampExpected));
    }

    @Test
    public void inputNull_whenGetTimestamp_thenReturnTimestampOfCurrentDate()  throws Exception  {
        String timestamp = timeService.getTimestampFromDate(null);
        Assert.assertThat(timestamp, IsNull.notNullValue());
    }
}
