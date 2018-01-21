package lyons.entity;

import java.util.Date;

/**
 * 订单实体类
 *
 * @author Lyons(zhanglei)
 * @version [版本号, 2016 6 3]
 * @since [应用/版本]
 */

public class OrderForm {
    private int id;
    private String username;
    private Date orderDate;
    private String commodityName;
    private double commodityPrice;
    private int sum;

    public OrderForm() {
    }

    public OrderForm(int id, String username, Date orderDate, String commodityName, double commodityPrice, int sum) {
        this.id = id;
        this.username = username;
        this.orderDate = orderDate;
        this.commodityName = commodityName;
        this.commodityPrice = commodityPrice;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", orderDate=" + orderDate +
                ", commodityName='" + commodityName + '\'' +
                ", commodityPrice=" + commodityPrice +
                ", sum=" + sum +
                '}';
    }
}
