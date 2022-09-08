package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCutil {

    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static ResultSetMetaData resultSetMetaData;

    public static void establishConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@techtorialacademy.cewvxnnnahzx.us-east-1.rds.amazonaws.com:1521/ORCL",
                    "techtorial",
                    "techtorialbatch12"
            );
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static List<Map<String, Object>> executeQuery(String query) {
        List<Map<String, Object>> table = new ArrayList<>();
        try {
            resultSet = statement.executeQuery(query);
            resultSet.beforeFirst();
            resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    row.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
                }
                table.add(row);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }

    // How can we learn total row number of the table
    public static int getRowNum() {
        try {


            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            ;
        }
        return -1;
    }

    public static void closeConnection() {
        try {


            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
