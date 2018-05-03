package Done;

/**
 * Created by S N Rao on 1/24/2017.
 *
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each
 * ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The
 * groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid
 * one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address
 * to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using
 * upper cases).
 *
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons
 * (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address
 * 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 * Note: You may assume there is no extra space or special characters in the input string.
 *
 */
public class ValidateIPAddressLeetCode {

    public static String validIPAddress(String IP) {
        int countDot=IP.length()- IP.replace(".", "").length();
        int countColon=IP.length()-IP.replace(":", "").length();

        if(countDot==3 && countColon==0) return checkFour(IP);
        else if(countDot==0 && countColon==7) return checkSix(IP);
        return "Neither";
    }

    private static String checkFour(String IP){
        String curr="";
        int part=0;
        for(int i=0;i<IP.length();i++){
            char ch=IP.charAt(i);
            if(!Character.isDigit(ch) && ch!='.') return "Neither";
            if(ch!='.') curr+=ch;
            if(ch=='.' || i==IP.length()-1){
                if(curr.equals(""))
                    return "Neither";
                if(curr.length()>1 && curr.charAt(0)=='0')
                    return "Neither";
                if(curr.length()>3 || Integer.parseInt(curr)>255)
                    return "Neither";
                curr="";
                part++;
            }
        }
        if(part==4)
            return "IPv4";
        else return "Neither";
    }

    private static String checkSix(String IP){
        String curr="";
        int part=0;
        for(int i=0;i<IP.length();i++){
            char ch=IP.charAt(i);
            if(ch!=':' && !Character.isDigit(ch) && !(ch>='a' && ch<='f') && !(ch>='A' && ch<='F'))
                return "Neither";
            if(ch!=':') curr+=ch;
            if(ch==':' || i==IP.length()-1){
                if(curr.equals(""))
                    return "Neither";
                if(curr.length()>4)
                    return "Neither";
                curr="";
                part++;
            }
        }
        if(part==8)
            return "IPv6";
        else return "Neither";
    }

    public static void main(String args[]){
        System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334")); //IPv6
        System.out.println(validIPAddress("172.16.254.1"));	//IPv4
        System.out.println(validIPAddress("172.16.254.01"));	//Neither
        System.out.println(validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334")); //IPv6
        System.out.println(validIPAddress("2001:0db8:85a3::8A2E:0370:7334")); //Neither
        System.out.println(validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334")); //Neither
        System.out.println(validIPAddress("1.0.1.")); //Neither
    }
}
