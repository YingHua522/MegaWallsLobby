package cn.infnetwork.megawallslobby.database;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import org.bukkit.configuration.ConfigurationSection;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DataBase {
    private final DataBaseCore dataBaseCore;
    private final Logger logger;

    public DataBase(DataBaseCore core) {
        this.dataBaseCore = core;
        this.logger = MegaWallsLobby.getInstance().getLogger();
    }

    public static DataBase create(ConfigurationSection dbConfig) {
        Type type = Type.valueOf(dbConfig.getString("type", "SQLITE").toUpperCase());
        if (type == Type.MYSQL) {
            return new DataBase(new MySQLCore(dbConfig));
        }
        return new DataBase(new SQLiteCore(MegaWallsLobby.getInstance(), dbConfig));
    }

    public void close() {
        try {
            this.dataBaseCore.getConnection().close();
        } catch (SQLException ignored) {
        }
    }

    public void createTables(String tableName, KeyValue fields, String Conditions) {
        try {
            this.dataBaseCore.createTables(tableName, fields, Conditions);
            this.isTableExists(tableName);
        } catch (Exception var5) {
            this.sqlerr("创建数据表 " + tableName + " 异常(内部方法)...", var5);
        }
    }

    public void dbDelete(String tableName, KeyValue fields) {
        String sql = "DELETE FROM `" + tableName + "` WHERE " + fields.toWhereString();

        try {
            this.dataBaseCore.executeUpdate(sql);
        } catch (Exception var5) {
            this.sqlerr(sql, var5);
        }
    }

    public boolean dbExist(String tableName, KeyValue fields) {
        String sql = "SELECT * FROM " + tableName + " WHERE " + fields.toWhereString();

        try {
            return this.dataBaseCore.executeQuery(sql).next();
        } catch (Exception var5) {
            this.sqlerr(sql, var5);
            return false;
        }
    }

    public int dbInsert(String tabName, KeyValue fields) {
        String sql = "INSERT INTO `" + tabName + "` " + fields.toInsertString();

        try {
            return this.dataBaseCore.executeUpdate(sql);
        } catch (Exception var5) {
            this.sqlerr(sql, var5);
            return 0;
        }
    }

    public List<KeyValue> dbSelect(String tableName, KeyValue fields, KeyValue selCondition) {
        String sql = "SELECT " + fields.toKeys() + " FROM `" + tableName + "`" + (selCondition == null ? "" : " WHERE " + selCondition.toWhereString());
        ArrayList kvlist = new ArrayList<>();

        try {
            ResultSet dbresult = this.dataBaseCore.executeQuery(sql);

            while (dbresult.next()) {
                KeyValue kv = new KeyValue();
                String[] var8 = fields.getKeys();
                int var9 = var8.length;

                for (String col : var8) {
                    kv.add(col, dbresult.getString(col));
                }

                kvlist.add(kv);
            }
        } catch (Exception var12) {
            this.sqlerr(sql, var12);
        }

        return kvlist;
    }


    public List<KeyValue> dbSelectA(String tableName, KeyValue fields, KeyValue selCondition) {
        String sql = "SELECT * FROM " + tableName + (selCondition == null ? "" : " WHERE " + selCondition.toWhereString());
        ArrayList kvlist = new ArrayList();

        try {
            ResultSet dbresult = this.dataBaseCore.executeQuery(sql);

            while (dbresult.next()) {
                KeyValue kv = new KeyValue();
                String[] var8 = fields.getKeys();
                int var9 = var8.length;

                for (int var10 = 0; var10 < var9; ++var10) {
                    String col = var8[var10];
                    kv.add(col, dbresult.getString(col));
                }

                kvlist.add(kv);
            }
        } catch (Exception var12) {
            this.sqlerr(sql, var12);
        }

        return kvlist;
    }


    public String dbSelectFirst(String tableName, String fields, KeyValue selConditions) {
        String sql = "SELECT " + fields + " FROM " + tableName + " WHERE " + selConditions.toWhereString() + " limit 1";

        try {
            ResultSet dbresult = this.dataBaseCore.executeQuery(sql);
            if (dbresult.next()) {
                return dbresult.getString(fields);
            }
        } catch (Exception var6) {
            this.sqlerr(sql, var6);
        }

        return null;
    }

    public int dbUpdate(String tabName, KeyValue fields, KeyValue upCondition) {
        String sql = "UPDATE `" + tabName + "` SET " + fields.toUpdateString() + " WHERE " + upCondition.toWhereString();

        try {
            return this.dataBaseCore.executeUpdate(sql);
        } catch (Exception var6) {
            this.sqlerr(sql, var6);
            return 0;
        }
    }

    public DataBaseCore getDataBaseCore() {
        return this.dataBaseCore;
    }

    public boolean isValueExists(String tableName, KeyValue fields, KeyValue selCondition) {
        String sql = "SELECT " + fields.toKeys() + " FROM `" + tableName + "`" + (selCondition == null ? "" : " WHERE " + selCondition.toWhereString());

        try {
            ResultSet dbresult = this.dataBaseCore.executeQuery(sql);
            return dbresult.next();
        } catch (Exception var6) {
            this.sqlerr(sql, var6);
            return false;
        }
    }

    public boolean isFieldExists(String tableName, KeyValue fields) {
        try {
            DatabaseMetaData dbm = this.dataBaseCore.getConnection().getMetaData();
            ResultSet tables = dbm.getTables(null, null, tableName, null);
            if (tables.next()) {
                ResultSet f = dbm.getColumns(null, null, tableName, fields.getKeys()[0]);
                return f.next();
            }
        } catch (SQLException var6) {
            this.sqlerr("判断 表名:" + tableName + " 字段名:" + fields.getKeys()[0] + " 是否存在时出错!", var6);
        }

        return false;
    }

    public boolean isTableExists(String tableName) {
        try {
            DatabaseMetaData dbm = this.dataBaseCore.getConnection().getMetaData();
            ResultSet tables = dbm.getTables(null, null, tableName, null);
            return tables.next();
        } catch (SQLException var4) {
            this.sqlerr("判断 表名:" + tableName + " 是否存在时出错!", var4);
            return false;
        }
    }

    public void sqlerr(String sql, Exception e) {
        this.logger.warning("数据库操作出错: " + e.getMessage());
        this.logger.warning("SQL查询语句: " + sql);
    }

    enum Type {
        MYSQL,
        SQLITE;

        Type() {
        }
    }
}
