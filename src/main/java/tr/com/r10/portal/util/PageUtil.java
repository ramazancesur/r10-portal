package tr.com.r10.portal.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.enums.SortableType;

import java.util.Objects;

public class PageUtil {
    public static Pageable getPageableData(PageablePortal pageablePortal) {
        if (Objects.isNull(pageablePortal.getSortable())) {
            return PageRequest.of(pageablePortal.getCurrentPage(), pageablePortal.getDataSize());
        } else if (Objects.equals(pageablePortal.getSortable().getSortableType(), SortableType.DESC)) {
            return PageRequest.of(pageablePortal.getCurrentPage(), pageablePortal.getDataSize(),
                    Sort.by(pageablePortal.getSortable().getSortableField()).descending());
        } else {
            return PageRequest.of(pageablePortal.getCurrentPage(), pageablePortal.getDataSize(),
                    Sort.by(pageablePortal.getSortable().getSortableField()));
        }
    }
}