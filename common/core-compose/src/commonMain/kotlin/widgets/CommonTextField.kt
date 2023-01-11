package widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import theme.AppTheme

@Composable
fun CommonTextField(
    value: String,
    placeholder: String,
    isSending: Boolean = false,
    isTextHidden: Boolean = false,
    trailingIcon: @Composable() (() -> kotlin.Unit),
    onValueChanged: (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        value = value,
        enabled = !isSending,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = AppTheme.colors.systemBackgroundSecondary,
            textColor = AppTheme.colors.systemTextPrimary,
            cursorColor = AppTheme.colors.controlTextBlue,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = if (isTextHidden) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        trailingIcon = {
            trailingIcon
        },
        placeholder = { Text(placeholder, color = AppTheme.colors.systemTextTertiary) },
        shape = RoundedCornerShape(10.dp),
        onValueChange = {
            onValueChanged.invoke(it)
        }
    )
}

@Composable
fun SSTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: androidx.compose.ui.Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    textStyle: androidx.compose.ui.text.TextStyle,
    label: @Composable() (() -> Unit)?,
    placeholder: @Composable() (() -> Unit)?,
    leadingIcon: @Composable() (() -> Unit)?,
    trailingIcon: @Composable() (() -> Unit)?,
    isError: Boolean,
    visualTransformation: androidx.compose.ui.text.input.VisualTransformation,
    keyboardOptions: androidx.compose.foundation.text.KeyboardOptions,
    keyboardActions: androidx.compose.foundation.text.KeyboardActions,
    singleLine: Boolean,
    maxLines: Int,
    interactionSource: androidx.compose.foundation.interaction.MutableInteractionSource,
    shape: Shape,
    colors: androidx.compose.material.TextFieldColors
){ /* compiled code */ }
