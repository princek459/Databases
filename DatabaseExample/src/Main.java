import java.sql.*;

public class Main {

    //  Constants
    public static final String DB_NAME = "testjava1.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/darcy/Desktop/Udemy/Databases/DatabaseExample/testjava1.db";

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

//            Creating a table
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + " text, " +
                    COLUMN_PHONE + " integer, " +
                    COLUMN_EMAIL + " text" +
                    ")");

//            Inserting data to the table (Row)
            insertContact(statement,"Prince", 12345, "prince@email.com");
            insertContact(statement,"Steve", 90210, "steve@email.com");
            insertContact(statement,"Jane", 52199, "jane@email.com");
            insertContact(statement,"Fido", 9038, "dog@email.com");


//            Updating
            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                    COLUMN_PHONE + "=101010" +
                    " WHERE " + COLUMN_NAME + "='Jane'");

//            Deleting a contact
            statement.execute("DELETE FROM " + TABLE_CONTACTS  +
                    " WHERE " + COLUMN_NAME + "='Prince'");

//          printing results sets
            ResultSet results = statement.executeQuery(" SELECT * FROM " + TABLE_CONTACTS);
            while(results.next()){
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getInt(COLUMN_PHONE) + " " +
                        results.getString(COLUMN_EMAIL));
            }
            results.close();


        } catch(SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //    Method to inset a contact
    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL +
                " ) " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}



//        Connecting to a Database and creating a blank one
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/darcy/Desktop/Udemy/JavaMasterContinued/testjava.db");
//            so the connection isn't automatically committing changes to the database
//            conn.setAutoCommit(false);
//            Statement objects to create tables
//            Statement statement = conn.createStatement();
//            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
//                                    " (name TEXT, phone INTEGER, email TEXT)");

//            Inserting a new row
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                "VALUES('Joe', 323522, 'joe@email.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                "VALUES('Jane', 223463, 'jane@email.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                "VALUES('Darcy', 9837483, 'darcy@email.com')");

//            Updating and deleting

//            *make sure there is always WHERE clause
//            statement.execute("UPDATE contacts SET phone=111111 WHERE name='Jane'");
//            statement.execute("DELETE FROM contacts WHERE name='Joe'");

//            Querying data from the database

//            statement.execute("SELECT* FROM contacts");
//            ResultSet results = statement.getResultSet();
//            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
//            while(results.next()){
//                System.out.println(results.getString("name") + " " +
//                                    results.getInt("phone") + " " +
//                                    results.getString("email"));
//            }
//            results.close();



//            Closing the database connection
//            statement.close();
//            conn.close();
//        } catch(SQLException e) {
//            System.out.println("Something went wrong: " + e.getMessage());
//        }