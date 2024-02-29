package t.o.text_to_Bin_Oct_Hex;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.widget.Toast;
import android.content.Context;


public class MainActivity extends AppCompatActivity {
    public void do_math(){
        EditText input= findViewById(R.id.editTextText);
        EditText output= findViewById(R.id.result);
        RadioButton numb_rb= findViewById(R.id.radioButton5);
        ToBinOctHex toBinOctHex = new ToBinOctHex();
        RadioButton bin_rb=findViewById(R.id.radioButton1);
        RadioButton oct_rb=findViewById(R.id.radioButton3);
        String inputText;
        inputText = input.getText().toString();
        if(numb_rb.isChecked()){
            input.setInputType(InputType.TYPE_CLASS_NUMBER);

            int textInt;
            // Sprawdzenie, czy pole EditText jest puste
            if (inputText.isEmpty()) {
                textInt = 0; // Przypisanie wartości domyślnej, jeśli pole jest puste
            } else {
                textInt = Integer.parseInt(inputText);
            }

            // Wybór odpowiedniej konwersji w zależności od zaznaczonego RadioButton
            if (bin_rb.isChecked()) {
                output.setText(toBinOctHex.return_bin(textInt));
            } else if (oct_rb.isChecked()) {
                output.setText(toBinOctHex.return_oct(textInt)); // Dodaj odpowiednią obsługę dla radioButtona oct
            }else {output.setText(toBinOctHex.return_hex(textInt));}
        }
        else {input.setInputType(InputType.TYPE_CLASS_TEXT);
            if (inputText.isEmpty()) {
                inputText = "empty";
                output.setText(inputText);
            } else {
                if (bin_rb.isChecked()){
                    output.setText(toBinOctHex.return_bin(inputText));
                } else if (oct_rb.isChecked()) {
                    output.setText(toBinOctHex.return_oct(inputText));
                }else {output.setText(toBinOctHex.return_hex(inputText));}

            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RadioGroup rg= findViewById(R.id.radioGroup2);
        RadioGroup rg_bin_hex= findViewById(R.id.radioGroup);
        EditText editText = findViewById(R.id.editTextText);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {do_math();}


    });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                EditText input= findViewById(R.id.editTextText);
                input.setText("");
            }
        });
        rg_bin_hex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                do_math();
            }
        });



}



}