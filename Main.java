//STEPS - STAGE 2
//Separate into sentences
//Find no of words in each sentence
//Find average
//output

//STEPS - STAGE 3
//Read a text file from command line
//Calculate number of characters,words,sentences
//Calculate score
//Calculate age

//STEPS - STAGE 4
// Count number of syllables
// Flesch test
// SMOG
// Coleman
// User interface
package read;

import java.io.*;
import java.text.BreakIterator;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static int no_syllables = 0;
    public static int no_poly = 0;
    public static int total_words = 0;
    public static int total_characters = 0;
    public static int no_sentences = 0;

    public static void main(String[] args) {

        File file = new File(args[0]);
        try {
            Scanner in = new Scanner(file);
            Scanner uin = new Scanner(System.in);
            System.out.println("The text is");
           while(in.hasNext())
           {
               String txt = in.nextLine();
               System.out.print(txt);
                BreakIterator bi = BreakIterator.getSentenceInstance();
                bi.setText(txt);
                int index = 0;

                while (bi.next() != BreakIterator.DONE) {
                    String sentence = txt.substring(index, bi.current());
                    total_words += analyzeData.num_words(sentence);
                    total_characters += analyzeData.num_char(sentence);
                    ++no_sentences;
                    index = bi.current();
            }
           }

            System.out.println("");
            System.out.println("Words: " + total_words);
            System.out.println("Sentences: " + no_sentences);
            System.out.println("Characters: "+ total_characters);
            System.out.println("Syllables: "+ no_syllables);
            System.out.println("Poly syllables: "+ no_poly);

            System.out.println("Enter the score you want to calculate(ARI, FK, SMOG, CL, all): ");
            String user_ip = uin.nextLine();
            double score=0;
            double tot_age = 0;
            if(user_ip.equalsIgnoreCase("ARI"))
              {
                score = ReadabilityMethods.ari();
                System.out.println("Automated Readability Index: "+String.format("%.2f",score)+"(about "+analyzeData.agefind((int)score)+ " year olds).");
              }
            else if(user_ip.equalsIgnoreCase("FK"))
              {
                score = ReadabilityMethods.fk();
                System.out.println("Flesch-Kincaid readability tests: "+String.format("%.2f",score)+"(about "+analyzeData.agefind((int)score)+ " year olds).");
              }
            else if(user_ip.equalsIgnoreCase("SMOG"))
              {
                score =  ReadabilityMethods.smog();
                System.out.println("Simple Measure of Gobbledygook: "+String.format("%.2f",score)+"(about "+analyzeData.agefind((int)score)+ " year olds).");
              }
            else if(user_ip.equalsIgnoreCase("CL"))
              {
                score = ReadabilityMethods.cl();
                System.out.println("Coleman-Liau index: "+String.format("%.2f",score)+"(about "+analyzeData.agefind((int)score)+ " year olds).");
              }
            else if(user_ip.equalsIgnoreCase("all"))
              {
                score = ReadabilityMethods.ari();
                tot_age = tot_age+Integer.parseInt(analyzeData.agefind((int)score));
                System.out.println("Automated Readability Index: "+String.format("%.2f",score)+"(about "+analyzeData.agefind((int)score)+ " year olds).");
                score = ReadabilityMethods.fk();
                tot_age = tot_age+Integer.parseInt(analyzeData.agefind((int)score));

                System.out.println("Flesch–Kincaid readability tests: "+String.format("%.2f",score)+"(about "+analyzeData.agefind((int)score)+ " year olds).");
                score =  ReadabilityMethods.smog();
                tot_age = tot_age+Integer.parseInt(analyzeData.agefind((int)score));

                System.out.println("Simple Measure of Gobbledygook: "+String.format("%.2f",score)+"(about "+analyzeData.agefind((int)score)+ " year olds).");
                score = ReadabilityMethods.cl();
                tot_age = tot_age+Integer.parseInt(analyzeData.agefind((int)score));

                System.out.println("Coleman–Liau index: "+String.format("%.2f",score)+"(about "+analyzeData.agefind((int)score)+ " year olds).");

                double avg_age = tot_age/4;

                System.out.println("This text should be understood by "+ String.format("%.2f",avg_age) +" year olds.");

              }






          


             }
        catch (FileNotFoundException f)
          {
            System.out.println("File not found");
          }

    }
}
