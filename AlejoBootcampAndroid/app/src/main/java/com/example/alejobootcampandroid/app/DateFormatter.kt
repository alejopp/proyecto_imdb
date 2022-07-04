package com.example.alejobootcampandroid.app

class DateFormatter {

    companion object{
        const val START_YEAR_POS = 0
        const val END_YEAR_POS = 3
        fun getYear(date: String): String{
            if(date.isNotEmpty()){
                var year = ""
                for(i in START_YEAR_POS..END_YEAR_POS){
                    year += date[i]
                }
                return year
            }
            else{
                return "N.D"
            }
        }
    }
}