package com.example.spacex.ui.all_launches.launches_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spacex.R
import com.example.spacex.data.RocketDataItem
import com.example.spacex.databinding.ItemLaunchBinding
import com.example.spacex.ui.base.BindingHolder

class LaunchesListAdapter(
    private val rocketList: List<RocketDataItem>,
    private val onItemClick: ((itemData: RocketDataItem) -> Unit)
) : RecyclerView.Adapter<BindingHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_launch, parent, false)
        return BindingHolder(view)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        holder.binding?.apply {
            when (this) {
                is ItemLaunchBinding -> {
                    vm = LaunchesItemViewModel(itemData = rocketList[position]) {
                        onItemClick.invoke(rocketList[position])
                    }
                }
            }
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int = rocketList.size
}