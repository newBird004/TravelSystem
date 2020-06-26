package cn.yy.controller;

import cn.yy.pojo.Msg;
import cn.yy.pojo.Orders;
import cn.yy.pojo.RealName;
import cn.yy.pojo.TravelUser;
import cn.yy.service.OrderItemService;
import cn.yy.service.OrdersService;
import cn.yy.service.RealNameService;
import cn.yy.service.TravelUserService;
import cn.yy.util.CookieUtil;
import cn.yy.util.MD5Utils;
import cn.yy.util.MailUtils;
import cn.yy.vo.OrderItemCustom;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Controller
public class TravelUserController {

    @Autowired
    private TravelUserService travelUserService;

    @Autowired
    private RealNameService realNameService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/loginPage")
    public String openLoginPage(){
        return "login";//跳转到WEB-INF下的登陆页面
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String userName, String password, String rememberUserAndPwd, String autoLogin,
                        Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session) throws UnsupportedEncodingException {
        String md5Password = MD5Utils.getMD5(password);
        TravelUser travelUser = travelUserService.selectByUserNameAndPassword(userName, md5Password);
        if(travelUser==null){

            model.addAttribute("loginMsg","0");
            return "loginFail";//告诉页面，登陆失败
        }else{//查询到该用户，登录成功

            session.setAttribute("travelUser",travelUser);//不管是谁，登陆上了就需要保存到session中
                if("true".equals(rememberUserAndPwd)) {//如果勾选了保存密码，将信息封装到cookie中
                    try {
                        CookieUtil.addCookie("rememberUser", ""+URLEncoder.encode(userName,"utf-8")+"",request,response);
                        CookieUtil.addCookie("rememberPwd", password,request,response);
                    } catch (UnsupportedEncodingException e){
                        e.printStackTrace();
                    }
                }else {//如果没有勾选记住密码，需要重新设置一下cookie中的值，使得账号和密码为空。否则cookie中一直有值，勾选不勾选记住密码就没效果了
                    CookieUtil.addCookie("rememberUser", "",request,response);
                    CookieUtil.addCookie("rememberPwd", "",request,response);
                }
                if("true".equals(autoLogin)) {
                    CookieUtil.addCookie("autoLoginUserinfo", ""+URLEncoder.encode(userName,"utf-8")+""+"#"+md5Password,request,response);
                }

                if(travelUser.getRole()==0){ //如果是一个普通用户
                    return "commonUserLoginSuccess";
                }else if(travelUser.getRole()==1){
                    return "managerLoginSuccess";
                }
            }
        return "loginSuccess";
    }

    @RequestMapping("/logout")
    public String logout( HttpServletRequest request, HttpServletResponse response,HttpSession session){
        session.removeAttribute("travelUser");
        CookieUtil.addCookie("autoLoginUserinfo","",request,response);
        return "redirect:/index.jsp";
    }

    @RequestMapping("/TravelManagerSystem")
    public String TravelSystemManager(){
        return "travelManagerSystem";
    }

    @RequestMapping("/registerPage")
    public String openRegisterPage(){
        return "register";
    }

    @RequestMapping("/checkNameReapt")
    @ResponseBody
    public String checkNameReapt(String name){//检查用户名是否重复
        String regex="(^[a-zA-Z0-9_-]{4,16}$)|(^[\\u2E80-\\u9FFF]{1,5})";

        TravelUser travelUser = travelUserService.selectByUserName(name);
        if(travelUser!=null){
            return "1";
        }
        if(!name.matches(regex)) {
            return "2";// 用户名必须为4~16字母的组合或者1~5个汉字
        }
        return "0";
    }

//    检查邮箱是否被注册过
    @RequestMapping("/checkEmailReapt")
    @ResponseBody
    public String checkEmailReapt(String email){//检查用户名是否重复
        TravelUser travelUser = travelUserService.selectByEmail(email);
        if(travelUser!=null){
            return "1";
        }
        return "0";
    }


    @RequestMapping("/register")//注册程序
    public String registerTravelUser(TravelUser travelUser){

        String password = travelUser.getPassword();
        String md5Password = MD5Utils.getMD5(password);
        travelUser.setPassword(md5Password);

        travelUser.setRole(0);
        travelUser.setTravelUserExist(1);//设置为存在状态
        travelUserService.insertTravelUser(travelUser);
        return "redirect:/index.jsp";
    }

    /*跳转到用户列表jsp页面*/
    @RequestMapping("/openTravelUserListPage")
    public String openTravelUserListPage(){
        return "travelUserList";
    }

    /*根据页数查询到用户并返回给页面加载*/
    @RequestMapping("/loadTravelUserList")
    @ResponseBody
    public Msg loadTravelUserList(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum){

        PageHelper.startPage(pageNum,10);//设置分页的数据。第一个参数指的是当前页，第二个参数是每页有多少条数据

        List<TravelUser> travelUsers = travelUserService.selectAll();//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询

        PageInfo pageInfo=new PageInfo(travelUsers,5);//用pageinfo封装分页的信息。

        Msg msg=Msg.success();
        msg.add("pageInfo",pageInfo);
        return msg;
    }

