package kz.ticket.back.customer;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository
                .findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()) {
            throw new IllegalStateException("email is taken");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerID) {
        boolean exists = customerRepository.existsById(customerID);
        if (!exists) {
            throw new IllegalStateException(
                    "customer with id " + customerID + " does not exist");
        }
        customerRepository.deleteById(customerID);
    }

    @Transactional
    public void updateCustomer(Long customerID,
                               String name,
                               String email,
                               String password,
                               Double ballance) {
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new IllegalStateException(
                        "customer with id " + customerID + " does not exist"));
        if ((name != null) &&
                (name.length() > 0) &&
                !Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }

        if ((email != null) &&
                (email.length() > 0) &&
                !Objects.equals(customer.getEmail(), email)) {
            Optional<Customer> customerOptional = customerRepository
                    .findCustomerByEmail(email);
            if (customerOptional.isPresent()) {
                throw new IllegalStateException("email is taken");
            }
            customer.setEmail(email);
        }

        if ((password != null) &&
                (password.length() > 0) &&
                !Objects.equals(customer.getPassword(), password)) {
            customer.setPassword(password);
        }

        if ((ballance != null) &&
                (ballance > 0) &&
        !Objects.equals(customer.getBalance(), ballance)) {
            customer.setBalance(ballance);
        }
    }
}
