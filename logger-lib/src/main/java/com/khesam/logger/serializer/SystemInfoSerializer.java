package com.khesam.logger.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.khesam.logger.model.SystemInfo;

import java.io.IOException;

public class SystemInfoSerializer extends StdSerializer<SystemInfo> {


    protected SystemInfoSerializer() {
        super(SystemInfo.class);
    }

    @Override
    public void serialize(
            SystemInfo systemInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeString(
                String.format("[%s-%s-%s-%s]", systemInfo.name(), systemInfo.node(), systemInfo.ip(), systemInfo.applicationId())
        );
    }
}
