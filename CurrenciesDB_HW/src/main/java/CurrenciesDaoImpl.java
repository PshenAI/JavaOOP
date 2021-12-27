import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrenciesDaoImpl extends AbstractDAO<Currency> {
    public  CurrenciesDaoImpl(Connection conn, String table){
        super(conn, table);
    }

    public void getRateByDate(String date, Connection conn, String table){
        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM " + table + " WHERE date BETWEEN '" + date
                        + "T00:00:00.00' AND '" + date + "T23:59:59.999'")) {
                    ResultSetMetaData md = rs.getMetaData();

                    while (rs.next()) {
                        Currency res = new Currency();
                        for (int i = 1; i <= md.getColumnCount(); i++) {
                            String columnName = md.getColumnName(i);
                            Field field = Currency.class.getDeclaredField(columnName);
                            if(field.getName().equals("date")){
                                field.setAccessible(true);
                                field.set(res, rs.getObject(columnName).toString());
                                continue;
                            }
                            field.setAccessible(true);
                            field.set(res, rs.getObject(columnName));
                        }
                        System.out.println("Currency : " + res.getCurrency() + "\nPurchase: " + res.getPurchaseRateNB() + "\nSale : " + res.getSaleRateNB());
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void getAvgRateByPeriod(String date1, String date2, Connection conn, String table){
        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT AVG(saleRate), AVG(purchaseRate) FROM " + table +
                        " WHERE date BETWEEN '" + date1 + "T00:00:00.00' AND '" + date2 + "T23:59:59.999'")) {
                    ResultSetMetaData md = rs.getMetaData();

                    String[] res = new String[2];

                    while (rs.next()) {
                        for (int i = 1; i <= md.getColumnCount(); i++) {
                            String columnName = md.getColumnName(i);
                            res[i - 1] = rs.getObject(columnName).toString();
                        }
                        System.out.println("Average purchase rate for " + date1 + " - " + date2 + " :\n"
                        + "Purchase : " + res[1] + "\nSale : " + res[0]);
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
