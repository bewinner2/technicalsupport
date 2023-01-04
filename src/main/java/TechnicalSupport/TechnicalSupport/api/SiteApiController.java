package TechnicalSupport.TechnicalSupport.api;


import TechnicalSupport.TechnicalSupport.domain.Site;
import TechnicalSupport.TechnicalSupport.service.SiteService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SiteApiController {

    private final SiteService siteService;

    private int pulltest;






    @GetMapping("/api/getSite")
    public Result getSite() {

        List<Site> findSite = siteService.findSite();
        //엔티티 -> DTO 변환
        List<SiteDto> collect = findSite.stream()
                .map(m -> new SiteDto(m.getId(),m.getSite_name(),m.getEmployee_name(),m.getPhone_number(),m.getAddress()))
                .collect(Collectors.toList());

        return new Result(collect);
    }

    @PostMapping("/api/registerSite")
    public CreateSiteResponse saveSite(@RequestBody @Valid CreateSiteRequest request) {

        Site site = new Site();
        site.setSite_name(request.getSite_name());
        site.setEmployee_name(request.getEmployee_name());
        site.setPhone_number(request.getPhone_number());
        site.setAddress(request.getAddress());

        Long id = siteService.join(site);
        return new CreateSiteResponse(id);
    }

    @PutMapping("/api/v2/site/{id}")
    public UpdateSiteResponse updateSiteV2(@PathVariable("id") Long id, @RequestBody @Valid UpdateSiteRequest request) {
        siteService.update(id, request.getName());
        Site findSite = siteService.findOne(id);
        return new UpdateSiteResponse(findSite.getId(), findSite.getSite_name());
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {


        private T data;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    static class SiteDto {
        private Long id;
        private String name;
        private String employee_name;
        private String phone_number;
        private String address;

    }

    @Data
    static class CreateSiteRequest {
        private String site_name;
        private String employee_name;
        private String phone_number;
        private String address;
    }

    @Data
    static class CreateSiteResponse {
        private Long id;
        public CreateSiteResponse(Long id) {
            this.id = id;
        }
    }

    @Data
    static class UpdateSiteRequest {
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateSiteResponse {
        private Long id;
        private String name;
    }




}
