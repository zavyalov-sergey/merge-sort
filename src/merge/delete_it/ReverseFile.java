package merge.delete_it;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReverseFile {


    public static String reverse(String output) {
        String temp = "C:\\Users\\Sonya\\IdeaProjects\\untitled\\src\\recourses\\temp.txt";

        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(output));
             BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {

            while (reader.ready()) {
                list.add(reader.readLine());
            }

            Collections.reverse(list);

            for (String s : list) {
                writer.write(s);
                writer.newLine();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return copy(output, temp);


    }

// сделать номальный временный файл
    private static String copy(String output, String temp) {

        try (BufferedReader reader = new BufferedReader(new FileReader(temp));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {

            while (reader.ready()) {
                writer.write(reader.readLine());
                writer.newLine();
            }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return output;
    }

}