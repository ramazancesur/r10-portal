package tr.com.r10.portal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tr.com.r10.portal.dao.interfaces.CityDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.model.CityEntity;
import tr.com.r10.portal.repository.CityRepository;
import tr.com.r10.portal.util.PageUtil;

import java.util.List;

@Repository
public class CityDaoImpl implements CityDao {
    private CityRepository cityRepository;

    @Override
    public CityEntity save(CityEntity data) {
        return cityRepository.save(data);
    }

    @Override
    public CityEntity get(Long id) {
        return cityRepository.getById(id);
    }

    @Override
    public List<CityEntity> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public List<CityEntity> getAllDataWithPagination(PageablePortal pageablePortal) {
        Pageable pageable = PageUtil.getPageableData(pageablePortal);
        return cityRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}