package com.lyy.condition;

import com.sun.istack.internal.Pool;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: spring-annotation
 * @description:
 * @author: ly
 * @create: 2021-11-15 20:41
 **/
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    //返回值，就是需要导入到容器中的组件的全类名
    //AnnotationMetadata：当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        importingClassMetadata.get
        //不要返回null
        return new  String[]{"com.lyy.bean.Blue","com.lyy.bean.Yellow"};
    }
}
