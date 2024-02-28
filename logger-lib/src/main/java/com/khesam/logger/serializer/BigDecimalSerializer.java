package com.khesam.logger.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.math.BigDecimal;

    public class BigDecimalSerializer extends StdSerializer<BigDecimal> {

    protected BigDecimalSerializer() {
        super(BigDecimal.class);
    }

    @Override
    public void serialize(
            BigDecimal bigDecimal, JsonGenerator jsonGenerator, SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeString(bigDecimal.toPlainString());
    }
}
