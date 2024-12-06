package bankProject.account;

import bankProject.dbUtill.dbUtill;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class accountDAOImplementation implements accountDAO{

    @Override // 계좌 추가 메서드
    public void addAccount(accountDTO account) {
        String insertSql = "INSERT INTO account (accountNumber, accountPw, balance, customerNumber) VALUES (?, ?, ?, ?)";
        try(Connection conn = dbUtill.getConnection();
            PreparedStatement insertPstmt = conn.prepareStatement(insertSql)) {

            insertPstmt.setString(1, account.getAccountNumber());
            insertPstmt.setInt(2, account.getAccountPw());
            insertPstmt.setLong(3, account.getBalance());
            insertPstmt.setString(4, account.getCustomerNumber());

            insertPstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override // 게좌번호를 통한 계좌 조회 메서드
    public accountDTO getAccount(String accountNumber) {
        String getSql = "SELECT * FROM account WHERE accountNumber = ? ";
        accountDTO account = null;
        try(Connection conn = dbUtill.getConnection();
            PreparedStatement getPstmt = conn.prepareStatement(getSql)) {
            getPstmt.setString(1, accountNumber);

            try (ResultSet rs = getPstmt.executeQuery()){
                if(rs.next()) {
                    account = new accountDTO(
                            rs.getString("accountNumber"),
                            rs.getInt("accuntPw"),
                            rs.getLong("balance"),
                            rs.getString("customerNumber")
                    );
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<accountDTO> getAllAcount() {
        List<accountDTO> accounts = new ArrayList<>();
        String getAllSql = "SELECT * FROM account";
        try(Connection conn = dbUtill.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(getAllSql)) {
            while (rs.next()) {
                accounts.add(new accountDTO(
                        rs.getString("accountNumber"),
                        rs.getInt("accountPw"),
                        rs.getLong("balance"),
                        rs.getString("customerNumber")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public void updateAccount(accountDTO account) {
        String updateSql = "UPDATE account SET accountPw = ?, balance = ?, customerNumber = ? WHERE accountNumber = ?";
        try(Connection conn = dbUtill.getConnection();
            PreparedStatement updatePstmt = conn.prepareStatement(updateSql);
        ){
            updatePstmt.setString(1, account.getAccountNumber());
            updatePstmt.setInt(2, account.getAccountPw());
            updatePstmt.setLong(3,account.getBalance());
            updatePstmt.setString(4, account.getCustomerNumber());
            updatePstmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delectAccount(String accountNumber) {
        String delectSql = "DELECT FROM account WHERE accountNumber = ?";
        try(Connection conn = dbUtill.getConnection();
            PreparedStatement delPstmt = conn.prepareStatement(delectSql)) {
            delPstmt.setString(1, accountNumber);
            delPstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
