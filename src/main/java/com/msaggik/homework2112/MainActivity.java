package com.msaggik.homework2112;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float matPlat = 70; // пальто
    byte matPlatDiscount = 77;
    float ram = 25; // шляпа
    byte ramDiscount = 37;
    float rom = 53; // костюм
    byte romDiscount = 44;
    float cooler = 19; // сорочка
    float caseAndPower = 41; // туфли
    byte caseAndPowerDiscount = 32;
    float account = 312;

    private float calculation() {
        float count = (matPlat * (100 - matPlatDiscount) + ram * (100 - ramDiscount)
                + rom * (100 - romDiscount) + cooler * (100)
                + caseAndPower * (100 - caseAndPowerDiscount)) / 100;
        return count;
    }


    private boolean possibility() {
        if (calculation() <= account) {
            return true;
        } else {
            return false;
        }
    }
    private float balance() {
        if(possibility()) {
            return account - calculation();
        } else {
            return -1;
        }
    }
    private TextView possibilityOut;
    private TextView balanceOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        possibilityOut = findViewById(R.id.possibilityOut);
        balanceOut = findViewById(R.id.balanceOut);
        if (possibility()) {
            possibilityOut.setText("Имеется достаточно средств для покупки серверного комплекта");
            balanceOut.setText("Остаток от покупки " + balance() + " серебрянных монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки серверного комплекта");
            balanceOut.setText(" - ");
        }
    }
}