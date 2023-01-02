package TechnicalSupport.TechnicalSupport.repository;

import TechnicalSupport.TechnicalSupport.domain.Site;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class siteRepositoryTest {


    @Autowired
    siteRepository siteRepository;

    @Test
    public void siteTest() throws Exception{

        Site site = new Site();
        site.setSite_name("memberA");
        Long savedId = siteRepository.save(site);
        Site findSite = siteRepository.findOne(savedId);


        Assertions.assertThat(findSite.getId()).isEqualTo(site.getId());

        Assertions.assertThat(findSite.getSite_name()).isEqualTo(site.getSite_name());

    }

}