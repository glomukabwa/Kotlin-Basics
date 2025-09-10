//Read this after Object expressions
//COMPANION OBJECTS

/*
class Entity private constructor(val id : String){
    //I've made this private to demonstrate companion objects.
    //Plz note that private class Entity(val id: String) is different from this
    //private class Entity(val id: String) means the class itself is private so cannot be accessed by any other class however we can make instances of the class inside it
    //private class Entity(val id: String) is the same as private class Entity public constructor(val id: String). We just don't write it cz it is the default. The same way we have to write public class... cz the compiler knows its public
    //class Entity private constructor(val id: String) means that the class itself is public but its constructor isn't. This means that you cannot make instances of this class however, this class is public meaning it's visible everywhere
    //The reason we make constructors private is to restrict instantiation. It is used to control object creation (Singleton)
    // The properties(methods and variables) cannot be accessed outside the class.
    // However, with companion object we can:

    companion object Factory{//Anything inside here can now be accessed outside this private class
        //I've labelled this companion object to make it easy to reference

        const val id = "id"
        fun create() = Entity(id)
    }
}


fun main() {
    val entity = Entity.Factory.create()//Before we used companion {val entity = Entity("id)} there was an error but now that we've used companion, there is no issue
    //If you write val entity = Entity.create() it will still be okay. However, in Java, the reference is a must. I am going to include the reference here cz I want my code to be easy to understand. Also, I'll be using Java too so to avoid confusion
    Entity.id // You can also access variables just like you can when it's a public class

    println(entity)
}
*/



//Companion objects with interfaces:
//Just like classes, they can implement interfaces
interface IdProvider{
    fun getId(): String
}

class Entity private constructor(val id : String){

    companion object Factory: IdProvider{

        override fun getId(): String {
            return "123"
        }

        fun create() = Entity(getId())
    }
    //I've tried to use the companion object without the class and it has brought errors
    //However, if you remove the word companion and just call it object Factory, and then remove the words Entity in the main function and every other thing related to the Entity class, the code works the same. I've illustrated this below

}


fun main() {
    val entity = Entity.Factory.getId()
    println(entity)
}




/*
//This is what I've done to use it without a class:
interface IdProvider{
    fun getId(): String
}

    object Factory: IdProvider{

        override fun getId(): String {
            return "123"
        }

        fun create() = getId()
    }


fun main() {
    val entity = Factory.getId()
    println(entity)
}
//ChatGpt explanation of why this is possible without a class(Remember: an object is an instance of a class):
//In Kotlin, the object keyword says:"Create a class definition AND its only instance at the same time."
//Behind the scenes, Kotlin creates a class (let’s call it FactoryClass).
//Then it creates a single instance of that class (Factory) for you automatically.
//You don’t need to call a constructor (new or Factory()) because the instance already exists.

//So apparently this is a Kotlin feature
*/


//Next:Entity Factory2