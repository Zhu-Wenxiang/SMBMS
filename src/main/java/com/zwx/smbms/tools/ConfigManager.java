package com.zwx.smbms.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
        //执行I/O操作，读写database.properties里的内容，使用单例模式中的饿汉模式
        private static ConfigManager configManager=new ConfigManager();
        private static Properties properties;

        //建立私有化的构造函数。
        private ConfigManager(){
                String configFile="database.properties";
                properties=new Properties();
                InputStream inputStream=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
                try {
                        properties.load(inputStream);
                        inputStream.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        //外部获得ConfigManager对象
        public static ConfigManager getInstance(){
                return configManager;
        }

        //得到properties中key对应value值的方法
        public String getValue(String key){
                return properties.getProperty(key);
        }

        //懒汉模式下对应的成员变量
        private static ConfigManager configManager2;

        //懒汉模式下的getInstance方法,由于懒汉模式线程不安全，故需要加线程锁
        public static synchronized ConfigManager getInstanceInLazyMode(){
                if (configManager2==null){
                        configManager2=new ConfigManager();
                }
                return configManager2;

        }

        //使用双重校验锁保证线程安全的的方法，
        public static ConfigManager getInstanceBydoubleSynchronized(){
                if (configManager2==null){
                        synchronized (ConfigManager.class){
                                if (configManager2==null){
                                        configManager2=new ConfigManager();
                                }
                        }
                }
                return configManager2;
        }

        //在饿汉模式下保证lazy loading特性的方法

        //使用静态内部类来获取configManager
        private static class ConfigManagerHelper{
                private static final ConfigManager INSTANCE=new ConfigManager();
        }
        private static ConfigManager getInstanceHungryLazyLoading(){
                return ConfigManagerHelper.INSTANCE;
        }

}
