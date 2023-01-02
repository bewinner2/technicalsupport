package TechnicalSupport.TechnicalSupport.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class version_locator_tag_Form {

    private Long id;

    //geospace 버전
    private String geospace_Version;

    //Locator 정보
    private String locator_name;
    private String locator_firmware;

    //tag 정보
    private String tag_name;
    private String tag_period;

}
