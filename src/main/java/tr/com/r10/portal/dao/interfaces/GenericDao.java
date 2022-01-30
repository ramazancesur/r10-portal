package tr.com.r10.portal.dao.interfaces;

import tr.com.r10.portal.dto.PageablePortal;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable> {
    T save(T data);

    T get(Long id);

    List<T> getAll();

    List<T> getAllDataWithPagination(PageablePortal pageablePortal);

    void deleteById(Long id);
}
