package co.com.umb.crowdfunding.arquitectura.infrastructure.driveradapter.customerpostgresql.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ECountry {

    Colombia(1,"001", "colombia"),
    Brasil(2,"002","Brasi");


    private int id;
    private String iso;
    private String country;
}
