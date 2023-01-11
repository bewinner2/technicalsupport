package TechnicalSupport.TechnicalSupport.controller;


import TechnicalSupport.TechnicalSupport.domain.version_locator_tag;
import TechnicalSupport.TechnicalSupport.service.version_locator_tag_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class version_locator_tag_Controller {

    private final version_locator_tag_Service version_locator_tag_service;

    @GetMapping(value="/version_locator_tag/new")
    public String createForm(Model model){
        model.addAttribute("form",new version_locator_tag_Form());
        return "items/create_version_locator_tag_form";
    }

    @PostMapping(value="/version_locator_tag/new")
    public String create(version_locator_tag_Form form){


        version_locator_tag version_locator_tag=new version_locator_tag();

        version_locator_tag.setGeospace_Version(form.getGeospace_Version());

        version_locator_tag.setLocator_name(form.getLocator_name());
        version_locator_tag.setLocator_firmware(form.getLocator_firmware());

        version_locator_tag.setTag_name(form.getTag_name());
        version_locator_tag.setTag_Period(form.getTag_period());


        version_locator_tag_service.saveItem(version_locator_tag);
        return "redirect:/items";
    }

    @GetMapping(value="/items")
    public String list(Model model){
        List<version_locator_tag> items=version_locator_tag_service.findItems();
        model.addAttribute("items",items);
        return "items/version_locator_tag_List";

    }



    /**
     * 수정 폼
     */


    @GetMapping(value="/items/{version_locator_tag_Id}/edit")
    public String updateItemForm(@PathVariable("version_locator_tag_Id") Long version_locator_tag_Id, Model model){

        version_locator_tag version_locator_tag =version_locator_tag_service.findOne(version_locator_tag_Id);


        version_locator_tag_Form form=new version_locator_tag_Form();

        form.setId(version_locator_tag.getId());
        form.setGeospace_Version(version_locator_tag.getGeospace_Version());
        form.setLocator_name(version_locator_tag.getLocator_name());
        form.setLocator_firmware(version_locator_tag.getLocator_firmware());

        form.setTag_name(version_locator_tag.getTag_name());
        form.setTag_period(version_locator_tag.getTag_Period());


        model.addAttribute("form",form);
        return "items/update_version_locator_tag_Form";

    }

    /**
     * 상품 수정
     */
    @PostMapping(value="/items/{version_locator_tag_Id}/edit")
    public String updateItem(@ModelAttribute("form") version_locator_tag_Form form){

        version_locator_tag version_locator_tag=new version_locator_tag();
        version_locator_tag.setId(form.getId());
        version_locator_tag.setGeospace_Version(form.getGeospace_Version());
        version_locator_tag.setLocator_name(form.getLocator_name());
        version_locator_tag.setLocator_firmware(form.getLocator_firmware());
        version_locator_tag.setTag_name(form.getTag_name());
        version_locator_tag.setTag_Period(form.getTag_period());

        version_locator_tag_service.saveItem(version_locator_tag);

        return "redirect:/items";
    }





}
