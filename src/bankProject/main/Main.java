package bankProject.main;

import bankProject.account.accountDAOImplementation;
import bankProject.account.accountDTO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        accountDAOImplementation accountDAO = new accountDAOImplementation();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== 은행 계좌 관리 시스템 ===");
            System.out.println("1. 계좌 추가");
            System.out.println("2. 계좌 번호로 조회");
            System.out.println("3. 모든 계좌 조회");
            System.out.println("4. 계좌 업데이트");
            System.out.println("5. 계좌 삭제");
            System.out.println("6. 프로그램 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // 계좌 추가
                    System.out.print("계좌 번호 입력: ");
                    String accountNumber = scanner.next();
                    System.out.print("계좌 비밀번호 입력: ");
                    int accountPw = scanner.nextInt();
                    System.out.print("계좌 초기 잔액 입력: ");
                    long balance = scanner.nextLong();
                    System.out.print("고객 번호 입력: ");
                    String customerNumber = scanner.next();

                    accountDTO newAccount = new accountDTO(accountNumber, accountPw, balance, customerNumber);
                    accountDAO.addAccount(newAccount);
                    System.out.println("계좌가 성공적으로 추가되었습니다.");
                    break;

                case 2: // 계좌 번호로 조회
                    System.out.print("조회할 계좌 번호 입력: ");
                    String searchAccountNumber = scanner.next();
                    accountDTO account = accountDAO.getAccount(searchAccountNumber);
                    if (account != null) {
                        System.out.println("계좌 정보: " + account);
                    } else {
                        System.out.println("해당 계좌 번호가 존재하지 않습니다.");
                    }
                    break;

                case 3: // 모든 계좌 조회
                    List<accountDTO> allAccounts = accountDAO.getAllAcount();
                    if (allAccounts.isEmpty()) {
                        System.out.println("등록된 계좌가 없습니다.");
                    } else {
                        System.out.println("모든 계좌 정보:");
                        for (accountDTO acc : allAccounts) {
                            System.out.println(acc);
                        }
                    }
                    break;

                case 4: // 계좌 업데이트
                    System.out.print("업데이트할 계좌 번호 입력: ");
                    String updateAccountNumber = scanner.next();
                    accountDTO existingAccount = accountDAO.getAccount(updateAccountNumber);
                    if (existingAccount != null) {
                        System.out.print("새 비밀번호 입력: ");
                        int newAccountPw = scanner.nextInt();
                        System.out.print("새 잔액 입력: ");
                        long newBalance = scanner.nextLong();
                        System.out.print("새 고객 번호 입력: ");
                        String newCustomerNumber = scanner.next();

                        existingAccount.setAccountPw(newAccountPw);
                        existingAccount.setBalance(newBalance);
                        existingAccount.setCustomerNumber(newCustomerNumber);
                        accountDAO.updateAccount(existingAccount);
                        System.out.println("계좌가 성공적으로 업데이트되었습니다.");
                    } else {
                        System.out.println("해당 계좌 번호가 존재하지 않습니다.");
                    }
                    break;

                case 5: // 계좌 삭제
                    System.out.print("삭제할 계좌 번호 입력: ");
                    String deleteAccountNumber = scanner.next();
                    accountDAO.delectAccount(deleteAccountNumber);
                    System.out.println("계좌가 성공적으로 삭제되었습니다.");
                    break;

                case 6: // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
    }
}
