import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletResponse.setContentType("text/html");
        PrintWriter out = httpServletResponse.getWriter();

        httpServletRequest.getRequestDispatcher("register.html").include(httpServletRequest, httpServletResponse);
//
//        String name = httpServletRequest.getParameter("name");
//        String password = httpServletRequest.getParameter("password");
////        out.println(name + " " + password);
//
//        InitialContext initContext= null;
//        try {
//            initContext = new InitialContext();
//            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
//            Connection con = ds.getConnection();
//
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from example");
//
//            while(rs.next())
//                out.println(rs.getInt(1)+"  "+rs.getString(2) + "<br>");
//
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
