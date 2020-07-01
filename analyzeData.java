package read;

import java.io.*;
import java.text.BreakIterator;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class analyzeData{
  public static void num_syllables(String word){
      int count=0;
      word = word.toLowerCase();
      String pat1 = "[aeiouy]";
      String pat2 = "[aeiouy][aeiouy]";
      Pattern pattern = Pattern.compile(pat1);
      Matcher matcher = pattern.matcher(word);
      while(matcher.find())
      {
          ++count;

      }
       pattern = Pattern.compile(pat2);
       matcher = pattern.matcher(word);
      while(matcher.find())
      {
          --count;

      }
      if(word.charAt(word.length()-1)=='e')--count;
      List<Character> li = new ArrayList<Character>();
      li.add('a');
      li.add('e');
      li.add('i');
      li.add('o');
      li.add('u');
      li.add('y');
      String k = word;
      Boolean check = false;
      for(int i=0;i<k.length();i++)
      {
        if(li.contains(k.charAt(i))){
          check = true;
          break;
        }
      }
      if(check==false)++count;

      Main.no_syllables += count;
      if(count>2)++Main.no_poly;
  }
  public static int num_words(String s){
      int count=0;
      //Pattern for a word
      String wordpat = "[a-zA-Z0-9,]+";
      Pattern pattern = Pattern.compile(wordpat);
      Matcher matcher = pattern.matcher(s);
      while(matcher.find())
      {
          ++count;
          num_syllables(matcher.group());
      }

      return count;
  }
  public static int num_char(String s)
  {
    int count = 0;
    //Pattern for counting characters except space
    String charpat = "[^\\s]";
    Pattern pattern = Pattern.compile(charpat);
    Matcher matcher = pattern.matcher(s);
    while(matcher.find())
    {
        ++count;
    }
  
    return count;
  }


  public static String agefind(int score){
    String age;
    switch (score){
      case 1:
        age = "6";
        break;
      case 2:
          age = "7";
          break;
      case 3:
      age = "9";
      break;
      case 4:
      age = "10";
      break;
      case 5:
      age = "11";
      break;
      case 6:
      age = "12";
      break;
      case 7:
      age = "13";
      break;
      case 8:
      age = "14";
      break;
      case 9:
      age = "15";
      break;
      case 10:
      age = "16";
      break;
      case 11:
      age = "17";
      break;
      case 12:
      age = "18";
      break;
      case 13:
      age = "24";
      break;
      case 14:
      age = "25";
      break;
      default:
      age = "69";
      break;
    }

    return age;
  }
}
