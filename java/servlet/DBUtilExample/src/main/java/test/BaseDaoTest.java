package test;

import dao.BaseDao;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.SQLException;
import java.util.List;

public class BaseDaoTest {
    public static void testArrayListHandler()throws SQLException{
        BaseDao baseDao = new BaseDao();
        String sql = "select * from user";
        List list = (List) baseDao.query(sql,new ArrayListHandler());
        Object[] arr = (Object[]) list.get(0);
        Object[] arr1 = (Object[]) list.get(1);
        Object[] arr2 = (Object[]) list.get(2);
        for(int i = 0;i< arr.length;i++){
            System.out.println(arr[i]+",");
        }
        for(int i = 0;i< arr.length;i++){
            System.out.println(arr1[i]+",");
        }
        for(int i = 0;i< arr.length;i++){
            System.out.println(arr2[i]);
        }

    }
    public static void main(String[] args) throws SQLException {
        testArrayListHandler();
    }
}
