package tr.com.r10.portal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tr.com.r10.portal.dao.interfaces.AddressDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.model.AddressEntity;
import tr.com.r10.portal.repository.AddressRepository;
import tr.com.r10.portal.util.PageUtil;

import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao {
    private AddressRepository addressRepository;

    @Override
    public AddressEntity save(AddressEntity data) {
        return addressRepository.save(data);
    }

    @Override
    public AddressEntity get(Long id) {
        return addressRepository.getById(id);
    }

    @Override
    public List<AddressEntity> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public List<AddressEntity> getAllDataWithPagination(PageablePortal pageablePortal) {
        Pageable pageable = PageUtil.getPageableData(pageablePortal);
        return addressRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
}