package co.com.umb.crowdfunding.arquitectura.domain.model.gateway;

import co.com.umb.crowdfunding.arquitectura.domain.model.CustomerModel;

import java.util.List;

public interface CustomerModelRepository {

    public CustomerModel getById(int id);
    public CustomerModel getByEmail(String email);
    public CustomerModel create(CustomerModel customerModel);
    public void delete(int id);
    public List<CustomerModel> getAll ();
    public CustomerModel update(CustomerModel customerModel);

    public Boolean exitsCustomer(String email);
}
