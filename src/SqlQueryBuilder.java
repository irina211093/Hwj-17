import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SqlQueryBuilder {
    public static String buildSelectQuery(Map<String, Object> params) {
        StringBuilder sql = new StringBuilder("SELECT * FROM cars WHERE ");

        boolean firstParam = true;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() != null) { // Проверка на null
                if (!firstParam) {
                    sql.append(" AND ");
                }

                if (entry.getValue() instanceof String) {
                    sql.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                } else {
                    sql.append(entry.getKey()).append(" = ").append(entry.getValue());
                }
                firstParam = false;
            }
        }

        if (firstParam) {
            sql.delete(0, sql.length());
        }

        return sql.toString();
    }
    public static void main(String[] args) {
        Map<String, Object> params1 = new LinkedHashMap<>();
        params1.put("model", "V-60");
        params1.put("country", "Germany");
        params1.put("city", "Berlin");
        params1.put("year", null);
        params1.put("active", true);

        Map<String, Object> params2 = new HashMap<>();
        params2.put("id", 1);
        params2.put("country", null);
        params2.put("city", "Helsinki");
        params2.put("year", null);

        String query1 = buildSelectQuery(params1);
        System.out.println(query1);

        String query2 = buildSelectQuery(params2);
        System.out.println(query2);
    }

}
