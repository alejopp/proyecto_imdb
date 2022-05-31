package com.example.alejobootcampandroid.providers

import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.models.BestSelection


class BestSelectionProvider {
    companion object{
        val bestSelectionList = listOf<BestSelection>(
            BestSelection(
                R.drawable.light_year,
            "3.5",
            "Light Year"),
            BestSelection(
                R.drawable.light_year,
                "3.5",
                "Light Year"),
            BestSelection(
                R.drawable.light_year,
                "3.5",
                "Light Year"),
            BestSelection(
                R.drawable.light_year,
                "3.5",
                "Light Year"),
            BestSelection(
                R.drawable.light_year,
                "3.5",
                "Light Year"),
        )
    }
}