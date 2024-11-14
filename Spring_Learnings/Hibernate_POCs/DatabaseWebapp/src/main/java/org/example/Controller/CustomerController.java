package org.example.Controller;

import org.example.Entity.Customer;
import org.example.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> theCustomers = customerService.getCustomers();
        model.addAttribute("customers", theCustomers);
        return "ListCustomers";
    }

    @GetMapping("/showFormForAdd")
    public String ShowFormForAdd(Model model) {
        Customer theCustomer = new Customer();  // Empty customer for adding
        model.addAttribute("customer", theCustomer);
        return "CustomerForm";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
        Customer theCustomer = customerService.getCustomer(theId);
        model.addAttribute("customer", theCustomer);
        return "CustomerForm";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
}
