
package connectdatabase;
import java.sql.SQLException;
public class DatabaseSingleton {
    private static Database instance;

   private DatabaseSingleton() {
   }

    public static synchronized Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
            instance.getConnection();
        }
        return instance;
    }
}