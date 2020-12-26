package com.icss.etc.zhaozichen.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @title:
 * @fileName: 读取配置文件
 * @description:
 * @copyright:
 * @company: 个人
 * @author: 原晋川
 * @date: 2020/12/26 10:12
 * @version: V1.0
 */
public class PropertiesUtil {

    private Properties properties;

    //构造私有
    private PropertiesUtil() {
        properties = new Properties();
        InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("login.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            System.out.println("未找到文件……");
            e.printStackTrace();
        }
    }

    //成员变量赋初值为空
    private volatile static PropertiesUtil propertiesUtil = null;

    //单例
    public static PropertiesUtil getInstance() {
        if (propertiesUtil == null) {
            synchronized (PropertiesUtil.class) {
                //二重检查
                if (propertiesUtil == null) {
                    propertiesUtil = new PropertiesUtil();
                }
            }
        }
        return propertiesUtil;
    }

    /**
     * 功能描述: 根据key取value
     * @param
     * @return
     * @auther 原晋川
     * @date 2020/12/26 10:25
     * @throws
     */
    public String getValue(String key){
       return properties.getProperty(key);
    }
}
