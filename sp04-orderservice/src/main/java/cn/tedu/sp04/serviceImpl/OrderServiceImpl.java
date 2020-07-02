package cn.tedu.sp04.serviceImpl;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.OrderService;
import cn.tedu.sp04.feignclient.ItemFeignClient;
import cn.tedu.sp04.feignclient.UserFeignClient;
import cn.tedu.web.util.JsonResult;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
  // @Qualifier("")
   @Autowired
    private  ItemFeignClient itemClient;
    //@Qualifier("user-service")
    @Autowired
    private UserFeignClient userClient;
    @Override
    public Order getOrder(String orderId) {
        //TODO: 调用user-service获取用户信息
        JsonResult<User> user = userClient.getUser(7);
        //TODO: 调用item-service获取商品信息
        JsonResult<List<Item>> items = itemClient.getItems(orderId);

        Order order = new Order();
        order.setId(orderId);
        order.setUser(user.getData());
        order.setItems(items.getData());
        return order;
    }

    @Override
    public void addOrder(Order order) {
        //TODO: 调用item-service减少商品库存
        itemClient.decreaseNumber(order.getItems());
        //TODO: 调用user-service增加用户积分
        userClient.addScore(7, 100);

        log.info("保存订单："+order);
    }
}
