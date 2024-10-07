package Core_Java.CoreJava;

public class NumericalValues {

    public static void main(String[] args) {
        // Integer types
        byte byteValue = 127;         // 1 byte (range: -128 to 127)
        short shortValue = 32000;     // 2 bytes (range: -32,768 to 32,767)
        int intValue = 123456789;     // 4 bytes (range: -2^31 to 2^31-1)
        long longValue = 123456789012345L; // 8 bytes (range: -2^63 to 2^63-1)

        // Floating-point types
        float floatValue = 3.14f;     // 4 bytes (single precision)
        double doubleValue = 3.14159265359; // 8 bytes (double precision)

        // Character type
        char charValue = 'A';         // 2 bytes (stores a single character)

        // Boolean type
        boolean booleanValue = true;  // 1 bit (true or false)

        // Displaying values
        System.out.println("Byte Value: " + byteValue);
        System.out.println("Short Value: " + shortValue);
        System.out.println("Int Value: " + intValue);
        System.out.println("Long Value: " + longValue);
        System.out.println("Float Value: " + floatValue);
        System.out.println("Double Value: " + doubleValue);
        System.out.println("Char Value: " + charValue);
        System.out.println("Boolean Value: " + booleanValue);
    }
}
