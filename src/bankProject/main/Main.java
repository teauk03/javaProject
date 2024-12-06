package bankProject.main;
import bankProject.account.accountDAOImplementation;
import bankProject.account.accountDTO;
import bankProject.customer.customerDAOImplementation;
import bankProject.customer.customerDTO;
import bankProject.dbUtill.dbUtill;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        accountDAOImplementation dao = new accountDAOImplementation();
        System.out.println("All Accounts:");
        dao.getAllAcount().forEach(System.out::println);

    }

}
