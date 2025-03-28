import java.util.Scanner;
public class SafeInput {
    public static int getRangeInt(Scanner pipe, String prompt, int low, int high) {
        int result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.println(prompt + "[" + low + "-" + high + "]:");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine();
                if (result >= low && result <= high) {
                    done = true;
                } else {
                    System.out.println("you must enter a value in the range {" + low + "-" + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("you must enter a value in the range [" + low + "-" + high + "]");
            }
        }
        while (!done);
        return result;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern) {
        String value = "";
        boolean done = false;
        do {
            System.out.print(prompt + ":");
            value = pipe.nextLine();
            if (value.matches(regExPattern)) {
                done = true;
            } else {
                System.out.println("\n Invalid input: " + value);
            }

        } while (!done);
        return value;
    }

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String value;
        do {
            System.out.print(prompt + " ");
            value = pipe.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (value.isEmpty());
        return value;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value = 0;
        boolean valid = false;
        String trash;
        do {
            System.out.print(prompt + " ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                valid = true;
            } else {
                trash = pipe.next(); // Consume invalid input
                System.out.println("Invalid input: '" + trash + "'. Please enter a valid integer.");
            }
            pipe.nextLine(); // Clear input buffer
        } while (!valid);
        return value;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double value = 0.0;
        boolean valid = false;
        String trash;
        do {
            System.out.print(prompt + " ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                valid = true;
            } else {
                trash = pipe.next(); // Consume invalid input
                System.out.println("Invalid input: '" + trash + "'. Please enter a valid decimal number.");
            }
            pipe.nextLine(); // Clear input buffer
        } while (!valid);
        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        boolean isYes = false;
        boolean valid = false;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
            if (response.equals("Y")) {
                isYes = true;
                valid = true;
            } else if (response.equals("N")) {
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (!valid);
        return isYes;
    }

    public static double getRangeDouble(Scanner pipe, String prompt, double low, double high) {
        double value = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.println(prompt + "[" + low + "-" + high + "]:");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine(); // clear the buffer
                if (value >= low && value <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a value in the range [" + low + "-" + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a value in the range [" + low + "-" + high + "]");
            }
        } while (!done);
        return value;
    }

    public static void prettyHeader(String msg) {
        final int WIDTH = 60;
        int msgLength = msg.length();
        int totalPadding = WIDTH - (msgLength + 6);
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        for (int i = 0; i < WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("***");
        for (int i = 0; i < leftPadding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < rightPadding; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();
    }


    public static void PrintArray(int[] array) {
        array[1] = 7;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " |");
            System.out.println();
        }
    }


    public static double getAverage(int values[]) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum = sum + values[i];
            System.out.println(sum);
        }
        return (double) sum / values.length;
    }
}


