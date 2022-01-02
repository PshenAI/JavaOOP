package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            emf = Persistence.createEntityManagerFactory("CurrenciesTest");
            em = emf.createEntityManager();

//            System.out.println("In how many days (from today) do you want to collect info?");
//            String daysNum = sc.nextLine();
//
//            fillDB(daysNum);

            while (true){
                System.out.println("1 -> Get rate by special date" +
                        "\n2 -> Get average rate for period");
                String command  = sc.nextLine();

                if(command.isEmpty()){
                    return;
                }
                switch (command){
                    case "1":
                        getRateByDate(sc);
                        break;
                    case "2":
                        getAvgRateForPeriod(sc);
                        break;
                    default:
                        System.out.println("Unknown command.");
                        break;
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
            return;
        }finally {
            em.close();
            emf.close();
        }
    }

    public static void getAvgRateForPeriod(Scanner sc){
        System.out.println("Enter first date in this format (1986-04-26): ");
        String rate1Date = sc.nextLine();
        System.out.println("Enter second date in this format (1986-04-26): ");
        String rate2Date = sc.nextLine();
        try{
            Query query = em.createQuery(
                    "SELECT AVG(x.purchaseRate), AVG(x.saleRate)" +
                            " FROM Currency x WHERE x.date BETWEEN :frstDate AND :scndDate");
            query.setParameter("frstDate", Date.valueOf(LocalDate.parse(rate1Date)));
            query.setParameter("scndDate", Date.valueOf(LocalDate.parse(rate2Date)));
            List<Object[]> list = query.getResultList();
            list.forEach(a -> System.out.println("Average rate for " + rate1Date + " - " + rate2Date + " :\n"
                    + "Purchase : " + a[0] + "\nSale : " + a[1]));
        }catch (NoResultException ex){
            System.out.println("No rates for such date in database.");
            return;
        }
    }

    public static void getRateByDate(Scanner sc){
        try {
            System.out.println("Enter date in this format (1986-04-26): ");
            String date = sc.nextLine();
            LocalDate rateDate = LocalDate.parse(date);
            Query query = em.createQuery(
                    "SELECT x FROM Currency x WHERE x.date = :date", Currency.class);
            query.setParameter("date", Date.valueOf(rateDate));
            Currency res = (Currency) query.getSingleResult();
            System.out.println("Rate for " + date + " :\nPurchase : " + res.getPurchaseRate()
                    + "\nSale : " + res.getSaleRate());
        } catch (NoResultException ex){
            System.out.println("No rates for such date in database.");
            return;
        } catch (NonUniqueResultException ex){
            System.out.println("Non unique result!");
            return;
        }
    }

    public static void fillDB(String daysNum) throws IOException {
        LocalDate date = LocalDate.now();
        List<Currency> usdInfo = new ArrayList<>();
        for (LocalDate itr = LocalDate.now(); itr.isAfter(date.minusDays(Integer.parseInt(daysNum)));
             itr = itr.minusDays(1)) {
            String dateArg = itr.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            usdInfo.add(usdInfoGetter(dateArg, itr));
        }
        try {
            em.getTransaction().begin();
            usdInfo.forEach(a -> em.persist(a));
            em.getTransaction().commit();
        } catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    public static Currency usdInfoGetter(String date, LocalDate dateType) throws IOException {
        String json = "";
        Gson gson = new GsonBuilder().create();
        URL url = new URL("https://api.privatbank.ua/p24api/exchange_rates?json&date=" + date);
        System.out.println(url);
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(
                urlConn.getInputStream()))){
            String buff;
            while ((buff = br.readLine()) != null){
                json = buff + System.lineSeparator();
            }
        }
        String[] temp = json.split("baseCurrency\"");
        for (int i = 0; i < temp.length; i++) {
            if(temp[i].contains("USD")){
                json = "{\"baseCurrency\"" + temp[i].substring(0, temp[i].length() - 3);
            }
        }
        Currency res = gson.fromJson(json, Currency.class);
        res.setDate(Date.valueOf(dateType));

        return res;
    }
}
