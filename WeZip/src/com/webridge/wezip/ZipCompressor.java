package com.webridge.wezip;

import java.io.*;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Thomas on 8/29/2014.
 */
public class ZipCompressor {

    /**
     * Compresses one or more files into the specified output archive
     * Does not work with directories
     * @param files An array with one or more file-path to be compressed
     * @param output The output path for the archive
     * @throws IOException if fails to read/write from the inputs/output
     */
    public static void compress(String[] files, String output)
            throws IOException {

        ZipOutputStream out = new ZipOutputStream(
                new FileOutputStream(output));

        for(String filePath : files){
            File file = new File(filePath);

            // If the file does not exists: skip
            if(!file.exists())
                continue;

            // Opening the file stream
            FileInputStream in = new FileInputStream(file);

            // Creating new entry in the zip file
            out.putNextEntry(new ZipEntry(file.getName()));

            // Init buffer
            byte[] buffer = new byte[1024];
            int readSize;

            // Write the buffer while there is something to read
            while ((readSize = in.read(buffer)) > 0){
                out.write(buffer, 0, readSize);
            }

            in.close();
        }
        out.close();
    }

    /**
     * Decompresses an archive at the specified location
     * Does not work with directories
     * @param archivePath The path to the archive file to decompress
     * @param destination The path of an existing directory where the archive will be decompressed
     */
    public static void decompress(String archivePath, String destination)
            throws IOException{

        // We open a stream to read the archive
        ZipInputStream in = new ZipInputStream(
                new FileInputStream(archivePath)
        );

        // As long as there are file in the archive to unzip
        ZipEntry entry;
        while ((entry = in.getNextEntry()) != null){

            FileOutputStream out = new FileOutputStream(
                    Paths.get(destination, entry.getName()).toString()
            );

            byte[] buffer = new byte[1024];

            int readSize;
            while((readSize = in.read(buffer)) > 0){
                out.write(buffer, 0, readSize);
            }

            out.close();
        }

        in.closeEntry();
        in.close();
    }
}
