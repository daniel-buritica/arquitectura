package co.com.umb.crowdfunding.arquitectura.infrastructure.entrypoints.customerservices;

import co.com.umb.crowdfunding.arquitectura.domain.model.CustomerModel;
import co.com.umb.crowdfunding.arquitectura.domain.usecase.CustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/crowdfunding")
@AllArgsConstructor
public class CustomerService {

    private final CustomerUseCase customerUseCase;


    @PostMapping("/customer/create")
    public CustomerModel create(@RequestBody CustomerModel customerModel){
        return customerUseCase.create(customerModel);
    }

    @GetMapping("/customer/exists/{email}")
    public Boolean existsCustomer(@PathVariable String email){
        return customerUseCase.exitsCustomer(email);
    }

    @GetMapping("/customer/findByEmail/{email}")
    public CustomerModel findByEmail(@PathVariable String email){
        return customerUseCase.getByEmail(email);
    }

}
