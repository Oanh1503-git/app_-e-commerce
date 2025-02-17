package com.example.app_e_commerce.model

sealed class Screems (val route:String){
    object HOMEPAGE:Screems("home_page")
    object CATAGORIES:Screems("catagories")

}