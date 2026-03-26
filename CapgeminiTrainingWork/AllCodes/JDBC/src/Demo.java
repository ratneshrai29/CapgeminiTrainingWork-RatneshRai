import java.sql.*;

public class Demo {
    public static void main(String[] args) throws  Exception{
        String sql = "Select department_name from department where manager_id =124";
        String url = "jdbc:mysql://localhost:3306/company_db";
        String username = "root";
        String password = "12345";

        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString(1);
        System.out.println(name);
        con.close();


    }
}