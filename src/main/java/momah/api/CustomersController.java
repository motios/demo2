package momah.api;

import momah.dao.Customer;
import momah.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
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
        model.put("name", "moti");
        return  new ModelAndView("index", model);
    }

    private void addStaticData(){
        customerService.create(new Customer("test1@gmail.com","first1","last1",25));
        customerService.create(new Customer("test2@gmail.com","first2","last2",26));
    }
}
