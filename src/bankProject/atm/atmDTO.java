package bankProject.atm;

import java.util.Date;

public class atmDTO {
    private String accountNumber;
    private Date depositDate;
    private Date withdrawDate;
    private long deposit;
    private long withdraw;

    public atmDTO() {}
    public atmDTO(String accountNumber, Date depositDate, Date withdrawDate, long deposit, long withdraw) {
        this.accountNumber = accountNumber;
        this.depositDate = depositDate;
        this.withdrawDate = withdrawDate;
        this.deposit = deposit;
        this.withdraw = withdraw;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public Date getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdraw(long withdraw) {
        this.withdraw = withdraw;
    }
    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getWithdraw() {
        return withdraw;
    }

    public void setWithdrawDate(Date withdrawDate) {
        this.withdrawDate = withdrawDate;
    }

    @Override // 입출금 객체 출력
    public String toString() {
        return "customer: {" +
                "\n accountNumber: " + accountNumber +
                "\n depositDate: " + depositDate +
                "\n withdrawDate: " + withdrawDate +
                "\n deposit: " + deposit +
                "\n withdraw: " + withdraw +
                "\n}";
    }

}
