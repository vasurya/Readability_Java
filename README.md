# Readability_Java
Finding the readability score and recommended age group for a text file using several methods.

## The program in action, divided into simplified steps

- Step 1
  -Take the name of the text file to be analyzed from the command line argument
  -Load the text from the file using Scanner class

- Step 2
  - Separate text into sentences using BreakIterator and store the number of sentences in a variable.
  - Separate each sentence into words using regex and store the total number of words in a variable(num_words function in analyzeData file)
  - Separate each word into characters using regex and store the total number of characters in a variable(num_char function in analyzeData file)
  - For each word, calculate the number of syllables and polysyllables and store the totals in separate variables(num_syllables function)
 - Step 3
  - Output the findings so far.
  - Ask the user to decide which of the following tests need to be performed on the file
    - Flesch-Kincaid test
    - Automated Readability Index
    - Simple Measure of Gobbledygook(that's the official name!)
    - Coleman-Liau Index
    - All of the above
    
  - Calculate the requested score and match them to the suitable age group using the age find method
  - In case, the user requests all the methods, additionally calculate the average age group for the text given.
 
 - Step 4
   - Output the result of the requested test and the recommended age group 
   
  ----------------------
  
