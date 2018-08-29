import dao.DBC;

import javax.naming.InitialContext;
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

public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletResponse.setContentType("text/html");
        PrintWriter out = httpServletResponse.getWriter();

        httpServletRequest.getRequestDispatcher("register.html").include(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html");
        PrintWriter out = httpServletResponse.getWriter();

        httpServletRequest.getRequestDispatcher("register.html").include(httpServletRequest, httpServletResponse);

        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");
//        out.println(name + " " + password);
//
        if ((name != null)&&(!name.isEmpty())) {
            try {
                Connection con = DBC.dbConnection();

                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from users where username = '" + name + "';");

                int i = 0;
                while (rs.next()) {
                    out.println(rs.getInt(1) + "  " + rs.getString(2) + "<br>");
                    i++;
                }
                if (i > 0) {
                    out.println("Username " + name + "already exist");
                } else {
                    stmt.executeUpdate("insert into users (username, password) values ('" + name + "','" + password + "');");
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
