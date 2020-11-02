package mg.example.coach.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import mg.example.coach.R;
import mg.example.coach.controller.Control;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

 //proprietes graphique
    private EditText txtPoids ;
    private EditText txtTaille ;
    private EditText txtAge ;
    private RadioButton rdHomme ;
    private TextView lblIMG ;
    private ImageView imgSmiley ;

    //declarer le controleur
    private Control controle  ;
    /**
     * initialisation des liens avec les objects graphiques
     */

    private  void init() {
        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAges);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMG = (TextView) findViewById(R.id.lblIMG) ;
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);
        this.controle = Control.getInstance(this);
        ecouteCalcul();
    }

    /**
     * Ecoute l'venement sur le boutton calcul
     */
    private void ecouteCalcul () {
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener () {

            public  void onClick (View v){

                //Toast.makeText(MainActivity.this , "test",Toast.LENGTH_SHORT ).show();
                //Log.d( "messages" , "click ok sur mon bouton calcul *************");
                Integer poids = 0 ;
                Integer taille = 0 ;
                Integer age = 0 ;
                Integer sexe = 0 ;

                // s il ne ce pass rien  , recuperation des donnees saisie
                try {


                poids = Integer.parseInt(txtPoids.getText().toString());
                taille = Integer.parseInt(txtTaille.getText().toString());
                age = Integer.parseInt(txtAge.getText().toString());
                }
                catch (Exception e ){

                }
                if(rdHomme.isChecked()){

                    sexe = 1 ;
                }

                //controle des donness saisies
                if(poids == 0 || taille == 0 || age == 0 ){

                    Toast.makeText(MainActivity.this , "Saisie Incorrect",Toast.LENGTH_SHORT ).show();
                }else {
                    affichageResult(poids ,taille , age , sexe);
                }
            }

        });
    }

    /**
     * Affichage de l img dans messages et de l image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private void affichageResult(Integer poids , Integer taille , Integer age , Integer sexe ){
            // creatioin du profil et recuperation des information
            this.controle.CreerProfil(poids,taille,age ,sexe ,this);
            float img = this.controle.getImg() ;
            String message = this.controle.getMessage() ;

            //gestion des affichage


        if(message == "normale")
        {
            imgSmiley.setImageResource(R.drawable.normal);
            lblIMG.setTextColor(Color.GREEN);
        }else {
            if(message == "trop faible"){
                imgSmiley.setImageResource(R.drawable.maigre);
                lblIMG.setTextColor(Color.RED);
            }else {

                imgSmiley.setImageResource(R.drawable.graisse);

            }
        }
    lblIMG.setText(String.format("%0.01f",img)+"IMG " + message);

    }
}