    /*保存用户*/
    @RequestMapping(value = "/travelUser",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveUser(@Valid TravelUser travelUser, BindingResult result){
        if(result.hasErrors()) {//JSR303校验失败
            Map<String,Object> map=new HashMap<String, Object>();
            List<FieldError> errors=result.getFieldErrors();
            for(FieldError error:errors) {
                map.put(error.getField(),error.getDefaultMessage());
            }
            return Msg.fail().add("errorMap",map);
        }else {
            //        加密密码
            String password = travelUser.getPassword();
            String md5 = MD5Utils.getMD5(password);
            travelUser.setPassword(md5);
            //        保存
            travelUser.setTravelUserExist(1);//设置为存在
            travelUserService.insertTravelUser(travelUser);
            Msg msg=Msg.success();
            return msg;
        }
    }

    /*
     * 根据id查询数据，并返回给页面。进行数据回显。
     * */
    @RequestMapping(value = "/travelUser/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getMsgById(@PathVariable("id")Integer id){
        TravelUser travelUser = travelUserService.selectById(id);
        Msg msg=Msg.success();
        msg.add("travelUser",travelUser);
        return  msg;
    }


    /*
     * 将传过来的数据进行更新
     * */
    @ResponseBody
    @RequestMapping(value="/travelUser/{travelUserId}",method = RequestMethod.PUT)
    public Msg updateEmp(TravelUser travelUser){
//        System.out.println(travelUser);
        travelUserService.updateTravelUser(travelUser);
        return Msg.success();
    }


    /*
     * 删除数据（删除单个数据和批量删除数据通用）
     * */
    @ResponseBody
    @RequestMapping(value="/travelUser/{ids}",method = RequestMethod.DELETE)
    public Msg deleteById(@PathVariable("ids")String ids){
        if(ids.contains("-")) {//批量删除
            List<Integer> deleteIdList=new ArrayList<Integer>();
            String[] deleteIds=ids.split("-");
            for(String s:deleteIds) {//遍历，将字符串转换为id的list集合
                Integer id = Integer.parseInt(s);
                deleteIdList.add(id);
            }
            travelUserService.deleteTravelUserBatch(deleteIdList);//调用service层方法执行批量删除
        }else {//单个删除
            travelUserService.deleteTravelUserById(Integer.parseInt(ids));
            return Msg.success();
        }
        return Msg.success();
    }

    /*跳转到为了修改密码发送邮件的页面*/
    @RequestMapping("/openFindPwdPage")
    public String openFindPwdPage(){
        return "findPwdPage";
    }

    /*发送邮件*/
    @ResponseBody
    @RequestMapping(value="/sendEmail",method=RequestMethod.POST)
    public Msg sendEmail(String emailAddress,HttpServletRequest request,HttpServletResponse response){
        MailUtils.sendMessage(emailAddress);

        String code=MailUtils.code;
        Cookie newCookie =new Cookie("code",code);
        newCookie.setPath(request.getContextPath());//设置cookie路径
        newCookie.setMaxAge(10*60);//设置有效时长十分钟
        response.addCookie(newCookie);
        System.out.println("邮箱验证码："+code);
//        System.out.println(emailAddress);
        return Msg.success();
    }

    /*检查验证码是否正确*/
    @ResponseBody
    @RequestMapping(value="/checkCode",method=RequestMethod.POST)
    public Msg checkCode(String checkCode,HttpServletRequest request){
        String realCode="";

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("code")){
                realCode=cookie.getValue();
            }
        }

