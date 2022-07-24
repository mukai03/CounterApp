package kg.geektech.counterapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.counterapp.databinding.ActivityMainBinding
import kg.geektech.counterapp.presenter.Presenter
import kg.geektech.counterapp.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)
        presenter= Injector.getPresenter()
        presenter.attachView(this)
        initClicker()
    }

    private fun initClicker(){
        with(binding){
            btnIncrement.setOnClickListener {
                presenter.increment()
            }
            btnDecrement.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun updateCount(count: String) {
        binding.tvCount.text=count
    }

    override fun showToastPlus() {
        showToast("Поздравляю у вас 10")
    }

    override fun showGreenPlus() {
        binding.tvCount.setBackgroundColor(Color.GREEN)
    }
}