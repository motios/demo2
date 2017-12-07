package momah.api;

import momah.dao.Customer;
import momah.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomersController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView index(){
        Map<String, String> model = new HashMap<>();
        if(customerService.dataIsEmpty()){
            addStaticData();
        }

        Customer cust = null;
        for (Customer customer: customerService.getAll()){
            //model.put(customer.getFirstName()+" " +customer.getLastname(), customer);
            cust=customer;
        }
        model.put("name", "Moti");
        return  new ModelAndView("customer", model);
    }

    private void addStaticData(){
        customerService.create(new Customer("test1@gmail.com","first1","last1",25));
        customerService.create(new Customer("test2@gmail.com","first2","last2",36));
        customerService.create(new Customer("test3@gmail.com","first3","last3",47));
    }
}
