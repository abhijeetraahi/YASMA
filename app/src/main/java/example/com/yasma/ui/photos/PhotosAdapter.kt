package example.com.yasma.ui.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import example.com.yasma.R
import example.com.yasma.databinding.PhotosItemBinding
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class PhotosAdapter @Inject
constructor(private val mPresenter: PhotosContract.Presenter<PhotosContract.View>) :
    RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.photos_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mPresenter.getPhotosResponse().size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.model = mPresenter.getPhotosResponse()[position]
        Picasso.get().load(mPresenter.getPhotosResponse()[position].thumbnailUrl).into(holder.binding.imageView)
    }

    inner class ViewHolder(var binding: PhotosItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}