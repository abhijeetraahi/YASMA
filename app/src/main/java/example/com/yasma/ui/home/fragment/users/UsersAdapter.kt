package example.com.yasma.ui.home.fragment.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import example.com.yasma.R
import example.com.yasma.databinding.UsersItemBinding
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class UsersAdapter @Inject
constructor(private val mPresenter: UsersContract.Presenter<UsersContract.View>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.users_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mPresenter.getUsersResponse().size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.model = mPresenter.getUsersResponse()[position]
    }

    inner class ViewHolder(var binding: UsersItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}