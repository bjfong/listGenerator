import java.util.*;

public class ListGenerator {  
    /*
     * This function generates a string based on the inputs passed
     * in. If the length of the list is 0, nothing gets returned.
     * If the size is 1, just that word is returned. If it's 2, 
     * then the two words are returned with an "and" in between.
     * If it's 3 or more, it will create a list and also take into
     * account the oxfordComma flag as well.
     *
     * @param list: the list of words to create a string
     * @param useOxfordComma: a flag denoting whether to use the 
     *                        Oxford comma in the string or not
     * @return a string of the list
     */
    public static String generateList(List<String> list, boolean useOxfordComma) {
        String ret = "";

        if(list == null || list.size() == 0) {
            return ret;
        }
        
        if(list.size() == 1) {
            return list.get(0);
        }
        
        if(list.size() == 2) {
            return list.get(0) + " and " + list.get(1);
        }
        
        String oxfordComma = useOxfordComma? "," : "";
        
        for(int i = 0; i < list.size(); i++) {
            if(i < list.size() - 2) {
                ret += list.get(i) + ", ";
            } else if(i == list.size() - 2) {
                ret += list.get(i) + oxfordComma;
            } else {
                ret += " and " + list.get(i);
            }
        }
        
        return ret;
    }
    
    public static void main(String args[])
    {
        // empty list
        List<String> list0 = new ArrayList<>();
        System.out.println("0: " + generateList(list0, false).equals(""));
        
        // one word
        List<String> list1 = new ArrayList<>();
        list1.add("Internal");
        System.out.println("1: " + generateList(list1, false).equals("Internal"));
        
        // two words
        List<String> list2 = new ArrayList<>();
        list2.add("Internal");
        list2.add("External");
        System.out.println("2: " + generateList(list2, false).equals("Internal and External"));
        
        // three words, no Oxford comma
        List<String> list3 = new ArrayList<>();
        list3.add("Internal");
        list3.add("Middle");
        list3.add("External");
        System.out.println("3: " + generateList(list3, false).equals("Internal, Middle and External"));
        
        // four words, with Oxford comma
        List<String> list4 = new ArrayList<>();
        list4.add("Internal");
        list4.add("Middle1");
        list4.add("Middle2");
        list4.add("External");
        System.out.println("4: " + generateList(list4, true).equals("Internal, Middle1, Middle2, and External"));
        
        // five words, no Oxford comma
        List<String> list5 = new ArrayList<>();
        list5.add("Internal");
        list5.add("Middle1");
        list5.add("Middle2");
        list5.add("Middle3");
        list5.add("External");
        System.out.println("5: " + generateList(list5, false).equals("Internal, Middle1, Middle2, Middle3 and External"));
    }
}