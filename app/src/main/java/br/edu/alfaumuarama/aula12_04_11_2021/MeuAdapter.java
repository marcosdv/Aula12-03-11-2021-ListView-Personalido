package br.edu.alfaumuarama.aula12_04_11_2021;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class MeuAdapter extends ArrayAdapter<HashMap<String,String>> {

    private final Context context;
    private final ArrayList<HashMap<String,String>> itens;

    public MeuAdapter(Context context, ArrayList<HashMap<String,String>> itens) {
        super(context, R.layout.listview_modelo, itens);
        this.itens = itens;
        this.context = context;
    }

    //o metodo getView é executado a cada registro dos itens recebidos
    //  neste metodo que configuramos o que sera exibido na linha (celula)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //pegando a instancia do gerenciador de layout do android
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //pegando a linha de modelo criada
        View modelo = inflater.inflate(R.layout.listview_modelo, parent, false);

        //carregando os campos existentes dentro do modelo
        TextView txtTitulo = modelo.findViewById(R.id.txtTitulo);
        TextView txtDescricao = modelo.findViewById(R.id.txtDescricao);
        ImageView imgLogo = modelo.findViewById(R.id.imgLogo);

        //pegando o valor do item e colocando nos componentes da tela
        txtTitulo.setText(itens.get(position).get("menu"));
        txtDescricao.setText(itens.get(position).get("desc"));
        imgLogo.setImageResource(Integer.parseInt(itens.get(position).get("img")));

        //retorna o modelo preenchido com os dados
        return modelo;
    }
}
