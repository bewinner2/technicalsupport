package TechnicalSupport.TechnicalSupport.api;


import TechnicalSupport.TechnicalSupport.domain.Site;
import TechnicalSupport.TechnicalSupport.domain.version_locator_tag;
import TechnicalSupport.TechnicalSupport.service.SiteService;
import TechnicalSupport.TechnicalSupport.service.version_locator_tag_Service;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class version_locator_tag_api_Controller {

    private final version_locator_tag_Service version_locator_tag_service;


    @GetMapping("/api/version_locator_tag_api")
    public version_locator_Tag_Result getSite() {

        List<version_locator_tag> find_version_locator_Tag = version_locator_tag_service.findItems();
        //엔티티 -> DTO 변환
        List<version_locator_Tag_Dto> collect = find_version_locator_Tag.stream()
                .map(m -> new version_locator_Tag_Dto(m.getId(),m.getGeospace_Version(),m.getLocator_name(),m.getLocator_firmware(),m.getTag_name(),m.getTag_Period()))
                .collect(Collectors.toList());

        return new version_locator_Tag_Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class version_locator_Tag_Result<T> {


        private T data;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    static class version_locator_Tag_Dto {
        private Long id;
        private String Geospace_Version;

        //Lcoator정보
        private String Locator_name;
        private String Locator_firmware;

        //tag 정보
        private String Tag_name;
        private String Tag_Period;

    }


}
