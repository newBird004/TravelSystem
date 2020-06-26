package cn.yy.controller;

import cn.yy.pojo.*;
import cn.yy.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ScenicService scenicService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RealNameService realNameService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTimeService roomTimeService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderItemService orderItemService;

    /*打开购物车页面*/
    @RequestMapping("/openBuyCartPage")
    public String openBuyCartPage(){
        return "buyCart";
    }

    /*根据页数查询到用户并返回给页面加载*/
    @RequestMapping("/loadCartList")
    @ResponseBody
    public Msg loadCartList(String travelUserId){

        List<Cart> carts = cartService.selectAll(travelUserId);

        System.out.println("///////////////////"+carts.size());
        List<CartMsg> cartMsgs=new ArrayList<>();

        for(Cart cart:carts){
            CartMsg cartMsg= new CartMsg();
            if(cart.getScenicId_FK_Cart()!=null){
                String scenicName = scenicService.selectScenicNameById(cart.getScenicId_FK_Cart());
                cartMsg.setGoodsName(scenicName);
                cartMsg.setStartDate(cart.getCartStartDate());
                cartMsg.setEndDate(cart.getCartStartDate());
                cartMsg.setGoodsPrice(cart.getCartPrice()+"");
                cartMsg.setRealName(realNameService.selectRealNameNameById(cart.getRealNameId_FK_Cart()));

                cartMsg.setCartEndDate(cart.getCartEndDate());
                cartMsg.setCartId(cart.getCartId());
                cartMsg.setCartPrice(cart.getCartPrice());
                cartMsg.setCartStartDate(cart.getCartStartDate());
                cartMsg.setHotelId_FK_Cart(cart.getHotelId_FK_Cart());
                cartMsg.setRealNameId_FK_Cart(cart.getRealNameId_FK_Cart());
                cartMsg.setRoomType(cart.getRoomType());

                cartMsgs.add(cartMsg);
            }else  if(cart.getHotelId_FK_Cart()!=null){
                String hotelName = hotelService.selectHotelNameByHotelId(cart.getHotelId_FK_Cart());
                cartMsg.setGoodsName(hotelName+"-"+cart.getRoomType());
                cartMsg.setStartDate(cart.getCartStartDate());
                cartMsg.setEndDate(cart.getCartEndDate());
                cartMsg.setGoodsPrice(cart.getCartPrice()+"");
                cartMsg.setRealName(realNameService.selectRealNameNameById(cart.getRealNameId_FK_Cart()));

                cartMsg.setCartEndDate(cart.getCartEndDate());
                cartMsg.setCartId(cart.getCartId());
                cartMsg.setCartPrice(cart.getCartPrice());
                cartMsg.setCartStartDate(cart.getCartStartDate());
                cartMsg.setHotelId_FK_Cart(cart.getHotelId_FK_Cart());
                cartMsg.setRealNameId_FK_Cart(cart.getRealNameId_FK_Cart());
                cartMsg.setRoomType(cart.getRoomType());

                cartMsgs.add(cartMsg);
            }
        }

        PageInfo pageInfo=new PageInfo(cartMsgs,5);//用pageinfo封装分页的信息。

        Msg msg=Msg.success();
        msg.add("cartMsgs",cartMsgs);
        return msg;
    }

    /*
     * 删除数据（删除单个数据和批量删除数据通用）
     * */
    @ResponseBody
    @RequestMapping(value="/cart/{ids}",method = RequestMethod.DELETE)
    public Msg deleteCartById(@PathVariable("ids")String ids){
        if(ids.contains("-")) {//批量删除
            List<Integer> deleteIdList=new ArrayList<Integer>();
            String[] deleteIds=ids.split("-");
            for(String s:deleteIds) {//遍历，将字符串转换为id的list集合
                Integer id = Integer.parseInt(s);
                deleteIdList.add(id);
            }
            try {
                cartService.deleteCartBatch(deleteIdList);//调用service层方法执行批量删除

            }catch (Exception e){
                e.printStackTrace();
                return Msg.fail();
            }
        }else {//单个删除
            try {
                cartService.deleteCartById(Integer.parseInt(ids));
            }catch (Exception e){
                e.printStackTrace();
                return Msg.fail();
            }

            return Msg.success();
        }
        return Msg.success();
    }


    /*根据勾选的商品计算价格*/
    @RequestMapping("/computeCheckedCartPrice")
    @ResponseBody
    public String computeCheckedCartPrice(String checkedIdStr){
        Integer price=0;
        String[] split = checkedIdStr.split("-");
        for(String s:split){
            Cart cart = cartService.selectById(Integer.parseInt(s));
            price=price+cart.getCartPrice();
        }
        return price+"";
    }

    /*根据勾选的商品计算价格*/
    @RequestMapping("/computeAllCheckedCartPrice")
    @ResponseBody
    public String computeAllCheckedCartPrice(String travelUserId){
        Integer price=0;

        List<Cart> carts = cartService.selectAll(travelUserId);
        for(Cart c:carts){
            price=price+c.getCartPrice();
        }
        return price+"";
    }

    /*根据传过来的购物车id查看是景点还是酒店，反馈给页面*/
    @RequestMapping("/selectCartMsgById")
    @ResponseBody
    public Msg selectCartMsgById(String cartId){
        Msg msg = Msg.success();
        Cart cart = cartService.selectById(Integer.parseInt(cartId));
        if(cart.getScenicId_FK_Cart()!=null){//如果不是景区信息
            msg.add("goodsType",1);//景点信息，0代表这是景点信息，应该打开景点信息的模态修改框
        }else {
            msg.add("goodsType",0);//那么就是酒店信息了，1代表这是酒店信息，应该打开酒店信息的模态修改框
        }
        msg.add("cart",cart);
        return msg;
    }

    /*根据购物车记录查询酒店id然后查询对应的房间类型*/
    @RequestMapping("/selectRoomTypeByCartId")
    @ResponseBody
    public Msg selectRoomTypeByCartId(String cartId){
        Msg msg = Msg.success();
        List<String> roomTypes=new ArrayList<>();
        Cart cart = cartService.selectById(Integer.parseInt(cartId));
        if(cart.getHotelId_FK_Cart()!=null){
            Integer hotelId=cart.getHotelId_FK_Cart();
            roomTypes= roomService.selectRoomTypeByHotelId(hotelId);
        }
        msg.add("roomTypes",roomTypes);
        return msg;
    }


    /*进行购物车中酒店类型商品的更新*/
    @RequestMapping(value = "/cartHotel/{cartId}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateCartHotel(Cart cart,String date){
        Msg msg = Msg.success();
        String[] split = date.split("-");
        String startDate=split[0];
        String endDate=split[1];

        /*根据入住时间计算价格*/
        Date date1=new Date();
        Date date2=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        try {
            date1 = sdf.parse(startDate);
            date2 = sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long dateTime1 = date1.getTime();
        long dateTime2 = date2.getTime();
        long dayTime=dateTime2-dateTime1;
        int day= (int) (dayTime/(24*60*60*1000));

        Cart cart1 = cartService.selectById(cart.getCartId());//这里需要注意，为什么需要再去查找一下呢？因为我们参数中写的这个cart中只有一些要更新的数据，像日期，房型，入住人等。没有我们需要用到的酒店编号信息。
        List<Room> rooms = roomService.selectRoomByHotelIdAndRoomType(cart1.getHotelId_FK_Cart(), cart.getRoomType());//注意其中一个是cart，一个是cart1.不能一样！！！
        Integer oneDayPrice=0;
        if(rooms!=null){
            oneDayPrice=rooms.get(0).getRoomPrice();
        }
        int price=day*oneDayPrice;


        cart.setCartStartDate(startDate);
        cart.setCartEndDate(endDate);
        cart.setCartPrice(price);
        cartService.updateCart(cart);
        return msg;
    }

    /*进行购物车中景点类型商品的更新*/
    @RequestMapping(value = "/cartScenic/{cartId}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateCartScenic(Cart cart){
        System.out.println(cart+"==================");
        Msg msg = Msg.success();
        cartService.updateCart(cart);
        return msg;
    }

    /*根据购物车id查询酒店id*/
    @RequestMapping(value = "/selectHotelIdByCartId",method = RequestMethod.POST)
    @ResponseBody
    public String selectHotelIdByCartId(String cartId){

        Cart cart = cartService.selectById(Integer.parseInt(cartId));
        if(cart.getHotelId_FK_Cart()!=null){
            return cart.getHotelId_FK_Cart()+"";
        }else {
            return null;
        }

    }

    /*购买购物车中的商品*/
    @RequestMapping(value = "/cartToPay",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String cartToPay(String checkedIdStr, HttpServletRequest request){

        String result=cartService.cartToPay(checkedIdStr,request);
        return result;
    }


    /*跳转到支付购物车的页面*/
    @RequestMapping(value = "/openPayCartPage")
    public String openPayCartPage(){
        return "payCart";
    }

    /*支付完成*/
    @RequestMapping(value = "/changeCartOrderToPaied")
    public String changeCartOrderToPaied(String orderIds){
        cartService.changeCartOrderToPaied(orderIds);
        return "redirect:/";
    }

}
