package TechnicalSupport.TechnicalSupport.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class version_locator_tag {

    @Id
    @GeneratedValue
    @Column(name="version_locator_tag_id")
    private Long id;

    //Geospace 버전 정보
    private String Geospace_Version;

   //Lcoator정보
    private String Locator_name;
    private String Locator_firmware;

   //tag 정보
    private String Tag_name;
    private String Tag_Period;


    @OneToMany(mappedBy = "version_locator_tag")
    private List<Site> sites=new ArrayList<>();


}
