package com.example.testappsunil.data.model

import com.example.testappsunil.R

data class EmployDetails(
    val id: Int,
    val title: String,
    val sex: String,
    val age: Int,
    val description: String,
    val ImageId: Int = 0
)

//object Details {
//
//    val EmployDetailsList = listOf(
//        EmployDetails(
//            id = 1,
//            title = "Rohan",
//            sex = "Male",
//            age = 24,
//            description = " Don't judge each day by the harvest you reap but by the seeds that you plant.” - ...",
//            ImageId = R.drawable.sample_image
//        ),
//        EmployDetails(
//            id = 2,
//            title = "Roy",
//            sex = "male",
//            age = 25,
//            description = " Don't judge each day by the harvest you reap but by the seeds that you plant.” - ...",
//            ImageId = R.drawable.sample_image
//        ),
//        EmployDetails(
//            id = 3,
//            title = "Vishal",
//            sex = "Male",
//            age = 29,
//            description = " Don't judge each day by the harvest you reap but by the seeds that you plant.” - ...",
//            ImageId = R.drawable.sample_image
//        ),
//        EmployDetails(
//            id = 4,
//            title = "Nikhil",
//            sex = "Male",
//            age = 27,
//            description = " Don't judge each day by the harvest you reap but by the seeds that you plant.” - ...",
//            ImageId = R.drawable.sample_image
//        )
//    )
//}