package ProjectBdatabase.databaseUtil;

import ProjectBdatabase.databaseUtil.Connector;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author remcoruijsenaars
 */
public class ConnectionTest {

    public static void main(String[] args) {
        try {
            Connection conn = Connector.getConnection();
            System.out.println("Connectie succesvol gemaakt.");
        } catch (SQLException exc) {
            System.err.println("Geen verbinding kunnen maken met database. Controleer uw configuratie\n"
                    + exc.toString());
        }
    }
}
