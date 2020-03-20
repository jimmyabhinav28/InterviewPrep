package dev.anksandabhi;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( ApplicationProperties.getProperty("aws.access.key.id" ));
    }
}
