package nl.svdoetelaar.madlevel5task2.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import nl.svdoetelaar.madlevel5task2.R
import nl.svdoetelaar.madlevel5task2.databinding.BacklogGameBinding
import nl.svdoetelaar.madlevel5task2.model.BacklogGame
import java.time.format.DateTimeFormatter

class BacklogGameAdapter(private val backlogGames: List<BacklogGame>) :
    RecyclerView.Adapter<BacklogGameAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = BacklogGameBinding.bind(itemView)

        fun dataBind(backlogGame: BacklogGame) {
            binding.tvGameName.text = backlogGame.name
            binding.tvPlatform.text = backlogGame.platform
            binding.tvPlatform.text = backlogGame.date.format(DateTimeFormatter.BASIC_ISO_DATE)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BacklogGameAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.backlog_game, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BacklogGameAdapter.ViewHolder, position: Int) {
        holder.dataBind(backlogGames[position])
    }

    override fun getItemCount(): Int {
        return backlogGames.size
    }

}