import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        var cats = Cat.makeCats(4);
        cats.sort(Comparator.comparingInt(Cat::getAverage).reversed());
        Printer.print(cats);
        System.out.println("Add a new cat");
        int catName = 0;
        try {
            System.out.println("Choose a cat's name: 1-Seth, 2-Jasper, 3-Poppy, 4-Charlie, 5-Harry");
            catName = sc.nextInt();
            System.out.println("Choose a cat's age: 1-18");
            int catAge = sc.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Enter answer in digits");
        }

        switch (catName){
            case 1:
                return ca;

        }

    }
}