package ua.kiev.prog;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.Callable;

public class Main {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EshopTest");
    static final EntityManager em = emf.createEntityManager();
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Product> goods = new ArrayList<>();
        fillGoodsTable(goods);

        while(true){
            System.out.println("\nWhat would you like ot do?   'Leave empty if you want to exit'"
             + "\n1 - Order :: 2 - Get orders info by order id :: 3 - Get orders info by dates");
            String check = sc.nextLine();
            if(check.isEmpty()) break;
            switch (check){
                case "1":
                    Client client = orderFactory(goods);
                    performTransaction(() -> {
                        em.persist(client);
                        return null;
                    });
                    break;
                case "2":
                    getOrderByNumber();
                    break;
                case "3":
                    getOrderByDates();
                    break;
            }
        }
    }

    private static void getOrderByDates() {
        System.out.println("Enter first date in this format (1986-04-26): ");
        String date1 = sc.nextLine();
        System.out.println("Enter second date in this format (1986-04-26): ");
        String date2 = sc.nextLine();
        TypedQuery<Order> query = em.createQuery(
                "SELECT o FROM Order o WHERE o.date BETWEEN :frstDate AND :scndDate", Order.class);
        query.setParameter("frstDate", Date.valueOf(LocalDate.parse(date1)));
        query.setParameter("scndDate", Date.valueOf(LocalDate.parse(date2)));
        List<Order> res = query.getResultList();
        res.forEach(a -> System.out.println("\n=================================\n" + a));
    }

    public static void getOrderByNumber(){
        System.out.println("Enter desired id :");
        String number = sc.nextLine();
        TypedQuery<Order> query = em.createQuery(
                "SELECT o FROM Order o WHERE o.id = :id", Order.class);
        query.setParameter("id", Long.valueOf(number));
        List<Order> res = query.getResultList();
        res.forEach(a -> System.out.println("\n=================================\n" + a));
    }

    public static Client orderFactory(List<Product> goods){
        Order order = new Order();
        System.out.println("Let's complete your order.\nEnter your full name:");
        String name = sc.nextLine();
        System.out.println("And number: ");
        String number = sc.nextLine();
        Client client = new Client(name, number);
        System.out.println("Please, enter shipping address:  (Country, city, street)");
        String[] fullAddress = sc.nextLine().split(", ");
        Address address = new Address(fullAddress[0],fullAddress[1], fullAddress[2]);
        client.setAddress(address);
        client.addOrder(order);
        System.out.println("Now choose wanted goods by id: (n, n, n)\n" + goods);
        String[] prods = sc.nextLine().split(", ");
        for (int i = 0; i < prods.length; i++) {
            order.addProduct(goods.get(Integer.parseInt(prods[i])));
        }
        return client;
    }

    public static void fillGoodsTable(List<Product> goods){
        performTransaction(() ->{
            for (int i = 0; i < 5; i++) {
                Double price = new Random().nextDouble(100);
                Product product = new Product("Product" + i, String.format("%.2f", price));
                goods.add(product);
                em.persist(product);
            }
            return null;
        });
    }

    public static <T> void performTransaction(Callable<T> action){
        EntityTransaction et = em.getTransaction();
        et.begin();
        try{
            action.call();
            et.commit();
        } catch(Exception ex){
            if(et.isActive()){
                et.rollback();
            }
        }
    }
}
