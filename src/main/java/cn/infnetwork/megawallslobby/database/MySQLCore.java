package cn.infnetwork.megawallslobby.database;

import cn.infnetwork.megawallslobby.MegaWallsLobby;
import org.bukkit.configuration.ConfigurationSection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class MySQLCore extends DataBaseCore {
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final Logger logger = MegaWallsLobby.getInstance().getLogger();
    private final String username;
    private final String password;
    private final String url;
    private Connection connection;

    public MySQLCore(ConfigurationSection cfg) {
        this(cfg.getString("ip"), cfg.getInt("port"), cfg.getString("database"), cfg.getString("username"), cfg.getString("password"));
    }

    public MySQLCore(String host, int port, String dbname, String username, String password) {
        this.url = "jdbc:mysql://" + host + ":" + port + "/" + dbname;
        this.username = username;
        this.password = password;

        try {
            Class.forName(driverName).newInstance();
        } catch (Exception var7) {
            logger.warning("数据库初始化失败 请检查驱动 " + driverName + " 是否存在!");
        }

    }

    public boolean createTables(String tableName, KeyValue fields, String conditions) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS `" + tableName + "` ( " + fields.toCreateString() + (conditions == null ? "" : " , " + conditions) + " );";
        return this.execute(sql);
    }

    public Connection getConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                return this.connection;
            } else {
                this.connection = DriverManager.getConnection(this.url, this.username, this.password);
                return this.connection;
            }
        } catch (SQLException var2) {
            logger.warning("数据库操作出错: " + var2.getMessage());
            logger.warning("登录URL: " + this.url);
            logger.warning("登录账户: " + this.username);
            logger.warning("登录密码: " + this.password);
            return null;
        }
    }
}
