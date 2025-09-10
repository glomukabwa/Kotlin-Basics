import java.util.*

//Read Entity Factory before this
//OBJECT DECLARATION, ENUM CLASSES, SEALED CLASSES

/*
//Object Declaration:
//The section below is completely self-explanatory
class Entity2 (val id : String, val name: String){
    override fun toString(): String {//toString is a built-in function
        return "id:$id name:$name"
    }
}

object EntityFactory{
    fun create() = Entity2("id", "name")
}

fun main() {
    val entity = EntityFactory.create()
    println(entity)
}
*/



/*
//Enum Classes:
//Classes that allow us to pass different types of data and to specify what we want to happen depending on the different types
class Entity2 (val id : String, val name: String){
    override fun toString(): String {//toString is a built-in function
        return "id:$id name:$name"
    }
}//If you comment this class, an error occurs. Because the object is extending this class

/*
//Creating the enum class:
enum class EntityType{
    EASY,  MEDIUM, HARD
}

object EntityFactory{
    //Using the Enum class:
    fun create(type: EntityType) : Entity2{//You have to pass the type specifying the enum class in the method you are creating
        val id = UUID.randomUUID().toString() //This is not part of enum classes. It is used to generate a random ID. The toString converts whatever number is generated to the type String
        //Now we're back to using the enum class. Here we are mapping the types to their respective values
        val name = when(type){
            EntityType.EASY -> "Easy"
            EntityType.MEDIUM -> "Medium"
            EntityType.HARD  -> "Hard"
        }
        return Entity2(id, name)
    }
}
*/

//An improved use of the enum class:
enum class EntityType{
    EASY,  MEDIUM, HARD; //I've added a semicolon here. Idk why we have to

    fun getFormattedName() = name.toLowerCase().capitalize() //I've created this function to turn the letters to small letters and make the first letter capital
    //name means the name of the different types eg EASY
    //toLowerCase() is an inbuilt function that converts letters to lowercase
    //capitalize() is also inbuilt and converts the first letter of a word to uppercase
    //We're doing this to avoid having to manually map the types to their values in the object below
}

object EntityFactory{
    fun create(type: EntityType) : Entity2{
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> type.getFormattedName()
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD  -> type.name //I've used name here to demonstrate that the output will just be the name of the type
        }
        return Entity2(id, name)
    }
}


fun main() {
    //Creating instances that will provide output depending on the type
    val entity = EntityFactory.create(EntityType.EASY)
    println(entity)

    val entity2 = EntityFactory.create(EntityType.MEDIUM)
    println(entity2)

    val entity3 = EntityFactory.create(EntityType.HARD)
    println(entity3)
}
*/



//Sealed Classes
//A sealed class in Kotlin is a class that restricts which classes can inherit from it.
//Only classes declared in the same file can extend a sealed class.
//This makes the type hierarchy closed: the compiler knows all possible subclasses.

//Sealed classes vs private classes:
//sealed class:
//Controls who can subclass it.
//Subclasses must be in the same file.
//Class itself can still be public (by default), so you can use its type outside the file.
//private class
//Controls where the class can be seen/used.
//A private class can only be accessed within the same Kotlin file where it is declared.
//Outside the file, it’s completely invisible.
//So: visibility restricted, but subclassing is still possible (within the file).
//Basically, for both, subclasses can only extend with the file but for different reasons. Private bcz the classes outside can't se it and sealed bcz it prevents from seeing
//However, for sealed, unlike private class, you can still use Result in other files (for variables, function parameters, etc.). You just can’t extend it outside its file.
sealed class Entity2 (){
    object Help : Entity2(){ //For some reason, if u remove the : Entity2() it brings an error
        val name = "Help"
    }

    //Data classes
    //A data class, in the context of programming languages like Python or Kotlin, is a specialized type of class primarily designed to hold data. Check solitary use in main class under the title data class
    data class Easy(val id:String, val name: String) : Entity2()
    data class  Medium(val id:String, val name: String) : Entity2()
    data class Hard(val id:String, val name: String, val multiplier: Float) : Entity2()//Notice that this one has id, name and multiplier unlike the others which don't have multiplier. Sealed classes allow difference of properties.
}

enum class EntityType{
    HELP, EASY,  MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object EntityFactory{
    fun create(type: EntityType) : Entity2{
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> type.getFormattedName()
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD  -> type.getFormattedName()
            EntityType.HELP -> type.getFormattedName()
        }
        //return Entity2(id, name) //I've commented this cz it brings an error. He's said that it is because sealed classes cannot be instantiated directly. Instead, we'll do this:
        return when (type) {
            EntityType.EASY -> Entity2.Easy(id, name)
            EntityType.MEDIUM -> Entity2.Medium(id, name)
            EntityType.HARD -> Entity2.Hard(id, name, 2f)
            EntityType.HELP -> Entity2.Help
        }
    }
}

//Extension Functions/Methods:
fun Entity2.Medium.printInfo(){//This is creating a function by extending a class. Here we are creating a function for data class Medium
    println("Medium class: $id")
}

//Extension properties:
val Entity2.Medium.info: String
    get() = "some info"

fun main() {

    /*
    val entity : Entity2 = EntityFactory.create(EntityType.EASY)
    val msg = when (entity){
        Entity2.Help -> "help class"
        is Entity2.Easy -> "easy class"
        is Entity2.Medium -> "medium class"
        is Entity2.Hard -> "hard class"
    }

    print(msg)*/


    /*
    //Data Classes
    //val entity1 = EntityFactory.create(EntityType.EASY)
    //val entity2 = EntityFactory.create(EntityType.EASY)//It will print they are NOT equal bcz the ids of the entities are different

    //val entity1 = Entity2.Easy("id","name")
    //val entity2 = Entity2.Easy("id","name")//It will print they are equal bcz the ids and names of the entities are different
    //OR:
    //val entity1 = Entity2.Easy("id","name")
    //val entity2 = entity1.copy()//This is an easier way of writing that they are equal to the same values
    //You can also just copy one value:
    val entity1 = Entity2.Easy("id","name")
    val entity2 = entity1.copy(name="new name")//Here, only id has been copied. Name is the value assigned within the brackets. It will display NOT equal

    if (entity1 == entity2){
        println("they are equal")
    } else {
        println("they are NOT equal")
    }

    //Three equal signs:
    val entity3 = Entity2.Easy("id","name")
    val entity4 = entity3.copy()//Here it will display not equal even though the data is the same bcz they have different names(entity3 and entity4)

    if (entity3 === entity4){ //The third equal is for references (entity3 and entity4)
        println("they are equal")
    } else {
        println("they are NOT equal")
    }



    val entity5 = Entity2.Easy("id","name")
    val entity6 = entity5.copy()

    if (entity5 === entity5){ //This will display equal because the both references and the data are similar
        println("they are equal")
    } else {
        println("they are NOT equal")
    }*/


    //Extension  Functions/Methods:
    val entity1 = Entity2.Easy("id","name")
    val entity2 = EntityFactory.create(EntityType.MEDIUM)
    if (entity2 is Entity2.Medium) {
        entity2.printInfo()
        //Extension properties:
        entity2.info
    }

}


//Next: HigherOrderFunctions