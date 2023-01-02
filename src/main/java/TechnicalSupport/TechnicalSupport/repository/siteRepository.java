package TechnicalSupport.TechnicalSupport.repository;

import TechnicalSupport.TechnicalSupport.domain.Site;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class siteRepository {

    @PersistenceContext
    EntityManager em;

    public long save(Site site){
        em.persist(site);

        return site.getId();
    }

    public void delete(Site site){
        em.remove(site);
    }

    public Site findOne(Long id){

        return em.find(Site.class,id);
    }

    public List<Site> findAll(){
        return em.createQuery("select m from Site m", Site.class).getResultList();

    }

    public List<Site> findByName(String site_name){
        return em.createQuery("select m from Site m where m.site_name=:site_name",Site.class)
                .setParameter("site_name",site_name).getResultList();

    }
}


