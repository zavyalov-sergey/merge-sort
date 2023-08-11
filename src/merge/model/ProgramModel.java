package merge.model;

import java.util.Arrays;

public class ProgramModel {
    private String cast;
    private String dataType;
    private String outputFile;

    private String[] inputFiles;

    public ProgramModel() {
        cast = "-a";
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public String[] getInputFiles() {
        return inputFiles;
    }

    public void setInputFiles(String[] inputFiles) {
        this.inputFiles = inputFiles;
    }

    @Override
    public String toString() {
        return "ProgramModel{" +
                "cast='" + cast + '\'' +
                ", dataType='" + dataType + '\'' +
                ", outputFile='" + outputFile + '\'' +
                ", inputFiles=" + Arrays.toString(inputFiles) +
                '}';
    }
}
