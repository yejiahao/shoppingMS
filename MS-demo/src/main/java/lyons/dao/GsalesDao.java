package lyons.dao;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Gsales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 数据库gSales表操作
 *
 * @author lyons(zhanglei)
 */
public final class GsalesDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * 1.当天卖出的商品
     *
     * @return ArrayList<Gsales> 商品信息,包括 allSum (单种商品的销售总和)
     */
    public ArrayList<Gsales> dailyGsales() {
        ArrayList<Gsales> GsalesList = new ArrayList<>();
        conn = DbConn.getConn();

        // 售卖时间=当前时间 trunc(sdate) =trunc(sysdate) 单位：天
        // sql语句解释见files/sql/java_sql.sql
        String sql = "SELECT gname,gprice,gnum, allSum FROM goods, (SELECT gid AS salesid,SUM(snum) AS allSum FROM gsales WHERE trunc(sdate) =trunc(sysdate) GROUP BY gid) WHERE gid = salesid";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String gName = rs.getString(1);
                double gPrice = rs.getDouble(2);
                int gNum = rs.getInt(3);
                int allSnum = rs.getInt("allSum");

                Gsales Gsales = new Gsales(gName, gPrice, gNum, allSnum);
                GsalesList.add(Gsales);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.queryClose(rs, pstmt, conn);
        }
        return GsalesList;
    }

    /**
     * 2.购物结算-向sales表中插入商品数据！
     *
     * @param gSales
     * @return boolean
     */
    public boolean shoppingSettlement(Gsales gSales) {
        boolean bool = false;
        conn = DbConn.getConn();
        String sql = "INSERT INTO GSALES(GID,SID,SNUM) VALUES(?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, gSales.getGId());
            pstmt.setInt(2, gSales.getSId());
            pstmt.setInt(3, gSales.getSNum());

            if (pstmt.executeUpdate() > 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbClose.addClose(pstmt, conn);
        }
        return bool;
    }

}
