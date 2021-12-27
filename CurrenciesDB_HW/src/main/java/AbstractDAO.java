
import java.lang.reflect.Field;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractDAO<T> {
    private final Connection conn;
    private final String table;

    public AbstractDAO(Connection conn, String table) {
        this.conn = conn;
        this.table = table;
    }

    public void createTable(Class<T> cls) {
        Field[] fields = cls.getDeclaredFields();
        Field id = getPrimaryKeyField(null, fields);

        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE ")
                .append(table)
                .append("(");

        sql.append(id.getName())
                .append(" ")
                .append(" INT AUTO_INCREMENT PRIMARY KEY,");

        for (Field f : fields) {
            if (f != id) {
                f.setAccessible(true);

                sql.append(f.getName()).append(" ");

                if(f.getName().equals("date")){
                    sql.append("DATE,");
                    continue;
                }

                if (f.getType() == int.class) {
                    sql.append("INT,");
                } else if (f.getType() == String.class) {
                    sql.append("VARCHAR(100),");
                } else
                    throw new RuntimeException("Wrong type");
            }
        }

        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");

        try {
            try (Statement st = conn.createStatement()) {
                st.execute(sql.toString());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void add(T t) {
        try {
            Field[] fields = t.getClass().getDeclaredFields();
            Field id = getPrimaryKeyField(t, fields);

            StringBuilder names = new StringBuilder();
            StringBuilder values = new StringBuilder();

            for (Field f : fields) {
                if (f != id) {
                    f.setAccessible(true);

                    if(f.getName().equals("date")){
                        String temp = (String)f.get(t);
                        String reso = temp.substring(6,10) + "-" + temp.substring(3,5) + "-" + temp.substring(0,2);
                        names.append(f.getName()).append(',');
                        values.append('"').append(reso).append("\",");
                        continue;
                    }

                    names.append(f.getName()).append(',');
                    values.append('"').append(f.get(t)).append("\",");
                }
            }

            names.deleteCharAt(names.length() - 1); // last ','
            values.deleteCharAt(values.length() - 1);

            String sql = "INSERT INTO " + table + "(" + names.toString() +
                    ") VALUES(" + values.toString() + ")";

            try (Statement st = conn.createStatement()) {
                st.execute(sql);
                id.setAccessible(true);
                id.set(t, idGetter(st, values.toString(), id));
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void update(T t) {
        try {
            Field[] fields = t.getClass().getDeclaredFields();
            Field id = getPrimaryKeyField(t, fields);

            StringBuilder sb = new StringBuilder();

            for (Field f : fields) {
                if (f != id) {
                    f.setAccessible(true);

                    sb.append(f.getName())
                            .append(" = ")
                            .append('"')
                            .append(f.get(t))
                            .append('"')
                            .append(',');
                }
            }

            sb.deleteCharAt(sb.length() - 1);

            // update t set name = "aaaa", age = "22" where id = 5
            String sql = "UPDATE " + table + " SET " + sb.toString() + " WHERE " +
                    id.getName() + " = \"" + id.get(t) + "\"";

            try (Statement st = conn.createStatement()) {
                st.execute(sql);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void delete(T t) {
        try {
            Field[] fields = t.getClass().getDeclaredFields();
            Field id = getPrimaryKeyField(t, fields);

            String sql = "DELETE FROM " + table + " WHERE " + id.getName() +
                    " = \"" + id.get(t) + "\"";

            try (Statement st = conn.createStatement()) {
                st.execute(sql);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<T> getAll(Class<T> cls) {
        List<T> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM " + table)) {
                    ResultSetMetaData md = rs.getMetaData();

                    while (rs.next()) {
                        T t = cls.getDeclaredConstructor().newInstance(); //!!!

                        for (int i = 1; i <= md.getColumnCount(); i++) {
                            String columnName = md.getColumnName(i);
                            Field field = cls.getDeclaredField(columnName);
                            field.setAccessible(true);

                            field.set(t, rs.getObject(columnName));
                        }

                        res.add(t);
                    }
                }
            }

            return res;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<T> getAll(Class<T> cls, String... fieldNames){
        List<T> res = new ArrayList<>();
        try {
            try (Statement st = conn.createStatement()) {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT ");
                for (int i = 0; i < fieldNames.length; i++) {
                    if(i + 1 == fieldNames.length - 1){
                        sb.append(fieldNames[i] + ", ");
                    } else{
                        sb.append(fieldNames[i]);
                    }
                }
                sb.append(" FROM " + table);

                try (ResultSet rs = st.executeQuery(sb.toString())) {
                    ResultSetMetaData md = rs.getMetaData();

                    while (rs.next()) {
                        T t = cls.getDeclaredConstructor().newInstance(); //!!!

                        for (int i = 1; i <= md.getColumnCount(); i++) {
                            String columnName = md.getColumnName(i);
                            Field field = cls.getDeclaredField(columnName);
                            field.setAccessible(true);

                            field.set(t, rs.getObject(columnName));
                        }

                        res.add(t);
                    }
                }
            }

            return res;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private Field getPrimaryKeyField(T t, Field[] fields) {
        Field result = null;

        for (Field f : fields) {
            if (f.isAnnotationPresent(Id.class)) {
                result = f;
                result.setAccessible(true);
                break;
            }
        }

        if (result == null)
            throw new RuntimeException("No Id field found");

        return result;
    }

    public int idGetter(Statement st, String values, Field id) throws SQLException {
        Integer res = 0;
        try (ResultSet rs = st.executeQuery("SELECT * FROM " + table)) {
            ResultSetMetaData md = rs.getMetaData();
            String[] arr = values.split(",");
            while (rs.next()) {
                List<String> check = new ArrayList<>();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    String columnName = md.getColumnName(i);
                    if(i == 1){
                        check.add(String.valueOf(rs.getObject(columnName)));
                        continue;
                    }
                    if(columnName.equals("date")){
                        check.add(rs.getObject(columnName).toString());
                        continue;
                    }
                    check.add((String) rs.getObject(columnName));
                }
                if(check.get(2).equals(arr[1].replaceAll("\"", "")) && check.get(7).equals(arr[6].replaceAll("\"", ""))){
                    res = Integer.valueOf(check.get(0));
                }
            }
        }
        return res;
    }
}
