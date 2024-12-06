package bankProject.customer;

public class customerDTO {
    private String customerNumber;
    private String customerName;

    public customerDTO() { }
    public customerDTO(String customerNumber, String customerName) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override // 고객 객체 상태 출력
    public String toString() {
        return "customer: {" +
                "\n customerNumber: " + customerNumber +
                "\n customerName: " + customerName +
                "\n}";
    }
}
