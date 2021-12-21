import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

   private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb101?serverTimezone=Europe/Kiev";

   private static final String DB_LOGIN = "root";
   private static final String DB_PASSWORD = "Toxa_Glob123";

   private static Connection conn;

    public static void main(String[] args) {

            try(Scanner sc = new Scanner(System.in);) {
                conn = DriverManager.getConnection(DB_CONNECTION, DB_LOGIN, DB_PASSWORD);
                initDB();

                while(true){
                    System.out.println("Enter wanted query:\n" +
                            "-fillRandom = 1\n-addFlat = 2\n-viewFlats = 3");
                    String comm = sc.nextLine();
                    switch (comm){
                        case "1":
                            fillWithFlats(sc);
                            break;
                        case "2":
                            addFlat(sc);
                            break;
                        case "3":
                            System.out.println("What parameter we'll use?");
                            String param = sc.nextLine();
                            System.out.println("What condition we'll use?");
                            String cond = sc.nextLine();
                            viewFlatsBy(param, cond);
                            break;
                        default:
                            if(!comm.equals("")){
                                System.out.println("Unknown command.");
                            } else {
                                return;
                            }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    public static void initDB() throws SQLException {
        try(Statement st = conn.createStatement();){
            st.execute("DROP TABLE IF EXISTS Flats");
            st.execute("CREATE TABLE Flats(flat_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "district VARCHAR(50) DEFAULT NULL, area DECIMAL(5, 2), room_number INT," +
                    "price DECIMAL(10, 2))");
        }
    }

    public static void addFlat(Scanner sc) throws SQLException{
        System.out.println("Enter district:");
        String dist = sc.nextLine();
        System.out.println("Enter an area of flat: ");
        String area = sc.nextLine();
        double areaD = Double.parseDouble(area);
        System.out.println("Enter number of rooms: ");
        String room = sc.nextLine();
        int roomD = Integer.parseInt(room);
        System.out.println("Enter price for flat: ");
        String price = sc.nextLine();
        double priceD = Double.parseDouble(price);

        try(PreparedStatement ps = conn.prepareStatement("INSERT INTO " +
                "Flats (district, area, room_number, price) " + "VALUES(?, ?, ?, ?)")){
            ps.setString(1, dist);
            ps.setDouble(2, areaD);
            ps.setInt(3, roomD);
            ps.setDouble(4, priceD);
            ps.executeUpdate();
        }
    }

    public static void fillWithFlats(Scanner sc) throws SQLException{
        System.out.println("How many flats do you want to add: ");
        String numS = sc.nextLine();
        Integer num = Integer.parseInt(numS);
        Random rnd = new Random();

        conn.setAutoCommit(false);
        try(PreparedStatement ps = conn.prepareStatement("INSERT INTO " +
                "Flats(district, area, room_number, price) " + "VALUES(?, ?, ?, ?)")){
                for (int i = 0; i < num; i++){
                    ps.setString(1, "test" + rnd.nextInt(4));
                    ps.setDouble(2, rnd.nextDouble(300));
                    ps.setInt(3, rnd.nextInt(5));
                    ps.setDouble(4, rnd.nextDouble(500_000));
                    ps.executeUpdate();
                }
                conn.commit();
        } catch (Exception ex){
            conn.rollback();
            ex.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
        }
    }

    private static void viewFlatsBy(String param, String cond) throws SQLException{
        try(PreparedStatement ps = conn.prepareStatement("SELECT " + param + " FROM Flats WHERE " + cond); ResultSet rs = ps.executeQuery();){
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <=md.getColumnCount(); i++){
                    System.out.print(md.getColumnName(i) + "\t\t");
                }
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++){
                        System.out.print(rs.getString(i) + "\t\t\t");
                    }
                    System.out.println();
                }
        }
    }
}
