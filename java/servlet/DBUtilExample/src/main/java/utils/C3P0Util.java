package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3P0Util {
    private static DataSource ds;
    static {
        ds = new ComboPooledDataSource("c3p0.xml");
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
