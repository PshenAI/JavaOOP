package ua.kiev.prog;

import java.io.File;
import java.util.Date;

public class FileForDB {

    @Id
    private int id;

    private String name;
    private String size;
    private String lastModif;

    private String parent;

    public FileForDB() {
    }

    public FileForDB(String name, String size, String lastModif) {
        this.name = name;
        this.size = size;
        this.lastModif = lastModif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLastModif() {
        return lastModif;
    }

    public void setLastModif(String lastModif) {
        this.lastModif = lastModif;
    }

    @Override
    public String toString() {
        return "FileForDB{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", lastModif='" + lastModif + '\'' +
                '}';
    }
}
