package edu.miu.cs473.mdptablayout

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.view.marginBottom
import androidx.core.view.marginStart
import androidx.core.view.setMargins
import androidx.core.view.updateLayoutParams
import edu.miu.cs473.mdptablayout.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addTableHeader()
        addTableRow("Android 9.0", "Pie", false)
        addTableRow("Android 8.0", "Oreo", false)
        binding.addBtn.setOnClickListener{
            addTableRow(binding.androidVersion.text.toString(),binding.androidCodeName.text.toString(),false)
        }
    }

    fun addTableHeader(){
        addTableRow("Version","Code Name",true)
    }

    fun addTableRow(version: String,codeName: String,isHeader: Boolean){
        val tableRow = TableRow(applicationContext)
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.setPadding(2,2,2,2)
        tableRow.setBackgroundColor(Color.BLACK)
        tableRow.layoutParams = layoutParams

        val versionText = TextView(this)
        versionText.setBackgroundColor(Color.parseColor("#FF4081"))
        versionText.text = version
        if(isHeader){
            versionText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD))
        }
        tableRow.addView(versionText)

        val codeNameText = TextView(this)
        codeNameText.setBackgroundColor(Color.parseColor("#FF4081"))
        codeNameText.text = codeName
        if(isHeader){
            codeNameText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD))
        }
        tableRow.addView(codeNameText)

        binding.tableLayout.addView(tableRow)
    }
}