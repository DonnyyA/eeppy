package com.doni.eeppy.ui.dataset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DatasetViewModel : ViewModel() {

   private val _text = MutableLiveData<String>().apply {
      value = "This is gallery Fragment"
   }
   val text: LiveData<String> = _text
}