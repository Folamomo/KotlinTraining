package com.example.tasksmanager.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.tasksmanager.R
import com.example.tasksmanager.model.Task

class TaskAdapter(private val context: Context, private val items: List<Task>) :BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = items[position]
        var rowView = convertView
        var holder: TaskHolder

        if (rowView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            rowView = inflater.inflate(R.layout.item_task, parent, false)
            holder = TaskHolder(rowView)

            rowView.tag = holder
        } else {
            holder = rowView.tag as TaskHolder
        }

        holder.taskNameTv.text = item.name
        holder.taskCommentTv.text = item.comment
        holder.taskImportantV.visibility = if(item.important) View.VISIBLE else View.INVISIBLE

        return rowView as View
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

    private class TaskHolder(view: View){
        val taskNameTv = view.findViewById<TextView>(R.id.item_task_name_tv)
        val taskCommentTv = view.findViewById<TextView>(R.id.item_task_comment_tv)
        val taskImportantV = view.findViewById<View>(R.id.item_task_important_view)
    }
}
