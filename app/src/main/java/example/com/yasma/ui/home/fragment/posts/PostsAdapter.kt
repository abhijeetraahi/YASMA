package example.com.yasma.ui.home.fragment.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import example.com.yasma.R
import example.com.yasma.databinding.PostsItemBinding
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 18/09/2019.
 */
class PostsAdapter @Inject
constructor(private val mPresenter: PostsContract.Presenter<PostsContract.View>) :
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.posts_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mPresenter.getPostsResponse().size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.model = mPresenter.getPostsResponse()[position]
    }

    inner class ViewHolder(var binding: PostsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                mPresenter.showComment(adapterPosition)
            }
        }
    }

}