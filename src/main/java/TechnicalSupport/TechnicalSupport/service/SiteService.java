package TechnicalSupport.TechnicalSupport.service;


import TechnicalSupport.TechnicalSupport.domain.Site;
import TechnicalSupport.TechnicalSupport.repository.siteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SiteService {

    private final siteRepository siteRepository;

    public Long join(Site site){
        validateDuplicateSite(site);
        siteRepository.save(site);
        return site.getId();
    }

    private void validateDuplicateSite(Site site) {
        List<Site> findSites=siteRepository.findByName(site.getSite_name());
        if(!findSites.isEmpty()){
            throw new IllegalStateException("this site already exists");
        }
    }

    public List<Site> findSite(){
        return siteRepository.findAll();
    }

    public void deleteSite(Site site){
         siteRepository.delete(site);
    }

    public Site findOne(Long siteId){
        return siteRepository.findOne(siteId);
    }


    @Transactional
    public void update(Long id, String name) {
        Site site = siteRepository.findOne(id);
        site.setSite_name(name);
    }

}
