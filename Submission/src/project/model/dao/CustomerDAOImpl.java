package project.model.dao;

import project.model.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public int insertCustomer(CustomerDTO customer) {
        return 0;
    }

    @Override
    public CustomerDTO selectCustomerByID(String id) {
        return null;
    }

    @Override
    public int updateCustomer(CustomerDTO customer) {
        return 0;
    }

    @Override
    public int deleteCustomer(String id) {
        return 0;
    }

    @Override
    public int updateMileage(String id, int mileage) {
        return 0;
    }
}
