package anagrams;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Ali
 */
public class Dictionary 
{
    private final Map<String, HashSet<String>> dictionary;
    
    public Dictionary()
    {
        dictionary = new HashMap<>();
    }
    
    //Creates dictionary from arrayList where dictionary is hashMap of
    //keys words in from arrayList in sorted order and values hashSets of
    //anagrams
    public void addWord(String word)
    {        
        String sortedWord = sortString(word);
        HashSet<String> set;

        if(dictionary.containsKey(sortedWord))
        {
            set = dictionary.get(sortedWord);
        }
        else
        {
            set = new HashSet<>();
        }
        set.add(word);
        dictionary.put(sortedWord, set);
    }
    
    public Collection getAnagrams()
    {
        return dictionary.values();
    }
    
    /////////////////////
    //
    //   Private methods
    //
    ////////////////////
    
    private String sortString(String str)
    {
        char[] chars = str.toLowerCase().toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }
}
