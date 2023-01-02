package TechnicalSupport.TechnicalSupport.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class siteForm {

    @NotEmpty(message="사이트 이름은 필수입니다.")
    private String site_name;
    private String employee_name;
    private String phone_number;
    private String address;
}
