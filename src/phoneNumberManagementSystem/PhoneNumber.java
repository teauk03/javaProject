package phoneNumberManagementSystem;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneNumber {
    static HashMap<String, HashMap<String, String>> PhoneBook = new HashMap<>();

    // 프로그램 실행 로직
    static void programRun() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1. 추가할 전화번호 입력: ");
        String tel = scanner.nextLine();
        addPhoneNumber(tel);

        System.out.print("2. 추가할 이름 입력: ");
        String name = scanner.nextLine();
        addName(tel, name);

        System.out.print("3. 추가할 그룹 입력: ");
        String groupName = scanner.nextLine();
        addGroup(tel, groupName);
    }

    static void addPhoneNumber(String tel) {
        if (!PhoneBook.containsKey(tel)) {
            PhoneBook.put(tel, new HashMap<>());
            System.out.println("전화번호: " + tel + " 추가 완료");
        } else {
            System.out.println("전화번호가 이미 존재합니다.");
        }
    }

    static void addName(String tel, String name) {
        if (PhoneBook.containsKey(tel)) {
            PhoneBook.get(tel).put("name", name);
            System.out.println("이름: " + name + " 추가 완료");
        } else {
            System.out.println("전화번호가 존재하지 않습니다. 먼저 전화번호를 추가하세요.");
        }
    }

    static void addGroup(String tel, String groupName) {
        if (PhoneBook.containsKey(tel)) {
            PhoneBook.get(tel).put("group", groupName);
            System.out.println("그룹: " + groupName + " 추가 완료");
        } else {
            System.out.println("전화번호가 존재하지 않습니다. 먼저 전화번호를 추가하세요.");
        }
    }

    // 연락처 출력
    static void printList() {
        if (PhoneBook.isEmpty()) {
            System.out.println("전화번호부가 비어 있습니다.");
            return;
        }

        System.out.println("\n현재 저장된 전화번호부:");
        for (String tel : PhoneBook.keySet()) {
            HashMap<String, String> info = PhoneBook.get(tel);
            String name = info.getOrDefault("name", "미등록");
            String group = info.getOrDefault("group", "미등록");
            System.out.println("[전화번호: " + tel + ", 이름: " + name + ", 그룹: " + group + "]");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n전화번호부 메뉴:");
            System.out.println("1. 연락처 추가");
            System.out.println("2. 연락처 조회");
            System.out.println("3. 프로그램 종료");
            System.out.print("메뉴 선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    programRun();
                    break;
                case 2:
                    printList();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
        scanner.close();
    }
}
