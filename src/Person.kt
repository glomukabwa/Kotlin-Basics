//Read after NDArg

//CLASSES

//NOTE:I've commented the different classes in order. To understand an aspect of classes, uncomment a class then make sure all the others are comments
//The main method I'm referring to here is in the NARrg file

//How to create parameters and use them inside the class:
/*class Person (_firstName:String, _lastName:String){
    val firstName:String = _firstName //We have to initialize (assigning eg = _firstName) or we will get an error. This is so that we can use the parameters inside the class
    val lastName:String = _lastName

    init{//This is called an init block of code and it is code that is run every time a class is called
    }
}*/
//We can create arguments and then variables to connect the parameters to variables and be able to use them or we can do it like I've done in the class that follows to make it easier:


/*class Person(val firstName:String, val lastName:String){

    //Secondary Constructors:
    init{
        println("init 1")
    }
    //This is called a secondary constructor
    //One of its uses is creating default arguments so that incase nothing is passed in the class Person back in the main function, sth is still displayed
    //Test it by removing the arguments u've assigned to Person in main method and u'll notice that it will still produce an output
    //Note that in the output, init 1 and init 2 is displayed before the output of the constructor. I do not know why but he just highlighted that
    //Secondary constructors are not always necessary because we can always just assign default arguments to the parameters like I've done in the class below
    constructor(): this("Peter", "Parker"){//The 'this' method calls to the primary constructor { Person(val firstName:String, val lastName:String) }
        println("secondary constructor")
    }
    init{
        println("init 2")
    }
}*/

class Person(val firstName:String = "Peter", val lastName:String = "Parker"){

    var nickName: String? = null
        //Defining how you want the set method to act if you don't want the automatic behaviour:
        set(value){
            field = value //He said that field is a special keyword to access the parameter value in set method { set(value)}
            println("the new nickname is $value") //Before we defined how we want the set method to act, the nickname was just being set. Now that we have told it to produce an output, you can see an output based on the nickname set
        }
        //Defining how you want the get method to act if you don't want the automatic behaviour:
        get(){
            println("the returned value is $field")//We've already assigned the value to field in the set method so there's no need for repetition
            return field
            //It'll output the text in println and the value of field below the println text
            //You are probably wondering why we need to learn both methods when we can just use set to output. I think it's cz set is used to assign a new value. Get can't do that
        }

    //Creating methods in classes:
    fun printInfo(){//You create them like you do functions
        //Recap: Difference between functions and methods:
        //Both functions and methods are blocks of code designed to perform specific tasks but their difference is:
        //Functions are independent blocks of code that can be defined and called without being associated with any particular class or object.
        //Methods are functions that are defined within a class and operate on instances (objects) of that class.

        //val nickNameToPrint = if(nickName != null) nickName else "no nickName"
        //OR:
        //Elvis Operator:
        val nickNameToPrint = nickName ?: "no nickname" //We can use the if else like the line above or we can use the elvis operator. It checks whether the first part(nickName) has a value and if it is null, it performs the second part
        println("$firstName ($nickNameToPrint) $lastName")
    }

    //Visibility modifier
    //This means defining access of classes, variables, functions and methods
    //public - accessible by all. Everything is automatically public so you don't have to write it
    //internal - accessible only within the module. It would be accessible in NDArg bcz they are in the same module. I think by module we mean the entire file(Hello Kotlin)
    //private - accessible only within a class
    //protected - accessible to a class and its subclasses
    //Examples:
    //internal class Person...
    //protected var nickName...
    //private fun printInfo...
    //Note that the words can be placed b4 classes, variables, methods and functions

}

//Next PersonInfoProvided