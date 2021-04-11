package com.ticketservice.scenic.application.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @CreateTime 2020-12-17
 * @Author wonzeng
 */
public class CommonTool {
    public CommonTool() {
    }

    public static void main(String[] args) {
        long xx = createIdByDateTime();
        System.out.println("args = " + xx );
    }
    public synchronized static Long createIdByDateTime() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime curDay = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String ss = LocalDateTime.now().format(formatter);
        return Long.parseLong(ss);
    }
}
