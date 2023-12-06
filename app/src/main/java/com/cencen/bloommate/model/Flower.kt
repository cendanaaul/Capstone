package com.cencen.bloommate.model

data class Flower(
    val id: Long,
    val image: String,
    val title: String,
    val price: Int,
    val description: String,
    val stock: Int,
)
