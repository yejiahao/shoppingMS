package lyons.dao;

import lyons.order.entity.Order;

import java.util.List;

/**
 * Order.xml 对应的接口
 *
 * @author lyons(zhanglei)
 */
public interface OrderDao {
    /**
     * 查询全部订单
     **/
    List<Order> queryOrderAllList();

    /**
     * 查询订单 By 用户名
     **/
    List<Order> queryOrderListByuserName(String useName);

    /**
     * 查询（关键字||用户名）or（关键字&&用户名）
     **/
    List<Order> queryOrderByKeyName(Order order);

    /**
     * 删除单条 By id
     **/
    void deleteOrderOneById(int id);

    /**
     * 删除批量 By id
     **/
    void deleteOrderBatch(List<Integer> ids);

    /**
     * 批量插入数据
     **/
    void insertOrderBatch(List<Order> listOrder);
}
