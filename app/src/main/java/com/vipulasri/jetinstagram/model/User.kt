package com.vipulasri.jetinstagram.model

data class User(
  val name: String,
  val username: String,
  val image: String
)

val currentUser = User(
    name = "Joseph Mbuyamba",
    username = "Joestagram",
    image = "https://www.cheatsheet.com/wp-content/uploads/2020/07/Will-Smith-3-2-scaled.jpg"
)