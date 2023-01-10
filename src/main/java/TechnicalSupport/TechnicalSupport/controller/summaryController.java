package TechnicalSupport.TechnicalSupport.controller;


import TechnicalSupport.TechnicalSupport.domain.Site;
import TechnicalSupport.TechnicalSupport.domain.Summary;
import TechnicalSupport.TechnicalSupport.domain.version_locator_tag;
//import TechnicalSupport.TechnicalSupport.repository.OrderSearch;
import TechnicalSupport.TechnicalSupport.repository.SummarySearch;
import TechnicalSupport.TechnicalSupport.service.SiteService;
import TechnicalSupport.TechnicalSupport.service.SummaryService;
import TechnicalSupport.TechnicalSupport.service.version_locator_tag_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class summaryController {

    private final SummaryService summaryService;
    private final SiteService siteService;
    private final version_locator_tag_Service version_locator_tag_service;


    @GetMapping(value="/order")
    public String createForm(Model model){

        List<Site> sites=siteService.findSite();
        List<version_locator_tag> version_locator_tags=version_locator_tag_service.findItems();

        model.addAttribute("sites",sites);
        model.addAttribute("version_locator_tags",version_locator_tags);

        return "order/orderForm";

    }

    @PostMapping(value="/order")
    public String order(@RequestParam("site_Id") Long site_Id, @RequestParam("version_locator_tag_id") Long version_locator_tag_id){

        summaryService.show(site_Id, version_locator_tag_id);
        return "redirect:/orders";

    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute("summarySearch") SummarySearch summarySearch, Model model) {
        List<Summary> orders = summaryService.findSummary(summarySearch);
        model.addAttribute("orders", orders);

        return "order/orderList";
    }

}
