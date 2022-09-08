package jdbc;

//Connection -> it will help us to provide our db credentials and connect the database
//Statement -> we define our conditions to get the result from database
//ResultSet -> we store the data from DB to the resultSet object in java
//resultset object represents the column from the result table
//resultset object can only get the datas from one row at a time
//ResultSetMetaData -> it is related to columns in data table and we can get information about columns


//what is JDBC? Is a collection of interfaces that helps to connect data base.
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCintro {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@techtorialacademy.cewvxnnnahzx.us-east-1.rds.amazonaws.com:1521/ORCL",
                "techtorial", "techtorialbatch12");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");

        resultSet.next();
        // ---> It will take result set object to the next row. If there is a next row this method will return
        // true. If there is no next row this method will return false.
        System.out.println(resultSet.getObject("first_name"));
        // How does while loop work ?
        // While loop will iterate when the condition is true
        // The most basic form for iterating through rows in the table
        while (resultSet.next()){
            System.out.println(resultSet.getObject("first_name").toString()+
                    resultSet.getObject("last_name").toString());
            System.out.println(resultSet.getString("first_name")+resultSet.getString("last_name"));// you can use this method instead to play it safe
        }
        System.out.println("---------------------------------------------------------------");
        resultSet.beforeFirst();// This method will take the result object to the columns

//        for(;resultSet.next();){
//            System.out.println(resultSet.getObject("first_name"));
//        }


        resultSet.first(); // THis method will take result set object to the first row
        // IF there is existing data row in the table it will return true
        // It returns false when there is no data in the table
        resultSet.last(); // THis method will take result set object to the last row
        // IF there is existing data row in the table it will return true
        // It returns false when there is no data in the table

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData(); // get results of the datatable
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(4));

        for(int c = 1;c<=resultSetMetaData.getColumnCount();c++){
            System.out.println(resultSetMetaData.getColumnName(c));

        }
/// Display all the information with their column names
        resultSet.beforeFirst(); //to get all information
        List<Map<String,Object>> employeeTable = new ArrayList<>();
        while (resultSet.next()){
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount() ; i++) {
                //  System.out.println(resultSetMetaData.getColumnName(i)+" = " + resultSet.getObject(i));

                row.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }
            employeeTable.add(row);
//            System.out.println("---------------------------------------------------------------");
        }
        System.out.println(employeeTable);

        for (int i = 0; i < employeeTable.size() ; i++) {
//            System.out.println(employeeTable.get(i));
//            System.out.println("---------------------------------------------------------------");
        }
        /// Get the phone number from 5th row in the table
        System.out.println(employeeTable.get(4).get("PHONE_NUMBER"));






    }



}
