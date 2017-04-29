//    Problem statement:
//    List all anagrams of words contained within a file
//    Two words are defined as anagrams if they do share the same letters, but are in a different order (i.e.
//    the english words race and care are anagrams).
//    Given an input file which contains one word per line, as an output construct a list of all anagrams
//    from that input file. Print those words to the console, where all words that are an anagram should
//    each other should be on the same line.
//    As an example, given the input file:
//    act
//    cat
//    tree
//    race
//    care
//    acre
//    bee
//    the output should be:
//    act cat
//    acre care race

package anagrams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 *
 * @author Ali
 */
public class Anagrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /**
            Assumptions:
            •	Assuming that list of anagrams should all be distinct thus 
                HashSet is used.
            •	Words containing characters other than alphabets (A-Z and a-z) 
                will get ignored.
            •	Spaces or empty lines will be ignored while reading from input
                file.
         */
        
        // Specify your input file path here
        String path = "src\\inputfile\\input.txt";
        readFromInputFile(path);
    }
    
    /////////////////////
    //
    //   Private methods
    //
    ////////////////////

    private static void readFromInputFile(String path)
    {
        Dictionary dictionary = new Dictionary();
        try
        {
            Pattern wordPattern = Pattern.compile("[a-zA-Z]*");
            Pattern emptyLinePattern = Pattern.compile("^\\s*$");
            
            for (String word : Files.readAllLines(Paths.get(path)))
            {
                if(wordPattern.matcher(word).matches() && 
                    !emptyLinePattern.matcher(word).matches())
                {
                    dictionary.addWord(word);
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        if(!dictionary.getAnagrams().isEmpty())
        {
            printAnagrams(dictionary.getAnagrams());
        }
        else
        {
            System.out.println("Input file is empty");
        }
    }
    
    private static void printAnagrams(Collection<HashSet<String>> allSets)
    {
        for(HashSet set : allSets)
        {
            Iterator iterator = set.iterator();
            while(iterator.hasNext())
            {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }
}
