package ua.kiev.prog;

import java.sql.Connection;

public class FilesDaoImpl extends AbstractDAO<FileForDB> {
    public FilesDaoImpl(Connection conn, String table){
        super(conn, table);
    }
}
