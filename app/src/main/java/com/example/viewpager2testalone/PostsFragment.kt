package com.example.viewpager2testalone

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "PostsFragment"

class PostsFragment : Fragment() {
    private val innerList: MutableList<String> = mutableListOf()
    private lateinit var liveDataList: MutableLiveData<List<String>>

    private lateinit var layoutManager: LinearLayoutManager


    private lateinit var postsRv: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 1..200) {
            innerList.add("The quick brown fox jumps over the lazy dog 1 The quick brown fox jumps over the lazy dog 2 The quick brown fox jumps over the lazy dog 3 The quick brown fox jumps over the lazy dog 4 The quick brown fox jumps over the lazy dog 5 The quick brown fox jumps over the lazy dog 6 The quick brown fox jumps over the lazy dog 7 The quick brown fox jumps over the lazy dog 8 The quick brown fox jumps over the lazy dog 9 The quick brown fox jumps over the lazy dog 10")
            innerList.add("post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary post summary ")
            innerList.add("حققت الشركة السعودية للكهرباء، إنجازاً جديداً يضاف إلى مجموعة الإنجازات العالمية والإقليمية والمحلية التي حققتها، تمثل في احتلال علامتها التجارية، المركة الأول في قطاع مرافق تحول الطاقة في انني احسن واحد فالعالم كله")
            innerList.add("create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post create new post ")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_posts, container, false)
        postsRv = view.findViewById(R.id.rv)

        layoutManager = LinearLayoutManager(context)

        liveDataList = MutableLiveData()

        liveDataList.value = innerList
        liveDataList.observe(viewLifecycleOwner) {
            updateUI(it)
        }
        Log.d(TAG, "onCreateView: ")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreate: ")
    }

    override fun onResume() {
        super.onResume()
        postsRv.layoutManager = layoutManager
    }

    private fun updateUI(innerList: List<String>) {
        val adapter = PostsAdapter(innerList)

        postsRv.adapter = adapter
    }
}

class PostsAdapter(private val innerList: List<String>) : RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)

        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val content = innerList[position]

        holder.bind(content)
    }

    override fun getItemCount(): Int = innerList.size
}

class PostsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textView: TextView = view.findViewById(R.id.textView)

    fun bind(content: String) {
        textView.text = content
    }

}