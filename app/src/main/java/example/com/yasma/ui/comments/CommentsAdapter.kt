package example.com.yasma.ui.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import example.com.yasma.R
import example.com.yasma.databinding.CommentsItemBinding
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class CommentsAdapter @Inject
constructor(private val mPresenter: CommentsContract.Presenter<CommentsContract.View>) :
    RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.comments_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mPresenter.getCommentsResponse().size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.model = mPresenter.getCommentsResponse()[position]
    }

    inner class ViewHolder(var binding: CommentsItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}