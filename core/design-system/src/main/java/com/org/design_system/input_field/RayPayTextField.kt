package com.org.design_system.input_field

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.core.design_system.R
import com.org.design_system.theme.RaypayTheme

@Composable
fun RayPayTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    cursorAlwaysAtTheEnd: Boolean = false,
    focusedBorderColor: Color = Color(0xff343434),
    unfocusedBorderColor: Color = Color(0xff343434),
    errorBorderColor: Color = Color(0xFFC80000),
    errorLabelColor: Color = Color(0xFFC80000),
    errorTrailingIconColor: Color = Color(0xFFD4D4D4),
    focusedContainerColor: Color = Color(0xff070707),
    unfocusedContainerColor: Color = Color(0xff070707),
    disabledContainerColor: Color = Color(0xff070707),
    textStyle: TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    ),
    shape: Shape = RoundedCornerShape(20.dp),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    label: @Composable (() -> Unit)? = null,
    placeHolder: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource? = null,
    onValueChange: (String) -> Unit,
) {
    if (cursorAlwaysAtTheEnd) {
        OutlinedTextField(
            value = TextFieldValue(text = value, selection = TextRange(value.length)),
            onValueChange = { onValueChange(it.text) },
            modifier = modifier,
            enabled = enabled,
            readOnly = readOnly,
            singleLine = singleLine,
            textStyle = textStyle,
            placeholder = placeHolder,
            label = label,
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon,
            supportingText = supportingText,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = focusedBorderColor,
                focusedLabelColor = focusedBorderColor,
                unfocusedLabelColor = unfocusedBorderColor,
                unfocusedBorderColor = unfocusedBorderColor,
                errorLabelColor = errorLabelColor,
                errorBorderColor = errorBorderColor,
                errorTrailingIconColor = errorTrailingIconColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedContainerColor = unfocusedContainerColor,
                disabledContainerColor = disabledContainerColor
            ),
            shape = shape,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            isError = isError,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource
        )
    } else {
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = modifier,
            enabled = enabled,
            readOnly = readOnly,
            singleLine = singleLine,
            textStyle = textStyle,
            placeholder = placeHolder,
            label = label,
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon,
            supportingText = supportingText,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = focusedBorderColor,
                disabledBorderColor = unfocusedBorderColor,
                focusedLabelColor = focusedBorderColor,
                unfocusedBorderColor = unfocusedBorderColor,
                unfocusedLabelColor = unfocusedBorderColor,
                errorLabelColor = errorLabelColor,
                errorBorderColor = errorBorderColor,
                errorTrailingIconColor = errorTrailingIconColor,
                focusedContainerColor = focusedContainerColor,
                unfocusedContainerColor = unfocusedContainerColor,
                disabledContainerColor = disabledContainerColor
            ),
            shape = shape,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            isError = isError,
            visualTransformation = visualTransformation,
            interactionSource = interactionSource
        )
    }
}

@Preview(showBackground = true,)
@Composable
fun RayPayTextFieldPreview() {
    RaypayTheme {
        RayPayTextField(
            value = "Hello",
            onValueChange = {},
            placeHolder = { Text("Placeholder") },
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable(onClick = {}),
                    painter = painterResource(R.drawable.error_filled_24),
                    tint = Color.Red,
                    contentDescription = null,
                )
            }
        )
    }
}
