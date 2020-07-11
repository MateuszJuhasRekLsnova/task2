import java.util.Scanner;


public class Task2 {
    public static void main(String[] args) {
        PairsFinder pairsFinder = new PairsFinder();
        String lineFromConsole = getLineFromConsole();
        int[] arrayOfInts = getArrayOfIntegersFromStringLine(lineFromConsole);
        pairsFinder.findPairs(arrayOfInts);
    }

    public static String getLineFromConsole(){
        Scanner scanner = new Scanner(System.in);
        String line = "";
        if(scanner.hasNextLine()){
            line = scanner.nextLine();
        }
        scanner.close();
        return line;
    }

    public static int[] getArrayOfIntegersFromStringLine(String line){
        String[] split = line.split(" ");
        int[] intsToReturn = new int[split.length];
        for (int i = 0; i <=split.length-1; i++){
            intsToReturn[i] = Integer.parseInt(split[i]);
        }
        return intsToReturn;
    }
}
