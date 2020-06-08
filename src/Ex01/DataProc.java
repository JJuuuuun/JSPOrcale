package Ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DataProc {
    private final String className = "oracle.jdbc.driver.OracleDriver";
    private final String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String jdbcUser = "c##admin";
    private final String jdbcPass = "admin";

    Connection conn;
    PreparedStatement stmt;

    private String sql = "insert into customers" +
            " (CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)" +
            " Values" +
            " (?, ?, ?, ?, ?, ?, ?)";


    public DataProc() {
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(jdbcDriver, jdbcUser, jdbcPass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        stmt = null;
    }

    public void storeCustomers(List<Customers> customersList) throws SQLException {
        stmt = conn.prepareStatement(sql);

        for (Customers customer : customersList) {
            stmt.setInt(1, customer.getCustomerID());
            stmt.setString(2, customer.getCustomerName());
            stmt.setString(3, customer.getContactName());
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getCity());
            stmt.setString(6, customer.getPostalCode());
            stmt.setString(7, customer.getCountry());

            System.out.println("before execute : " + customer.getCustomerID());
            stmt.execute();
            System.out.println("after execute : " + customer.getCustomerID());

        }
    }

    public void closeConnect() throws SQLException {
        conn.close();
    }
}
