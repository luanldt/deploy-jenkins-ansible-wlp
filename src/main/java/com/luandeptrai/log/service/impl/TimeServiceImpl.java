package com.luandeptrai.log.service.impl;

import com.luandeptrai.log.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeServiceImpl implements TimeService {

    public final Logger logger = LoggerFactory.getLogger(TimeServiceImpl.class);

    @Override
    public String getTimestampFromDate(Date date) {
        logger.debug("Begin process...");
        Date dateToFormat = date;
        if (date == null) {
            logger.debug("Date input is null...");
            dateToFormat = new Date();
            logger.debug("Get current date...");
        }
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(dateToFormat);
        logger.debug("End process...");
        return timestamp;
    }
}
