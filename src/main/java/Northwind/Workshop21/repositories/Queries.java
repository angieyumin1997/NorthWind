package Northwind.Workshop21.repositories;

public interface Queries {
    public static final String SQL_SELECT_ALL_CUSTOMERS = 
    "select first_name,last_name from customers";

    public static final String SQL_SELECT_CUSTOMER_DETAILS = 
    "select first_name,last_name,email_address,job_title,mobile_phone,city,country_region,address from customers where id=?";

    public static final String SQL_SELECT_ORDER_DETAILS =
    "select customer_id,order_date,shipped_date,shipper_id,ship_name,ship_address,shipping_fee,payment_type from orders where customer_id=?";
}
