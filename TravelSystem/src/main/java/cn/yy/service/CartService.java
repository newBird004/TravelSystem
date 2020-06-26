package cn.yy.service;


import cn.yy.pojo.Cart;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CartService {

    public Cart selectById(Integer id);

    public void insertCart(Cart cart);

    public List<Cart> selectAll(String travelUserId);

    public void updateCart(Cart cart);

    public void deleteCartById(Integer id);

    public void deleteCartBatch(List<Integer> idList);

    public String cartToPay(String checkedIdStr, HttpServletRequest request);

    public void changeCartOrderToPaied(String orderIds);

}
