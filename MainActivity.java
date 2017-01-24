package com.law.eishan.calculator;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spanned;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView textView;

    double num1, num2; //the numbers which are operated on

    int id, id2; //to id the sign buttons

    int x=0;  //for making sign button work

    final double PI = Math.PI; //Constants
    final double E = Math.E;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


         //To change layout as orientation changes
        switch (getResources().getConfiguration().orientation) {
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main);
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.landscape);



                //To tell the user that the angles are in radians
                Toast.makeText(this,"The Angles are in Radians",Toast.LENGTH_SHORT).show();
                break;
        }


         //The text view is initialized
        textView= (TextView) findViewById(R.id.text);
        textView.setText("");


    }

    //Listener method for all the buttons in the calculator
    public void clicked(View view) {



        switch(view.getId()){



            //When the user presses any of the number buttons, it changes the text on the text

            case R.id.one:
                textView.append("1");
                break;

            case R.id.two:
                textView.append("2");
                break;

            case R.id.three:
                textView.append("3");
                break;

            case R.id.four:
                textView.append("4");
                break;

            case R.id.five:
                textView.append("5");
                break;

            case R.id.six:
                textView.append("6");
                break;

            case R.id.seven:
                textView.append("7");
                break;


           case R.id.eight:
                textView.append("8");
                break;

            case R.id.nine:
                textView.append("9");
                break;

            case R.id.zero:
                textView.append("0");
                break;



            /*This section of code is to make the rest of the buttons work*/


            //This is to change the sign of the number
            case R.id.sign:



                if(x==0){
                    textView.setText("-"+textView.getText());
                    x=1;}
                else{
                    textView.setText(textView.getText().toString().replace("-",""));
                    x=0;
                }
                break;





           //This is to delete the last digit entered
            case R.id.clearbutton:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null)
                textView.setText(textView.getText().toString().substring(0,textView.getText().toString().length()-1));
                break;




           //This is to delete the whole number
            case R.id.fullclear:
                textView.setText("");
                id=0;
                id2=0;

                break;




           //This is to add a decimal
            case R.id.point:
                textView.append(".");
                break;






           //This is to initialize addition
            case R.id.plus:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null){
                num1= Double.parseDouble(textView.getText().toString());
                textView.setText("");
                id=1;
                    id2=1;
                }
                break;








           //This is to initialize subtraction
            case R.id.minus:
                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null){
                    num1= Double.parseDouble(textView.getText().toString());
                textView.setText("");
                id=2;
                    id2=2;
                }
                break;







           //This is to initialize division
            case R.id.divide:
                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null){
                    num1= Double.parseDouble(textView.getText().toString());
                textView.setText("");
                id=3;
                    id2=3;
                }
                break;







           //This is to initialize multiplication
            case R.id.multiply:
                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null){
                    num1= Double.parseDouble(textView.getText().toString());
                textView.setText("");
                id=4;
                    id2=4;
                }
                break;





            //This is to use percentage operator of math
            case R.id.percent:
                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null &&id==0){
                    num1= Double.parseDouble(textView.getText().toString());
                    num1=num1/100;
                    textView.setText(Double.toString(num1));


                }
                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null &&id!=0){

                    num2=Double.parseDouble(textView.getText().toString());
                    num2=num2/100;

                    switch (id2){

                        case 1:

                            textView.setText(Double.toString(num1*(1 + num2)));
                            break;

                        case 2:

                            textView.setText(Double.toString(num1*(1 - num2)));
                            break;

                        case 3:
                            if (num2 == 0)
                                textView.setText("Error");
                            else {
                                textView.setText(Double.toString(((double) num1 / (double) num2)));
                            }
                            break;

                        case 4:

                            textView.setText(Double.toString(num1 * num2));
                            break;


                    }

                }
                break;





            //Set the number on screen to PI
            case R.id.pi:

                textView.setText(Double.toString(PI));
                break;







           //Sets the number on screen to euler's number
            case R.id.exponential:

                textView.setText(Double.toString(E));
                break;





            //Takes the log base 10 of the number on screen
            case R.id.log:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null){
                num1 = Double.parseDouble(textView.getText().toString());

                textView.setText(Double.toString(Math.log10(num1)));}

                break;






            //Takes the natural log of the number on screen
            case R.id.ln:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null){
                num1 = Double.parseDouble(textView.getText().toString());

                    if(num1<=0)
                        textView.setText("Error");
                    else
                textView.setText(Double.toString(Math.log(num1)));}

                break;




           //Take the sqrt of the number on screen
            case R.id.sqrt:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null) {
                    num1 = Double.parseDouble(textView.getText().toString());

                    if (num1 < 0) {

                        textView.setText("Error");

                    } else {
                        textView.setText(Double.toString(Math.sqrt(num1)));
                    }
                }

                break;




           //Outputs the factorial of the number on screen
            case R.id.factorial:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null){
                num1 = Double.parseDouble(textView.getText().toString());

                    if(num1<0)
                        textView.setText("Error");
                else{
                double fact=1;

                for(int i=1;i<=num1;i++){

                    fact=fact*i;
                }

                textView.setText(Double.toString(fact));}}

                break;



            //Outputs sin of the number on screen
            case R.id.sin:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null){
                num1 = Double.parseDouble(textView.getText().toString());


                    if(num1==PI/2)
                        textView.setText("1");
                    else if (num1== PI)
                        textView.setText("0");

                    else

                        textView.setText(Double.toString(Math.sin(num1)));}

                break;


           //Outputs tan of the number on screen
            case R.id.tan:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null){
                num1 = Double.parseDouble(textView.getText().toString());

                    if(num1==PI/2)
                        textView.setText("Error");
                    else if (num1== PI)
                        textView.setText("0");

                    else

                textView.setText(Double.toString(Math.tan(num1)));}

                break;


           //Outputs cosine of the number on screen
            case R.id.cos:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null)
            {
                num1 = Double.parseDouble(textView.getText().toString());

                textView.setText(Double.toString(Math.cos(num1)));}

                break;


            //Initializes exponential operation
            case R.id.power:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null){
                num1 = Double.parseDouble(textView.getText().toString());

                textView.setText("");

                id=5;}

                break;



     /* This is where the second half of all the working of the calculator happens*/




            case R.id.equal:

                if(textView.getText().toString().length()>0 && textView.getText().toString()!=null) {
                    num2 = Double.parseDouble(textView.getText().toString());



                    switch (id) {
                        case 1:  //In case of addition

                            textView.setText(Double.toString(num1 + num2));
                            break;

                        case 2:  //In case of subtraction

                            textView.setText(Double.toString(num1 - num2));
                            break;

                        case 3:  //In case of addition
                            if (num2 == 0)
                                textView.setText("Error");
                            else {
                                textView.setText(Double.toString(((double) num1 / (double) num2)));
                            }
                            break;

                        case 4:  //In case of Multiplication

                            textView.setText(Double.toString(num1 * num2));
                            break;

                        case 5:  //In case of power operation

                            textView.setText(Double.toString(Math.pow(num1,num2)));

                            break;


//THE END



                    }
                }




        }
    }


}
