package Northwind.Workshop21.controllers;


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Northwind.Workshop21.models.Customer;
import Northwind.Workshop21.models.Order;
import Northwind.Workshop21.repositories.CustomersRepositary;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

@RestController
@RequestMapping(path="/api")
public class CustomersRestController {

    @Autowired
    private CustomersRepositary customersRepositary;
    
    @GetMapping(path="/customers", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllCustomers(Model model){
        
        List<Customer> customers = new LinkedList<>();
        customers = customersRepositary.getAllCustomers();

        JsonObjectBuilder builder = Json.createObjectBuilder();
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        System.out.printf("++++++ Customerlists: %s\n", customers);
        for(Customer c: customers){
            builder.add("first_name",c.getFirst_name())
            .add("last_name",c.getLast_name());
            arrBuilder.add(builder.build());
        }

        return ResponseEntity.ok(arrBuilder.build().toString());
    }

    @GetMapping(path="customer/{customer_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomerDetails(@PathVariable(name="customer_id",required=true) Integer id){
        System.out.printf("++++++ CUSTOMERID: %d\n", id);
        JsonObjectBuilder builder = Json.createObjectBuilder();
        Customer customer = customersRepositary.getCustomerDetails(id);
        builder.add("first_name",customer.getFirst_name());
        builder.add("last_name",customer.getLast_name());
        // builder.add("email",customer.getEmail_address());
        builder.add("jobtitle",customer.getJob_title());
        builder.add("address",customer.getAddress());
        builder.add("city",customer.getCity());
        builder.add("countryregion",customer.getCountry_region());
        
        return ResponseEntity.ok(builder.build().toString());
    }

    @GetMapping(path="/customer/{customer_id}/orders", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getOrders(
        @PathVariable(name="customer_id",required=true) Integer id,
        Model model){
        
        List<Order> orders = new LinkedList<>();
        orders = customersRepositary.getOrderDetails(id);

        JsonObjectBuilder builder = Json.createObjectBuilder();
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        System.out.printf("++++++ Customerlists: %s\n", orders);
        for(Order o: orders){
            builder
            .add("customer_id",(o.getCustomer_id()== null) ? "" : o.getCustomer_id().toString())
            .add("shipper_id",(o.getShipper_id()== null) ? "" : o.getShipper_id().toString())
            .add("ship_name",(o.getShip_name()== null) ? "" : o.getShip_name())
            .add("ship_address",(o.getShip_address() == null) ? "" : o.getShip_address())
            .add("shipping_fee",(o.getShipping_fee()== null) ? "" : o.getShipping_fee().toString())
            .add("payment_type",(o.getPayment_type()== null) ? "" : o.getPayment_type().toString());
            arrBuilder.add(builder.build());
        }

        return ResponseEntity.ok(arrBuilder.build().toString());
    }
    
}
