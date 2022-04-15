package com.example.springboottutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BoardRepository boardRepository;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last) {
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }

    @GetMapping("/testclick")
    public Board getTestCust() {
        Board board = new Board();
        board.setFirstName("5,5,5,5,5,5");
        board.setLastName("5,5,5,5,5,5");
        boardRepository.save(board);
        return board;
    }
}