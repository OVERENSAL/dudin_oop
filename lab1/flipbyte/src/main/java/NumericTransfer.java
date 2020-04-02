public class NumericTransfer {

    public String decimalToBinary(int number) {
        StringBuilder binary = new StringBuilder();//используем билдер для вставки цифры в начало строки, строка не пересоздается
        for (int i = 0; i < 7; i++) {
            binary.insert(0, number % 2);
            number /= 2;
        }
        binary.insert(0, number);

        return binary.toString();
    }

    public int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
