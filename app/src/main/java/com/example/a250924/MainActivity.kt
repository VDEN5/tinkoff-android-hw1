package com.example.a250924
interface Animal {
    val weight: Double
    val age: Int
}

interface Dog : Animal {
    val biteType: BiteType
}

interface Cat : Animal {
    val behaviorType: BehaviorType
}

enum class BiteType {
    STRAIGHT, OVERBITE, UNDERBITE
}

enum class BehaviorType {
    ACTIVE, PASSIVE
}

class Husky(override val weight: Double, override val age: Int) : Dog {
    override val biteType = BiteType.STRAIGHT
}

class Corgi(override val weight: Double, override val age: Int) : Dog {
    override val biteType = BiteType.UNDERBITE
}

class ScottishCat(override val weight: Double, override val age: Int) : Cat {
    override val behaviorType = BehaviorType.PASSIVE
}

class SiameseCat(override val weight: Double, override val age: Int) : Cat {
    override val behaviorType = BehaviorType.ACTIVE
}

class PetStore {
    fun identifyAnimal(breed: String): String {
        return when (breed.lowercase()) {
            "husky" -> "Это собака"
            "corgi" -> "Это собака"
            "scottish cat" -> "Это кот"
            "siamese cat"  -> "Это кот"
            else -> "не собака и не кот"
        }
    }
}

fun main() {
    val petStore = PetStore()

    println(petStore.identifyAnimal("Husky"))
    println(petStore.identifyAnimal("Corgi"))
    println(petStore.identifyAnimal("Scottish Cat"))
    println(petStore.identifyAnimal("Siamese Cat"))
    println(petStore.identifyAnimal("Dog"))
}
