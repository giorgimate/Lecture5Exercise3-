package com.example.mythirdapplication

import java.util.regex.Pattern

fun main(){
  //  var pr = Person(email = "ef@mai.ru", userName = "esfფდვდფვდფვდ", firstName = "esf", lastName = "esf", age = 2300)
}
class Person() {

    var email: String = ""
    var userName: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var age: Int = 0

//    public fun isValidEmail(email: String): String? {
//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            return "შეიყვანეთ სწორი ემეილი"
//        }
//        return null  // Return null when the email is valid
//    }
    public fun isValidEmail(email:String): String? {
        val emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"

        if (!email.matches(emailPattern.toRegex())) {
            return "შეიყვანეთ სწორი ემეილი"
        }

        return null
    }

    public fun isValidUserName(userName: String) : String?{
        if(userName.length < 10){
            return "იუზერნეიმის სიმბოლოების რაოდენობა უნდა აღემატებოდეს 10 _ ს"
        }
        return null
    }
    public fun isValidFirstName(firstName: String) : String?{
        if(firstName.length < 2){
            return "სახელის სიმბოლოების რაოდენობა უნდა აღემატებოდეს 2 _ ს"
        }
        return null
    }
    public fun isValidLastName(lastName: String) : String?{
        if(lastName.length < 2){
            return "გვარის სიმბოლოების რაოდენობა უნდა აღემატებოდეს 2 _ ს"
        }
        return null
    }
    public fun isValidAge(age: Int) : String?{
        if((age > 0 && age < 130)){

            return null
        }
        else{
           return "გთხოვთ შეიყვანოთ სწორი ასაკი"
        }


    }
}


