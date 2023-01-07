import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cat {
    private String name;
    private int age;
    private static int satietyLevel;
    private static int moodLevel;
    private static int healthLevel;
    private static final Random r = new Random();
    private static final Scanner sc = new Scanner(System.in);
    private static final List<String> names = List.of("Seth", "Jasper", "Poppy", "Charlie");

    public int getAverage() {
        return (satietyLevel + moodLevel + healthLevel) / 3;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        satietyLevel = r.nextInt(60) + 20;
        moodLevel = r.nextInt(60) + 20;
        healthLevel = r.nextInt(60) + 20;
    }

    public Cat() {
        name = names.get(r.nextInt(names.size()));
        age = r.nextInt(18) + 1;
        satietyLevel = r.nextInt(100) + 1;
        moodLevel = r.nextInt(100) + 1;
        healthLevel = r.nextInt(100) + 1;
    }

    public static List<Cat> makeCats(int amount) {
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

    public static void feedCat(String name, int age){
        System.out.printf("You fed cat %s, %s years old", name, age);
        feedCatSatiety(age);
        feedCatMoodIncrease(age);

    }
    public static int feedCatSatiety(int age) {
        satietyLevel = satietyLevel + checkAgeToIncrease(age);
        return satietyLevel;
    }
    public static int feedCatMoodIncrease(int age){
        moodLevel = moodLevel + checkAgeToIncrease(age);
        return moodLevel;
    }

    public static void playWithCat(String name, int age) {
        System.out.printf("You played with the cat %s, %s years old", name, age);
        playWithCatMood(age);
        playWithCatHealth(age);
        playWithCatSatiety(age);
    }
    public static int playWithCatMood(int age){
        moodLevel = moodLevel + checkAgeToIncrease(age);
        return moodLevel;
    }
    public static int playWithCatHealth(int age){
        healthLevel = healthLevel + checkAgeToIncrease(age);
        return healthLevel;
    }
    public static int playWithCatSatiety(int age){
        satietyLevel = satietyLevel + checkAgeToDecrease(age);
        return satietyLevel;
    }

    public static void treatCat(String name, int age) {
        System.out.printf("You treated cat %s, %s years old", name, age);
        treatCatHealth(age);
        treatCatMood(age);
        treatCatSatiety(age);
    }
//    public static void newDay(){
//       newDaySatiety();
//       newDayMood();
//       newDayHealth();
//    }

    public static int newDayHealth() {
        healthLevel = healthLevel +r.nextInt(3)-3;
        return healthLevel;
    }

    public static int newDayMood() {
        moodLevel = moodLevel + r.nextInt(3)-3;
        return moodLevel;
    }

    public static int newDaySatiety() {
        satietyLevel = satietyLevel - r.nextInt(5)+1;
        return satietyLevel;
    }

    public static int treatCatHealth(int age){
        healthLevel = healthLevel + checkAgeToIncrease(age);
        return healthLevel;
    }
    public static int treatCatMood(int age){
        moodLevel = moodLevel + checkAgeToDecrease(age);
        return moodLevel;
    }
    public static int treatCatSatiety(int age){
        satietyLevel = satietyLevel + checkAgeToDecrease(age);
        return satietyLevel;
    }

    private static int checkAgeToIncrease(int age) {
        if (age >= 1 && age <= 5) {
            return 7;
        }
        if (age >= 6 && age <= 10) {
            return 5;
        }
        if (age >= 11) {
            return 4;
        }
        return 0;
    }

    private static int checkAgeToDecrease(int age) {
        if (age >= 1 && age <= 5) {
            return -3;
        }
        if (age >= 6 && age <= 10) {
            return -5;
        }
        if (age >= 11) {
            return -6;
        }
        return 0;
    }

    public static void getNewCat(List<Cat> cats) {
        cats.add(new Cat(names.get(getCatNameNumber()), getCatAge()));
    }

    public static int getCatNameNumber() {
        int catNameNumber = 0;
        try {
            System.out.println("Add a new cat");
            System.out.println("Choose a cat's name: 0-Seth, 1-Jasper, 2-Poppy, 3-Charlie");
            catNameNumber = sc.nextInt();
            if (catNameNumber > names.size() || catNameNumber < 0) {
                System.out.println("Enter number from 0-3");
                catNameNumber = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Enter answer in digits");
        }
        return catNameNumber;
    }

    public static int getCatAge() {
        int catAge = 0;
        try {
            System.out.println("Choose a cat's age: 1-18");
            catAge = sc.nextInt();
            if (catAge < 1 || catAge > 18) {
                System.out.println("Enter number from 1-18");
                catAge = sc.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Enter age from 1-18");
            catAge = sc.nextInt();
        }
        return catAge;
    }
}
