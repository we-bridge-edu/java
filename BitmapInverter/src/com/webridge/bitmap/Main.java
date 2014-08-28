package com.webridge.bitmap;

import java.io.*;

public class Main {

    // The Header size (in bytes) of the BMP file
    private static final int HEADER_SIZE = 54;

    public static void main(String[] args) {
        try {
            // Buffer size (i.e How many byte we will read/write at a time)
            // This is important as it's not always possible to read/write
            // A whole file in one time (i.e put everything in memory)
            byte[] buffer = new byte[64];

            // Creating the input stream to read the BMP file
            FileInputStream fis = new FileInputStream("webridge.bmp");
            // Creating the output stream to write the inverted BMP file
            FileOutputStream fos = new FileOutputStream("webridge2.bmp");

            // Write the header of the file
            writeHeader(fis, fos);

            // As long as there is something to read
            while (fis.available() > 0){
                // We read a new buffer from the input stream
                fis.read(buffer);
                // And write it into the output stream
                fos.write(inverseBmpBuffer(buffer));
            }

            // Close and flush the streams
            // This is important to avoid error like "file already used..."
            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not find file");
        } catch (IOException e) {
            System.out.println("Error: Enable to read the file");
        }
    }

    /**
     * Write the header according the size specified in the HEADER_SIZE constant
     * @param inputStream The Input stream to read the Header from
     * @param outputStream The Output stream to write the Header from
     * @throws IOException if failed to read/write from the input/output streams
     */
    public static void writeHeader(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        // Creating a buffer of the header size
        // A header size should never be too big to put in memory
        // So this is not an issue.
        byte[] buffer = new byte[HEADER_SIZE];

        // Read the file header from the input stream
        inputStream.read(buffer, 0, HEADER_SIZE);
        // Write the file header to the output stream
        outputStream.write(buffer, 0, HEADER_SIZE);

        // Flush to be sure everything was written before we continue
        // That should not happen here but when working with bigger
        // file it's a good thing to do so no data are
        // lost if the application crash. Else it might have waited
        // for more data to write and the data would be lost after a crash
        outputStream.flush();
    }

    /**
     * Invert the sign of a buffer of signed BMP bytes
     * This will basically invert colors (white from/to black)
     * @param buffer An array of bytes representing BMP colors
     * @return An array of byte representing the inverted colors
     */
    public static byte[] inverseBmpBuffer(byte[] buffer){

        // Take each byte and invert it
        // Bytes here are from -128 to 127
        // The first negative (-1) is white
        // The first positive (0) is Black
        for (int i = 0; i < buffer.length; i++) {
            // We inverse the color by changing the sign
            byte newValue = (byte)(buffer[i] * -1);

            if(newValue >= 0) newValue -= 1;
            else newValue += 1;

            // We replace the color with the inverted one
            buffer[i] = newValue;
        }
        return buffer;
    }
}
