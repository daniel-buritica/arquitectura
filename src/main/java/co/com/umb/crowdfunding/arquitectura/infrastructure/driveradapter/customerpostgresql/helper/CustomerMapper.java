package co.com.umb.crowdfunding.arquitectura.infrastructure.driveradapter.customerpostgresql.helper;

import co.com.umb.crowdfunding.arquitectura.domain.model.*;
import co.com.umb.crowdfunding.arquitectura.infrastructure.driveradapter.customerpostgresql.Customer;
import co.com.umb.crowdfunding.arquitectura.infrastructure.driveradapter.helper.MapperGeneric;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomerMapper implements MapperGeneric<Customer, CustomerModel> {

    @Override
    public Customer toEntity(CustomerModel model) {
        return Customer.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .secondName(model.getSecondName())
                .firstSurname(model.getFirstSurname())
                .idTypeIdCard(model.getTypeIdCardModel().getId())
                .idCard(model.getIdCard())
                .email(model.getEmail())
                .idCity(model.getCityModel().getId())
                .phone(model.getPhone())
                .idRol(model.getRolModel().getId())
                .dateBirth(model.getDateBirth())
                .idStatus(model.getStatusModel().getId())
                .build();
    }

    @Override
    public CustomerModel toModel(Customer entity) {
        return CustomerModel.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .secondName(entity.getSecondName())
                .firstSurname(entity.getFirstSurname())
                .typeIdCardModel(buildTypeIdCard(entity.getIdTypeIdCard()))
                .idCard(entity.getIdCard())
                .email(entity.getEmail())
                .cityModel(buildCityModel(entity.getIdCity()))
                .phone(entity.getPhone())
                .rolModel(buildRolModel(entity.getIdRol()))
                .dateBirth(entity.getDateBirth())
                .statusModel(buildStatusModel(entity.getIdStatus()))
                .build();
    }

    private TypeIdCardModel buildTypeIdCard(int id){
        ETypeCard [] allType = ETypeCard.values();
        var type = Arrays.stream(allType).filter(eTypeCard -> eTypeCard.getId() == id)
                .findFirst().get().getType();
        return TypeIdCardModel.builder()
                .id(id)
                .type(type)
                .build();
    }
    private CityModel buildCityModel(int id){
        ECity [] allCity = ECity.values();
        var city = Arrays.stream(allCity).filter(eTypeCard -> eTypeCard.getId() == id)
                .findFirst().get().getCity();
        return CityModel.builder()
                .id(id)
                .countryModel(buildCountryModel(id))
                .city(city)
                .build();
    }
    private CountryModel buildCountryModel(int id){
        ECountry [] allCountry = ECountry.values();
        var iso = Arrays.stream(allCountry).filter(eTypeCard -> eTypeCard.getId() == id)
                .findFirst().get().getIso();
        var country = Arrays.stream(allCountry).filter(eTypeCard -> eTypeCard.getId() == id)
                .findFirst().get().getCountry();
        return CountryModel.builder()
                .id(id)
                .iso(iso)
                .country(country)
                .indicatorCountryModel(buildIndicatorCountryModel(id))
                .build();
    }

    private IndicatorCountryModel buildIndicatorCountryModel(int id){
        EIndicatorCountry [] allIndicator = EIndicatorCountry.values();
        var indicator = Arrays.stream(allIndicator).filter(eTypeCard -> eTypeCard.getId() == id)
                .findFirst().get().getIndicator();
        return IndicatorCountryModel.builder()
                .id(id)
                .indicator(indicator)
                .build();
    }

    private RolModel buildRolModel(int id){
        ERol [] allRol = ERol.values();
        var rol = Arrays.stream(allRol).filter(eTypeCard -> eTypeCard.getId() == id)
                .findFirst().get().getRol();
        return RolModel.builder()
                .id(id)
                .rol(rol)
                .build();
    }

    private StatusModel buildStatusModel(int id){
        EStatus [] allStatus = EStatus.values();
        var status = Arrays.stream(allStatus).filter(eTypeCard -> eTypeCard.getId() == id)
                .findFirst().get().getStatus();
        return StatusModel.builder()
                .id(id)
                .status(status)
                .build();
    }

}
