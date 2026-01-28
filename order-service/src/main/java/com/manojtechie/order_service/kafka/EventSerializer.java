package com.manojtechie.order_service.kafka;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.SerializationException;
import org.springframework.core.serializer.Serializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

@Slf4j
public class EventSerializer<T extends Serializable> implements Serializer<T> {
    protected final ObjectMapper objectMapper;
    private boolean useDefaultMapper;
    public EventSerializer(){
        this.objectMapper = new Jackson2ObjectMapperBuilder()
                .featuresToEnable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .featuresToDisable(MapperFeature.DEFAULT_VIEW_INCLUSION)
                .build().findAndRegisterModules();

    }
private final  void initObjectMapper(){
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
}
 public String serialize(T data){
        try{
            if(data!=null){
                return this.objectMapper.writeValueAsString(data);
            }
            return null;
        }
        catch(IOException ex){
           throw new SerializationException("can't serialize the data ",ex);
        }
 }

    @Override
    public void serialize(T object, OutputStream outputStream) throws IOException {

    }
}
