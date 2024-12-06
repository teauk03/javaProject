package bankProject.customer;
import bankProject.customer.customerDTO;

import java.util.*;
public interface customerDAO {
    void addCustomer(customerDTO customer);
    customerDTO getCustomer(String customerNumber);
    List<customerDTO> getAllcustome();
    void delectCustomer(String customerNumber);
}