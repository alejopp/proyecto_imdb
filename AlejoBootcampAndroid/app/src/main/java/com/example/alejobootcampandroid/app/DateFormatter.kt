package com.example.alejobootcampandroid.app

class DateFormatter {

    companion object{
        private const val START_YEAR_POS = 0
        private const val END_YEAR_POS = 3
        fun getYear(date: String): String{
            return if(date.isNotEmpty()){
                var year = ""
                for(i in START_YEAR_POS..END_YEAR_POS){
                    year += date[i]
                }
                year
            } else{
                "N.D"
            }
        }
    }
}