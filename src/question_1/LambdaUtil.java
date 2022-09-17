package question_1;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.function.*;

public class LambdaUtil {

    static Random random = new Random();

    /**
     * Returns {@link Supplier} that always supply "Hello"
     *
     * @return a string supplier
     */
    public static Supplier<String> helloSupplier() {
        // solution 1
        /*Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        };
        return supplier;*/

        // solution 2
        /*Supplier<String> supplier = () -> "Hello";
        return supplier;
*/

        // solution 3
        return () -> "Hello";
    }

    /**
     * Returns a {@link Predicate} of string that checks if string is empty
     *
     * @return a string predicate
     */
    public static Predicate<String> isEmptyPredicate() {
        return String::isEmpty;
        // return (word) -> word.isEmpty();
    }

    /**
     * Return a {@link Function} that accepts {@link String} and returns that string repeated n time, where n is passed
     * as function argument
     *
     * @return function that repeats Strings
     */
    public static BiFunction<String, Integer, String> stringMultiplier() {
        // solution 1
        /*BiFunction<String, Integer, String> biFunction = new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String string, Integer integer) {
                return string.repeat(integer);
            }
        };
        return biFunction;*/

        // solution 2
        return (string, integer) -> string.repeat(integer);
        // return String::repeat;
    }

    /**
     * Returns a {@link Function} that converts a {@link BigDecimal} number into a {@link String} that start with
     * a dollar sign and then gets a value
     *
     * @return function that converts adds dollar sign
     */
    public static Function<BigDecimal, String> toDollarStringFunction() {
        // solution 1
        /*Function<BigDecimal, String> function = new Function<BigDecimal, String>() {
            @Override
            public String apply(BigDecimal bigDecimal) {
                return "$" + bigDecimal.toString();
            }
        };
        return function;*/

        // solution 2
        return bigDecimal -> "$" + bigDecimal.toString();
    }

    /**
     * Receives two parameter that represent a range and returns a {@link Predicate<String>} that verifies if string
     * length is in the specified range. E.g. min <= length < max
     *
     * @param min min length
     * @param max max length
     * @return a string predicate
     */
    public static Predicate<String> lengthInRangePredicate(int min, int max) {
        // solution 1
        /*Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return min <= string.length() && string.length() < max;
            }
        };
        return predicate;*/

        // solution 2
        return string -> min <= string.length() && string.length() < max;
    }

    /**
     * Returns a {@link Supplier} of random integers
     *
     * @return int supplier
     */
    public static IntSupplier randomIntSupplier() {
        // solution 1
        /*IntSupplier intSupplier = new IntSupplier() {
            @Override
            public int getAsInt() {
                return random.nextInt();
            }
        };
        return intSupplier;*/

        // solution 2
        return () -> random.nextInt();
    }

    /**
     * Returns an {@link IntUnaryOperator} that receives an int as a bound parameter, and returns a random int
     *
     * @return int operation
     */
    public static IntUnaryOperator boundedRandomIntSupplier() {
        // solution 1
        /*IntUnaryOperator intUnaryOperator = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int bound) {
                return random.nextInt(bound);
            }
        };
        return intUnaryOperator;*/

        // solution 2
        /*IntUnaryOperator intUnaryOperator = bound -> random.nextInt(bound);
        return intUnaryOperator;*/

        // solution 3
        return bound -> random.nextInt(bound);
    }

    /**
     * Returns {@link IntUnaryOperator} that calculates an integer square
     *
     * @return square operation
     */
    public static IntUnaryOperator intSquareOperation() {
        // solution 1
        /*IntUnaryOperator intUnaryOperator = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return (int) Math.pow(operand, 2);
            }
        };
        return intUnaryOperator;*/

        // solution 2
        return number -> (int) Math.pow(number, 2);
    }

    /**
     * Returns a {@link LongBinaryOperator} sum operation.
     *
     * @return binary sum operation
     */
    public static LongBinaryOperator longSumOperation() {
        // solution 1
        /*LongBinaryOperator longBinaryOperator = new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left + right;
            }
        };
        return longBinaryOperator;*/

        // solution 2
        return (firstNumber, secondNumber) -> firstNumber + secondNumber;
        //return Long::sum;
    }

    /**
     * Returns a {@link ToIntFunction<String>} that converts string to integer.
     *
     * @return string to int converter
     */
    public static ToIntFunction<String> stringToIntConverter() {
        // solution 1
        /*ToIntFunction<String> toIntFunction = new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return Integer.valueOf(value);
            }
        };
        return toIntFunction;*/

        // solution 2
        return word -> Integer.parseInt(word);
        //return Integer::parseInt;
    }

