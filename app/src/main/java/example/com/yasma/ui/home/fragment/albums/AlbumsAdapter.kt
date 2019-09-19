package example.com.yasma.ui.home.fragment.albums

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import example.com.yasma.R
import example.com.yasma.databinding.AlbumsItemBinding
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class AlbumsAdapter @Inject
constructor(private val mPresenter: AlbumsContract.Presenter<AlbumsContract.View>) :
    RecyclerView.Adapter<AlbumsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.albums_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mPresenter.getAlbumsResponse().size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.model = mPresenter.getAlbumsResponse()[position]
    }

    inner class ViewHolder(var binding: AlbumsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                mPresenter.itemClicked(adapterPosition)
            }
        }
    }
}