package co.com.umb.crowdfunding.arquitectura.domain.usecase;

import co.com.umb.crowdfunding.arquitectura.domain.model.CustomerModel;
import co.com.umb.crowdfunding.arquitectura.domain.model.gateway.CustomerModelRepository;
import co.com.umb.crowdfunding.arquitectura.domain.model.gateway.ICrudModelRepositoryGeneric;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CustomerUseCase {

    private CustomerModelRepository customerModelRepository;

    public CustomerModel getById(int id){
        return customerModelRepository.getById(id);
    }

    public CustomerModel create(CustomerModel customerModel){
        return customerModelRepository.create(customerModel);
    };

    public CustomerModel update(CustomerModel customerModel){
        return customerModelRepository.create(customerModel);
    };

    public List<CustomerModel> getAll(){
        return customerModelRepository.getAll();
    }

    public void delete(int id){
    }

    public Boolean exitsCustomer(String email){
        return customerModelRepository.exitsCustomer(email);
    }
}
