package tr.com.r10.portal.dto;

public class PortalException {
    private String statusCode;
    private String detailMessage;

    public PortalException(String statusCode, String detailMessage) {
        this.statusCode = statusCode;
        this.detailMessage = detailMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }
}