import java.util.Collection;
import java.util.HashMap;

/**
 * Created by S N Rao on 4/6/2017.
 *
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and
 * it returns a short URL such as http://tinyurl.com/4e9iAk.
 *
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode
 * algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 *
 */
public class EncodeAndDecodeTinyURLLeetCode {

    public static class Codec {

        int tinyURL=0;
        HashMap<Integer,String> tinyToFull=new HashMap<>();
        HashMap<String,Integer> fullToTiny=new HashMap<>(); //Just to prevent same URL from having multiple entries.
                                                            //Works even if this is not done but memory wasted.

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if(fullToTiny.containsKey(longUrl)) return Integer.toString(fullToTiny.get(longUrl));
            tinyToFull.put(++tinyURL,longUrl);
            fullToTiny.put(longUrl,tinyURL);
            return Integer.toString(tinyURL);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return tinyToFull.get(Integer.parseInt(shortUrl));
        }
    }

    public static void main(String args[]) {
        // Your Codec object will be instantiated and called as such:
        // Codec codec = new Codec();
        // codec.decode(codec.encode(url));
        Codec codec=new Codec();
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}
