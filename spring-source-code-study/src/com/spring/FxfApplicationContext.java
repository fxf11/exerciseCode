package com.spring;

import com.fxf.service.AppConfig;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;

/**
 * @Classname FxfApplicationContext
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/26 22:58
 * @Created by 饭小范
 */
public class FxfApplicationContext {

    private Class configClass;

    public FxfApplicationContext(Class appConfigClass) {
        this.configClass = appConfigClass;

        if(appConfigClass.isAnnotationPresent(ComponentScan.class)){
            ComponentScan annotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = annotation.value();
            path = path.replace(".", "/");
            ClassLoader classLoader = FxfApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);

            File file = new File(resource.getFile());
            System.out.println(file);
        }
    }

    public Object getBean(String beanName){
        return null;
    }
}
