import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
//        super.doPost(httpServletRequest, httpServletResponse);
//        httpServletResponse.setContentType("text/html;charset=utf-8");
//        httpServletResponse.getWriter().println("Hello world!doPost" + httpServletRequest.getRemoteAddr());
//        httpServletResponse.getWriter().println("Hello world!2");
//        httpServletResponse.getWriter().println("Hello world!3");
//        httpServletResponse.getWriter().println("Hello world!4");
//        httpServletResponse.getWriter().println(httpServletRequest.getRemoteAddr());

        httpServletResponse.setContentType("text/html");
        PrintWriter out = httpServletResponse.getWriter();

        //httpServletRequest.getRequestDispatcher("link.html").include(httpServletRequest, httpServletResponse);

        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");
        out.println(name + " " + password);

    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
//        super.doGet(httpServletRequest, httpServletResponse);
        httpServletResponse.sendRedirect("/");
    }
}
