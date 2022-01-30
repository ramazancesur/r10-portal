package tr.com.r10.portal.model;

import javax.persistence.*;

@Entity
@Table(name = "TOWN")
public class TownEntity extends BaseEntity {
    @Column
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private CityEntity city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TownEntity)) return false;

        TownEntity that = (TownEntity) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TownEntity{" +
                "name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
