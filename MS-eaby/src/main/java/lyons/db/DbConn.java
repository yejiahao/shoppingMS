package lyons.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接oracle数据库
 *
 * @author lyons(zhanglei)
 */

public class DbConn {
    public static Connection getConn() {
        Connection conn = null;

        String user = "scott";
        String passwd = "tiger";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";

        // 已加载驱动
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
