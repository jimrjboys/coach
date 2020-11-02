package mg.example.coach.model;

import java.io.Serializable;

public class Profil implements Serializable {



    //constante

    private static final Integer minFemme =   15 ;
    private static final Integer maxFemme =   30 ;
    private static final Integer minHomme =   10 ;
    private static final Integer maxHomme =   25 ;
    //propriétes
    private Integer poids ;
    private Integer taille;
    private Integer age;
    private Integer sexe ;
    private float img ;
    private String message;


    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;

        this.calculMG();
        this.resultIMG();
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    private void calculMG() {
        float tailleM = ((float)taille) /100;
        this.img = (float) ((1.2 * poids / (tailleM* tailleM)) + (0.23 * age) - (10.83 * sexe) - 5.4) ;
    }
    private void resultIMG (){
        Integer min ;
        Integer max ;
        if(sexe == 0 ) { //femme
            min = minFemme ;
            max = maxFemme ;
        }else
        {//homme
            min = minHomme ;
            max = maxHomme;
        }

        //message corerspondant
        message = "normale" ;
        if (img <min) {

            message = "trop faible";
        }else
        {
            if(img > max) {
                message = "trop eleve";
            }
        }

    }

}
