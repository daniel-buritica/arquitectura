package co.com.umb.crowdfunding.arquitectura.infrastructure.driveradapter.customerpostgresql;

import co.com.umb.crowdfunding.arquitectura.domain.model.CustomerModel;
import co.com.umb.crowdfunding.arquitectura.domain.model.gateway.CustomerModelRepository;
import co.com.umb.crowdfunding.arquitectura.domain.model.gateway.ICrudModelRepositoryGeneric;
import co.com.umb.crowdfunding.arquitectura.infrastructure.driveradapter.customerpostgresql.helper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@RequiredArgsConstructor
@Component
public class CustomerAdapterImpl implements CustomerModelRepository {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public CustomerModel getById(int id) {
        return null;
    }

    @Override
    public CustomerModel create(CustomerModel customerModel) {
        var customerEntity = customerMapper.toEntity(customerModel);
        var customerData = customerRepository.save(customerEntity);
        return customerMapper.toModel(customerData);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<CustomerModel> getAll() {
        return null;
    }

    @Override
    public CustomerModel update(CustomerModel customerModel) {
        return null;
    }

    @Override
    public Boolean exitsCustomer(String email) {
        return customerRepository.existsCustomerByEmail(email);
    }
}
