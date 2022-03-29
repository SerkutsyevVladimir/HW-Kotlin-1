package com.example.myapplication8


const val StopAppCommand = "end"
const val Operations = "(?<=[^-+*/={,])[-+*/=]"

fun main() {
    inputFromConsole()

}
    fun inputFromConsole() {
        var parser = Parser()
        while (true) {
            println("Please, enter your expression:")
            val expressionString = readLine()
            if (expressionString != null && expressionString != StopAppCommand) {
                val result = parser.evaluate(expressionString)
              if (result!=null)  {
                  println("Calculations result: $result \nTo end the program, enter word <end>")

              }
            } else {
                println("App Closed")
                break

            }
        }
    }
