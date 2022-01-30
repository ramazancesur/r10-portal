package tr.com.r10.portal.dto;

import tr.com.r10.portal.enums.SortableType;

public class Sortable {
    private String sortableField;
    private SortableType sortableType;

    public String getSortableField() {
        return sortableField;
    }

    public void setSortableField(String sortableField) {
        this.sortableField = sortableField;
    }

    public SortableType getSortableType() {
        return sortableType;
    }

    public void setSortableType(SortableType sortableType) {
        this.sortableType = sortableType;
    }

    @Override
    public String toString() {
        return "Sortable{" +
                "sortableField='" + sortableField + '\'' +
                ", sortableType=" + sortableType +
                '}';
    }
}
