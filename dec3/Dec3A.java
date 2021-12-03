import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dec3A {

    public static void main(String[] args) {
        try {
            File file = new File("dec3/input");
            Scanner scanner = new Scanner(file);
            List<String> list = new ArrayList<>();

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            scanner.close();

            firstPart(list);
            secondPart(list);

        } catch (FileNotFoundException e) {
            System.out.println(
                    e);
        }

    }

    public static void firstPart(List<String> inputList) {
        StringBuilder gammaBuilder = new StringBuilder();
        StringBuilder epsilonBuilder = new StringBuilder();

        for (int j = 0; j < inputList.get(0).length(); j++) {
            int i = j;
            int oneCount = (int) inputList.stream().filter(s -> s.charAt(i) == '1').count();
            int zeroCount = inputList.size() - oneCount;

            if (oneCount > zeroCount) {
                gammaBuilder.append('1');
                epsilonBuilder.append('0');
            } else {
                gammaBuilder.append('0');
                epsilonBuilder.append('1');

            }

        }
        int gamma = Integer.parseInt(gammaBuilder.toString(), 2);
        int epsilon = Integer.parseInt(epsilonBuilder.toString(), 2);

        System.out.println("Power consumption: " + gamma * epsilon);

    }

    public static void secondPart(List<String> inputList) {
        List<String> oxygenList = new ArrayList<>(filterList(inputList, true));
        List<String> co2List = new ArrayList<>(filterList(inputList, false));

        int oxygen = Integer.parseInt(oxygenList.get(0), 2);
        int co2 = Integer.parseInt(co2List.get(0), 2);

        System.out.println("Life support: " + oxygen * co2);

    }

    public static List<String> filterList(List<String> inputList, boolean oxygen) {
        char value1, value2;
        if (oxygen) {
            value1 = '1';
            value2 = '0';
        } else {
            value1 = '0';
            value2 = '1';

        }

        for (int j = 0; j < inputList.get(0).length(); j++) {
            if (inputList.size() == 1) {
                return inputList;
            }
            int i = j;
            int oneCount = (int) inputList.stream().filter(s -> s.charAt(i) == '1').count();
            int zeroCount = inputList.size() - oneCount;

            if (oneCount > zeroCount) {
                inputList = inputList.stream().filter(s -> s.charAt(i) == value1).collect(Collectors.toList());
            } else if (oneCount == zeroCount) {
                inputList = inputList.stream().filter(s -> s.charAt(i) == value1).collect(Collectors.toList());

            } else {
                inputList = inputList.stream().filter(s -> s.charAt(i) == value2).collect(Collectors.toList());

            }

        }

        return inputList;
    }
}
