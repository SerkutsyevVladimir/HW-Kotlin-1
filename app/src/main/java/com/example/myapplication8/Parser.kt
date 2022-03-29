package com.example.myapplication8




class Parser {
    fun evaluate(expressionString: String): Number? {
        var expressionString = expressionString.replace(" ", "").trim()
        val parts = expressionString.split(Regex(Operations))
        val leftPartAsString = parts[0]
        val leftAsDouble = leftPartAsString.toDoubleOrNull()
        if (leftAsDouble == null) {
            println("Please enter digits")
            return null
        }
        val leftNumber = Number(leftAsDouble)
        if (parts.size == 1) {
            return leftNumber
        } else {
            val rightPartAsString = parts[1]
            val rightAsDouble = rightPartAsString.toDoubleOrNull()
            if (rightAsDouble == null) {
                println("Please enter digits")
                return null
            }
            val rightNumber = Number(rightAsDouble)
            val regex = Operations.toRegex()
            val operation = regex.find(expressionString)
            when (operation!!.value) {
                "+" -> return leftNumber.add(rightNumber)!!
                "-" -> return leftNumber.sub(rightNumber)!!
                "*" -> return leftNumber.mul(rightNumber)!!
                "/" -> {
                    if (rightNumber.value.toInt() == 0) {
                        println("Error: division by zero")
                        return null
                    } else
                        return leftNumber.div(rightNumber)!!
                }
                else -> {
                    println("Sometning went wrong")
                    return null
                }
            }
        }
    }



}



