package TechnicalSupport.TechnicalSupport.api;


import TechnicalSupport.TechnicalSupport.domain.Site;
import TechnicalSupport.TechnicalSupport.domain.version_locator_tag;
import TechnicalSupport.TechnicalSupport.repository.siteRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class SimpleApiController {

    private final siteRepository siteRepository;


//    @GetMapping("/api/v1/simple")
//    public List<Site> sitesV1() {
//        List<Site> all = siteRepository.findAll(new OrderSearch());
//
//
//        for (Order site : all) {
//            site.getMember().getName(); //Lazy 강제 초기화
//            site.getDelivery().getAddress(); //Lazy 강제 초기화
//        }
//
//
//        return all;
//    }

    @GetMapping("/api/v2/simple-sites")
    public List<SimpleSiteDto> sitesV2() {
        List<Site> sites = siteRepository.findAll();
        List<SimpleSiteDto> result = sites.stream()
                .map(o -> new SimpleSiteDto(o))
                .collect(toList());

        return result;
    }

    @Data
    static class SimpleSiteDto {

//        private Long siteId;
//        private String name;
//        private LocalDateTime siteDate; //주문시간
//        private OrderStatus siteStatus;
//        private Address address;

        private Long siteId;
        private String site_name;
        private String employee_name;
        private String phone_number;
        private String address;

        private String Geospace_Version;


        private version_locator_tag version_locator_tag;
        public SimpleSiteDto(Site site) {
            siteId = site.getId();
            site_name = site.getSite_name();
            employee_name = site.getEmployee_name();
            phone_number = site.getPhone_number();
            address = site.getAddress();
            Geospace_Version=version_locator_tag.getGeospace_Version();

        }
    }





}
