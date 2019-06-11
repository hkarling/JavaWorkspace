package project.model.dao;

import project.model.dto.CustomerDTO;

public interface CustomerDAO {

    /**
     * 고객등록.
     * insert into customer (id, name, phone, mileage) values (?, ?, ?, ?)
     */
    int insertCustomer(CustomerDTO customer);

    /**
     * id를 통한 고객 검색
     * select customer where id = ?
     */
    CustomerDTO selectCustomerByID(String id);

    /**
     * 이름, 핸드폰 번호 수정
     * update customer set name = ?, phone = ? where id = ?
     */
    int updateCustomer(CustomerDTO customer);

    /**
     * 고객 삭제
     * delete customer where id = ?
     */
    int deleteCustomer(String id);

    /**
     * 마일리지 수정
     * update customer set mileage = ? where id = ?
     */
    int updateMileage(String id, int mileage);
}
