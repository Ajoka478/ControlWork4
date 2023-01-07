import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Printer {
    private static void printHeader() {
        System.out.printf("%1$10.10s | %1$3.3s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-10.11s|%n", "---------------");
        System.out.printf("%10.10s | %3.3s | %10.10s | %10.10s | %10.10s | %10.10s |%n", "Name", "Age", "Health", "Mood", "Satiety" , "Average");
        System.out.printf("%1$10.10s | %1$3.3s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s |%n", "--------------");
    }
    private static void printCat(Cat cat) {
        System.out.printf("%10.10s | %3.3s | %-10.10s | %-10.10s | %-10.10s | %-10.10s |%n", cat.getName(), cat.getAge(), cat.getHealthLevel(), cat.getMoodLevel(), cat.getSatietyLevel(), cat.getAverage());
        System.out.printf("%1$10.10s | %1$3.3s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-10.11s|%n", "---------------");
    }
    public static void print(List<Cat> cats) {
        printHeader();
        cats.forEach(Printer::printCat);
        System.out.println();
    }
    public static void printMenu(){
        System.out.println("1 - покормить");
        System.out.println("2 - поиграть");
        System.out.println("3 - к ветеринару");
        System.out.println("4 - завести нового");
    }

}
