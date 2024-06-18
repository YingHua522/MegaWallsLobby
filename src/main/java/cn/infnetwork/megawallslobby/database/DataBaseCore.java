package cn.infnetwork.megawallslobby.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataBaseCore {
    public DataBaseCore() {
    }

    public abstract boolean createTables(String var1, KeyValue var2, String var3) throws SQLException;

    public boolean execute(String sql) throws SQLException {
        return this.getStatement().execute(sql);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return this.getStatement().executeQuery(sql);
    }

    public int executeUpdate(String sql) throws SQLException {
        return this.getStatement().executeUpdate(sql);
    }

    public abstract Connection getConnection();

    private Statement getStatement() throws SQLException {
        return this.getConnection().createStatement();
    }
}
