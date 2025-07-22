package me.abdullokhonz.kotlin


import kotlin.random.Random
import kotlin.math.PI


fun test() {
    val msg: String = "Hello, world!"
    println(msg)
}

fun firstPractice() {
    val name = "Mary"
    val age = 20
    println("$name is $age years old")
}

fun secondPractice() {
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000_000
    val e: Boolean = false
    val f: Char = '\n'
}

fun thirdPractice() {
    // Exercise 1
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    val totalCount = greenNumbers.count() + redNumbers.count()
    println(totalCount)

    // Exercise 2
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")

    // Exercise 3
    val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
    val n = 2
    println("$n is spelt as '${number2word[2]}'")
}

fun fourthPractice() {
    // Exercise 1
    val firstResult = Random.nextInt(6)
    val secondResult = Random.nextInt(6)
    println(
        if (firstResult == secondResult)
            "You win :) ($firstResult == $secondResult)"
        else
            "You lose :( ($firstResult != $secondResult)"
    )

    // Exercise 2
    val list: List<String> = listOf("A", "B", "X", "Y", "Other")
    val button = list.random()

    println(
        when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> "There is no such button"
        }
    )
}

fun fifthPractice() {
    // Exercise 1
    var pizzaSlices = 0

    while (pizzaSlices < 7) {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    }

    do {
        pizzaSlices++
        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    } while (pizzaSlices > 8)

    // Exercise 2
    for (number in 1..100) {
        println(
            when {
                number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
                else -> "$number"
            }
        )
    }

    // Exercise 3
    val words = listOf("dinosaur", "limousine", "magazine", "language")

//    for (word in words) {
//        for (letter in word) {
//            if (letter == 'l') {
//                println(word)
//                continue
//            }
//            else {
//                break
//            }
//        }
//    }

    for (word in words) {
        if (word.startsWith("l"))
            println(word)
    }
}

fun sixthPractice() {
    // Exercise 1
    fun circleArea1(radius: Int): Double {
        return PI * radius * radius
    }
    println(circleArea1(2))

    // Exercise 2
    fun circleArea2(radius: Int): Double = PI * radius * radius
    println(circleArea2(2))

    // Exercise 3
    fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) =
        ((hours * 60) + minutes) * 60 + seconds

    println(intervalInSeconds(1, 20, 15))
    println(intervalInSeconds(0, 1, 25))
    println(intervalInSeconds(2, 0, 0))
    println(intervalInSeconds(0, 10, 0))
    println(intervalInSeconds(1, 0, 1))
}

fun seventhPractice() {
    // Exercise 1
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5
    val urls = actions.map { action -> "$prefix/$id/$action" }
    println(urls)

    // Exercise 2
    fun repeatN(n: Int, action: () -> Unit) {
        for (i in 1..n) {
            action()
        }
    }

    repeatN(5) {
        println("Hello")
    }
}

fun eighthPractice() {
    // Exercise 1
    data class Employee(val name: String, var salary: Int)

    fun exercise1() {
        val emp = Employee("Mary", 20)
        println(emp)
        emp.salary += 10
        println(emp)
    }

    exercise1()

    // Exercise 2
    data class Name(val first: String, val last: String)
    data class City(val name: String, val countryCode: String)
    data class Address(val street: String, val city: City)
    data class Person(val name: Name, val address: Address, val ownsAPet: Boolean = true)

    fun exercise2() {
        val person = Person(
            Name("John", "Smith"),
            Address("123 Fake Street", City("Springfield", "US")),
            ownsAPet = false
        )

        println(person)
    }

    exercise2()

    // Exercise 3
    class RandomEmployeeGenerator(var minSalary: Int = 100, var maxSalary: Int = 1000) {
        val names: List<String> = listOf(
            "Mary",
            "Jane",
            "Alex",
            "John",
            "Ann",
            "Paul",
            "Jack",
            "Elizabeth"
        )

        fun generateEmployee(): Employee {
            val randName: String = names.random()
            val randSalary: Int = Random.nextInt(minSalary, maxSalary)
            val emp = Employee(randName, randSalary)

            return emp
        }
    }

    fun exercise3() {
        val empGen = RandomEmployeeGenerator()
        println(empGen.generateEmployee())
        println(empGen.generateEmployee())
        empGen.minSalary = 10
        empGen.maxSalary = 30
        println(empGen.generateEmployee())
        println(empGen.generateEmployee())
        empGen.minSalary = 50
        empGen.maxSalary = 100
        println(empGen.generateEmployee())
        println(empGen.generateEmployee())
    }

    exercise3()
}

fun ninthPractice() {
    // Exercise 1
    data class Employee(val name: String, var salary: Int)

    fun employeeById(id: Int) = when(id) {
        1 -> Employee("Mary", 20)
        2 -> null
        3 -> Employee("John", 21)
        4 -> Employee("Ann", 23)
        else -> null
    }

    fun salaryById(id: Int) = employeeById(id)?.salary ?: 0

    fun exercise() {
        println((1..5).sumOf { id -> salaryById(id) })
    }

    exercise()
}

