package TechnicalSupport.TechnicalSupport.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Summary {

    @Id
    @GeneratedValue
    private Long id;


    private String site_name;
    private String employee_name;
    private String phone_number;
    private String address;

    //Geospace 버전 정보
    private String Geospace_Version;

    //Lcoator정보
    private String Locator_name;
    private String Locator_firmware;

    //tag 정보
    private String Tag_name;
    private String Tag_Period;


}
