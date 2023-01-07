import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Cat {
    private String name;
    private int age;
    private int satietyLevel;
    private int moodLevel;
    private int healthLevel;
    private static final Random r = new Random();
    private static final List<String> names = List.of("Seth", "Jasper", "Poppy", "Charlie");

    public int getAverage() {
        int average = (satietyLevel+moodLevel+healthLevel)/3;
        return average;
    }

    public Cat() {
        name = names.get(r.nextInt(names.size()));
        age = r.nextInt(18)+1;
        satietyLevel = r.nextInt(100)+1;
        moodLevel = r.nextInt(100)+1;
        healthLevel = r.nextInt(100)+1;
    }

//    public int getRandomNumberWithoutDuplicates(){
//        Stream.generate(new Random()::ints)
//                .flatMap(IntStream::boxed)
//                .distinct()
//                .limit(names.size())
//                .toArray(Integer[]::new);
//        return int
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

}
