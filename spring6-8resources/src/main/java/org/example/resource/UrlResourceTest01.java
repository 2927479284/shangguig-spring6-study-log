package org.example.resource;

import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * spring6资源
 * 1.访问网络资源
 * 2.访问文件资源
 */
public class UrlResourceTest01 {


    public static void main(String[] args) throws MalformedURLException {
        loadUrlResource("http://lwdblog.xyz/");
        loadUrlResource("file:spring6.txt");
    }


    public static void loadUrlResource(String path){
        try {
            UrlResource urlResource = new UrlResource(path);
            URL url = urlResource.getURL();
            String filename = urlResource.getFilename();
            URI uri = urlResource.getURI();
            System.out.println(url);
            System.out.println(filename);
            System.out.println(uri);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
