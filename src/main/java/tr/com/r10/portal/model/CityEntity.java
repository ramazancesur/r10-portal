package tr.com.r10.portal.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CITY")
public class CityEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private int plateCode;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private List<TownEntity> townList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(int plateCode) {
        this.plateCode = plateCode;
    }

    public List<TownEntity> getTownList() {
        return townList;
    }

    public void setTownList(List<TownEntity> townList) {
        this.townList = townList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityEntity)) return false;

        CityEntity that = (CityEntity) o;

        if (plateCode != that.plateCode) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + plateCode;
        return result;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "name='" + name + '\'' +
                ", plateCode=" + plateCode +
                ", townList=" + townList +
                '}';
    }
}