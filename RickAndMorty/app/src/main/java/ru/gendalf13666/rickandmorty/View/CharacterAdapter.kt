package ru.gendalf13666.rickandmorty.View

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import ru.gendalf13666.rickandmorty.Model.Data.Character
import ru.gendalf13666.rickandmorty.R
import ru.gendalf13666.rickandmorty.View.fragments.ListFragmentDirections

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var listCharacters = emptyList<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(listCharacters[position])

        holder.itemView.setOnClickListener { view ->
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(listCharacters[position])
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCharacters(characters: List<Character>) {
        listCharacters = characters
        notifyDataSetChanged()
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image_character = itemView.character_img
        var status_type = itemView.txt_status
        var id_number = itemView.txt_id_character
        var name_character = itemView.txt_name_character

        fun bind(character: Character) {
            Picasso.get().load(character.image).into(image_character)
            status_type.text = character.status
            id_number.text = character.id.toString()
            name_character.text = character.name
        }
    }
}
