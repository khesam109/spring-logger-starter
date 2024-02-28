package com.khesam.logger.serializer;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.khesam.logger.serializer.mask.MaskMe;
import com.khesam.logger.serializer.mask.MaskMeJacksonSerializer;
import com.khesam.logger.serializer.truncate.TruncateMe;
import com.khesam.logger.serializer.truncate.TruncateMeJacksonSerializer;


public class ComplementaryJacksonAnnotationIntrospector extends JacksonAnnotationIntrospector {

    @Override
    public Object findSerializer(Annotated annotated) {
        MaskMe maskAnnotation = annotated.getAnnotation(MaskMe.class);
        TruncateMe truncateAnnotation = annotated.getAnnotation(TruncateMe.class);
        if (maskAnnotation != null) {
            return MaskMeJacksonSerializer.class;
        } else if (truncateAnnotation != null) {
            return TruncateMeJacksonSerializer.class;
        }

        return super.findSerializer(annotated);
    }
}
