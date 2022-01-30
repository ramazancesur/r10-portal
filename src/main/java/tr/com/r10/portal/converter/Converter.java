package tr.com.r10.portal.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<T, D> {
    T convertToEntity(D dto);

    D convertToDTO(T entity);

    default List<T> convertToEntityList(List<D> dtoList) {
        return dtoList.stream()
                .map(dto -> convertToEntity(dto))
                .collect(Collectors.toList());
    }

    default List<D> convertToDTOList(List<T> entityList) {
        return entityList.stream()
                .map(entity -> convertToDTO(entity))
                .collect(Collectors.toList());
    }
}