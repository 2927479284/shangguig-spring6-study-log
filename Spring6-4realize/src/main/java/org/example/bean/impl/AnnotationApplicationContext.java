package org.example.bean.impl;

import org.example.bean.ApplicationContext;
import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.example.zhujie.Bean;
import org.example.zhujie.Di;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 自定义ioc容器实现
 */
public class AnnotationApplicationContext implements ApplicationContext {


    private static Map<Class<?>,Object> beanMaps = new HashMap<>();

    private static String rootPath;

    /**
     * 获取对应的bean
     * @param clazz 类加载文件
     * @return 返回对应对象
     */
    @Override
    public Object getBean(Class<?> clazz) {
        return beanMaps.get(clazz);
    }

    /**
     * 根据包名扫描对应的bean
     * @param basePackage 包名地址
     */
    //public AnnotationApplicationContext(String basePackage)
    public AnnotationApplicationContext(String basePackage) {
        System.out.println(basePackage);
        try {
            //1.包名替换成 xxxx\xxxx\xxxx org.example org\example
            String replace = basePackage.replaceAll("\\.", "\\\\");
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(replace);
            while (resources.hasMoreElements()){
                URL url = resources.nextElement();
                // 需要解码
                //file:/C:/Users/Administrator.DESKTOP-31RFSET/Desktop/spring6Study/Spring6-4realize/target/classes/org%5cexample
                //String file = url.getFile();
                String decode = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
                //这里不从第一位截取 首位会多出一个 /  例如：/C:/xxxx/xxx/xx/xx/x/xxx
                rootPath = decode.substring(1, decode.length()-replace.length());
                loadBean(new File(decode));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //依赖注入
        loadDi();
    }

    private void loadDi() {

        Set<Map.Entry<Class<?>, Object>> entries = beanMaps.entrySet();
        for (Map.Entry<Class<?>, Object> entry : entries) {
            Object object = entry.getValue();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                Di annotation = field.getAnnotation(Di.class);
                if (annotation != null){
                    //说明当前属性上面具备Di这个注解 给他set对应的对象
                    field.setAccessible(true);
                    try {
                        field.set(object,beanMaps.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

    /**
     * 扫描当前路径下的所有文件 加载bean
     * @param file
     */
    private static void loadBean(File file) {
        //1.获取当前路径下面的所有的文件
        File[] files = file.listFiles();
        if (files == null){
            return;
        }
        //2.判断当前文件是否是文件/文件夹 文件夹则递归继续执行
        for (File file1 : files) {
            if (file1.isDirectory()){
                loadBean(file1);
            }else {
                //获取出他的包的路径 org\example\zhujie\Di.class 还未开始替换斜杠
                String substring = file1.getAbsolutePath().substring(rootPath.length());
                //判断当前路径后缀是否是class文件
                if (substring.contains(".class")){
                    //去掉class后缀 并且 \ 替换成 . 例如 org\example\zhujie\Di.class 修改为 org.example.zhujie.Di
                    String replace = substring.replaceAll("\\\\", ".").replace(".class", "");
                    try {
                        //开始使用 反射加载当前类
                        Class<?> aClass = Class.forName(replace);
                        //判断当前aclass 是否是接口 非接口 判断其是否具备@Bean注解 存在则创建实例化对象并存储
                        if (!aClass.isInterface()){
                            Bean annotation = aClass.getAnnotation(Bean.class);
                            if (annotation!=null){
                                //说明当前类上存在Bean注解 开始创建实例化对象
                                Object o = aClass.getDeclaredConstructor().newInstance();
                                //判断其当前类是否具备实现接口 有的话 则用接口的class对象作为 map中的key Map<Class<?>,Object>
                                if (aClass.getInterfaces().length>0){
                                    System.out.println("正在加载实现："+aClass.getInterfaces()[0]+" 的接口 实例化对象为："+ o.getClass().getName());
                                    beanMaps.put(aClass.getInterfaces()[0],o);
                                }else {
                                    //当前类不存在实现接口 以他自己的class对象作为 key
                                    System.out.println("当前类："+o.getClass().getName()+" 无实现接口 以自己的class作为key");
                                    beanMaps.put(aClass,o);
                                }
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }

    }

/*    public static void main(String[] args) {
        AnnotationApplicationContext1("org.example");

        UserDaoImpl o = (UserDaoImpl) beanMaps.get(UserDao.class);
        o.add();
        System.out.println("结束");
    }*/
}
