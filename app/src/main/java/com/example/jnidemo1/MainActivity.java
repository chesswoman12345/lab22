package com.example.jnidemo1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.jnidemo1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public native String helloFromJNI();
    public native int factorial(int n);
    public native String reverseString(String s);
    public native int sumArray(int[] values);

    static {
        System.loadLibrary("jnidemo");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHello = findViewById(R.id.tvHello);
        TextView tvFact = findViewById(R.id.tvFact);
        TextView tvReverse = findViewById(R.id.tvReverse);
        TextView tvArray = findViewById(R.id.tvArray);

        tvHello.setText(helloFromJNI());

        int fact10 = factorial(20);
        if (fact10 >= 0) {
            tvFact.setText("Factoriel de 10 = " + fact10);
        } else {
            tvFact.setText("Erreur factoriel, code = " + fact10);
        }

        String reversed = reverseString("");
        tvReverse.setText("Texte inverse : " + reversed);

        int[] numbers = {};
        int sum = sumArray(numbers);
        tvArray.setText("Somme du tableau = " + sum);
    }
}

/**
 * A native method that is implemented by the 'jnidemo' native library,
 * which is packaged with this application.
 */
