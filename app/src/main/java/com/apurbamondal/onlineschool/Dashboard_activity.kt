package com.apurbamondal.onlineschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dashboard_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_activity)
        var lesson1 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180206-WA0001.mp4?alt=media&token=a6955675-612c-4291-98f6-b104b31edc20"
        var lesson2 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180207-WA0004.mp4?alt=media&token=935a1940-e522-4376-bf71-da2d4549e84f"
        var lesson3 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180209-WA0002.mp4?alt=media&token=023111e8-e6bf-48fa-853a-f9f829c783f9"
        var lesson4 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180209-WA0005.mp4?alt=media&token=d2c06e65-fcf6-4b44-8fdc-2742e29b5f4c"
        var lesson5 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180210-WA0002.mp4?alt=media&token=5d2ac7f6-fb09-4c37-9d16-b4a85918159c"
        var lesson6 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180210-WA0003.mp4?alt=media&token=9c014c23-bcbc-4dd0-817e-f1db15365c6f"
        var lesson7 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180216-WA0004.mp4?alt=media&token=0cc2a8ef-137f-4edf-b9c3-ef6547bbaaf2"
        var lesson8 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180226-WA0006.mp4?alt=media&token=3cac97da-858b-40b9-9270-c327a1502616"
        var lesson9 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180316-WA0003.mp4?alt=media&token=cce0e8a2-3611-4e9e-bd40-372e3007679f"
        var lesson10 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180529-WA0001.mp4?alt=media&token=d219c00b-0084-4f71-b850-38543c3c618a"
        var lesson11 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180613-WA0002.mp4?alt=media&token=515f9eaf-48f0-4461-b554-9a63c46cce06"
        var lesson12 = "https://firebasestorage.googleapis.com/v0/b/online-school-2c5d8.appspot.com/o/VID-20180627-WA0001.mp4?alt=media&token=fdb60b77-a30c-4f1f-89e2-b371a170e3af"

        var items = ArrayList<Lesson>()
        items.add(Lesson("Math Confusion", "Confusion while doing a Math.", lesson1))
        items.add(Lesson("Fart in Office", "A person having a bad day in Office.", lesson2))
        items.add(Lesson("Propose day", "Boy Proposing a girl with a beautiful background music.", lesson3))
        items.add(Lesson("Girls Fighting", "Two girl are fighting badly.", lesson4))
        items.add(Lesson("Beautiful Nature", "A White Peacock showing her dance.", lesson5))
        items.add(Lesson("Praying GOD", "A little girl showing her gratitude to GOD.", lesson6))
        items.add(Lesson("Relationship Breakups", "This is how it looks like when breakup happens", lesson7))
        items.add(Lesson("Dance Talent", "Someone showing his dance talent to impress the audience.", lesson8))
        items.add(Lesson("Relationship Advise", "Someone giving a great advise about relationship.", lesson9))
        items.add(Lesson("Tricky Man", "A man showing her trick to the audience.", lesson10))
        items.add(Lesson("The magician", "Best Even magic performance in talent show.", lesson11))
        items.add(Lesson("Vape God", "Meet the 21 year old vape god", lesson12))

        val list = findViewById<RecyclerView>(R.id.videos_list)
        val adapter = Adapter(items, applicationContext)
        list.layoutManager = GridLayoutManager(applicationContext, 1)
        list.adapter = adapter
    }
}