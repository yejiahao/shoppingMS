package lyons.db;

import java.sql.*;

public class DBUtil {
    private DBUtil() {
        throw new AssertionError();
    }

    public static Connection getConnection() {
        Connection conn = null;

        String user = "root";
        String passwd = "20170419";
        String url = "jdbc:mysql://localhost:3306/ms_eaby?characterEncoding=utf8&useSSL=true";

        // 已加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /*
     * 关闭登录资源
     */
    public static void allClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        commonClose(rs, pstmt, null, conn);
    }

    /*
     * 关闭增、删、改资源。
     */
    public static void close(PreparedStatement pstmt, Connection conn) {
        commonClose(null, pstmt, null, conn);
    }

    public static void close(PreparedStatement pstmtOrder, PreparedStatement pstmtCommodity, Connection conn) {
        commonClose(null, pstmtOrder, pstmtCommodity, conn);
    }

    private static void commonClose(ResultSet rs, PreparedStatement pstmt1, PreparedStatement pstmt2, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt1 != null) {
                pstmt1.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt2 != null) {
                pstmt2.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
