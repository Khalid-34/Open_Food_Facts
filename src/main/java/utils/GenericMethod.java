package utils;

import java.lang.reflect.Method;

public class GenericMethod {

    public static <T> Object getGetters(T entite, String getterString){
        try {
            Method getter = entite.getClass().getMethod(getterString);
            return getter.invoke(entite);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
