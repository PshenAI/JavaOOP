package ua.kiev.prog;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try (Connection conn = ConnectionFactory.getConnection()) {
            try (Statement st = conn.createStatement()) {
                st.execute("DROP TABLE IF EXISTS FileForDB");
            }
            FilesDaoImpl fdi = new FilesDaoImpl(conn, "FileForDB");
            fdi.createTable(FileForDB.class);

            File fld = new File("test0");
            List<FileForDB> flList = objCreator(fld);

            flList.forEach(a -> fdi.add(a));

            deleteFile("jojo.txt", fdi, flList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteFile(String fileName, FilesDaoImpl fdi, List<FileForDB> flList) {
        for (FileForDB ffdb: flList) {
            if(fileName.equals(ffdb.getName())){
                fdi.delete(ffdb);
                File parent = new File(ffdb.getParent());
                File[] fls = parent.listFiles();
                for (File fl: fls) {
                    if(fl.getName().equals(fileName)){
                        fl.delete();
                    }
                }
            }
        }
    }

    public static List<FileForDB> objCreator(File fld) {
        Map<Integer, String[]> fls = folderReader(fld);
        List<FileForDB> res = new ArrayList<>();
        fls.forEach((k, v) -> {
            Date lastModif = new Date(Long.valueOf(v[2]));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            FileForDB temp = new FileForDB(v[0], v[1], sdf.format(lastModif));
            temp.setParent(fld.getAbsolutePath());
            res.add(temp);
        });

        return res;
    }

    public static Map<Integer, String[]> folderReader(File fld) {
        Map<Integer, String[]> res = new HashMap<>();
        File[] files = fld.listFiles();
        int count = 1;
        for (File file : files) {
            String[] flData = new String[3];
            flData[0] = file.getName();
            flData[1] = String.valueOf(file.length());
            flData[2] = String.valueOf(file.lastModified());
            res.put(count, flData);
            count++;
        }
        return res;
    }
}
