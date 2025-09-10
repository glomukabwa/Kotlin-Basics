//Read after Person

//INTERFACES

/*
interface PersonInfoProvided {
    fun printInfo2(person:Person)//Here you are creating a parameter person which you are telling the computer to treat like a parameter being passed in class Person that we created before. So all the public methods and variables in that class will be applicable here
}

//You can create a class within an interface:
//Explaining abstract classes:
//abstract class BasicInfoProvider : PersonInfoProvided //This class implements interface PersonInfoProvider
//abstract means it does not have to implement all the methods in PersonInfoProvided and that it cannot be instantiated
//If you don't make the class above abstract, there will be an error because it has to then implement all the methods in interface PersonInfoProvider
//fun main() {
    //val provider = BasicInfoProvider()//There is an error here because abstract classes cannot be implemented
//}

class BasicInfoProvider : PersonInfoProvided{
    override fun printInfo2(person: Person) {
        println("basicInfoProvider")
        person.printInfo()//Here, you're calling the method printInfo() from Person class
    }
}

fun main() {
    val provider = BasicInfoProvider()

    provider.printInfo2(Person())
}*/

//In Kotlin, unlike Java, interfaces can define the implementation so instead of creating a class to define the method inside the interface, you can do the following:
interface PersonInfoProvided{
    val providerInfo : String
    fun printInfo2(person:Person){
        println(providerInfo)
        person.printInfo()//Calling this method from class person
    }
}

interface SessionInfoProvider{
    fun getSessionId() : String
}

open class BasicInfoProvider : PersonInfoProvided, SessionInfoProvider{
    //The word open before class means that the class can be extended. If you don't add it, another class cannot extend it
    //So here, we are just going to override the providerInfo. We cannot initialize a variable in an interface, that is why we need to override it here
    override val providerInfo: String
        //Override means the act of a class providing specific implementation to a method inherited from a parent class or an interface
        get() = "basicInfoProvider" //This will work in the same way as initializing it cz this is what will be displayed before the person info

    protected open val sessionIdPrefix = "Session" //Note the 'open'. I've added the protected so that it cannot be accessible to the main class. Open makes it public and to restrict how public it is, you add protected

    //Additionally, this allows you to add text to output. The info below will be displayed after both basicInfoProvider and the person info
    override fun printInfo2(person: Person) {
        super.printInfo2(person)
        println("additional print statement")//This will appear after al the other info
        println("add3")
        println("add4")
    }//I've tried duplicating this second override and it brings an error. If there's any other text you want to add, it has  to be within the curly brackets

    //Implementing the second interface
    override fun getSessionId(): String {
        return "$sessionIdPrefix"
    }
}

fun main() {
    /*val provider = BasicInfoProvider() //I've commented this to illustrate inheritance below


    provider.printInfo2(Person()) //I'm not sure why we need to put Person() inside the brackets but it won't work if you don't put it
    provider.getSessionId()//I do not know why this doesn't return output. He didn't test it on his end. He just said that now we can call the  method getSessionId()

    checkTypes(provider)
    */


    /*
    val provider = FancyInfoProvider() //This is to demonstrate Inheritance (FancyInfoProvider)
    provider.printInfo2(Person())
    provider.getSessionId()
    checkTypes(provider)
    */


    //Read this after Inheritance
    //Object Expressions:
    //They allow us to create class an anonymous interclass so that you don't have to create a new named class to implement an interface
    val provider = object : PersonInfoProvided{ //Here, instead of creating a new class to implement the interface, we are extending the PersonInfoProvided directly. We put object before to mean provider is an object expression. You'll notice that we can also add our own methods that are not in PersonInfo Provided
        override val providerInfo: String
            get() = "New Info Provider"

        fun getSessionId() = "id" //This was not a method in PersonInfoProvided and we've added it
    }

    provider.printInfo2(Person())
    provider.getSessionId()
    //Next: EntityFactory

}

//Type checking and typecasting:
fun checkTypes(infoProvider: PersonInfoProvided){//He said this is creating a parameter of type PersonInfoProvided. This is means that all methods and variables inside the interface are accessible to infoProvider
    if(infoProvider !is SessionInfoProvider){//He said that this checks if infoProvider is also an instance of SessionProvider
        println("not a session info provider")
    }else {
        println("is a session info provider")
        //Typecasting:
        //Typecasting means converting a variable from one data type to another.
        //It tells the compiler: “Treat this value as if it were of another type.”
        //In the example below, we're telling the compiler, treat this parameter like it is of type SessionInfoProvider which means:
        //we want the compiler to give access of methods and variables inside SessionInfoProvider to infoProvider. I'm guessing that sth being an instance of sth doesn't mean that you can access all the methods and variables cz infoProvider is already an instance of SessionInfoProvider if this else statement is executed
        //(infoProvider as SessionInfoProvider).getSessionId()//We cast to access the methods in the interface however this is not necessary since we have already validated that infoProvider is an instance of SessionInfoProvider so instead we use:
        infoProvider.getSessionId()//This is smart casting. You'll notice that infoProvider is highlighted. The computer is doing smart casting which  is accessing the methods and variables of an interface without having to cast each time. We are able to access the method without casting bcz infoProvider is an instance of SessionInfoProvider

    }
}
//What I've understood from this checking method is that you want to see if it is an instance of certain method
//So you create a parameter{infoProvider}. We passed provider in checkTypes as an argument{ checkTypes(provider) }
//provider had used methods printInfo2 and getSessionId therefore it is an instance of both of them that's why the output will be "is a session info provider"





//Recap: Difference between a class, an object and an interface
//A class is a blueprint (template) for creating objects.
//Example:
//class Car(val brand: String, val speed: Int) {
//    fun drive() {
//        println("$brand is driving at $speed km/h")
//    }
//}
//Here, Car is a class that describes what a car looks like (brand, speed) and what it can do (drive).
//
//An object is an instance of a class (a real-world thing created from the class blueprint).
//Example:
//val car1 = Car("Toyota", 120)
//val car2 = Car("BMW", 180)
//car1.drive()
//Each object has its own values for the properties but shares the structure defined by the class.
//
//An interface is like a contract that defines what methods a class should have, but does not provide the full implementation.
//A class can implement multiple interfaces.
//Example:
//interface Drivable {
//    fun drive()
//}
//class Bike : Drivable {
//    override fun drive() {
//        println("Bike is moving 🚴‍♂️")
//    }
//}
//Here:
//Drivable is an interface (just a promise that "drive()" exists).
//Bike implements it, giving its own version of "drive()".
//
//Analogy:
//Class = Recipe for a cake
//Object = The actual cake you baked
//Interface = A contract saying "any dessert must have a sweetTaste() method"



//Next:FancyInfoProvider
