package utils;


import dao.IDao;

import java.util.HashMap;
import java.util.HashSet;

public class TraitementInsert {

    public static void verifyBeforeSend(Object entite, IDao entyDao, String nomGetter, HashSet entyMap) throws Exception {

            String getNom = (String) GenericMethod.getGetters(entite,"getNom");
        if(entyMap.size() == 0 ){

            entyMap.add(getNom);

        }
        if(entyMap.contains(getNom) ){
            System.out.println(ConsoleColors.BLUE + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );

        }else {
            System.out.println(ConsoleColors.CYAN + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            long id = entyDao.save(entite);
            System.out.println(ConsoleColors.GREEN_BOLD + "indentité ==== "+ id) ;
            entyMap.add(getNom);


        }
    }
}
