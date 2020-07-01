package read;

import java.io.*;
import java.text.BreakIterator;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class ReadabilityMethods{

  public static double ari()
        {
          double score = (4.71*((double)Main.total_characters/(double)Main.total_words))+(0.5*((double)Main.total_words/(double)Main.no_sentences))-21.43;
          return score;
        }
  public static double fk(){
          double score = (0.39*((double)Main.total_words/(double)Main.no_sentences))+11.8*((double)Main.no_syllables/(double)Main.total_words)-15.59;
          return score;
        }
  public static double smog(){
        double score = 1.043*Math.sqrt(Main.no_poly*(30/Main.no_sentences))+3.1291;
        return score;
      }
public static double cl(){
      int L,S;
      L = ((Main.total_characters)/(Main.total_words))*100;
      S = ((Main.total_words)/(Main.no_sentences));
      double score = 0.0588*L - 0.296*S - 15.8;
      return score;
    }

}
