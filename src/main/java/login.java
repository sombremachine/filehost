
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
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletResponse.setContentType("text/html");
        PrintWriter out = httpServletResponse.getWriter();

//        httpServletRequest.getRequestDispatcher("register.html").include(httpServletRequest, httpServletResponse);
//
        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");
//        out.println(name + " " + password);

        InitialContext initContext= null;
        try {
            initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
            Connection con = ds.getConnection();

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from users");

            boolean ok = false;
            while(rs.next()) {
                out.println(rs.getInt(1) + "  " + rs.getString(2)  + "  " + rs.getString(3) + "<br>");
                if (rs.getString(2).equals(name) && rs.getString(3).equals(password)){
                    ok = true;
                }
            }
            con.close();

            if (ok){
                out.println("Hello " + name);
            }else {
                out.println("login fail<br>");
                httpServletRequest.getRequestDispatcher("index.html").include(httpServletRequest, httpServletResponse);
            }
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
