
package br.ulbra.jokenpo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    int pontuacaoJogador = 0;
    int pontuacaoApp = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionado("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionado("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionado("tesoura");
    }

    public void atualizarPlacar(View view) {
        TextView txtPlacar = findViewById(R.id.txtPlacar);
        txtPlacar.setText("Jogador:" + pontuacaoJogador + " - App:" + pontuacaoApp);
    }

    public void reiniciarJogo(View view) {
        pontuacaoJogador = 0;
        pontuacaoApp = 0;
        TextView txtPlacar = findViewById(R.id.txtPlacar);
        TextView txtResult = findViewById(R.id.txtResult);
        txtPlacar.setText("Jogador" + pontuacaoJogador + "- App:" + pontuacaoApp);
        ImageView imageResultado = findViewById(R.id.imgApp);
        imageResultado.setImageResource(R.drawable.padrao);
        txtResult.setText("Ganhador");
    }

    public void opcaoSelecionado(String opcaoSelecionada) {
        TextView txtResult = findViewById(R.id.txtResult);
        TextView txtPlacar = findViewById(R.id.txtPlacar);
        String opcoes[] = {"pedra", "papel", "tesoura"};

        String opcaoApp = opcoes[new Random().nextInt(3)];
        ImageView imageResultado = findViewById(R.id.imgApp);
        switch (opcaoApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if ((opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                (opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                (opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura"))) {
            pontuacaoApp++;
            txtResult.setText("Vencedor App:" + pontuacaoApp);

        } else if ((opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel")) ||
                (opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra")) ||
                (opcaoSelecionada.equals("pedra") && opcaoApp.equals("tesoura"))) {
            pontuacaoJogador++;
            txtResult.setText("Vencedor Você:" + pontuacaoJogador);

        } else {
            txtResult.setText("Vencedor: Vocês empataram :I");
        }
        if(pontuacaoJogador == 3){
            txtPlacar.setText("Você venceu a partida");
        }else if(pontuacaoApp == 3){
            txtPlacar.setText("Você perdeu a partida");
        }
    }
}



