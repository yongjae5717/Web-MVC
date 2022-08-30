package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    //서블릿이 호출되면 이 메서드가 호출이된다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("helloServlet.service"); //soutm

        System.out.println("request = " + request); //soutv
        System.out.println("response = " + response); //soutv

        String username = request.getParameter("username"); //command + shift + v
        System.out.println("username = " + username); //soutv

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); //header 정보
        response.getWriter().write("hello " + username);
    }
}
