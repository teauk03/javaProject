package bankProject.account;

import java.util.List;

public interface accountDAO {
    void addAccount(accountDTO account);
    accountDTO getAccount(String accountNumber);
    List<accountDTO> getAllAcount();
    void updateAccount(accountDTO account);
    void delectAccount(String accountNumber);
}
