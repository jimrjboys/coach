package mg.example.coach.controller;

import android.content.Context;

import mg.example.coach.model.Profil;
import mg.example.coach.outils.Serializer;

public final class Control {


    private static Control instance  = null ;
    private static  Profil profil ;
    private static  String nomFic = "saveProfil";



    /**
     * constructeur privée
     */
    private Control (){

        super();

    }

    /**
     * Creatuib de l instance
     * @return
     */
    public static final Control getInstance (Context context) {

        if (Control.instance == null )  {

            Control.instance = new Control() ;
            recupSerialize(context);
        }
        return Control.instance ;
    }

    /**
     * Création du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme
     */
    public void CreerProfil (Integer poids  , Integer taille , Integer age , Integer sexe , Context context ){
        profil = new  Profil (poids , taille , age , sexe ) ;
        Serializer.serialize(nomFic,profil,context);
    }

    /**
     * recuperation de img de profil
     * @return
     */
    public float getImg (){
        return  profil.getImg();
    }

    /**
     * Recuperation messages de profil
     * @return le messages
     */
    public String getMessage (){
        return profil.getMessage() ;
    }
    private static  void recupSerialize (Context context) {

        profil =(Profil)Serializer.deSerialize(nomFic,context);
    }

}
