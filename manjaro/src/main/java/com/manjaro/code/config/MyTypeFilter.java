package com.manjaro.code.config;

import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

public class MyTypeFilter  extends TypeExcludeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {
        if(!"com.manjaro.code.cache.RedisCacheConfig".equals(metadataReader.getClassMetadata().getClassName())){
            System.out.println("skip >>>>>>> " + metadataReader.getClassMetadata().getClassName());
            return true;
        }
        return false;
    }

}
