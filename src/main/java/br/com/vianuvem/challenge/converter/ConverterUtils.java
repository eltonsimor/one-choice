package br.com.vianuvem.challenge.converter;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by eltonmoraes on 7/18/17.
 */
public abstract class ConverterUtils {

    private final static Mapper mapper;

    static {
        mapper = new DozerBeanMapper();
    }

    public static <T> T convertTo(Object source, Class<T> destinationClazz){
        return mapper.map(source, destinationClazz);
    }
}
