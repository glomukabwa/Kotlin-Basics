//First Lesson
//VARIABLES

//Variables can be declared outside classes
var greeting: String = "Hello"

//Variables in Kotlin are non-null. To create a variable that is null, you have to add a question mark
var gender: String? = "male"//You can now change this to null in the class. (I'm also illustrating changing so that's y I gave it the value male but you can assign null right now)

//Kotlin can figure out the type of variable you are creating so you don't always have to define it:
var age = 24 //You see? No error. However, this can't work if you want to assign the null value cz the automatic principle is that variables are non-null

fun main() {
    //Read only variable. You can't change the value (They act like constants)
    val name: String = "Nate"

    //This one can be changed:
    var name1: String = "Abby"
    name1 = "Adrian" //Reassigning the value

    println(name1)//This will display Adrian

    println(greeting) //It will still display the greeting even though the variable is outside the class main

    //Changing variables outside the class:
    greeting = "hi"
    println(greeting) //You'll notice that the first greeting which is hello will be displayed but below it, hi will be displayed

    gender = null //If ? had not been placed when assigning, this would've brought an error
    println(gender) //It will display the word null.

    //If...else...
    if (gender != null){
        println(gender)
    }else{
        println("Gender undefined")
    }

    //When (Similar use to the switch clause)
    when(gender){
        null -> println("Please define your gender")
        else -> println(gender)
    }

    //Using if...else to assign variables
    val genderToPrint = if(gender != null ) gender else "female"
    println(genderToPrint)


    //Using when to assign variables
    val genderToDisplay = when(gender){
        null -> "FEM"
        else -> gender
    }
    print(genderToDisplay)
}

//Next:Functions