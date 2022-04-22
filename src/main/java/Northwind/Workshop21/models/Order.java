package Northwind.Workshop21.models;

import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {

    private Integer customer_id;
    private Integer shipper_id;
    private String ship_name;
    private String ship_address;
    private Double shipping_fee;
    private String payment_type;
    private Date ship_date;
    private Date order_date;

    public Date getShip_date() {
        return ship_date;
    }
    public void setShip_date(Date ship_date) {
        this.ship_date = ship_date;
    }
    public Date getOrder_date() {
        return order_date;
    }
    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }
    public Integer getShipper_id() {
        return shipper_id;
    }
    public void setShipper_id(Integer shipper_id) {
        this.shipper_id = shipper_id;
    }
    public String getShip_name() {
        return ship_name;
    }
    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }
    public String getShip_address() {
        return ship_address;
    }
    public void setShip_address(String ship_address) {
        this.ship_address = ship_address;
    }
    public Double getShipping_fee() {
        return shipping_fee;
    }
    public void setShipping_fee(Double shipping_fee) {
        this.shipping_fee = shipping_fee;
    }
    public String getPayment_type() {
        return payment_type;
    }
    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public static Order create(SqlRowSet rs){

        Order order = new Order();
        order.setCustomer_id(rs.getInt("customer_id"));
        order.setShipper_id(rs.getInt("shipper_id"));
        order.setShip_name(rs.getString("ship_name"));
        order.setShip_address(rs.getString("ship_address"));
        order.setShipping_fee(rs.getDouble("shipping_fee"));
        order.setPayment_type(rs.getString("payment_type"));
        order.setOrder_date(rs.getDate("cast(order_date as date)"));
        order.setShip_date(rs.getDate("cast(shipped_date as date)"));

        return order;
    } 



}
