import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<String> names = List.of("Seth", "Jasper", "Poppy", "Charlie");
    private static final  List<Cat> cats = Cat.makeCats(4);
    public static void run() {
        cats.sort(Comparator.comparingInt(Cat::getAverage).reversed());
        Printer.print(cats);
        Cat.getNewCat(cats);
        Printer.print(cats);
        chooseAction();
        Printer.print(cats);
    }

    private static void chooseAction() {
        Printer.printMenu();
        int choiceAction = 0;
        try {
            choiceAction = sc.nextInt();
            if (choiceAction> 4 || choiceAction<1){
                System.out.println("Enter correct number");
                choiceAction = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println();
        }
        switch (choiceAction){
            case 1:
                Cat.feedCat((cats.get(chooseCat()).getName()), cats.get(chooseCat()).getAge());
                break;
            case 2:
                Cat.playWithCat((cats.get(chooseCat()).getName()), cats.get(chooseCat()).getAge());
                break;
            case 3:
                Cat.treatCat((cats.get(chooseCat()).getName()), cats.get(chooseCat()).getAge());
                break;
            case 4:
                Cat.getNewCat(cats);
                break;
            default:
                System.out.println("Enter numbers from 1-4");
        }
    }
    private static int chooseCat(){
        int choiceCat = 0;
        try {
            System.out.println("Enter cat number (0-3)");
            choiceCat = sc.nextInt();
            if (choiceCat > names.size() - 1 || choiceCat < 0) {
                System.out.println("Number should be from 0-3");
                choiceCat = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Enter correct number from 0-3");
        }
        return choiceCat;
    }


}
