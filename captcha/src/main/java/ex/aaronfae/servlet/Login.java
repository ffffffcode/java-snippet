package ex.aaronfae.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获得用户输入的验证码
        String verifyCode = request.getParameter("verifyCode");
        // 2 获得服务器session 存放数据 ,如果没有返回null
        String sessionCacheData = (String) request.getSession().getAttribute("captcha");
        // *将服务器缓存session数据移除
        request.getSession().removeAttribute("captcha");
        // ** 判断服务器是否存在
        if (sessionCacheData == null) {
            request.setAttribute("msg", "请不要重复提交");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        // 3 比较
        if (!sessionCacheData.equalsIgnoreCase(verifyCode)) {
            // 用户输入错误
            // * 存放request作用域
            request.setAttribute("msg", "验证码输入错误");
            // * 请求转发
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        }

        // ...... 登录操作
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
