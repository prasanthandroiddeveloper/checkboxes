package com.example.badari.checkboxes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    CheckBox pizza,coffe,burger;
    Button buttonOrder;
    String NameHolder;
    FirebaseAuth mAuth;
    Firebase firebase;




    public static final String Firebase_Server_URL = "https://fullfire-1ce63.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(MainActivity.this);

        firebase = new Firebase(Firebase_Server_URL);


        // Passing firebase Server URL into firebase object.



        addListenerOnButtonClick();
    }


    public void addListenerOnButtonClick() {
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        pizza = (CheckBox) findViewById(R.id.checkBox1);
        coffe = (CheckBox) findViewById(R.id.checkBox2);
        burger = (CheckBox) findViewById(R.id.checkBox3);
        buttonOrder = (Button) findViewById(R.id.button1);

        //Applying the Listener on the Button click
        buttonOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int totalamount = 0;


                Item item = new Item();
                item.setitemselected(NameHolder);

                // Calling function to Get data from EditText and store into string variables.
                GetDataFromCheckBox();

                // Adding student name into student class object.


                // Adding student number into student class object.
               // student.setStudentPhoneNumber(NumberHolder);

                // Passing student phone number and name into firebase object to add into database.
                 firebase.child("Item").setValue(item);


                StringBuilder result = new StringBuilder();
                result.append("Selected Items:");
                if (pizza.isChecked()) {
                    result.append("\nPizza 100Rs");
                  //  GetDataFromCheckBox();
                  //  item.setitemselected(NameHolder);

                    totalamount += 100;
                }
                if (coffe.isChecked()) {
                    result.append("\nCoffe 50Rs");
                    totalamount += 50;
                }
                if (burger.isChecked()) {
                    result.append("\nBurger 120Rs");
                    totalamount += 120;
                }
                result.append("\nTotal: " + totalamount + "Rs");
                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }


            public void GetDataFromCheckBox() {

                NameHolder = pizza.getText().toString().trim();
                NameHolder = coffe.getText().toString().trim();
                NameHolder = burger.getText().toString().trim();

                // NumberHolder = PhoneNumberEditText.getText().toString().trim();

            }
        });
    }}