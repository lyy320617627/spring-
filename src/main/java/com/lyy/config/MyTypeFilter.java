package com.lyy.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 18:56
 **/

public class MyTypeFilter implements TypeFilter {
    @Override
    /**
     * metadataReader:读取到当前正在扫描的类的信息
     *  metadataReaderFactory：可以获取到其他任何类信息的
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取到当前类资源（类的路径）
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println(className);
        if (className.contains("er")){
            return true;
        }
      return false;
    }
}
