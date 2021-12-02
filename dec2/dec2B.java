import java.io.File;
import java.util.Scanner;

public class dec2B {

    static int horPos = 0;
    static int depth = 0;
    static int aim = 0;

    public static void main(String[] args) {
        readFile();

        System.out.println("Final horizontal position is: " + horPos);
        System.out.println("Final depth is: " + depth);

        System.out.println("Answer is : " + getAnswer());

    }

    public static void readFile() {

        try {
            File file = new File("dec2/input");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String[] temp = scanner.nextLine().split(" ");
                String dir = temp[0];
                int amount = Integer.parseInt(temp[1]);

                countPosition(dir, amount);

            }

            scanner.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            // TODO: handle exception
        }

    }

    public static void countPosition(String dir, int amount) {

        switch (dir) {
            case "forward":
                horPos += amount;
                depth += (aim * amount);

                break;
            case "up":
                aim -= amount;
                break;
            case "down":
                aim += amount;
                break;

            default:
                break;
        }

    }

    public static int getAnswer() {

        int answer = horPos * depth;

        return answer;

    }

}
