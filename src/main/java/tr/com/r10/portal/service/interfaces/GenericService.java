package tr.com.r10.portal.service.interfaces;

import tr.com.r10.portal.dto.BaseDTO;
import tr.com.r10.portal.dto.PageablePortal;

import java.util.List;

public interface GenericService<T extends BaseDTO> {
    T save(T data);

    T get(Long id);

    List<T> getAll();

    List<T> getAllDataWithPagination(PageablePortal pageablePortal);

    void deleteById(Long id);
}