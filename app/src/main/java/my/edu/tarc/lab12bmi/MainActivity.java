package my.edu.tarc.lab12bmi;


import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextKg, editTextCm;
    private TextView textViewBMI;
    private ImageView imageViewBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateBMI(View v){
        editTextKg = (EditText)findViewById(R.id.editTextKg);
        editTextCm = (EditText)findViewById(R.id.editTextCm);
        textViewBMI = (TextView)findViewById(R.id.textViewBMI);
        imageViewBMI = (ImageView)findViewById(R.id.imageViewBMI);

        try {
            double kg = Double.parseDouble(editTextKg.getText().toString());
            double m = Double.parseDouble(editTextCm.getText().toString()) / 100;
            double bmi = kg / (m * m);
            textViewBMI.setText(getResources().getString(R.string.result)+" "+String.format("%.2f",bmi));
            if(bmi<=18.5)
                imageViewBMI.setImageResource(R.drawable.under);
            else if(bmi>=25)
                imageViewBMI.setImageResource(R.drawable.over);
            else
                imageViewBMI.setImageResource(R.drawable.normal);
        }
        catch(Exception e){
            Toast.makeText(getApplication().getBaseContext(),"Enter a value!",Toast.LENGTH_SHORT).show();
        }

    }

    public void resetBMI(View v){
        editTextKg = (EditText)findViewById(R.id.editTextKg);
        editTextCm = (EditText)findViewById(R.id.editTextCm);
        textViewBMI = (TextView)findViewById(R.id.textViewBMI);
        imageViewBMI = (ImageView)findViewById(R.id.imageViewBMI);

        editTextKg.setText("");
        editTextCm.setText("");
        textViewBMI.setText("BMI: ");
        imageViewBMI.setImageResource(R.drawable.empty);
    }

}
