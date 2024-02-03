import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.plantcatalog.MyModel
import com.example.plantcatalog.databinding.ItemDataBinding

class MyAdapter(private var dataList: List<MyModel>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        // Ustaw dane w widoku za pomocą view binding
        holder.binding.textViewName.text = data.name
        holder.binding.textViewCountry.text = data.country
        holder.binding.textViewType.text = data.type
        holder.binding.textViewDescription.text = data.description

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateData(newDataList: List<MyModel>) {
        dataList = newDataList
    }

    class ViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root)
}


