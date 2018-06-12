package org.lhyf.demo.utils;

import org.springframework.stereotype.Component;


/****
 * @author yangfan
 * @date 2018-06-12 09:35
 * @desc Commons
 *
 **/
@Component
public class Commons {


    public static String random(int max, String str) {
        return UUID.random(1, max) + str;
    }
}
