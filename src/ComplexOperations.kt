//Read HigherOrderFunctions before this

//COMPLEX OPERATIONS
//Here we are going to perform complex operations using few lines of code

fun main() {
    val list = listOf("Kotlin", "Java", "C++", "JavaScript", null, null)

    //Printing only strings that start with J:
    list
        .filterNotNull() //This is there cz the list has null values. If there were no null values, this wouldn't be necessary. This is a safe call.
        .filter{
            it.startsWith("J")
        }
        .forEach{//We need this part to do the actual printing cz the above only filters
        println(it)
    }

    //Changing the type of output produced. In this case, String to int
    list
        .filterNotNull()
        .filter{
            it.startsWith("J")
        }
        .map{//Map allows us to change the type of output returned. In this case, it changes the output from Java and Javascript to the length of this filtered output
            it.length
        }
        .forEach{
            println(it)//The output will be 4 and 10
        }

    //Printing out only the first certain number of items in the list
    list
        .filterNotNull()
        .take(3)//This takes the first 3 items in the list so only those are printed
        .forEach{
            println(it)
        }

    //Printing only the last certain number of items in the list
    list
        .filterNotNull()
        .takeLast(3)
        .forEach{
            println(it) //U'll notice that it skips null. This is bcz we've filtered the null values
        }

    //Mapping a string to its length
    list
        .filterNotNull()
        .associate{ it to it.length}
        .forEach{
            println("${it.value}, ${it.key}") //it.length is the value and it is the key
        }

    //Creating a variable to hold the map instead so that we can perform individual operations instead of iterations
    //All the methods below can be used in iteration and all the methods above can be used individually
    val Map1 = list
        .filterNotNull()
        .associate {it to it.length}

    val language = list.first()
    println(language)//This will print the firts list item which is Kotlin

    val language2 = list.last()
    println(language2)//This prints null

    val language3 = list.filterNotNull().last()//The filterNotNull() removes the null values
    println(language3) //This prints Javascript since we've removed the null values

    val language4 = list.filterNotNull().find { it.startsWith("Java") } //find is used for looking for the first thing given the specification in the curly brackets. Here it will display the first item in the list that starts with Java which is Java
    println(language4)

    val language5 = list.filterNotNull().findLast { it.startsWith("Java") }//findLast looks for the last thing so it will display Javascript
    println(language5)

    //Trying to find sth that isn't there:
    val language6 = list.filterNotNull().findLast { it.startsWith("foo") }
    println(language6) //It will print null since no item in the list starts with null

    //Making it return an empty string (nothing) when an item has not been found:
    val language7 = list.filterNotNull().findLast { it.startsWith( "foo")}.orEmpty() //The orEmpty() ensures that it returns an empty string if nothing is found
    println(language7)
}



//THE END