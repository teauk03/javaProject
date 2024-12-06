package bankProject.account;

public class accountDTO {
    private String accountNumber;
    private int accountPw;
    private long balance;
    private String customerNumber;

    public accountDTO() {}
    public accountDTO(String accountNumber, int accountPw, long balance, String customerNumber) {
        this.accountNumber = accountNumber;
        this.accountPw = accountPw;
        this.balance = balance;
        this.customerNumber = customerNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountPw() {
        return accountPw;
    }

    public void setAccountPw(int accountPw) {
        this.accountPw = accountPw;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
    @Override // 계좌정보 객체 출력
    public String toString() {
        return "customer: {" +
                "\n accountNumber: " + accountNumber +
                "\n accountPw: " + accountPw +
                "\n balance: " + balance +
                "\n customerNumber: " + customerNumber +
                "\n}";
    }
}
