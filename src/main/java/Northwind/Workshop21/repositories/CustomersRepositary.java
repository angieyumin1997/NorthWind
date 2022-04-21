package Northwind.Workshop21.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import Northwind.Workshop21.models.Customer;
import Northwind.Workshop21.models.Order;

@Repository
public class CustomersRepositary implements Queries{
    @Autowired
    private JdbcTemplate template;
    
    public List<Customer> getAllCustomers(){
        final List<Customer> customers = new LinkedList<>();

        final SqlRowSet result = template.queryForRowSet(SQL_SELECT_ALL_CUSTOMERS);

        while (result.next()){
            Customer customer = Customer.create(result);
            customers.add(customer);
        }

        return customers;
    }

    public Customer getCustomerDetails(Integer id){
        final SqlRowSet result= template.queryForRowSet(SQL_SELECT_CUSTOMER_DETAILS,id);
        Customer customer=new Customer();
        while (result.next()){
            customer = Customer.createCustomerDetails(result);
        }
        return customer;
    }

    public List<Order> getOrderDetails(Integer id){
        final List<Order> orders = new LinkedList<>();
        final SqlRowSet result= template.queryForRowSet(SQL_SELECT_ORDER_DETAILS,id);
        Order order=new Order();
        while (result.next()){
            order = Order.create(result);
            orders.add(order);
        }
        return orders;
    }
}
