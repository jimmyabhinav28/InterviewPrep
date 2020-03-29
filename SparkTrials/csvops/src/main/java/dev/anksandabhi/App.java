package dev.anksandabhi;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Integer maximumNumberOfLinesPerPartition=1000000;//1 million lines per partition
    public static void main( String[] args ) throws Exception {
        String csvFileToProcessAbsolutePath=args[0];
        String tempDirectoryForSplitFilesAbsolutePath=args[1];
        String outputCsvFileDirectoryAbsolutePath=args[2];
        File[] listOfSplitFiles=splitCsvFiles(csvFileToProcessAbsolutePath,tempDirectoryForSplitFilesAbsolutePath);
        processSplitFiles(listOfSplitFiles);

    }

    private static void processSplitFiles(File[] listOfSplitFiles) {
        //let's use the OS's concurrency itself
        //i will start a java process which reads the chunk
    }

    private static File[] splitCsvFiles(String csvFileToProcessAbsolutePath, String tempDirectoryForSplitFilesAbsolutePath) throws Exception {

        Path pathToCsvFile= Paths.get(csvFileToProcessAbsolutePath);
        Path pathToTempDirectory=Paths.get(tempDirectoryForSplitFilesAbsolutePath);
        Files.move(pathToCsvFile,pathToTempDirectory);
        String csvFileFileName=pathToCsvFile.getFileName().toString();
        String newPathOfFileToProcess=pathToTempDirectory.toString()+"/"+csvFileFileName;

        ProcessBuilder processBuilder=new ProcessBuilder();
        String[] commandArray={"cd",tempDirectoryForSplitFilesAbsolutePath,"&&","split","-l",String.valueOf(maximumNumberOfLinesPerPartition),csvFileToProcessAbsolutePath};

        List<String> commandList=Arrays.asList(commandArray);
        int status=processBuilder.command(commandList).start().waitFor();
        if(status!=0)
            throw new Exception("split command did not complete properly");

        File tempDirectoryFile=new File(tempDirectoryForSplitFilesAbsolutePath);
        File[] listOfSpliteFiles=tempDirectoryFile.listFiles(getFileFilterForSplitFiles());
    }

    private static FileFilter getFileFilterForSplitFiles()
    {
        FilenameFilter splitFileFilter = new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                if(name.endsWith(".txt"))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        };
        return splitFileFilter;
    }

}
