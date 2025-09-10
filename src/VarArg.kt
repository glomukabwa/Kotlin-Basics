//Read after Maps
//VARIABLE ARGUMENTS
fun sayHi(greeting:String, itemsToGreet:List<String>){
    itemsToGreet.forEach{ itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

//Increasing flexibility using vararg
fun sayHi2(greeting:String, vararg toGreet:String) {
    toGreet.forEach{ greet->
        println("$greeting $greet")
    }
}

fun main() {
    val interestingThings = listOf("Kotlin", "Programming", "Comic Books")
    sayHi(greeting = "Hi", interestingThings)//You'll notice that with this one, you have to pass both parameters or else it'll bring an error. To increase flexibility, we use vararg

    println("Using vararg")
    //Flexible vararg
    //To be able to pass the greeting without having to put a list
    val interestingThings2 = arrayOf("Kotlin", "Programming", "Comic Books")//Note that I've changed it to array
    sayHi2("Hi")//You'll notice that for this one, it will not have an error and it will not display anything
    //In the above, the vararg is treated like an empty array therefore nothing is being passed
    //Also notice that you don't have to use greeting = "Hi". Before, I hadn't noticed that I'm not supposed to type greeting. It'll automatically come. That's why it wasn't working
    //If you want to pass something:
    sayHi2("Hi", "Kotlin", "Programming", "Comic Books")//You can either do it like this or:
    sayHi2("Hi", *interestingThings2)//The asterik will only work if what it is displaying is an array(I do not know why but it doesn't work if it is a list)
}

//Next:NDArg