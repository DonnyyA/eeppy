package com.doni.eeppy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.tensorflow.lite.Interpreter

class HomeViewModel : ViewModel() {
   private val _result = MutableLiveData<String>()

   val result: LiveData<String> = _result

   fun doInference(inputs: Array<Float>, interpreter: Interpreter){
      val input = FloatArray(18)
      if (!inputs.contentEquals(Array(18){""})){
         for (i in 0..17) {
            input[i] = inputs[i]
         }
         val output = Array(1) { FloatArray(1) }
         interpreter.run(input, output)
         _result.value = output[0][0].toString()
      }
   }
}