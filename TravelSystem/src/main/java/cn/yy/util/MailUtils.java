package cn.yy.util;


import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class MailUtils {

    public static String code;
    /**
     *1.首先获取发送邮件的session对象
     *2.使用session对象获取待发送的邮件信息
     *3。设置发件人，收件人，标题，内容，附件，发送时间等等
     *4.利用Transport发送邮件
     */
    public static void sendMessage(String emailAddress){

        //设置一些需要的参数
        String myEmailSMTPHost = "smtp.163.com";//发件人邮箱的smtp服务器地址，连接的主机
        String myEmailAccount = "Yy2269861713@163.com";//账户名
        String myEmailPassword = "Yy894002";//授权码
        
        //1.设置properties，session中需要
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost); // 定义发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true"); // 设置是否需要经过身份验证
        props.setProperty("mail.debug","true");//设置成可以在控制台看到debug消息
        
        //2.创建session对象，用于和服务器交互
        Session session = Session.getDefaultInstance(props);//根据配置创建会话对象,用于和邮件服务器交互
        session.setDebug(true);//设置debug模式，可以查看详细发送信息，可以省略。功能和上面prop对象设置的那种debug一样。

        //3.创建邮件对象。需要自己写一个方法，参数至少有session，发送人，收件人
        MimeMessage message = createComplicatedMessage(session,myEmailAccount,emailAddress);//调用方法创建一封完整的邮件，需要session，发送人，收件人作为参数

        //4.利用transport发送邮件
        try {
            Transport transport = session.getTransport(); //获取邮件传输对象
            //连接服务器，确认发送方是否授权
            transport.connect(myEmailAccount, myEmailPassword);
            //发送邮件。两个参数，第一个参数是要发送的东西，第二个参数是要接受的人。
//            message.getAllRecipients();//这个方法就是用来获取要接受的人的。
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();//关闭连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  /*
   * 添加一个方法用来创建一个完整的邮件，需要在这个方法中设置发件人，收件人，邮件标题，邮件内容等等。
   * 这个创建邮件的方法的参数有：session（参数配置），发件人邮箱，收件人邮箱。
   * */
    public static MimeMessage createComplicatedMessage(Session session,String myEmailAccount,String emailAddress) {
    	//创建邮件对象。
        MimeMessage message = new MimeMessage(session);
        //设置发送人，收件人，标题，邮件内容，附件发送时间等 
        try {
        	//设置发件人setFrom。参数是一个InternetAddress对象，这个对象的参数又有三个，都是String类型，分别是邮箱，名字，编码
			message.setFrom(new InternetAddress(myEmailAccount,"找回密码","UTF-8"));
			//设置收件人地址。可以支持多个收件人，以及抄送，密送 。想要发给多个人，就重复下面代码多次
			/*
			 * MimeMessage.RecipientType.TO发送
			 * MimeMessage.RecipientType.CC抄送
			 * MimeMessage.RecipientType.BCC密送
			 * */
			//设置收件人地址setRecipient。参数有两个，MimeMessage.RecipientType.TO和InternetAddress对象，InternetAddress对象的构造器的参数有三个，都是String类型，分别是邮箱，名字，编码。
			message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(emailAddress,"xxxx","utf-8"));
			//设置邮件主题
			message.setSubject("找回密码-验证码","utf-8");
//			String ip=Inet4Address.getLocalHost().getHostAddress();//获取服务器的ip地址
			code=RandomNumUtil.getRandomNum();//生成随机验证码
			//设置邮件正文，可以使用html标签.
			message.setContent("您好！您的验证码为："+code+"，请注意时间，十分钟内有效！","text/html;charset=utf-8");
			//设置邮件发送时间
			message.setSentDate(new Date());//这里设置的是现在发送
			//保存设置
			message.saveChanges();
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        return message;//返回创建好的邮件对象	
    }
}

