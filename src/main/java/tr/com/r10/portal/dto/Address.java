package tr.com.r10.portal.dto;

import java.util.Date;

public class Address extends BaseDTO {
    private Long addressOid;
    private String description;
    private String details;
    private String cityName;
    private String townName;
    private Date createDate;
    private Date updateDate;

    public Long getAddressOid() {
        return addressOid;
    }

    public void setAddressOid(Long addressOid) {
        this.addressOid = addressOid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        return addressOid != null ? addressOid.equals(address.addressOid) : address.addressOid == null;
    }

    @Override
    public int hashCode() {
        return addressOid != null ? addressOid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressOid=" + addressOid +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                ", cityName='" + cityName + '\'' +
                ", townName='" + townName + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}