package t.o.text_to_Bin_Oct_Hex;

import androidx.annotation.NonNull;

import java.nio.charset.StandardCharsets;

public class ToBinOctHex {

    public String return_bin( String text) {



        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

        StringBuilder binaryStringBuilder = new StringBuilder();
        for (byte b : bytes) {
            String binaryString = Integer.toBinaryString(b & 0xFF);
            binaryStringBuilder.append(String.format("%8s", binaryString).replace(' ', '0'));
        }

        return binaryStringBuilder.toString();
    }

    public String return_bin(int text) {       //Overloaded return_bin
        String bin ;
        bin = Integer.toBinaryString(text);
       return bin;
    }
    public String return_oct( String text) {
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

        StringBuilder octalStringBuilder = new StringBuilder();
        for (byte b : bytes) {
            int unsignedByte = b & 0xFF; // Konwersja na wartość dodatnią
            String octalString = Integer.toOctalString(unsignedByte);
            octalStringBuilder.append(octalString).append(" ");
        }

        return octalStringBuilder.toString();}

    public String return_oct(int text) {       //Overloaded return_oct
        String bin;
        bin = Integer.toOctalString(text);
        return bin;
    }

    public String return_hex( String text) {
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);

        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte b : bytes) {
            String hexString = Integer.toHexString(b & 0xFF);
            if (hexString.length() == 1) {
                hexString = "0" + hexString; // Dodaj zero z przodu dla jednocyfrowych wartości
            }
            hexStringBuilder.append(hexString).append(" ");
        }

        return hexStringBuilder.toString();

    }
    public String return_hex(int text) {       //Overloaded return_oct
        String bin;
        bin = Integer.toHexString(text);
        return bin;
    }
    }
