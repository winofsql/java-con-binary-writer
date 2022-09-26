import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {

        FileOutputStream fos;
        try {
            fos = new FileOutputStream("Settings.dat");

            float f = 1.250f;
            byte[] bytes = floatToByteArray(f);
            fos.write(bytes);

            String str = "c:\\Temp";
            bytes = str.getBytes();
            fos.write(bytes);

            bytes = intToByteArray(123456789);
            fos.write(bytes);

            fos.write(1);

            fos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static byte[] floatToByteArray(float value) {
        int intBits =  Float.floatToIntBits(value);
        return new byte[] {
            (byte) (intBits),
            (byte) (intBits >> 8),
            (byte) (intBits >> 16),
            (byte) (intBits >> 24) };
    }
    public static byte[] intToByteArray(int value) {
        return new byte[] {
            (byte) (value),
            (byte) (value >> 8),
            (byte) (value >> 16),
            (byte) (value >> 24) };
    }
}