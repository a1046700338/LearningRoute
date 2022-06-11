package dao;

import org.apache.commons.dbutils.ResultSetHandler;
import utils.JDBCUtil;

import java.sql.*;

//数据库操作层
public class BaseDao {
    public static Object query(String sql, ResultSetHandler<?> rsh,
                               Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; params != null && i < params.length; i++)
            {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            Object obj = rsh.handle(rs);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            JDBCUtil.release(rs, pstmt, conn);
        }
        return rs;
    }
}
