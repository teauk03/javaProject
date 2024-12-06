package bankProject.customer;

import bankProject.customer.customerDAO;
import bankProject.customer.customerDTO;
import bankProject.dbUtill.dbUtill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class customerDAOImplementation implements customerDAO {

    @Override // 고객 추가: addCustomer method
    public void addCustomer(customerDTO customer) {
        String confirmationSql = "SELECT * FROM customer WHERE customerNumber = ?";
        String insertSql = "INSERT INTO customer(customerNumber, customerName) VALUES (?, ?)";
        try (Connection conn = dbUtill.getConnection();
             PreparedStatement confirmationPstmt = conn.prepareStatement(confirmationSql); // 고객번호 중복
             PreparedStatement insertPstmt = conn.prepareStatement(insertSql); // 고객번호 삽입
        ){
            // 고객 번호 중복 검사 로직
            confirmationPstmt.setString(1, customer.getCustomerNumber()); // 쿼리 준비 후 고객 번를 쿼리에 바인딩
            try (ResultSet rs = confirmationPstmt.executeQuery()) { // 쿼리 실행 후 결과를 ResultSet로 변환 후 닫기
                if (rs.next() && rs.getInt(1)>0) { // 결과 값에 데이터가 존재하고 첫번째 열의 값이 0보다 클 경우(고객 정보가 이미 있는 경우)
                    System.out.println("고객번호 추가 실패(중복코드)");
                    return;
                }

            }
            // 고객 추가
            insertPstmt.setString(1, customer.getCustomerNumber()); //index 1 -> 고객 번호
            insertPstmt.setString(2,customer.getCustomerName()); // index 2 -> 고객 이름
            int rowCount = insertPstmt.executeUpdate(); // executeUpdate() 메서드는 SQL문에 영향을 받은 행의 수를 정수 값으로 반환한다.

            // SQL 문이 적어도 1개는 영향이 갔는가?
            if (rowCount > 0) {
                System.out.println("고객 추가 성공");
            } else {
                System.out.println("고객 추가 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override // 고객 번호를 입력 후 고객 정보를 조회하는 메서드
    public customerDTO getCustomer(String customerNumber) {
        String getCustomerSql = "SELECT * FROM customer WHERE customerNumber = ?";
        customerDTO customer = null; // 데이터 베이스에서 찾지 못할 기본 값 설정
       try (Connection conn = dbUtill.getConnection();
            PreparedStatement getPpstmt = conn.prepareStatement(getCustomerSql)) { // 쿼리 준비
           getPpstmt.setString(1, customerNumber);
           try (ResultSet rs = getPpstmt.executeQuery()) { // 쿼리 실행 후 결과를 rs에 저장
               if(rs.next()) { // 그 쿼리 실행 결과에 해당 행이 있는지 조회
                   customer = new customerDTO( // 있다면 customer 객체 생성 후 customerNumber,Name을 가져온다
                           rs.getString("customerNumber"),
                           rs.getString("customerName")
                   );
               }
           }
       }catch (SQLException e) {
           e.printStackTrace();

       }
       return customer;
    }

    @Override // 모든 회원 정보 조회 메서드
    public List<customerDTO> getAllcustome() {
        List<customerDTO> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try (Connection conn = dbUtill.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                customers.add(new customerDTO(
                        rs.getString("customerNumber"),
                        rs.getString("customerName")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override //  고객 삭제 메서드 (고객의 고객번호를 이용한 삭제)
    public void delectCustomer(String customerNumber) {
    String delectSql = "DELETE FROM customer WHERE customerNumber = ?";
    try (Connection conn = dbUtill.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(delectSql))
    {   pstmt.setString(1, customerNumber);
        pstmt.executeUpdate();

    } catch (SQLException e){ e.printStackTrace();}
    }
}
