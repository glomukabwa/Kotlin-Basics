//Read PersonInfoProvided first
//INHERITANCE
//

//Extending classes:
class FancyInfoProvider : BasicInfoProvider(){ //If you don't add the brackets after the name of the class being extended, it'll give you an error.

    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override val providerInfo: String
        get() = "Fancy Info Provider"

    override fun printInfo2(person: Person) {
        super.printInfo2(person)
        println("Fancy Info") //Run in main to see the difference when val provider = FancyInfoProvider()
    }
}

//Next:Object Expressions in PersonInfoProvided in the main function