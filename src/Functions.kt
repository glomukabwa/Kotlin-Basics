//Read after Variables
//FUNCTIONS

//Creating functions:
fun getGreeting(): String {//The String here is the return type
    return "Hello Kotlin"
}

fun getGreeting2(){
    println("Tara")
}

fun nullGreeting(): String? {
    return null
}


//Single expression function
//It works the same as the other 2 functions above but is shorter.
//It is Kotlin's way of easing function definition. Explanation is similar to the variable one so similarly, for null, you have to define
fun greetingTwo() = "Hello again"


//Function parameters
//How to pass parameters:
fun sayHello(itemToGreet:String){
    val msg = "Hello " + itemToGreet
    println(msg)
}
//OR:
fun sayHello2(item2:String){
    val msg = "Hello $item2"
    println(msg)
}
//OR:
fun sayHello3(whatToSay:String) = println("Hello $whatToSay")


//Multiple parameters:
fun sayHello4(greeting:String, toSay:String) = println("$greeting $toSay")

fun main() {
    println(getGreeting())
    getGreeting2() //I'm not using println here because I've already indicated it in the function. In the others, I had used return so I had to use it and to define the return type
    println(nullGreeting())
    println(greetingTwo())

    //Functions with parameters
    sayHello(itemToGreet = "Caren")
    sayHello2(item2 = "Tisha")
    sayHello3(whatToSay = "Zara")
    sayHello4(greeting = "Bonjour", toSay = "Jean-Paul")
}

//Next:Arrays