package TechnicalSupport.TechnicalSupport;

import TechnicalSupport.TechnicalSupport.domain.Site;
import TechnicalSupport.TechnicalSupport.domain.version_locator_tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            Site site = createSite("TYM_DTOL", "홍길동", "010-8741-3628", "1111");
            em.persist(site);
            version_locator_tag version_locator_tag = create_version_locator_tag("2.8", "DA350", "GLA-200","DT720","3");
            em.persist(version_locator_tag);

        }

        private Site createSite(String site_name, String employee_name, String phone_number, String address) {

            Site site = new Site();
            site.setSite_name(site_name);
            site.setEmployee_name(employee_name);
            site.setPhone_number(phone_number);
            site.setAddress(address);

            return site;
        }

        private version_locator_tag create_version_locator_tag(String Geospace_Version, String Locator_name , String Locator_firmware, String Tag_name, String Tag_Period) {
            version_locator_tag version_locator_tag = new version_locator_tag();

            version_locator_tag.setGeospace_Version(Geospace_Version);
            version_locator_tag.setLocator_name(Locator_name);

            version_locator_tag.setLocator_firmware(Locator_firmware);
            version_locator_tag.setTag_name(Tag_name);
            version_locator_tag.setTag_Period(Tag_Period);

            return version_locator_tag;
        }
    }
}