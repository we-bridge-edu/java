ZIP Exercise
====

The goal is to create a functional CLI tool able to compress and decompress files.
 
The Rules
===

* The tool must be usable from a CLI (see output sample) (best using a JAR file)
* Should have 2 options:
    * zip: Zip one or more files into a zip archive at the specified path
    * unzip: Unzip all the files in a zip archive to the specified folder

Getting Started
===

1. Create a project named `WeZip`
2. Create a package named `com.webridge.wezip`
3. Create a `ZipCompressor` class with:
    * A static method `public static void compress(String[] files, String output)`
        * The method should compress all the files in parameter to the specified output path
    * A static method `public static void decompress(String archivePath, String destination)`
        * The method should decompress the specified archive in the specified directory
4. In your Main class:
    * A static method `private static void validateParameters(String[] args`
        * The method should validate at least that a good number of parameter is provided
        and that the used picked a valid option
    

Help & Tips
===

* Java has the `ZipInputStream` and `ZipOutputStream` classes to help you out
* You can create a **Jar** file in **IntelliJ** for your module in:
    1. `File->Project Structure...->Artifacts`
    2. Add a new artifact of type `Jar`
    3. Chose the output path, the main class to use and check `Build On Make` option
    
Sample output
===

```
WeBridge>java -jar WeZip.jar
WeZip allows you to Compress and Decompress files
Usage: wezip [OPTION] [ARCHIVE_PATH] [[FILES]||[OUTPUT_PATH]

Options:
   zip             Compress one or more files into the specified archive
   unzip           Decompress an archive


WeBridge>java -jar WeZip.jar zip test.zip webridge.bmp webridge2.bmp
WeBridge>java -jar WeZip.jar unzip test.zip ./
```