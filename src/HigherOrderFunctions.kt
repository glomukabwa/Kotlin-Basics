//Read Entity Factory2 before this

//HIGHER ORDER FUNCTIONS
//These are functions that either return other functions or that take functions as parameter values

//Functions that accept other functions as parameters:
/*fun printFilteredStrings(List: List<String>, predicate: (String) -> Boolean) {
    //predicate: (String) -> Boolean) is the function being passed as a parameter in this function printFilteredString
    //predicate is the name of the function
    //String in the brackets is the data type being returned if it has fulfilled the boolean condition so it is accepting a string and returning it. The guy said it returns a Boolean bcz it returns the true value

    List.forEach { //Here we are just gonna use the default name. See in notes of Lists. You can give it a name or use default
        if(predicate(it)){//This means that if the condition passed in the bracket is true:
            println(it) //return the value
        }
    }
}*/

//If the function is nullable:
fun printFilteredStrings(List: List<String>, predicate: ((String) -> Boolean)?){
    List.forEach{
        if(predicate?.invoke(it) == true){//For nullable functions, you can't pass them directly. You have to invoke them safely (it's called a safe call) and specify that if true( == true)
            println(it)
        }
    }//However, the nullable function will still be used the same way in main
}

//OR:
//We can create a variable of functional type
val predicate: (String) -> Boolean = {
    it.startsWith("C")//And then do this instead of having to specify inside main
}//Plz Note that when doing this, the function predicate is still taken as a parameter in the same way as it had been done when we hadn't created a variable of function type. The changes only occur in main



//Functions that return other functions:
fun getPrintPredicate() :(String) -> Boolean {
    return { it.startsWith("J")}
}


fun main() {

    /*
    //Functions that accept other functions as parameters:
    /*
    val list = listOf("Kotlin", "Java", "C++", "Javascript")
    printFilteredStrings(list, { it.startsWith("K")}) //Will return only the data that starts with K
    printFilteredStrings(list, { it.endsWith("t")})// Will print JavaScript
    //OR:
    printFilteredStrings(list) {//You can specify the function outside the brackets
        it.endsWith("a")
    }
    //With the nullable function, if we are passing things, we'll still do it like we did with the function that isn't nullable. The above works the same way

    //Passing a null value:
    printFilteredStrings(list, null)//This will print nothing but I guess it was just to show that null is allowed
    */

    //Using a variable of function type:
    val list = listOf("Kotlin", "Java", "C++", "Javascript")
    printFilteredStrings(list, predicate)
    */


    //Functions that return other functions:
    val list = listOf("Kotlin", "Java", "C++", "Javascript")
    printFilteredStrings(list, getPrintPredicate())//The output is the same but how it works is different
    //The function predicate being passed in the second position and is returning the value of the function getPrintPredicate is being returned so instead of having to define what the predicate should do we're telling the compiler, just use function getPrintPredicate() and return its value
    //At the end of the day, all these different methods will provide the same output

}

//Next: ComplexOperations