package com.khesam.logger.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.core.io.ByteArrayResource;

import java.io.IOException;

public class ByteArrayResourceSerializer extends StdSerializer<ByteArrayResource> {

    protected ByteArrayResourceSerializer() {
        super(ByteArrayResource.class);
    }

    @Override
    public void serialize(
            ByteArrayResource byteArrayResource, JsonGenerator jsonGenerator, SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeString(
                String.format(
                        "ByteArrayResource[%d]",
                        byteArrayResource.contentLength()
                )
        );
    }
}
