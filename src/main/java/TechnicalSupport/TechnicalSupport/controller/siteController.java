package TechnicalSupport.TechnicalSupport.controller;

import TechnicalSupport.TechnicalSupport.domain.Site;
import TechnicalSupport.TechnicalSupport.service.SiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class siteController {

    private final SiteService siteService;


    @GetMapping(value="/sites/new")
    public String createForm(Model model){
        model.addAttribute("siteForm",new siteForm());
        return "sites/createSiteForm";
    }

    @PostMapping(value="/sites/new")
    public String create(@Valid siteForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "sites/createSiteForm";
        }


        Site site=new Site();
        site.setSite_name(form.getSite_name());
        site.setEmployee_name(form.getEmployee_name());
        site.setPhone_number(form.getPhone_number());
        site.setAddress(form.getAddress());
        siteService.join(site);

        return "redirect:/";
    }


    @GetMapping(value="/sites")
    public String list(Model model){
        List<Site> sites=siteService.findSite();
        model.addAttribute("sites",sites);
        return "sites/siteList";

    }
}
