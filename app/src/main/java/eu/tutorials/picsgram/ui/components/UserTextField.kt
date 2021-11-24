package eu.tutorials.picsgram.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun UserTextField(fieldState:String, onFieldChange:(String)->Unit, placeholder:String,
                  modifier: Modifier = Modifier,
                  passwordToggle: @Composable (() -> Unit)? = null,passwordTransformation:VisualTransformation = VisualTransformation.None) {
    OutlinedTextField(value = fieldState, onValueChange = {
       onFieldChange(it)
    },placeholder = { Text(text =placeholder) },
        modifier = modifier
            .fillMaxWidth().padding(top = 16.dp),
    trailingIcon = passwordToggle,
    visualTransformation = passwordTransformation)
}