package sg.edu.nus.iss;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        // read string/content from arguments passed in when running app
        // e.g. java sg.edu.nus.iss/App "C:\Data" myfile.txt

        if (args.length > 0) {
            for (int i =0; i < args.length; i++) {
                System.out.println("Argument " + i + ": " + args[i]);
            }           
        } else {
            System.out.println("You have not passed in any arguments.");
        }   

        // assign variables to arguments
        // concat both variables

        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        // use File object to check if directory exists
        // create directory if directory does not exist
        // Slide 3

        File newDirectory = new File(dirPath);

        if (newDirectory.exists()) {
            System.out.println("Directory " + dirPath + " already exists");
        } else {
            newDirectory.mkdir();
        }

        // check whether a file exists in directory
        // create file if file does not exist

        File fileData = new File(dirPathFileName);

        if (fileData.exists()) {
            System.out.println(dirPathFileName + " already exists");
        } else {
            fileData.createNewFile();
        }

        // create new String variable with content to write to file

        String content = "\n I would like to go home early to rest and start coding practice again.";
        String content2 = "\n Let's keep on coding and coding and coding...";

        // initiate FileWriter object and write String content to file

        FileWriter fileWriter = new FileWriter(dirPathFileName, true);
        fileWriter.write(content + "\n" + content2);
        fileWriter.flush();
        fileWriter.close();

        // another example using a type of decorator pattern

        String content3 = "\n The quick brown fox jumps over the lazy dog.";
        FileWriter fw2 = new FileWriter(dirPathFileName, true);
        BufferedWriter bw = new BufferedWriter(fw2);
        bw.append(content3);
        bw.flush();
        bw.close();
        fw2.close();

        // another example using FileOutputStream

        String content4 = "\n It's good to buy a MacBook with 32GB of RAM for your development.";
        FileOutputStream fos = new FileOutputStream(dirPathFileName, true);
        byte[] byteContent = content4.getBytes();
        fos.write(byteContent);
        fos.flush();
        fos.close();

        // another example with decorator pattern
        String content5 = "\n I am going to buy the Apple AirTag this weekend.";
        FileOutputStream fos2 = new FileOutputStream(dirPathFileName, true);
        DataOutputStream dos2 = new DataOutputStream(fos2);
        dos2.writeBytes(content5);
        dos2.flush();
        dos2.close();
        fos2.close();

    }
 }
