package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/preproj_db";
    private static final String user = "lexbekker";
    private static final String password = "Cah4ec182!";
    private static Connection con;

    public static Connection getConnection() throws SQLException {
        if (con == null) {
            con = DriverManager.getConnection(url, user, password);
        }
        con.setAutoCommit(false);
        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean tableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[] {"TABLE"});

        return resultSet.next();
    }

}
