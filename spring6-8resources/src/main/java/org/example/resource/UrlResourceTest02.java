package org.example.resource;


import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取类文件路径下的资源
 * target->classes 目录下
 */
public class UrlResourceTest02 {

    public static void main(String[] args) {
        loadClassPathResources("spring6Study.txt");
    }

    /**
     * 加载类文件下的资源
     */
    public static void loadClassPathResources(String path){
        ClassPathResource classPathResource = new ClassPathResource(path);
        System.out.println("文件名："+classPathResource.getFilename());
        System.out.println("文件描述："+classPathResource.getDescription());

        // 读取文件内容
        try {
            InputStream inputStream = classPathResource.getInputStream();
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes)!=-1){
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
