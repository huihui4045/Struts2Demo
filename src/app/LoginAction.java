package app;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gavin on 2017/9/28.
 */
public class LoginAction implements Action,ServletResponseAware {

    private String userName;
    private String passWord;



    private HttpServletResponse response;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }





    @Override
    public String execute() throws Exception {

        ActionContext context = ActionContext.getContext();

        Integer counter= (Integer) context.getApplication().get("counter");

        if (counter==null){

            counter=1;
        }else {
            counter++;
        }

        context.getApplication().put("counter",counter);

        context.getSession().put("user",getUserName());


        if (getUserName().equals("huihui") &&getPassWord().equals("123456")){


            context.put("tip","服务器提示：你已经登录成功");

            Cookie cookie=new Cookie("user",getUserName());

            cookie.setMaxAge(600);
           // response.addCookie(cookie);

            ServletActionContext.getResponse().addCookie(cookie);

            return SUCCESS;
        }
        context.put("tip","服务器提示：你登录失败");


        return ERROR;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response=response;
    }
}
