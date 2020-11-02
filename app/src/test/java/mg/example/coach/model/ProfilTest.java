package mg.example.coach.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfilTest {
    //creation de profil
    private Profil profil = new Profil (67,165,35,0  );
    //resultas IMG
    private  float img = (float) 32.2 ;
    //messages
    private String messages = "trop eleve";

    @Test
    public void getImg() {

    assertEquals(img  , profil.getImg(),(float)0.1);
    }

    @Test
    public void getMessage() {

        assertEquals(messages,profil.getMessage()); // comparer
    }
}