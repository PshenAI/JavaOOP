import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        try(Connection conn = ConnectionFactory.getConnection(); Scanner sc = new Scanner(System.in); ){
            try (Statement st = conn.createStatement()) {
                st.execute("DROP TABLE IF EXISTS currencyinfo");
            }
            CurrenciesDaoImpl cdi = new CurrenciesDaoImpl(conn , "currencyinfo");
            cdi.createTable(Currency.class);

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String currentDate = sdf.format(date);
            int day = Integer.valueOf(currentDate.substring(0,2));
            List<Currency> usdInfo = new ArrayList<>();
            for (int i = day; i >= day - 1  ; i--) {
                usdInfo.add(usdInfoGetter(currentDate.replace(currentDate.substring(0,2), String.valueOf(i))));
            }
            usdInfo.forEach(a -> cdi.add(a));
            System.out.println(usdInfo);
            while(true){
                System.out.println("1 -> Get rate by date" +
                        "\n2 -> Get average rate within period");
                String comm = sc.nextLine();
                if(comm.isEmpty()) break;
                switch (comm){
                    case "1":
                        System.out.println("Enter date: ");
                        String rateDate = sc.nextLine();
                        cdi.getRateByDate(rateDate, conn,"currencyinfo");
                        break;
                    case "2":
                        System.out.println("Enter first date: ");
                        String rate1Date = sc.nextLine();
                        System.out.println("Enter second date: ");
                        String rate2Date = sc.nextLine();
                        cdi.getAvgRateByPeriod(rate1Date,rate2Date,conn,"currencyinfo");
                        break;
                    default:
                        System.out.println("Unknown command.");
                        break;
                }
            }
        }
    }

    public static Currency usdInfoGetter(String date) throws IOException {
        String json = "";
        Gson gson = new GsonBuilder().create();
        URL url = new URL("https://api.privatbank.ua/p24api/exchange_rates?json&date=" + date);
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(
                urlConn.getInputStream()))){
            String buff;
            while ((buff = br.readLine()) != null){
                json = buff + System.lineSeparator();
            }
        }
        json = json.substring(2533, 2672);
        Currency res = gson.fromJson(json, Currency.class);
        res.setDate(date);
  
        return res;
    }
}
