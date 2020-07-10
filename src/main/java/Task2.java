import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

    }

    public static String getLineFromConsole(){
        Scanner scanner = new Scanner(System.in);
        String line = "";
        if(scanner.hasNextLine()){
            line = scanner.nextLine();
        }
        return line;
    }
}
