package kz.ticket.back.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping(path = "{customerID}")
    public void deleteCustomer(
            @PathVariable("customerID") Long customerID) {
        customerService.deleteCustomer(customerID);
    }

    @PutMapping(path = "{customerID}")
    public void updateCustomer(
            @PathVariable("customerID") Long customerID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) Double balance) {
        customerService.updateCustomer(customerID, name, email, password, balance);
    }

}
