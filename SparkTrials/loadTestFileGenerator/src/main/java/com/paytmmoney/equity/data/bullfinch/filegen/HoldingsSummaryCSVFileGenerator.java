package com.paytmmoney.equity.data.bullfinch.filegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.stream.Stream;

public class HoldingsSummaryCSVFileGenerator {

    private final String holdingsSummaryFilePath = "/tmp/BullfinchFilesLoadTest/Bullfinch_Output_Files/Holding_Sumry.csv";


    private final String[] holdingsHeader = {"Asset_Class", "As_On_Date", "UCC", "Purchase_Date", "ISIN", "Scrip_Name", "Quantity", "Purchase_Price", "Purchase_Value", "Market_Price", "Market_Value", "Unrealized_Gain/Loss_Amount"};
    private final Long numberOfUsers = 6000000l;//6 million
    private final Character SEPARATOR = '|';
    private final Character NEW_LINE = '\n';
    //10 random isins
    private String[] ISIN_LIST = {"INE062A01012", "INE002A01018", "INE090A01021", "INE040A01026", "INE155A01022", "INE585B01010", "INE009A01021", "INE467B01029", "INE075A01022", "INE860A01027"};

    private String[] SCRIP_NAME_LIST = {"SBI", "RELIANCE IND", "ICICI", "HDFC", "TATA MOTORS", "MARUTI SUZUKI", "INFOSYS", "TCS", "WIPRO", "HCL TECH"};

    public void generate() throws IOException {
        File holdingsSummaryFile = new File(holdingsSummaryFilePath);
        holdingsSummaryFile.mkdirs();
        if (holdingsSummaryFile.exists())
            holdingsSummaryFile.delete();
        BufferedWriter bufferedWriter = null;
        long i = 0;
        int j = 0;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(holdingsSummaryFile, true));
            bufferedWriter.write(generateHeaderLine());

            for (; i < numberOfUsers; i++) {
                for (j=0; j < 10; j++) {
                    String generatedLine = generateLine(i, j);
                    bufferedWriter.write(generatedLine);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            bufferedWriter.close();
           // System.out.println("number of written records" + i);
        }

        Path path = Paths.get(holdingsSummaryFilePath);
        try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
            long numOfLines = lines.count();
            System.out.println("number of lines in file " + numOfLines);
        }
    }

    private String generateHeaderLine() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < holdingsHeader.length - 1; i++) {
            builder.append(holdingsHeader[i]);
            builder.append(SEPARATOR);
        }
        builder.append(holdingsHeader[holdingsHeader.length - 1]);
        builder.append("\n");
        return builder.toString();
    }

    private String generateLine(long userId, int j) {
        StringBuilder builder = new StringBuilder();

        String assetClass = "Equity";
        builder = addStringToRecord(builder, assetClass, false);

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String asOnDate = formatter.format(localDate);
        builder = addStringToRecord(builder, asOnDate, false);

        String UCC = String.valueOf(userId);
        builder = addStringToRecord(builder, UCC, false);

        String purchaseDate = asOnDate;
        builder = addStringToRecord(builder, purchaseDate, false);

        String ISIN = ISIN_LIST[(int) j % 10];
        builder = addStringToRecord(builder, ISIN, false);

        String SCRIP_NAME = SCRIP_NAME_LIST[(int) j % 10];
        builder = addStringToRecord(builder, SCRIP_NAME, false);

        Random random = new Random();
        int quantity = random.nextInt(1000);
        builder = addStringToRecord(builder, String.valueOf(quantity), false);

        float purchasePrice = random.nextFloat();
        builder = addStringToRecord(builder, String.valueOf(purchasePrice), false);

        double purchaseValue = purchasePrice * quantity;
        builder = addStringToRecord(builder, String.valueOf(purchaseValue), false);

        float marketPrice = random.nextFloat();
        builder = addStringToRecord(builder, String.valueOf(marketPrice), false);

        double marketValue = marketPrice * quantity;
        builder = addStringToRecord(builder, String.valueOf(marketValue), false);

        double unrealizedGainLoss = marketValue - purchaseValue;
        builder = addStringToRecord(builder, String.valueOf(unrealizedGainLoss), true);

        return builder.toString();
    }


    private StringBuilder addStringToRecord(StringBuilder builder, String toAppend, boolean isEndOfRecord) {
        builder.append(toAppend);
        if (isEndOfRecord)
            builder.append(NEW_LINE);
        else
            builder.append(SEPARATOR);
        return builder;
    }
}
