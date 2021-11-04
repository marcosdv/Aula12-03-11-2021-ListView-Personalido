package br.edu.alfaumuarama.aula12_04_11_2021;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {

    ArrayList<HashMap<String,String>> itensMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //criando os itens do menu
        itensMenu = new ArrayList<>();
        itensMenu.add(criarItem("Tela 01", "Descrição da Tela 01", R.drawable.icone01));
        itensMenu.add(criarItem("Tela 02", "Descrição da Tela 02", R.drawable.icone02));
        itensMenu.add(criarItem("Tela 03", "Descrição da Tela 03", R.drawable.icone03));

        //configurando o ADAPTER padrão de dados (fonte de dados da lista)
        //1 paran -> Em que tela esta a listagem
        //2 paran -> Qual objeto do tipo ArrayList<HashMap<>> que estao os dados
        //3 paran -> Qual o modelo de celula (linha) para a lista
        //4 paran -> Nome dos campos (chave) do HashMap (Dicionario de dados)
        //5 paran -> Qual objeto do modelo vai receber o valor dos dados
        //ListAdapter adapter = new SimpleAdapter(this,
        //        itensMenu, R.layout.listview_modelo,
        //        new String[] { "menu", "desc" },
        //        new int[] { R.id.txtTitulo, R.id.txtDescricao } );

        //adicionando o adapter (fonte de dados) criado acima na lista da tela
        //setListAdapter(adapter);

        //adicionando o meu adapter personalidado
        setListAdapter(new MeuAdapter(this, itensMenu));
    }

    private HashMap<String,String> criarItem(String texto, String descricao, int imagem) {
        //criando o dicionario de dados (HashMap) com os dados para o menu
        HashMap<String,String> item = new HashMap<>();
        item.put("menu", texto);
        item.put("desc", descricao);
        item.put("img", String.valueOf(imagem));
        return item;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //criando o objeto que ira receber o caminho de tela
        Intent telaDestino;

        //verifica qual item foi selecionado na lista e carrega o caminho de tela correspondente
        /*
        if (position == 0)
            telaDestino = new Intent(MainActivity.this, Tela01Activity.class);
        else if (position == 1)
            telaDestino = new Intent(MainActivity.this, Tela02Activity.class);
        else
            telaDestino = new Intent(MainActivity.this, Tela03Activity.class);
        */

        //verifica qual item foi selecionado na lista e carrega o caminho de tela correspondente
        switch (position) {
            case 0: telaDestino = new Intent(MainActivity.this, Tela01Activity.class); break;
            case 1: telaDestino = new Intent(MainActivity.this, Tela02Activity.class); break;
            default: telaDestino = new Intent(MainActivity.this, Tela03Activity.class);
        }

        //abre o caminho de tela criado acima
        startActivity(telaDestino);
    }
}