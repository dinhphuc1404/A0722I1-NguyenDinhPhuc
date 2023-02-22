package util;

public class Vali {
    public static boolean checkName(String name){
        String regName =" /^(([a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ']+)\\s*)+$/";
        return name.matches(regName);

    }
}
