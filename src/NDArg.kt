//Read after VarArg
//NAMED AND DEFAULT ARGUMENTS

//Named Arguments:
//This is basically just what I was doing before I figured out that the parameter names were supposed to be typed automatically
fun greetPerson(greeting:String, name:String) = println("$greeting $name")

//Default Arguments:
//With this one, you assign a default value so that in case an arguement is not passed in the main function, sth is still displayed
//It improves flexibility since with the one above, if you try to call an empty function, an error will occur so it won't work
fun greetPerson2(greeting:String = "Hola", name:String = "Patricia") = println("$greeting $name")

fun main() {
    //Named Arguments
    //This:
    greetPerson(greeting = "Hi", name = "Ria")
    //Instead of this:
    greetPerson("Hello", "Anna")

    //The first one is named arguments. It's advantages are that order doesn't matter. It's disadvantages are you can't mix it with the other one. If you use named arguments for greeting, you use the automatic appearance of parameters for name
    //This:
    greetPerson(name = "Ria", greeting = "Hi",) //will still work and display the same thing while in the one with automatic appearance of parameters, the order matters. if you don't write it in the right order, it'll bring errors


    //Default Arguments:
    greetPerson2()//Notice that it still works cz there's a default argument passed
    greetPerson2(name = "Maria")//Will display a different name but and default greeting
    greetPerson2(greeting = "Salut", name = "Pierre")//Since there are arguments, default arguments will be ignored


    //How to use a class
    val person = Person("Mukabwa", "Gloria")//You have to create a variable then call it

    //The get and set property:
    //You'll notice that we don't have to use the get and set methods like we do in Java bcz Kotlin allows direct access without the methods
    //If you create a val in your class, it'll have an automatic getter. If you create a var, it'll have both getter and setter
    //However, if you don't want the automatic behaviour of the get or set method in Kotlin, you can define what happens when the methods are called. You'll see this in the Person class
    person.firstName
    person.lastName
    //person.nickName = "Shades" //Before we defined how we want the set method to act, the nickname was just being set. Now that we have told it to produce an output, you can see an output based on the nickname set
    //person.nickName = "New nickname"
    println(person.nickName)

    //Using methods:
    person.printInfo()

}

//Recap: Parameters vs Arguments:
//Parameters: are the named variables listed in the function's definition. They act as placeholders for the values that the function expects to receive when it is called.
//Arguments: are the actual values that are passed to the function when it is called or invoked.
//Parameter - greeting, argument - hello

//Next:Person (Intro to classes)
