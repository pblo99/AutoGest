package com.pablo.autogest.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoDAO {
    
    public Connection connectaBD() throws SQLException {
        return ConnectionPool.getConnection();
    }
}
