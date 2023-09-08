package com.example.pokedex_app.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex_app.R
import com.example.pokedex_app.domain.Pokemon

class PokemonAdapter(
    private val items:List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false);
        return ViewHolder(view);
    }

    /**
     * No Kotlin, o ; é opcional. Há também uma sintaxe mais curta para retornar valores.
     * Você pode usar o operador = em vez de return sem especificar o tipo de retorno.
     * Kotlin saberá o tipo que será retornado.
     * **/
    override fun getItemCount() = items.size;

    /**
     * Recebe o ViewHolder e sua posição na lista
     * **/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position];

        holder.bindView(item);
    }

    /**
     * Atualizar o xml
     * **/
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: Pokemon) =
            /**
             * O 'with' é uma função de escopo, que são funções da biblioteca padrão do Kotlin
             * cujo o objetivo é executar um bloco de código dentro de um escopo/contexto de um
             * objeto que podem ou não ter um valor de retorno. São cinco funções:
             * let, run , with , apply e also .
             *
             * Utilizamos o with para executar funções no objeto dentro de um contexto.
             * Podemos ler como “com esse objeto, faça”
             *
             * Ex.: Com(itemView) { faça }
             * **/
            with(itemView){
                val ivPokemon = findViewById<ImageView>(R.id.ivPokemon);
                val tvNumber = findViewById<TextView>(R.id.tvNumber);
                val tvName = findViewById<TextView>(R.id.tvName);
                val tvType1 = findViewById<TextView>(R.id.tvType1);
                val tvType2 = findViewById<TextView>(R.id.tvType2);

                // TODO: Load image with Glide

                // Utilizando biblioteca para carregamento de imagem
                tvNumber.text = "Nº ${item.number}";
                tvName.text = item.name;
                tvType1.text = item.types[0].name;

                if(item.types.size > 1) {
                    tvType2.visibility = View.VISIBLE;
                    tvType2.text = item.types[1].name;
                } else {
                    tvType2.visibility = View.GONE;
                }

            }

    }

}