    /**
     * Receives int parameter n, and returns a {@link Supplier} that supplies {@link IntUnaryOperator}
     * that is a function f(x) = n * x
     *
     * @param n a multiplier
     * @return a function supplier
     */
    public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {
        // solution 1
        /*Supplier<IntUnaryOperator> supplier = new Supplier<IntUnaryOperator>() {
            @Override
            public IntUnaryOperator get() {
                IntUnaryOperator intUnaryOperator = new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int operand) {
                        return operand * n;
                    }
                };
                return intUnaryOperator;
            }
        };
        return supplier;*/

        // solution 2
        /*return new Supplier<IntUnaryOperator>() {
            @Override
            public IntUnaryOperator get() {
                return new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int operand) {
                        return operand * n;
                    }
                };
            }
        };*/

        // solution 3
        /*Supplier<IntUnaryOperator> supplier = () -> {
            IntUnaryOperator intUnaryOperator = (operand) -> { return operand * n;};
            return intUnaryOperator;
        };
        return supplier;*/

        // solution 4
        /*return () -> {
            return (operand) -> { return operand * n;};
        };*/

        // solution 5
        return () -> (operand) -> operand * n;
    }

    /**
     * Returns {@link Supplier} of {@link Supplier} of {@link Supplier} of {@link String} "WELL DONE".
     *
     * @return a supplier instance
     */
    public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
        // solution 1
        /*Supplier<Supplier<Supplier<String>>> supplier1 = new Supplier<Supplier<Supplier<String>>>() {
            @Override
            public Supplier<Supplier<String>> get() {
                Supplier<Supplier<String>> supplier2 = new Supplier<Supplier<String>>() {
                    @Override
                    public Supplier<String> get() {
                        Supplier<String> supplier3 = new Supplier<String>() {
                            @Override
                            public String get() {
                                return "WELL DONE";
                            }
                        };
                        return supplier3;
                    }
                };
                return supplier2;
            }
        };
        return supplier1;*/

        // solution 2
        /*Supplier<Supplier<Supplier<String>>> supplier1 = () -> {
            Supplier<Supplier<String>> supplier2 = () -> {
                Supplier<String> supplier3 = () -> {
                  return "WELL DONE";
                };
              return supplier3;
            };
            return supplier2;
        };
        return supplier1;*/

        // solution 3
        /*return () -> {
            return () -> {
                return () -> {
                    return "WELL DONE";
                };
            };
        };*/

        // solution 4
        return () -> () -> () -> "WELL DONE";
    }

    /**
     * Returns a {@link UnaryOperator} that accepts str to str function and returns the same function composed with trim
     *
     * @return function that composes functions with trim() function
     */
    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
        // solution 1
        /*UnaryOperator<Function<String, String>> unaryOperator = new UnaryOperator<Function<String, String>>() {
            @Override
            public Function<String, String> apply(Function<String, String> stringStringFunction) {
                return stringStringFunction.compose(word -> word.trim());
            }
        };
        return unaryOperator;*/

        // solution 2
        return stringStringFunction -> stringStringFunction.compose(word -> word.trim());

        // solution 3
        //return stringStringFunction -> stringStringFunction.compose(String::trim);
    }

    /**
     * Returns a {@link BiFunction} that has two parameters. First is {@link IntUnaryOperator} which is some integer function.
     * Second is {@link IntPredicate} which is some integer condition. And the third is {@link IntUnaryOperator} which is
     * a new composed function that uses provided predicate (second parameter of binary function) to verify its input
     * parameter. If predicate returns {@code true} it applies a provided integer function
     * (first parameter of binary function) and returns a result value, otherwise it returns an element itself.
     *
     * @return a binary function that receiver predicate and function and compose them to create a new function
     */
    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
        // solution 1
        return (intUnaryOperator, intPredicate) -> (n) -> {
            if (intPredicate.test(n))
                return intUnaryOperator.applyAsInt(n);
            else
                return n;
        };

        // solution 2
        /*BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> biFunction = new BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator>() {
            @Override
            public IntUnaryOperator apply(IntUnaryOperator intUnaryOperator, IntPredicate intPredicate) {
                IntUnaryOperator intUnaryOperator1 = new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int n) {
                        if (intPredicate.test(n))
                            return intUnaryOperator.applyAsInt(n);
                        else
                            return n;
                    }
                };
                return intUnaryOperator1;
            }
        };
        return biFunction;*/
    }

    /**
     * Returns a {@link BiFunction} which first parameter is a {@link Map} where key is a function name, and value is some
     * {@link IntUnaryOperator}, and second parameter is a {@link String} which is a function name. If the map contains a
     * function by a given name then it is returned by high order function otherwise an identity() is returned.
     *
     * @return a high-order function that fetches a function from a function map by a given name or returns identity()
     */
    public static BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader() {
        // solution 1
        /*BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> biFunction = new BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator>() {
            @Override
            public IntUnaryOperator apply(Map<String, IntUnaryOperator> stringIntUnaryOperatorMap, String name) {
                IntUnaryOperator intUnaryOperator = new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int operand) {
                        if (stringIntUnaryOperatorMap.get(name) == null) {
                            return operand;
                        } else
                            return stringIntUnaryOperatorMap.get(name).applyAsInt(operand);
                    }
                };
                return intUnaryOperator;
            }
        };
        return biFunction;*/

        // solution 2
        return ((stringIntUnaryOperatorMap, name) -> (IntUnaryOperator) operand -> {
            if(stringIntUnaryOperatorMap.get(name) == null)
                return operand;
            else
                return stringIntUnaryOperatorMap.get(name).applyAsInt(operand);
        });
    }
}
