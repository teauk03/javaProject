package bankProject.dbUtill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtill {
    private static final String URL = "jdbc:mysql://localhost:3306/bank"; // 기본 포트 번호로 수정
    private static final String USER = "root";
    private static final String PASSWORD = "qwer1124";

    // 데이터베이스 연결을 생성하는 메소드
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("데이터베이스 연결 성공!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터베이스 연결 실패!");
        }
        return connection;
    }

    // 데이터베이스 연결을 닫는 메소드
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("데이터베이스 연결 해제 성공!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("데이터베이스 연결 해제 실패!");
            }
        }
    }
}
