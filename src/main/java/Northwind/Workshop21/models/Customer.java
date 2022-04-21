package Northwind.Workshop21.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Customer {
    private String first_name;
    private String last_name;
    private String email_address;
    private String job_title;
    private String mobile_phone;
    private String city;
    private String country_region;
    private String address;

    public String getEmail_address() {
        return email_address;
    }
    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
    public String getJob_title() {
        return job_title;
    }
    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
    public String getMobile_phone() {
        return mobile_phone;
    }
    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry_region() {
        return country_region;
    }
    public void setCountry_region(String country_region) {
        this.country_region = country_region;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public static Customer create(SqlRowSet rs){

        Customer customer = new Customer();
        customer.setFirst_name(rs.getString("first_name"));
        customer.setLast_name(rs.getString("last_name"));
        return customer;
    } 

    public static Customer createCustomerDetails(SqlRowSet rs){

        Customer customer = new Customer();
        customer.setFirst_name(rs.getString("first_name"));
        customer.setLast_name(rs.getString("last_name"));
        customer.setEmail_address(rs.getString("email_address"));
        customer.setJob_title(rs.getString("job_title"));
        customer.setMobile_phone(rs.getString("mobile_phone"));
        customer.setAddress(rs.getString("address"));
        customer.setCity(rs.getString("city"));
        customer.setCountry_region(rs.getString("country_region"));
        return customer;
    }

    

}
