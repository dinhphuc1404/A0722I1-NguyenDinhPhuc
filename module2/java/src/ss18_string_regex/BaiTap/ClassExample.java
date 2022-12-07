package ss18_string_regex.BaiTap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String CLASS_REGEX= "^[CAP]+[\\d]{4}[GHIKLM]$";
    public ClassExample(){
        pattern=Pattern.compile(CLASS_REGEX);

    }
    public boolean validate(String regex){
        matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
