package com.paytmmoney.equity.data;

import com.paytmmoney.equity.data.bullfinch.filegen.HoldingsSummaryCSVFileGenerator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String filepath="/home/abhinav/Downloads/part-00000-8e711ecd-d8a4-4bd2-9aef-e920a1b8314e-c000.csv";
        HoldingsSummaryCSVFileGenerator generator=new HoldingsSummaryCSVFileGenerator();
        try {
            generator.generate();
//            countLines(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void countLines(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
            long numOfLines = lines.count();
            System.out.println("number of lines in file " + numOfLines);
        }
    }
}
