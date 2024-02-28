package com.khesam.logger.serializer.mask;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * More info: <a href="https://stackoverflow.com/questions/18659835/how-to-deserialize-field-from-object-based-on-annotation-using-jackson">Mask data</a>
 */
public class MaskMeJacksonSerializer extends StdSerializer<Object> {

    protected MaskMeJacksonSerializer() {
        super(Object.class);
    }

    @Override
    public void serialize(
            Object object, JsonGenerator jsonGenerator, SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeString("[PROTECTED]");
    }
}
