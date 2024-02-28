package com.khesam.logger.serializer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.khesam.logger.model.SystemInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoggerSerializerProvider {

    @Bean("logger-serializer")
    public ObjectMapper provideObjectMapper(
            Module module
    ) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(module);
        objectMapper.setAnnotationIntrospector(new ComplementaryJacksonAnnotationIntrospector());
        return objectMapper;
    }

    @Bean
    public SimpleModule module(
            BigDecimalSerializer bigDecimalSerializer,
            ByteArrayResourceSerializer byteArrayResourceSerializer,
            SystemInfoSerializer systemInfoSerializer
    ) {
        SimpleModule module = new SimpleModule();
        module.addSerializer(BigDecimal.class, bigDecimalSerializer);
        module.addSerializer(ByteArrayResource.class, byteArrayResourceSerializer);
        module.addSerializer(SystemInfo.class, systemInfoSerializer);

        return module;
    }

    @Bean
    public BigDecimalSerializer bigDecimalSerializer() {
        return new BigDecimalSerializer();
    }

    @Bean
    public ByteArrayResourceSerializer byteArrayResourceSerializer() {
        return new ByteArrayResourceSerializer();
    }

    @Bean
    public SystemInfoSerializer systemInfoSerializer() {
        return new SystemInfoSerializer();
    }
}
