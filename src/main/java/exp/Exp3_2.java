package exp;

import java.util.regex.Pattern;

public class Exp3_2 {
    public static void main(String[] args) {
        String[] strs = {"130681198712092019", "13068119871209201x", "13068119871209201", "123456789012345", "12345678901234x", "1234567890123"};

        for (String str : strs) {
            boolean isValid = check(str);
            System.out.println(str + (isValid ? "\t  是" : "\t不是") + "合法身份证号");
        }
    }

    public static boolean check(String idCardNumber) {
        // 15位、18位和17位+字母X
        String regex = "^\\d{15}$|^\\d{17}([0-9]|X|x)$";
        return Pattern.matches(regex, idCardNumber);
    }
}
