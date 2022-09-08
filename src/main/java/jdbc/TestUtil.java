package jdbc;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestUtil {

    @Test
    public void testConnection(){

        JDBCutil.establishConnection();
        List<Map<String,Object>> resultList= JDBCutil.
                executeQuery("select department_id, department_name, employee_id,first_name from departments d left join employees e using(department_id)");
        // Department name for row 39
        System.out.println(resultList.get(38).get("DEPARTMENT_NAME"));
    }
}
