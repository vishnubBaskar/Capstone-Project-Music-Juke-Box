package DAOinterface;

import java.sql.SQLException;

public interface UserInterface {

        boolean createAccount() throws SQLException;
        boolean login() throws SQLException;

}
