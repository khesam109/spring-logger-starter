package com.khesam.logger.serializer.truncate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class TruncateMeJacksonSerializer extends StdSerializer<String> {

    public static final int MAX_TEXT_LENGTH = 10;

    protected TruncateMeJacksonSerializer() {
        super(String.class);
    }

    @Override
    public void serialize(
            String string, JsonGenerator jsonGenerator, SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeString(
                String.format(
                        "Truncated value: [%s]",
                        truncateText(string)
                )
        );
    }

    private String truncateText(String input) {
        return input.substring(
                0, Math.min(
                        input.length(), MAX_TEXT_LENGTH
                )
        ).concat("...");
    }
}
