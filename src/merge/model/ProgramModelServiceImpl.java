package merge.model;

/**
 * -a -s -out.txt {in.txt}
 */

public class ProgramModelServiceImpl implements ProgramModelService{

    private String upcast = "-a";
    private String downcast = "-d";
    private String stringDataType = "-s";
    private String integerDataType = "-i";
    @Override
    public ProgramModel parse(String[] args) {
        ProgramModel model = new ProgramModel();



        /**
         * Switch case?
         */
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(downcast)) {
                model.setCast(args[i]);
            }
            if (args[i].equals(stringDataType)) {
                model.setDataType(stringDataType);
            }
            if (args[i].equals(integerDataType)) {
                model.setDataType(integerDataType);
            }
            if (model.getOutputFile() != null) {
                String[] inputFiles = new String[args.length - i];

                for (int j = i; j < args.length; j++) {
                    inputFiles[j - i] = args[j];
                }
                model.setInputFiles(inputFiles);
                break;
            }
            if (args[i].endsWith(".txt")) {
                model.setOutputFile(args[i]);
            }

        }

        checkData(model);


        return model;
    }

    private void checkData(ProgramModel model) {
        if (!model.getCast().equals(upcast) && !model.getCast().equals(downcast)) {
            throw new RuntimeException("Wrong cast! Try again.");
        }
        if (!model.getDataType().equals(integerDataType) && !model.getDataType().equals(stringDataType)) {
            throw new RuntimeException("Wrong data type! Try again.");
        }
    }
}
