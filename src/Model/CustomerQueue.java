package Model;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    private Queue<Customer> customerQueue;

    // Constructor
    public CustomerQueue() {
        customerQueue = new LinkedList<>();
    }

    // Add a new customer to the queue
    public void addNewCustomer(Customer customer) {
        customerQueue.add(customer);
        System.out.println("Customer added to the queue: " + customer.getName());
    }

    // Remove the next customer from the queue
    public Customer removeCustomer() {
        if (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.poll();
            System.out.println("Customer removed from the queue: " + customer.getName());
            return customer;
        }
        System.out.println("No customers in the queue!");
        return null;
    }

    // Call the next customer in the queue
    public Customer callNextCustomer() {
        if (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.peek();
            System.out.println("Calling next customer: " + customer.getName());
            return customer;
        }
        System.out.println("No customers in the queue!");
        return null;
    }
}
