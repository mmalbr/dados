package com.example.dados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private SeekBar seekBarEscala;
    private TextView valorEscala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //banner admob - Início
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //banner admob - Fim

        seekBarEscala = findViewById(R.id.seekBarEscala);
        valorEscala = findViewById(R.id.valorEscala);

        seekBarEscala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valorEscala.setText("" +  (progress + 6));
                TextView acabouTempo = findViewById(R.id.textView2);
                //acabouTempo.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }


    public void recuperarProgresso (View view){
        int x = seekBarEscala.getProgress();
        TextView textReal = findViewById(R.id.textView5);
        CharSequence y = textReal.getText();
        //valorEscala.setText( "Informado: " + x + " / " + y );
        TextView acabouTempo = findViewById(R.id.textView2);
        acabouTempo.setVisibility(View.VISIBLE);
        int y2 = Integer.parseInt(y.toString());
        if ((x + 6) == y2){
            Button botaoVerifica = findViewById(R.id.botaoVerificar);
            botaoVerifica.setVisibility(View.INVISIBLE );
            SeekBar escalaVerifica = findViewById(R.id.seekBarEscala);
            escalaVerifica.setVisibility(View.INVISIBLE);
            TextView descEscala = findViewById(R.id.textView3);
            descEscala.setVisibility(View.INVISIBLE);
            TextView valorEsc = findViewById(R.id.valorEscala);
            valorEsc.setText("6");
            valorEsc.setVisibility(View.INVISIBLE);
            Button botaoApaga = findViewById(R.id.botaoAcao);
            botaoApaga.setVisibility(View.VISIBLE );
            Button botaoReset = findViewById(R.id.botaoReset);
            botaoReset.setVisibility(View.VISIBLE );
            seekBarEscala.setProgress(0);
            acabouTempo.setText("Parabéns, você acertou!!!!!\nQue tal jogar mais uma vez?");
            ImageView dado01 = findViewById(R.id.dado01);
            ImageView dado02 = findViewById(R.id.dado02);
            ImageView dado03 = findViewById(R.id.dado03);
            ImageView dado04 = findViewById(R.id.dado04);
            ImageView dado05 = findViewById(R.id.dado05);
            ImageView dado06 = findViewById(R.id.dado06);
            dado01.setImageResource(R.drawable.dados00);
            dado02.setImageResource(R.drawable.dados00);
            dado03.setImageResource(R.drawable.dados00);
            dado04.setImageResource(R.drawable.dados00);
            dado05.setImageResource(R.drawable.dados00);
            dado06.setImageResource(R.drawable.dados00);
            botaoReset.setVisibility(View.INVISIBLE );
        }
        else{
            acabouTempo.setText("Errrrou! Tente novamente!");
        }

    }




    public void botaoClicado (View view){
        String[] opcoes = {"dado1", "dado2", "dado3", "dado4", "dado5", "dado6" };
        int totalPontos = 0;

        //dado 01
        ImageView dado01 = findViewById(R.id.dado01);
        int dado1 = new Random().nextInt(6);
        totalPontos = totalPontos + dado1 + 1;
        String opcaoDado1 = opcoes[dado1];
        switch ( opcaoDado1 ){
           case "dado1" :
               dado01.setImageResource(R.drawable.dados01);
               break;
           case "dado2" :
               dado01.setImageResource(R.drawable.dados02);
               break;
           case "dado3" :
               dado01.setImageResource(R.drawable.dados03);
               break;
           case "dado4" :
               dado01.setImageResource(R.drawable.dados04);
               break;
           case "dado5" :
               dado01.setImageResource(R.drawable.dados05);
               break;
           case "dado6" :
               dado01.setImageResource(R.drawable.dados06);
               break;
       }

        //dado 02
        ImageView dado02 = findViewById(R.id.dado02);
        int dado2 = new Random().nextInt(6);
        totalPontos = totalPontos + dado2 + 1;
        String opcaoDado2 = opcoes[dado2];
        switch ( opcaoDado2 ){
            case "dado1" :
                dado02.setImageResource(R.drawable.dados01);
                break;
            case "dado2" :
                dado02.setImageResource(R.drawable.dados02);
                break;
            case "dado3" :
                dado02.setImageResource(R.drawable.dados03);
                break;
            case "dado4" :
                dado02.setImageResource(R.drawable.dados04);
                break;
            case "dado5" :
                dado02.setImageResource(R.drawable.dados05);
                break;
            case "dado6" :
                dado02.setImageResource(R.drawable.dados06);
                break;
        }

        //dado 03
        ImageView dado03 = findViewById(R.id.dado03);
        int dado3 = new Random().nextInt(6);
        totalPontos = totalPontos + dado3 + 1;
        String opcaoDado3 = opcoes[dado3];
        switch ( opcaoDado3 ){
            case "dado1" :
                dado03.setImageResource(R.drawable.dados01);
                break;
            case "dado2" :
                dado03.setImageResource(R.drawable.dados02);
                break;
            case "dado3" :
                dado03.setImageResource(R.drawable.dados03);
                break;
            case "dado4" :
                dado03.setImageResource(R.drawable.dados04);
                break;
            case "dado5" :
                dado03.setImageResource(R.drawable.dados05);
                break;
            case "dado6" :
                dado03.setImageResource(R.drawable.dados06);
                break;
        }

        //dado 04
        ImageView dado04 = findViewById(R.id.dado04);
        int dado4 = new Random().nextInt(6);
        totalPontos = totalPontos + dado4 + 1;
        String opcaoDado4 = opcoes[dado4];
        switch ( opcaoDado4 ){
            case "dado1" :
                dado04.setImageResource(R.drawable.dados01);
                break;
            case "dado2" :
                dado04.setImageResource(R.drawable.dados02);
                break;
            case "dado3" :
                dado04.setImageResource(R.drawable.dados03);
                break;
            case "dado4" :
                dado04.setImageResource(R.drawable.dados04);
                break;
            case "dado5" :
                dado04.setImageResource(R.drawable.dados05);
                break;
            case "dado6" :
                dado04.setImageResource(R.drawable.dados06);
                break;
        }

        //dado 05
        ImageView dado05 = findViewById(R.id.dado05);
        int dado5 = new Random().nextInt(6);
        totalPontos = totalPontos + dado5 + 1;
        String opcaoDado5 = opcoes[dado5];
        switch ( opcaoDado5 ){
            case "dado1" :
                dado05.setImageResource(R.drawable.dados01);
                break;
            case "dado2" :
                dado05.setImageResource(R.drawable.dados02);
                break;
            case "dado3" :
                dado05.setImageResource(R.drawable.dados03);
                break;
            case "dado4" :
                dado05.setImageResource(R.drawable.dados04);
                break;
            case "dado5" :
                dado05.setImageResource(R.drawable.dados05);
                break;
            case "dado6" :
                dado05.setImageResource(R.drawable.dados06);
                break;
        }

        //dado 06
        ImageView dado06 = findViewById(R.id.dado06);
        int dado6 = new Random().nextInt(6);
        totalPontos = totalPontos + dado6 + 1;
        String opcaoDado6 = opcoes[dado6];
        switch ( opcaoDado6 ){
            case "dado1" :
                dado06.setImageResource(R.drawable.dados01);
                break;
            case "dado2" :
                dado06.setImageResource(R.drawable.dados02);
                break;
            case "dado3" :
                dado06.setImageResource(R.drawable.dados03);
                break;
            case "dado4" :
                dado06.setImageResource(R.drawable.dados04);
                break;
            case "dado5" :
                dado06.setImageResource(R.drawable.dados05);
                break;
            case "dado6" :
                dado06.setImageResource(R.drawable.dados06);
                break;
        }
        //exibe o valor correto
        TextView texto = findViewById(R.id.textView5);
        texto.setText("" + totalPontos);

        TextView textView2 = findViewById(R.id.textView2);

        new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                textView2.setText("" + millisUntilFinished / 1000);
                Button botaoReset = findViewById(R.id.botaoReset);
                botaoReset.setVisibility(View.INVISIBLE );
            }

            public void onFinish() {
                dado01.setImageResource(R.drawable.dados0);
                dado02.setImageResource(R.drawable.dados0);
                dado03.setImageResource(R.drawable.dados0);
                dado04.setImageResource(R.drawable.dados0);
                dado05.setImageResource(R.drawable.dados0);
                dado06.setImageResource(R.drawable.dados0);
                textView2.setText("Acabou o tempo!");
                Button botaoReset = findViewById(R.id.botaoReset);
                botaoReset.setVisibility(View.VISIBLE );
               // Button botaoApaga = findViewById(R.id.botaoAcao);
               // botaoApaga.setVisibility(View.VISIBLE );

            }
        }.start();
        Button botaoApaga = findViewById(R.id.botaoAcao);
        botaoApaga.setVisibility(View.INVISIBLE );

        Button botaoVerifica = findViewById(R.id.botaoVerificar);
        botaoVerifica.setVisibility(View.VISIBLE );
        SeekBar escalaVerifica = findViewById(R.id.seekBarEscala);
        escalaVerifica.setVisibility(View.VISIBLE);
        TextView descEscala = findViewById(R.id.textView3);
        descEscala.setVisibility(View.VISIBLE);
        TextView valorEsc = findViewById(R.id.valorEscala);
        valorEsc.setVisibility(View.VISIBLE);





    }
}
