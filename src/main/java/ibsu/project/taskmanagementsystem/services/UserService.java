package ibsu.project.taskmanagementsystem.services;

import ibsu.project.taskmanagementsystem.entities.User;
import ibsu.project.taskmanagementsystem.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private AddressService addressService;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("RECORD_NOT_FOUND"));
    }

//    @Transactional
//    public User add(AddCustomer addCustomer) throws Exception {
//        Customer customer = new Customer();
//        customer.setCreateDate(new Date());
////        customer.setFirstName(addCustomer.getFirstName());
////        customer.setLastName(addCustomer.getLastName());
////        customer.setMiddleName(addCustomer.getMiddleName());
////        customer.setActive(addCustomer.getActive());
//        GeneralUtil.getCopyOf(addCustomer, customer);
//
//        Address address = addressService.getById(addCustomer.getAddressId());
//
//        customer.setAddress(address);
//        return customerRepository.save(customer);
//    }

}
