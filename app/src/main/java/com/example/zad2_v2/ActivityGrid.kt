package com.example.zad2_v2


import android.content.Context
import android.content.Intent
import android.graphics.ColorSpace
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ActivityGrid : AppCompatActivity() {

    val modallist = ArrayList<Modal>()
    var names = arrayOf(
            "picture1",
            "picture2",
            "picture3",
            "picture4",
            "picture5",
            "picture6",
            "picture7",
            "picture8",
            "picture9",
            "picture10",
            "picture11",
            "picture12"
    )

    var images = intArrayOf(
            R.drawable.picture1, R.drawable.picture2, R.drawable.picture3, R.drawable.picture4,
            R.drawable.picture5, R.drawable.picture6, R.drawable.picture7, R.drawable.picture8,
            R.drawable.picture9, R.drawable.picture10, R.drawable.picture11, R.drawable.picture12
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        for (i in names.indices)
        {
            modallist.add(Modal(names[i],images[i]))
        }

        var customAdapter =  CustomAdapter(modallist,this);
        var myGrid = findViewById<GridView>(R.id.myGrid)
        myGrid.adapter = customAdapter;

        myGrid.setOnItemClickListener { adapterView, view, i, l ->
            var intent = Intent(this,ViewActivity::class.java)
            intent.putExtra("data",modallist[i])
            startActivity(intent)

        }


    }

    class CustomAdapter (
            var itemModel: ArrayList<Modal>,
            var context: Context
    ) : BaseAdapter() {

        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view;
            if(view == null){
                view = layoutInflater.inflate(R.layout.row_items,viewGroup,false);
            }
            var tvImageName = view?.findViewById<TextView>(R.id.imageName)
            var imageView = view?.findViewById<ImageView>(R.id.imageView);

            tvImageName?.text = itemModel[position].name;
            imageView?.setImageResource(itemModel[position].image!!)

            return view!!;

        }

        override fun getItem(position: Int): Any {
            return itemModel[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return itemModel.size
        }

    }

}
