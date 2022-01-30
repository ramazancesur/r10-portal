package tr.com.r10.portal.dto;

import java.io.Serializable;
import java.util.Date;

public class BaseDTO implements Serializable {
    private Date createdDate;
    private Date updatedDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}