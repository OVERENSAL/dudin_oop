import java.io.*;

public class Flipbyte {
    private static final String INCORRECT_INPUT = "Incorrect input. Enter a number from 0 to 255.";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 255;

    public static void main(String[] args) {
        int number = checkNumber();
        if (number != -1) {
            NumericTransfer transfer = new NumericTransfer();
            String binary = transfer.decimalToBinary(number);
            String reverseBinary = flip(binary);
            number = transfer.binaryToDecimal(reverseBinary);
            System.out.println(number);
        }
    }

    public static int checkNumber() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = -1;
            number = Integer.parseInt(reader.readLine());//может выбросить NumberFormatException, если введем не число
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IOException();
            }
            return number;
        } catch (IOException | NumberFormatException e) {//обработка двух исключений сразу, иначе нужно оборачивать
            System.out.println(INCORRECT_INPUT);//в еще один блок try-catch, нормально так делать или нет, пока не знаю
        }
        return -1;
    }

    public static String flip(String binarySequence) {
        StringBuilder builder = new StringBuilder(binarySequence);
        builder.reverse();
        return builder.toString();
    }
}
