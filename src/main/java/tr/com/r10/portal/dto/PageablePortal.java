package tr.com.r10.portal.dto;

public class PageablePortal {
    // todo this dao is editing for one more field sorting
    private Sortable sortable;
    private int dataSize;
    private int currentPage;

    public Sortable getSortable() {
        return sortable;
    }

    public void setSortable(Sortable sortable) {
        this.sortable = sortable;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageablePortal{" +
                "sortable=" + sortable +
                ", dataSize=" + dataSize +
                ", currentPage=" + currentPage +
                '}';
    }
}