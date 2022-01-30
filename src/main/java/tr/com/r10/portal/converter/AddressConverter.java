package tr.com.r10.portal.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.r10.portal.dto.Address;
import tr.com.r10.portal.model.AddressEntity;
import tr.com.r10.portal.repository.CityRepository;
import tr.com.r10.portal.repository.TownRepository;

import java.util.Objects;

@Component
public class AddressConverter implements Converter<AddressEntity, Address> {
    private CityRepository cityRepository;
    private TownRepository townRepository;

    @Override
    public AddressEntity convertToEntity(Address address) {
        if (Objects.isNull(address)) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCreatedDate(address.getCreatedDate());
        addressEntity.setUpdatedDate(address.getUpdatedDate());
        addressEntity.setDescription(address.getDescription());
        addressEntity.setId(address.getAddressOid());
        addressEntity.setCity(cityRepository.findByName(address.getCityName()));
        addressEntity.setTown(townRepository.findByName(address.getTownName()));
        addressEntity.setDetail(address.getDetails());
        return addressEntity;
    }

    @Override
    public Address convertToDTO(AddressEntity addressEntity) {
        if (Objects.isNull(addressEntity)) {
            return null;
        }
        Address address = new Address();
        address.setCreatedDate(addressEntity.getCreatedDate());
        address.setUpdatedDate(addressEntity.getUpdatedDate());
        address.setDescription(addressEntity.getDescription());
        address.setAddressOid(addressEntity.getId());
        if (Objects.nonNull(addressEntity.getCity())) {
            address.setCityName(addressEntity.getCity().getName());
        }
        if (Objects.nonNull(addressEntity.getTown())) {
            address.setTownName(addressEntity.getTown().getName());
        }
        address.setDetails(addressEntity.getDetail());
        return address;
    }

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Autowired
    public void setTownRepository(TownRepository townRepository) {
        this.townRepository = townRepository;
    }
}