        if(!realCode.equals("")){
            if(realCode.equals(checkCode)){
                return Msg.success();
            }else{
                return  Msg.fail();
            }
        }else{
            return Msg.fail();
        }

    }
    /*根据邮箱查找到该用户并修改密码*/
    @RequestMapping(value = "/changePwdByEmail",method = RequestMethod.POST)
    @ResponseBody
    public Msg changePwdByEmail(String emailAddress,String newPWd){
        TravelUser travelUser = travelUserService.selectByEmail(emailAddress);
        String md5 = MD5Utils.getMD5(newPWd);
        travelUser.setPassword(md5);
        travelUserService.updatePwdByEmail(emailAddress,travelUser);
        return Msg.success();
    }




    /*
    * 下面的都是个人信息中的模块
    * */

    /*点击用户名，跳转到个人中心页面*/
    @RequestMapping("/openPersonalPage")
    public String openPersonalPage(){
        return "personalPage";
    }

    /*个人中心中打开修改个人信息页面*/
    @RequestMapping("/openPersonalMsgPage")
    public String openPersonalMsgPage(){
        return "personalMsgPage";
    }

    /*
     * 根据id查询数据，并返回给页面。进行数据回显。
     * */
    @RequestMapping(value="/loadPersonalMsg",method = RequestMethod.POST)
    @ResponseBody
    public Msg loadPersonalMsg(String travelUserId){
        Integer id = Integer.parseInt(travelUserId);
        TravelUser travelUser = travelUserService.selectById(id);
//        System.out.println(travelUser);
        Msg msg=Msg.success();
        msg.add("travelUser",travelUser);
        return  msg;
    }

    /*保存用户*/
    @ResponseBody
    @RequestMapping(value = "/savePersonalMsg",method = RequestMethod.POST)
    public String  savePersonalMsg(TravelUser travelUser){
//            System.out.println(travelUser);
            //        保存
            travelUserService.updateTravelUser(travelUser);
            return "1";
    }


    /*个人中心中打开实名信息页面*/
    @RequestMapping("/openRealNamePage")
    public String openRealNamePage(){
        return "personalRealNamePage";
    }

    /*根据页数查询到用户的真实身份信息并返回给页面加载*/
    @RequestMapping("/loadRealNameList")
    @ResponseBody
    public Msg loadRealNameList(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum,Integer travelUserId){

        PageHelper.startPage(pageNum,5);//设置分页的数据。第一个参数指的是当前页，第二个参数是每页有多少条数据

        List<RealName> realNames = realNameService.selectRealNameByTravelUserId(travelUserId);//紧跟在PageHelper.startPage()方法之后的这个查询就是一个分页查询

//        for(RealName r:realNames){
//            System.out.println(r.getRealName());
//        }

        PageInfo pageInfo=new PageInfo(realNames,5);//用pageinfo封装分页的信息。

        Msg msg=Msg.success();
        msg.add("pageInfo",pageInfo);
        return msg;
    }

    /*保存真实身份信息*/
    @ResponseBody
    @RequestMapping(value = "/realName",method = RequestMethod.POST)
    public Msg saveRealName(RealName realName,Integer travelUserId){
            realName.setTravelUserId_FK_RealName(travelUserId);
            realName.setRealNameExist(1);//设置为存在状态
            //       保存
            realNameService.insertRealName(realName);
            Msg msg=Msg.success();
            return msg;
    }

    /*
     * 根据id查询实名身份数据，并返回给页面。进行数据回显。
     * */
    @RequestMapping(value = "/realName/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getRealNameById(@PathVariable("id")Integer id){
        RealName realName = realNameService.selectRealNameById(id);
        Msg msg = Msg.success();
        msg.add("realName",realName);
        return  msg;
    }

    /*
     * 将传过来的实名信息进行更新
     * */
    @ResponseBody
    @RequestMapping(value="/realName/{realNameId}",method = RequestMethod.PUT)
    public Msg updateRealName(RealName realName){
        System.out.println(realName);
        realNameService.updateRealName(realName);
        return Msg.success();
    }

    /*
     * 删除数据（删除单个数据和批量删除数据通用）
     * */
    @ResponseBody
    @RequestMapping(value="/realName/{ids}",method = RequestMethod.DELETE)
    public Msg deleteRealNameById(@PathVariable("ids")String ids){
        if(ids.contains("-")) {//批量删除
            List<Integer> deleteIdList=new ArrayList<Integer>();
            String[] deleteIds=ids.split("-");
            for(String s:deleteIds) {//遍历，将字符串转换为id的list集合
                Integer id = Integer.parseInt(s);
                deleteIdList.add(id);
            }
            realNameService.deleteRealNameBatch(deleteIdList);//调用service层方法执行批量删除
        }else {//单个删除
            realNameService.deleteRealNameById(Integer.parseInt(ids));
            return Msg.success();
        }
        return Msg.success();
    }


    /*个人中心中打开个人订单页面*/
    @RequestMapping("/openOrderPage")
    public String openOrderPage(){
        return "personalOrderPage";
    }

    /*根据页数查询到用户的所有订单并返回给页面加载*/
    @RequestMapping("/loadPersonOrderList")
    @ResponseBody
    public Msg loadPersonOrderList(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum,Integer travelUserId){

        PageHelper.startPage(pageNum,5);//设置分页的数据。第一个参数指的是当前页，第二个参数是每页有多少条数据

        List<Orders> orders = ordersService.selectOrdersByUserId(travelUserId);

        PageInfo pageInfo=new PageInfo(orders,5);//用pageinfo封装分页的信息。

        Msg msg=Msg.success();
        msg.add("pageInfo",pageInfo);
        return msg;
    }

    /*个人中心中打开个可以评价的子订单页面*/
    @RequestMapping("/openCommentPage")
    public String openCommentPage(){
        return "personalCouldCommentPage";
    }

    /*根据页数查询可以评价的子订单并返回*/
    @RequestMapping("/loadCouldCommentOrderList")
    @ResponseBody
    public Msg loadCouldCommentOrderList(@RequestParam(value = "pn",defaultValue ="1")Integer pageNum,Integer travelUserId){

        List<OrderItemCustom> orderItemCustoms =orderItemService.selectCouldCommentOrderItemsByUserId(travelUserId);

        Msg msg=Msg.success();
        msg.add("orderItemCustoms",orderItemCustoms);
        return msg;
    }

    /*根据用户编号查询用户*/
    @RequestMapping("/selectUserMsgByUserId")
    @ResponseBody
    public Msg selectUserMsgByUserId(String userId){
        TravelUser travelUser = travelUserService.selectById(Integer.parseInt(userId));
        Msg msg=Msg.success();
        msg.add("travelUser",travelUser);
        return msg;
    }

}
