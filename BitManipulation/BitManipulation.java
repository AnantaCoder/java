package BitManipulation;

public class BitManipulation {

    public static String decimalToBinary(int num) {
        if (num == 0)
            return "0";

        StringBuilder binary = new StringBuilder();
        int tempNum = num;
        while (tempNum > 0) {
            int remainder = tempNum % 2;
            binary.insert(0, remainder);
            tempNum = tempNum / 2;
        }
        return binary.toString();
    }

    public int bitwiseComplement(int n) {
        // 1009: Complement of base 10 integer
        // find the bit length → create mask of 1s → XOR.
        // converting to binary
        String decimal = decimalToBinary(n);

        int bitsLength = decimal.length();

        // masking creation
        StringBuilder oneMasker = new StringBuilder();
        for (int i = 0; i < bitsLength; i++) {
            oneMasker.append("1");
        }
        int mask = Integer.parseInt(oneMasker.toString(), 2);
        int complement = n ^ mask;

        return complement;

    }
}
