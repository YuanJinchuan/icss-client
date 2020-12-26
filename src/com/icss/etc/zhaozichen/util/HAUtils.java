package com.icss.etc.zhaozichen.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: Object转List
 * @fileName: ${fileName}
 * @description:
 * @copyright:
 * @company: 个人
 * @author: 原晋川
 * @date: 2020/12/26 13:40
 * @version: V1.0
 */
public class HAUtils {
    public static <T> List<T> objToList(Object obj, Class<T> cla) {
        List<T> list = new ArrayList<T>();
        if (obj instanceof ArrayList<?>) {
            for (Object o : (List<?>) obj) {
                list.add(cla.cast(o));
            }
            return list;
        }
        return null;
    }
}
