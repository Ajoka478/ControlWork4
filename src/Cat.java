import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cat {
    private String name;
    private int age;
    private int satietyLevel;
    private int moodLevel;
    private int healthLevel;
    private static final Random r = new Random();
    private static final Scanner sc = new Scanner(System.in);
    private static final List<String> names = List.of("Seth", "Jasper", "Poppy", "Charlie");

    public int getAverage() {
        int average = (satietyLevel+moodLevel+healthLevel)/3;
        return average;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        satietyLevel = r.nextInt(60)+20;
        moodLevel = r.nextInt(60)+20;
        healthLevel = r.nextInt(60)+20;
    }

    public Cat() {
        name = names.get(r.nextInt(names.size()));
        age = r.nextInt(18)+1;
        satietyLevel = r.nextInt(100)+1;
        moodLevel = r.nextInt(100)+1;
        healthLevel = r.nextInt(100)+1;
    }

//    public List<Integer> getRandomNumberWithoutDuplicates(){
//        Stream.generate(new Random()::ints)
//                .flatMap(IntStream::boxed)
//                .distinct()
//                .limit(names.size())
//                .toArray(Integer[]::new);
//        return List<I>;
//    }
    public static final List<Cat> makeCats(int amount){
        return Stream.generate(Cat::new)
                .limit(amount)
                .distinct()
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public int getSatietyLevel() {
        return satietyLevel;
    }


    public int getMoodLevel() {
        return moodLevel;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void feedCat(String name, int age) {
        System.out.printf("You fed cat %s, %s years old", name, age);
    }


    public static void playWithCat(String name, int age) {
        System.out.printf("You played with the cat %s, %s years old", name, age);
    }


    public static void treatCat(String name, int age) {
        System.out.printf("You treated cat %s, %s years old", name, age);
    }
    public static void getNewCat(List<Cat> cats){
        cats.add(new Cat(names.get(getCatNameNumber()),getCatAge()));
    }
    public static int getCatNameNumber(){
        int catNameNumber = 0;
        try {
            System.out.println("Add a new cat");
            System.out.println("Choose a cat's name: 0-Seth, 1-Jasper, 2-Poppy, 3-Charlie");
            catNameNumber = sc.nextInt();
            if (catNameNumber>names.size() || catNameNumber<0){
                System.out.println("Enter number from 0-3");
                catNameNumber = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Enter answer in digits");
        }
        return catNameNumber;
    }
    public static int getCatAge(){
        int catAge = 0;
        try{
            System.out.println("Choose a cat's age: 1-18");
            catAge = sc.nextInt();
            if(catAge<1 || catAge>18){
                System.out.println("Enter number from 1-18");
                catAge = sc.nextInt();
            }
        } catch (Exception e){
            System.out.println("Enter age from 1-18");
            catAge = sc.nextInt();
        }
        return catAge;
    }
}
