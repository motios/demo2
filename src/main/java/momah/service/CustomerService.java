package momah.service;

import momah.Utils.CustomerHelperValidator;
import momah.Utils.ResponseResolve;
import momah.dao.Customer;
import momah.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService  {
    @Autowired
    CustomerRepository customerRepository;

    public Iterable<Customer> getAll(){
        return customerRepository.findAll();
    }

    public ResponseResolve create(Customer customer){
        ResponseResolve responseResolve;
        try {
            responseResolve= CustomerHelperValidator.customerValidation(customer);
            //check if all is ok(no description and status 200)
            if(responseResolve.getDescroption().equals("") && responseResolve.getCode()== HttpStatus.OK.value()){
                customerRepository.save(customer);
            }
            return responseResolve;
        }
        catch (Exception e){
            responseResolve = new ResponseResolve();
            responseResolve.setDescroption(HttpStatus.INTERNAL_SERVER_ERROR + ". " + e.getMessage());
            responseResolve.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return responseResolve;
        }

    }

    public boolean dataIsEmpty(){
        return ((List<Customer>) customerRepository.findAll()).size()==0;
    }


}
