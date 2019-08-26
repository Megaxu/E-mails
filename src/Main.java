import java.util.HashSet;
import java.util.Scanner;

public class Main {

    private static final String REGEX_LIST = "LIST";
    private static final String REGEX_ADD = "ADD\\s+.+";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9+_-]+@([A-Za-z0-9]+\\.)[a-z]{2,6}$";

    private static HashSet<String> listEmail = new HashSet<>();
    private static String text = "";
    private static String target = "";

    public static void main(String[] args) {
        while (true) {
            System.out.println(
                "Список команд: \n LIST - выводит список электронных почт; \n ADD - добавляет email в список");
            System.out.println("Введите команду: ");
            Scanner scan = new Scanner(System.in);
            text = scan.nextLine();

            if (text.matches(REGEX_ADD)) {
                addEmail(text);
            } else if (text.matches(REGEX_LIST)) {
                listEmails();
            } else {
                System.out.println("Комманда указана неверно. Повторите ввод.");
            }

            target = "";
        }
    }

    private static void addEmail(String text) {
        String[] command = text.split("\\s+");

        for (int i = 1; i < command.length; i++) {
            target += command[i] + " ";
        }

        if (isEmailCorrect(target.trim())) {
            listEmail.add(target);
        } else {
            System.out.println("Неправильно указан адрес электронной почты.");
        }

    }

    private static void listEmails() {
        for (String email : listEmail) {
            System.out.println(email);
        }
    }

    private static boolean isEmailCorrect(String target) {
        return target.matches(REGEX_EMAIL);
    }
}
