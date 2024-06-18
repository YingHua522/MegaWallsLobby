package cn.infnetwork.megawallslobby.database;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SQLiteCore extends DataBaseCore {
    private static final String driverName = "org.sqlite.JDBC";
    private static final Logger logger = MegaWallsLobby.getInstance().getLogger();
    private final File dbFile;
    private Connection connection;

    public SQLiteCore(File dbFile) {
        this.dbFile = dbFile;
        if (this.dbFile.exists()) {
            try {
                this.dbFile.createNewFile();
            } catch (IOException var4) {
                logger.warning("数据库文件 " + dbFile.getAbsolutePath() + " 创建失败!");
                var4.printStackTrace();
            }
        }

        try {
            Class.forName(driverName).newInstance();
        } catch (Exception var3) {
            logger.warning("数据库初始化失败 请检查驱动 " + driverName + " 是否存在!");
            var3.printStackTrace();
        }

    }

    public SQLiteCore(Plugin plugin, ConfigurationSection cfg) {
        this(plugin, cfg.getString("database"));
    }

    public SQLiteCore(Plugin plugin, String filename) {
        this.dbFile = new File(plugin.getDataFolder(), filename + ".db");
        if (this.dbFile.exists()) {
            try {
                this.dbFile.createNewFile();
            } catch (IOException var5) {
                logger.warning("数据库文件 " + this.dbFile.getAbsolutePath() + " 创建失败!");
                var5.printStackTrace();
            }
        }

        try {
            Class.forName(driverName).newInstance();
        } catch (Exception var4) {
            logger.warning("数据库初始化失败 请检查驱动 " + driverName + " 是否存在!");
            var4.printStackTrace();
        }

    }

    public SQLiteCore(String filepath) {
        this(new File(filepath));
    }

    public boolean createTables(String tableName, KeyValue fields, String Conditions) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS `%s` ( %s )";
        return this.execute(String.format(sql, tableName, fields.toCreateString().replace("AUTO_INCREMENT", "AUTOINCREMENT")));
    }

    public String getAUTO_INCREMENT() {
        return "AUTOINCREMENT";
    }

    public Connection getConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                return this.connection;
            } else {
                this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbFile);
                return this.connection;
            }
        } catch (SQLException var2) {
            logger.warning("数据库操作出错: " + var2.getMessage());
            logger.warning("数据库文件: " + this.dbFile.getAbsolutePath());
            return null;
        }
    }
}
