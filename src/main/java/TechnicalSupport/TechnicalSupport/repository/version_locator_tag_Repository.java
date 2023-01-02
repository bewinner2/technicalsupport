package TechnicalSupport.TechnicalSupport.repository;

import TechnicalSupport.TechnicalSupport.domain.version_locator_tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class version_locator_tag_Repository {

    private final EntityManager em;

    public void save(version_locator_tag version_locator_tag){
        if(version_locator_tag.getId()==null){
            em.persist(version_locator_tag);
        }else{
            em.merge(version_locator_tag);
        }
    }

    public version_locator_tag findOne(Long id){
        return em.find(version_locator_tag.class,id);
    }

    public List<version_locator_tag> findAll(){
        return em.createQuery("select i from version_locator_tag i", version_locator_tag.class).getResultList();

    }
}
