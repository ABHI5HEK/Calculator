package com.example.calculator

class Calculation {

    public fun sum( result: String,inputNumber: String):String{
        var output: String
        output = (result.toDouble() + inputNumber.toDouble()).toString()
        return output
    }
    public fun sub( result: String,inputNumber: String):String{
        var output: String
        output = (result.toDouble() - inputNumber.toDouble()).toString()
        return output
    }
    public fun multiply( result: String,inputNumber: String):String{
        var output: String
        output = (result.toDouble() * inputNumber.toDouble()).toString()
        return output
    }
    public fun divide( result: String,inputNumber: String):String{
        var output: String
        if(inputNumber != null){
            var resultD = result.toDouble()
            var inputNumberD = inputNumber.toDouble()
            if (resultD is Double && inputNumberD is Double){
                if (resultD == 0.0){
                    return "Not Defined"
                }else{
                    output = (resultD/inputNumberD).toString()
                    return output
                }
            }else{
                output = (result.toInt()/inputNumber.toInt()).toString()
                return output
            }
        }else{
            output = "0"
            return output
        }

    }
    public fun percent( result: String,inputNumber: String):String{
        var output: String
        var resultD = result.toDouble()
        var inputNumberD = inputNumber.toDouble()
        if (resultD is Double && inputNumberD is Double){
            if (resultD == 0.0){
                return "0"
            }else{
                output = ((inputNumberD/resultD)*100).toString()
                return output
            }
        }else{
            output = ((result.toInt()/inputNumber.toInt())*100).toString()
            return output
        }

    }
}