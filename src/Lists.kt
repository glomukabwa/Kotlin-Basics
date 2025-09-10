//Read after Arrays
//LISTS

//Creating a function with a list(come to this after going through the first two sections in main)
fun sayHello(greeting:String, peopleToGreet:List<String>){
    peopleToGreet.forEach{ personToGreet ->
        println("$greeting $personToGreet")
    }
}



fun main() {
    //Creating a list
    val interestingThings = listOf("Kotlin", 1 , 3.9999 )
    interestingThings.forEach{ interestingThing ->
        println(interestingThing)
    }

    //Dynamic Lists
    //Collections(arrays,lists,maps) in Kotlin are immutable(you can't add things once created)
    //However, if you want to add things (for lists and maps), you use the word mutable. I'll demonstrate things here and in Maps
    val intThings = mutableListOf("Kdrama", "Novels", 7 , 9.2888) //You must define it as mutable meaning the list can grow
    intThings.add("History")
    intThings.forEach{ intThing ->
        println("I like $intThing")//You'll notice that in the list, History is included cz I added it
    }//I have no idea why val works despite us changing the variable by increasing its values. Maybe increasing doesn't count


    //Using Lists in functions
    val peopleNames = listOf("Anna", "Beniah", "Trixie")
    sayHello(greeting = "Hola", peopleNames) //Note that the list has a different name here
    //OR:
    val peopleToGreet = listOf("Anna", "Beniah", "Trixie")
    sayHello(greeting = "Bonjour", peopleToGreet)//I've tried giving it the same name and it has worked



    //Has other methods that array doesn't. Use knowledge of data structures to know the difference between them

    //Data Structures Recap:
    //Definition:
    //Array: A collection of elements of the same data type, stored in contiguous(neighbouring) memory locations.
    //List: A collection of elements that can be of different data types, stored in a dynamic structure (not necessarily contiguous in memory).

    //Memory allocation:
    //Array: Fixed size (decided at creation). Memory is allocated in one continuous block.
    //List: Dynamic size (can grow or shrink as needed). Memory allocation is more flexible, may be scattered.

    //Performance:
    //Array:
    //Fast access time O(1) because elements are indexed directly in memory.
    //Insertion/deletion is costly (O(n)), especially in the middle, since elements must be shifted.
    //List:
    //Access may be slower (O(n) for linked lists, O(1) for Python lists which are dynamic arrays).
    //Insertion and deletion can be more efficient (especially for linked lists).

    //Data types:
    //Array: Typically stores only one type of data (e.g., integers only).
    //List: Can store mixed data types (e.g., [1, "hello", 3.5]).

    //Flexibility:
    //Array: Less flexible, best for situations where the number of elements is known in advance.
    //List: More flexible, good for cases where the number of elements changes frequently.

    //Summary:
    //Use arrays when you need fixed-size, fast random access, and all elements are of the same type.
    //Use lists when you need flexibility, dynamic resizing, and possibly mixed data types.
}

//Next:Maps