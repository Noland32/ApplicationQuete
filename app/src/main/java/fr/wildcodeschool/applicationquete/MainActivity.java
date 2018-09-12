package fr.wildcodeschool.applicationquete;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // import biblio button
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {  //MA(subclass)inherit AppComp(superclass)?

    @Override // sert à identifier le button
    protected void onCreate(Bundle savedInstanceState) {        //method onCreate ou snippet
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonVariable = findViewById(R.id.buttonDesign); //R=ressources
        buttonVariable.setOnClickListener(new View.OnClickListener() { //action au click

            @Override // créé par new OnClickListener pour créer l'action
            public void onClick(View view) {
                EditText edit_FirstName = findViewById(R.id.editFirstName);
                EditText edit_LastName = findViewById(R.id.editLastName);
                String firstnameValue = edit_FirstName.getText().toString();
                String lastnameValue = edit_LastName.getText().toString();
                /**/
                if(firstnameValue.equals("") || lastnameValue.equals("")) {

                    Context context = getApplicationContext(); //call variable + methode
                    CharSequence text = "Please fill your firstname and lastname";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    Toast.makeText(MainActivity.this, "Congratulation " + firstnameValue +" "+ lastnameValue, Toast.LENGTH_SHORT).show();
                }
            } // ferme onClick
        }); // ferme onCreate

        CheckBox checkbox1 = findViewById(R.id.checkBox1); //call la checkbox
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) { //ischecked est une variable
                EditText edit_FirstName = findViewById(R.id.editFirstName);
                EditText edit_LastName = findViewById(R.id.editLastName);
                Button button_Design = findViewById(R.id.buttonDesign);
            if (ischecked) {
                edit_FirstName.setEnabled(true);
                edit_LastName.setEnabled(true);
                button_Design.setEnabled(true);
            }else{
                edit_FirstName.setEnabled(false);
                edit_LastName.setEnabled(false);
                button_Design.setEnabled(false);

            }
            }
        });

    }
}


