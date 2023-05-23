package org.example.resource;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * 访问当前系统指定目录的资源
 */
public class UrlResourceTest03 {

    public static void main(String[] args) {
        loadAndReadUrlResource("D:\\dddd.txt");
    }

    /**
     * 访问当前系统指定目录的资源
     */
    public static void loadAndReadUrlResource(String path){
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        System.out.println("文件名："+fileSystemResource.getFilename());
        System.out.println("文件描述："+fileSystemResource.getDescription());

        // 读取文件内容
        try {
            InputStream inputStream = fileSystemResource.getInputStream();
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes)!=-1){
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
