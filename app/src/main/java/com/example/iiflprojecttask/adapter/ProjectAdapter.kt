package com.example.iiflprojecttask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iiflprojecttask.databinding.AdapterViewOneBinding
import com.example.iiflprojecttask.models.DataList
import com.example.iiflprojecttask.models.Gainer
import com.example.iiflprojecttask.models.ScriptModel


class ProjectAdapter() : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {

    private var projectList: List<Gainer>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {

        val binding: AdapterViewOneBinding =
            AdapterViewOneBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
            )
        return ProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.binding.setProject(projectList!![position])
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return if (projectList == null) 0 else projectList!!.size
    }

    class ProjectViewHolder(binding: AdapterViewOneBinding) :
        RecyclerView.ViewHolder(binding.getRoot()) {
        val binding: AdapterViewOneBinding

        init {
            this.binding = binding
        }
    }

    fun setProjectList(projectList: List<Gainer>) {
        this.projectList = projectList
        notifyDataSetChanged()
    }
}