//Read after Functions
//ARRAYS

fun main() {
    val interestingThings =  arrayOf("Kotlin", "Programming", "Comic books")
    println(interestingThings.size)//Prints size of array
    println(interestingThings[0])//Prints the first value of the array
    println(interestingThings.get(0))//Also prints first value of the array


    //Accessing each value of the array
    for (interestingThing in interestingThings){//You've given the name for each value as singular name of array. For each, do the following:
        println(interestingThing)//Will print all values of array
    }
    //OR:
    interestingThings.forEach{
        println(it)//it is the default name of the values of the array. It will do the same thing as the above
    }
    //OR:
    interestingThings.forEach{interestingThing -> //Instead, you give the 'it' a name for easy remembering I guess
        println(interestingThing)
    }


    //Displaying values of an array plus their indexes:
    interestingThings.forEachIndexed {index, interestingThing ->
        println("$interestingThing is at index $index")
    }
}

//Next:Lists