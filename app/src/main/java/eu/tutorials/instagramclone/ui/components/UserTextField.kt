package eu.tutorials.instagramclone.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

/**Todo 8: create a reusable composable for the username and password field
 * @param [fieldState] holds the entered value
 * @param onFieldChange keeps track of when the entered value changes
 * @param placeholder holds the fields hint word
 * @param modifier  sets the properties of both element
 * @param passwordToggle changes  the trailing icon
 * @param passwordTransformation sets the password value visibility
 */
@Composable
fun UserTextField(fieldState:String, onFieldChange:(String)->Unit, placeholder:String,
                  modifier: Modifier = Modifier,
                  passwordToggle: @Composable (() -> Unit)? = null,passwordTransformation:VisualTransformation = VisualTransformation.None) {
    /*Todo 9: We add an OutlineTextField with place holder,trailing icon which is st to null by default
    since we only need it for password field, visual transformation which is set
    to None by default so we can ignore it for the user name field
     */
    OutlinedTextField(value = fieldState, onValueChange = {
       onFieldChange(it)
    },placeholder = { Text(text =placeholder) },
        modifier = modifier
            .fillMaxWidth().padding(top = 16.dp),
    trailingIcon = passwordToggle,
    visualTransformation = passwordTransformation)
}