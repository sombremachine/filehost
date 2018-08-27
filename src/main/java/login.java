
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login extends HttpServlet {

    @Override
    public void init() throws ServletException {
        InitialContext initContext= null;
        try {
            initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
            Connection conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
//        out.println(name + " " + password);

        InitialContext initContext= null;
        try {
            initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
            Connection con = ds.getConnection();

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from example");

            while(rs.next())
                out.println(rs.getInt(1)+"  "+rs.getString(2));

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
//        super.doGet(httpServletRequest, httpServletResponse);
        httpServletResponse.sendRedirect("/");
    }
}
