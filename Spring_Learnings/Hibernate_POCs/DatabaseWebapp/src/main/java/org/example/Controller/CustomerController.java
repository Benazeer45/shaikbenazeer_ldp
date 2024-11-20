package org.example.Controller;

import org.example.Entity.Customer;
import org.example.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String showFormForAdd(Model model) {
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
    public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model, RedirectAttributes redirectAttributes) {
        try {
            Customer theCustomer = customerService.getCustomer(customerId);
            model.addAttribute("customer", theCustomer);
            return "CustomerForm";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Customer ID " + customerId + " not found.");
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId, RedirectAttributes redirectAttributes) {
        try {
            customerService.deleteCustomer(customerId);
            return "redirect:/customer/list";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Customer ID " + customerId + " could not be deleted.");
            return "redirect:/customer/list";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "errorPage";  
    }
}
