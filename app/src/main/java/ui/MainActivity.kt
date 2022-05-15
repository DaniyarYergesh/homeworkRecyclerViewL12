package ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import com.example.homework_recyclerview.Add1
import com.example.homework_recyclerview.Currency
import com.example.homework_recyclerview.R


class MainActivity : AppCompatActivity() {
    private var adapter: Adapter? = null
    private var layoutManager: LinearLayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupFun()
    }

    private fun setupFun() {
        val currencyList = listOf(
            Currency("1 500 000", "Тенге, Казахстан ", R.drawable.image_1),
            Currency("23450", "Доллары, США ", R.drawable.image_1_2),
            Currency("23450", "Лира, Турция", R.drawable.image_1_3),
            Currency("23450", "Евро, EC", R.drawable.image_1_4),
            Currency("23450", "Доллары, США", R.drawable.image_1_5),
            Currency("23450", "Доллары, США", R.drawable.image_1_2),
            Currency("23450", "Доллары, США", R.drawable.image_1_2),
            Currency("23450", "Лира, Турция", R.drawable.image_1_3),
            Currency("23450", "Евро, EC", R.drawable.image_1_4),
            Add1("Добавить", R.drawable.path837)
        )



        val myLambda: () -> Unit =
            {
                val transaction = supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, AddCurrencyFragment(adapter!!), "MainFragment")

                transaction.addToBackStack(null)
                transaction.commit()

                //adapter?.addNewItem()
                //scrollBottom(adapter?.itemCount ?: 0)
            }

        adapter = Adapter(myLambda)

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val myRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        myRecyclerView.adapter = adapter
        myRecyclerView.layoutManager = layoutManager

        adapter?.setItems(currencyList)

        var itemTouchHelper = ItemTouchHelper(SwipeToDelete(adapter!!))
        itemTouchHelper.attachToRecyclerView(myRecyclerView)

        var itemTouchHelper1 = ItemTouchHelper(DragDropMove(adapter!!))
        itemTouchHelper1.attachToRecyclerView(myRecyclerView)

    }

    fun scrollBottom(n: Int){
        val smoothScroller = object : LinearSmoothScroller(this) {
            override fun getVerticalSnapPreference(): Int = LinearSmoothScroller.SNAP_TO_START
        }
        smoothScroller.targetPosition = n
        layoutManager?.startSmoothScroll(smoothScroller) // плавная прокрутка
    }


}