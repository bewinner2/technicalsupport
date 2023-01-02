package TechnicalSupport.TechnicalSupport.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Site {

    @Id @GeneratedValue
    @Column(name="site_id")
    private Long id;


    @NotEmpty    //javax validation
    private String site_name;
    private String employee_name;
    private String phone_number;
    private String address;


    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="version_locator_tag_id")
    private version_locator_tag version_locator_tag;



}
