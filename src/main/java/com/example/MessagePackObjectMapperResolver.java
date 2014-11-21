package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.WILDCARD)
@Produces(MediaType.WILDCARD)
public class MessagePackObjectMapperResolver implements ContextResolver<ObjectMapper> {
    private final ObjectMapper objectMapper;

    public MessagePackObjectMapperResolver() {
        objectMapper = new ObjectMapper(new MessagePackFactory());
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}
