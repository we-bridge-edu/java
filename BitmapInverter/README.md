The Bitmap Inverter Exercise
====

The goal is to create a simple console application that will invert the colors of a bitmap image.
A sample image is provided to help you out.

The rules
===

The console application must be able to read from a BMP file,
invert the colors without interfering with the Header of the file,
and write the result to a chosen output file.

Getting Started
===

1. Create a project named `BitmapInverter`
2. Create a package `com.webridge.bitmap`
3. Create (if not already generated) a class **Main** with the **Main method**
4. Create a method `public static byte[] inverseBmpBuffer(byte[] buffer)`
    * The method should invert each color in the array of byte and return the result
5. Create a method `public static void writeHeader(InputStream inputStream, OutputStream outputStream)`
    * The method should write the header of the BMP file
6. In the main method create the input and output streams
7. Use the methods you created to complete the exercise

Sample file info
===

* The file provided `webridge.bmp`:
    * File size: 49206 bytes
    * Picture size: 128px by 128px
    * Bit/Pixel: 24bit
    * Header: 54 bytes

How to get the Header size?
===

The header itself contains the size of the header and/or the offset where the
picture actually starts (see wikipedia on BMP file format).

Another way using the data we have here is the following:

1. Number of pixels
    * Width * Height (in pixels)
    * 128 * 128 = 16384px
2. Number of bytes/pixels
    * 1 byte = 8 bit
    * 24 bit/pixels = 3 bytes/pixels
3. Size of the image (without header)
    * Number of Pixels * bytes/pixels
    * 16384 * 3 = 49152 bytes
4. Size of the header
    * File size - Image size
    * 49206 - 49152 = 54 bytes
   
How to invert a color
===

* The byte type have a decimal value between -128 and 127
* The first positive `0` is **Black**
* The first negative `-1` is **White**

We can then invert colors by:

1. Changing the sign
2. Remove 1 for a positive (after changing the sign)
3. Add 1 for a negative (after changing the sign)

So 0 becomes -1, -10 becomes 9, 120 becomes -121....
