package momah.dao;

import momah.Utils.OrderHelperValidator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Order implements IEntity{
    @Id
    @GeneratedValue
    private long orderId;
    private LocalDateTime date;

   // @OneToMany
   // @Column(name ="customerId")
    private long customerId;

    private String productDescroption;
    private double price;
    private int quantity;

    public Order(){init();};

    @Override
    public void init() {
        setDate(LocalDateTime.now());
        setProductDescroption("");
        setCustomerId(OrderHelperValidator.CUSTOMER_ID_DEFAULT);
        setPrice(OrderHelperValidator.PRICE_DEFAULT);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getProductDescroption() {
        return productDescroption;
    }

    public void setProductDescroption(String productDescroption) {
        this.productDescroption = productDescroption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (customerId != order.customerId) return false;
        if (Double.compare(order.price, price) != 0) return false;
        if (quantity != order.quantity) return false;
        if (!date.equals(order.date)) return false;
        return productDescroption.equals(order.productDescroption);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date.hashCode();
        result = 31 * result + (int) (customerId ^ (customerId >>> 32));
        result = 31 * result + productDescroption.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        return result;
    }
}
