package com.webridge.wezip;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static final String ZIP_OPTION = "zip";
    public static final String UNZIP_OPTION = "unzip";

    // The help displayed for the user if used incorrectly
    public static final String HELP = "WeZip allows you to Compress and Decompress files\n" +
            "Usage: wezip [OPTION] [ARCHIVE_PATH] [[FILES]||[OUTPUT_PATH] \n\n" +
            "Options:\n" +
            "   zip             Compress one or more files into the specified archive\n" +
            "   unzip           Decompress an archive";

    // A list of valid options, anything else will display the help
    private static final List<String> OPTIONS = Arrays.asList(
            ZIP_OPTION,
            UNZIP_OPTION
    );

    public static void main(String[] args) {
        // You can use those to fake arguments if necessary,
        // you can also give debug arguments under the menu Run->Edit Configurations...

        //args = new String[]{ZIP_OPTION, "webridge.zip", "webridge.bmp", "webridge2.bmp"};
        //args = new String[]{UNZIP_OPTION, "./", "webridge.zip"};

        try {

            // If the parameters aren't valid we display the doc
            validateParameters(args);

            // Get the option and send to the corresponding logic
            String option = args[0];

            // If zip option => zip!
            if (option.equals(ZIP_OPTION)) {
                ZipCompressor.compress(
                        Arrays.copyOfRange(args, 2, args.length),
                        args[1]
                );
            // If unzip option => unzip!
            } else if (option.equals(UNZIP_OPTION)) {
                ZipCompressor.decompress(
                        args[2],
                        args[1]
                );
            }
        } catch (Exception e) {
            System.out.println(HELP);
        }

    }

    /**
     * Validates the parameters given to ensure all necessary parameters
     * are passed and that a valid option is used
     * @param args The parameters to validate as an array of String
     */
    private static void validateParameters(String[] args) {

        try {
            // Need at least 3 parameters
            if (args.length < 3)
                throw new InvalidParameterException("Invalid number of parameters");

            // Check if the option is valid
            if (!OPTIONS.contains(args[0]))
                throw new InvalidParameterException("Invalid option");

            // TODO: We could do more check here

        } catch (Exception e) {
            throw new InvalidParameterException("Failed to read parameters");
        }
    }
}
