import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            Simulation.run();
            System.out.println("Do you want to continue: y-yes,n-no");
        } while (!SCANNER.nextLine().contains("n"));



    }
}