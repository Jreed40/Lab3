import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;
public class Words {

    public static void main(String[] args) {
        System.out.println(specificWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"), "Prince"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int wordCount(final String words) {
        String a = trimPunc(words);
        String[] wordAr = a.split(" ");
        return wordAr.length;
    }
    public static int specificWordCount(final String words, final String search){
        int count = 0;
        String realSearch = search.toLowerCase();
        String a = trimPunc(words);
        String[] wordAr = a.split(" ");
        for(int i = 0; i < wordAr.length; i++){
            if(wordAr[i].toLowerCase().contains(realSearch)){
                count++;
            }
        }
        return count;
    }
    public static int uniqueWordCount(final String words) {
        int count = 0;
        String a = trimPunc(words);
        String[] wordAr = words.split(" ");
        ArrayList<String> unique = new ArrayList<String>(0);
        boolean add = false;
        for(int i = 0; i<wordAr.length; i++) {
            add = true;
            for(int j = 0; j < unique.size(); j++){
                if(wordAr[i].toLowerCase().equalsIgnoreCase(unique.get(j))) {
                    add = false;
                }
            }
            if(add) {
                unique.add(wordAr[i]);
                count++;
            }
        }
        return count;
    }
    public static String trimPunc(String a) {
        ArrayList<Character> c = new ArrayList<Character>(a.length());
        for(int i = 0; i<a.length(); i++) {
            if(a.charAt(i) != '.' && a.charAt(i) != '!' && a.charAt(i) != ',' && a.charAt(i) != '\'' && a.charAt(i) != '?' && a.charAt(i) != ';' && a.charAt(i) != '(' && a.charAt(i) != ')'
                    && a.charAt(i) != '[' && a.charAt(i) != ']'){
                c.add(a.charAt(i));
            }
        }
        String rt = "";
        for(int i = 0; i < c.size(); i++){
            rt += c.get(i);
        }
        return rt;
    }
}