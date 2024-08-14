package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//Create a form to validate a PAN card number with an input box and a submit button. Upon clicking submit, validation should occur through the ViewModel, displaying an appropriate toast message.
//
//
//
//PAN Card Validation Criteria:
//Length: The PAN card number must be exactly ten characters long.
//Format:
//First Five Characters: Must be uppercase alphabets (A-Z).
//Next Four Characters: Must be digits (0-9).
//Last (Tenth) Character: Must be an uppercase alphabet (A-Z).
//No Whitespaces: The PAN card number should not contain any white spaces.
//has context menu

class PanCardViewModel : ViewModel() {


    fun validatePanCard(panCard: String, onValidationResult: (Boolean, String) -> Unit) {

        viewModelScope.launch {
            val isValid = validatePanCardNumber(panCard)
            val message = if (isValid) "Valid PAN Card" else "Invalid PAN Card Number"
            onValidationResult(isValid, message)
        }
    }

    private fun validatePanCardNumber(panCard: String): Boolean {
        val panCardRegex = "^[A-Z]{5}[0-9]{4}[A-Z]$".toRegex()
        return panCard.matches(panCardRegex)
    }






}