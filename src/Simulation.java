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
            if (choiceAction> 5 || choiceAction<1){
                System.out.println("Enter correct number");
                choiceAction = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println();
        }
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
        switch (choiceAction){
            case 1:
                Cat.feedCat((cats.get(choiceCat).getName()), cats.get(choiceCat).getAge());
                break;
            case 2:
                Cat.playWithCat((cats.get(choiceCat).getName()), cats.get(choiceCat).getAge());
                break;
            case 3:
                Cat.treatCat((cats.get(choiceCat).getName()), cats.get(choiceCat).getAge());
                break;
            case 4:
                //Cat.getNewCat(cats);
                break;
//            case 5:
//                Cat.newDay();
            default:
                System.out.println("Enter numbers from 1-5");
        }

    }



}
