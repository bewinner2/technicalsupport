package TechnicalSupport.TechnicalSupport.service;


import TechnicalSupport.TechnicalSupport.domain.Site;
import TechnicalSupport.TechnicalSupport.domain.Summary;
import TechnicalSupport.TechnicalSupport.domain.version_locator_tag;
import TechnicalSupport.TechnicalSupport.repository.SummaryRepository;
import TechnicalSupport.TechnicalSupport.repository.SummarySearch;
import TechnicalSupport.TechnicalSupport.repository.siteRepository;
import TechnicalSupport.TechnicalSupport.repository.version_locator_tag_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SummaryService {


    private final SummaryRepository summaryRepository;
    private final siteRepository siteRepository;
    private final version_locator_tag_Repository version_locator_tag_repository;


    @Transactional
    public Long show(Long site_Id, Long version_locator_tag_Id) {

        //엔티티조회
        Site site = siteRepository.findOne(site_Id);
        version_locator_tag version_locator_tag = version_locator_tag_repository.findOne(version_locator_tag_Id);

        //종합
        Summary summary = new Summary();
        summary.setSite_name(site.getSite_name());
        summary.setEmployee_name(site.getEmployee_name());
        summary.setPhone_number(site.getPhone_number());
        summary.setAddress(site.getAddress());

        summary.setGeospace_Version(version_locator_tag.getGeospace_Version());
        summary.setLocator_name(version_locator_tag.getLocator_name());
        summary.setLocator_firmware(version_locator_tag.getLocator_firmware());
        summary.setTag_name(version_locator_tag.getTag_name());
        summary.setTag_Period(version_locator_tag.getTag_Period());

        return summary.getId();
    }

    public List<Summary> findSummary(SummarySearch summarySearch) {
        return summaryRepository.findAllByString(summarySearch);
    }




}
