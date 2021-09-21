package com.mnp.inspectioncheck.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InspeksiViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is inspeksi Fragment"
    }
    val text: LiveData<String> = _text
}