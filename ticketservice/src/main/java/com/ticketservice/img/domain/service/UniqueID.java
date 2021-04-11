package com.ticketservice.img.domain.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author WangZeng
 * @Date 2021-04-11 11:33
 */
public class UniqueID {

    private static long lastId = 0;
    private static Object locked = new Object();
    public UniqueID() {
    }

    public static long getId() {
        long currId = 0;
        //上锁
        synchronized (locked) {
            //年、月、日、时、分、秒、毫秒
            currId = Long.parseLong(new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()).toString()) * 100;
            if (lastId < currId) {
                lastId = currId;
            } else {
                lastId = lastId + 1;
                currId = lastId;
            }
            return currId;
        }
    }

}
