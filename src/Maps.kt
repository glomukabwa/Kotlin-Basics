//Read after Lists
//MAPS

fun main() {

    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach{ key, value -> println("$key -> $value")} //The 'key' and 'value' are names I've given them but you can give them different names and they will still work. It's kinda like how we called 'it' ,which was the default value, interestingThing in arrays

    //Mutable maps(maps that can grow):
    val map2 = mutableMapOf(101 to "Alice", 102 to "James", 103 to "Theresa")
    map2.put(104, "Brian")//Please note that unlike lists, we use put and be keen about how we use it. It's different from creating a map
    map2.forEach{key, value -> println("The key is $key and the value is $value")}//You'll notice that the map also includes Brian when displayed


    //Data Structures Recap:
    //A map is a data structure (sometimes called a dictionary, hash map, or associative array) that stores data as key–value pairs.
    //Key is the unique identifier of the value
    //Examples:
    //Student_ID → Student_Name
    //101        → "Alice"
    //102        → "Brian"

    //Use Advances DBMS knowledge (hash bucket,etc.) to understand

}

//Next:VarArg