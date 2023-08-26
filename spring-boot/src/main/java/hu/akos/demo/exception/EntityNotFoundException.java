package hu.akos.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;
import java.util.stream.Collectors;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException
{
    public EntityNotFoundException(Class<?> entityClass, Map<String, String> searchPropertyMap)
    {
        super(String.format("Entity %s not found with parameters %s", entityClass.getSimpleName(), mapToString(searchPropertyMap)));
    }

    private static String mapToString(Map<String, String> searchPropertyMap) {
        if(searchPropertyMap == null) {
            return null;
        }

        return searchPropertyMap.entrySet().stream()
                .map(entry -> String.format("%s=%s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));
    }
}
