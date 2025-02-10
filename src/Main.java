import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;

public class Main {
    public static void main(String[] args) {

        // Завдання 1: Лямбда-вирази для роботи з датами

        // 1. Перевірка чи є рік високосним
        IntPredicate isLeapYear = year -> (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        System.out.println("Is 2024 a leap year? " + isLeapYear.test(2024)); // true

        // 2. Підрахунок кількості днів між двома датами
        BiFunction<LocalDate, LocalDate, Long> daysBetween = (start, end) -> java.time.temporal.ChronoUnit.DAYS.between(start, end);
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 2, 1);
        System.out.println("Days between: " + daysBetween.apply(startDate, endDate)); // 31

        // 3. Підрахунок кількості повних неділь між двома датами
        BiFunction<LocalDate, LocalDate, Long> fullWeeksBetween = (start, end) -> java.time.temporal.ChronoUnit.WEEKS.between(start, end);
        System.out.println("Full weeks between: " + fullWeeksBetween.apply(startDate, endDate)); // 4

        // 4. Підрахунок дня тижня для конкретної дати
        Function<LocalDate, String> dayOfWeek = date -> date.getDayOfWeek().toString();
        LocalDate date = LocalDate.of(1969, 7, 20);
        System.out.println("Day of the week: " + dayOfWeek.apply(date)); // SUNDAY


        // Завдання 2: Лямбда-вирази для дробів

        // 1. Сума двох дробів
        BiFunction<Double, Double, Double> sumFractions = (a, b) -> a + b;
        System.out.println("Sum of fractions: " + sumFractions.apply(1.5, 2.5)); // 4.0

        // 2. Різниця двох дробів
        BiFunction<Double, Double, Double> subtractFractions = (a, b) -> a - b;
        System.out.println("Difference of fractions: " + subtractFractions.apply(5.0, 3.0)); // 2.0

        // 3. Множення двох дробів
        BiFunction<Double, Double, Double> multiplyFractions = (a, b) -> a * b;
        System.out.println("Multiplication of fractions: " + multiplyFractions.apply(1.5, 2.0)); // 3.0

        // 4. Ділення двох дробів
        BiFunction<Double, Double, Double> divideFractions = (a, b) -> a / b;
        System.out.println("Division of fractions: " + divideFractions.apply(5.0, 2.0)); // 2.5


        // Завдання 3: Лямбда-вирази для максимуму та мінімуму

        // 1. Максимум із чотирьох чисел
        Function<int[], Integer> maxOfFour = arr -> Math.max(Math.max(arr[0], arr[1]), Math.max(arr[2], arr[3]));
        int[] numbers = {4, 7, 1, 9};
        System.out.println("Max of four: " + maxOfFour.apply(numbers)); // 9

        // 2. Мінімум із чотирьох чисел
        Function<int[], Integer> minOfFour = arr -> Math.min(Math.min(arr[0], arr[1]), Math.min(arr[2], arr[3]));
        System.out.println("Min of four: " + minOfFour.apply(numbers)); // 1


        // Завдання 4: Лямбда-вирази для перевірки чисел

        // 1. Перевірка на рівність конкретному числу
        IntPredicate equalsToTen = x -> x == 10;
        System.out.println("Is 10 equal to 10? " + equalsToTen.test(10)); // true

        // 2. Число не знаходиться в діапазоні від A до B
        IntPredicate notInRange = x -> x < 5 || x > 10;
        System.out.println("Is 3 not in range [5, 10]? " + notInRange.test(3)); // true

        // 3. Перевірка на додатне число
        IntPredicate isPositive = x -> x > 0;
        System.out.println("Is 5 positive? " + isPositive.test(5)); // true

        // 4. Перевірка на від'ємне число
        IntPredicate isNegative = x -> x < 0;
        System.out.println("Is -5 negative? " + isNegative.test(-5)); // true
    }
}
