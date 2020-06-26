package cn.yy.filter;

import cn.yy.pojo.TravelUser;
import cn.yy.service.TravelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * 利用过滤器实现自动登陆
 */
@WebFilter("/loginForm")
public class AutoLoginFilter implements Filter {

    @Autowired
    TravelUserService travelUserService;

    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//转换为httpservlet的请求和响应，否则无法获取session和cookie
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String contextPath = ((HttpServletRequest) request).getContextPath();

		HttpSession session = req.getSession();//获取session
		TravelUser user = (TravelUser) session.getAttribute("travelUser");//根据名字获取固定session，查看用户登陆信息有没有保存在session中，有的话直接登录就行。
		if(user!=null) {//在session中查到了信息
			resp.sendRedirect(contextPath);//直接跳转到主界面，也就是自动登陆
		}else {
			Cookie[] cookies = req.getCookies();//获取cookie数组
			if(cookies!=null) {//如果数组不为空，再继续往下。更严谨
				for(Cookie cookie:cookies) {//遍历整个cookie数组
					if(cookie.getName().equals("autoLoginUserinfo")) {//如果找到了名字为userinfo的cookie
						String userinfo = cookie.getValue();//获取cookie中对应的值
						String[] userinfo2=null;
						if(!userinfo.equals("")&&userinfo!=null) {//有可能userinfo是""或者是null，因为可能被注销过。如果不经过这个判断，直接用split得到字符串数组，就会报错
							userinfo2= userinfo.split("#");//因为值中存放的是用户名和密码，用#隔开的。所以用#分离，得到string数组
							String name=userinfo2[0];//数组中第一个就是用户名
							String password=userinfo2[1];//数组中第二个是密码
							String userName=URLDecoder.decode(name,"utf-8");//从cookie中拿到的用户名可能是中文，是经过urlencode编码的，需要进行解码

                            ServletContext sc = req.getSession().getServletContext();
                            XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sc);
                            if(cxt != null && cxt.getBean(TravelUserService.class) != null && travelUserService == null){
                                travelUserService = (TravelUserService) cxt.getBean(TravelUserService.class);
                            }
                            TravelUser loginUser = this.travelUserService.selectByUserNameAndPassword(userName, password);      //调用service的login方法，进行登陆尝试


							if(loginUser!=null) {//如果有返回值，证明有该用户。登陆成功
								session.setAttribute("travelUser",loginUser);//将信息放入session中，方便下一次可以使用session实现自动登陆
								resp.sendRedirect(contextPath+"/loginForm");//跳转到登陆页面
							}else {
								resp.sendRedirect(contextPath+"/loginForm");//跳转到登陆页面
							}
						}
						
					}
				}
			}
			
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
