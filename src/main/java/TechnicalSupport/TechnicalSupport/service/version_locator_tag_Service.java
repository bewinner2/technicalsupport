package TechnicalSupport.TechnicalSupport.service;

import TechnicalSupport.TechnicalSupport.domain.version_locator_tag;
import TechnicalSupport.TechnicalSupport.repository.version_locator_tag_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class version_locator_tag_Service {

    private final version_locator_tag_Repository version_locator_tag_repository;

    @Transactional
    public void saveItem(version_locator_tag version_locator_tag) {
        version_locator_tag_repository.save(version_locator_tag);
    }
    public List<version_locator_tag> findItems() {
        return version_locator_tag_repository.findAll();
    }
    public version_locator_tag findOne(Long version_locator_tag_Id) {
        return version_locator_tag_repository.findOne(version_locator_tag_Id);
    }


}
