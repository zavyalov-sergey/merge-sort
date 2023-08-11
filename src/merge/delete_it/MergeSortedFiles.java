package merge.delete_it;

import merge.model.ProgramModel;
import merge.model.ProgramModelService;
import merge.model.ProgramModelServiceImpl;
import merge.ReverseFile;

import java.io.*;

public class MergeSortedFiles {
    public static void main(String[] args) {

        ProgramModelService modelService = new ProgramModelServiceImpl();
        ProgramModel model = modelService.parse(args);

        System.out.println(model.toString());

        String downcast = "-d";
        String stringDataType = "-s";
        String integerDataType = "-i";

        if (model.getDataType().equals(stringDataType)) {
            stringMerge(model);
        } else {
            intMerge(model);
        }
        if (model.getCast().equals(downcast)) {
            model.setOutputFile(ReverseFile.reverse(model.getOutputFile()));

        }

        System.out.println(model.getOutputFile());

    }


    static void stringMerge(ProgramModel model) {
        String outputFile = model.getOutputFile();
        String[] inputFiles = model.getInputFiles();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            BufferedReader[] readers = new BufferedReader[inputFiles.length];

            for (int i = 0; i < inputFiles.length; i++) {
                readers[i] = new BufferedReader(new FileReader(inputFiles[i]));
            }

            String[] currentValues = new String[inputFiles.length];

            for (int i = 0; i < inputFiles.length; i++) {
                currentValues[i] = readers[i].readLine();
            }

            while (true) {
                int minIndex = -1;
                String minValue = null;

                for (int i = 0; i < inputFiles.length; i++) {
                    if (currentValues[i] != null) {
                        if (minIndex == -1 || currentValues[i].compareTo(currentValues[minIndex]) < 0) {
                            minIndex = i;
                            minValue = currentValues[i];
                        }
                    }
                }

                if (minIndex == -1) {
                    break;
                }

                bw.write(minValue);
                bw.newLine();
                currentValues[minIndex] = readers[minIndex].readLine();
            }

            for (BufferedReader reader : readers) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void intMerge(ProgramModel model) {
        String outputFile = model.getOutputFile();
        String[] inputFiles = model.getInputFiles();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            BufferedReader[] readers = new BufferedReader[inputFiles.length];
            for (int i = 0; i < inputFiles.length; i++) {
                readers[i] = new BufferedReader(new FileReader(inputFiles[i]));
            }

            String[] currentValues = new String[inputFiles.length];
            for (int i = 0; i < inputFiles.length; i++) {
                currentValues[i] = readers[i].readLine();
            }

            while (true) {
                int minIndex = -1;
                String minValue = null;

                for (int i = 0; i < inputFiles.length; i++) {
                    if (currentValues[i] != null) {
                        if (minIndex == -1 || Integer.parseInt(currentValues[i]) < Integer.parseInt(currentValues[minIndex])) {
                            minIndex = i;
                            minValue = currentValues[i];
                        }
                    }
                }

                if (minIndex == -1) {
                    break;
                }

                bw.write(minValue);
                bw.newLine();
                currentValues[minIndex] = readers[minIndex].readLine();
            }

            for (BufferedReader reader : readers) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}