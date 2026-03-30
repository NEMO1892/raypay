package com.org.design_system.input_field

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.core.design_system.R
import com.org.design_system.spacer.HorizontalSpacer
import com.org.design_system.spacer.VerticalSpacer
import com.org.design_system.theme.RaypayTheme

@Composable
fun AuthInputFiled(
    value: String,
    supportText: String?,
    onValueChanged: (String) -> Unit,
    focusManager: FocusManager,
    focusRequester: FocusRequester,
    title: String? = null,
    placeHolderRes: String? = null,
    isFieldInError: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
    keyboardActions: KeyboardActions = KeyboardActions(
        onNext = { focusManager.moveFocus(FocusDirection.Next) }
    ),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    textStyle: TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        color = Color(0xFFA2A2A2)
    ),
    modifier: Modifier = Modifier,
) {
    Column {
        title?.let {
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color(0xFFA2A2A2),
            )
            VerticalSpacer(8.dp)
        }

        RayPayTextField(
            modifier = modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            value = value,
            onValueChange = { newValue ->
                onValueChanged(newValue)
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            placeHolder = {
                placeHolderRes?.let {
                    Text(
                        text = placeHolderRes,
                        style = TextStyle(
                            fontWeight = FontWeight.W400,
                            fontSize = 14.sp,
                            lineHeight = 16.sp,
                        ),
                        color = Color(0xFF737373)
                    )
                }
            },
            textStyle = textStyle,
            isError = isFieldInError,
            supportingText = {
                if (isFieldInError) {
                    Row(
                        modifier = Modifier.padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.error_filled_24),
                            tint = Color(0xFFC80000),
                            contentDescription = null,
                        )
                        HorizontalSpacer(8.dp)
                        supportText?.let { text ->
                            Text(
                                text = text,
                                style = TextStyle(
                                    fontWeight = FontWeight.W400,
                                    fontSize = 14.sp,
                                    lineHeight = 16.sp,
                                ),
                                color = Color(0xFFC80000)
                            )
                        }
                    }
                }
            },
            readOnly = readOnly,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AuthInputFiledPreview() {
    RaypayTheme {
        AuthInputFiled(
            value = "Login",
            supportText = "password",
            isFieldInError = true,
            onValueChanged = {},
            focusManager = LocalFocusManager.current,
            focusRequester = remember { FocusRequester() }
        )
    }
}
