package com.mywebsite.hotel.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mywebsite.hotel.R
import androidx.compose.material3.OutlinedTextFieldDefaults
import com.mywebsite.hotel.helpers.MaskVisualTransformation
import com.mywebsite.hotel.ui.components.NumberDefaults.INPUT_LENGTH
import com.mywebsite.hotel.ui.components.NumberDefaults.MASK

@Composable
fun TextFieldSimple(labelText: String,
                    value: String,
                    onValueChanged: (String) -> Unit = {},
                    modifier: Modifier = Modifier.fillMaxWidth()
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = {
            Text(
                text = labelText,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.grey_text_light)
                )
            )
        }, modifier = modifier
    )
}

object NumberDefaults {
    const val MASK = "+7 (###) ###-##-##"
    const val INPUT_LENGTH = 10 // Equals to "#####-###".count { it == '#' }
}
@Composable
fun TextFieldPhone(
    mValue: String,
    mOnValueChanged: (String) -> Unit,
    mFocusRequester: FocusRequester,
    mKeyboardActions: KeyboardActions,
    mIsError: Boolean

) {
    val requiredField = stringResource(R.string.booking_required_field)
    val requiredFieldDescr = stringResource(R.string.booking_provide_valid_phone)

    OutlinedTextField(
        label = {
            Text(
                text = stringResource(R.string.booking_phone),
                style = TextStyle(
                    color = colorResource(R.color.grey_text_light)
                )
            )
        },
        singleLine = true,
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(mFocusRequester),
        value = mValue,
        onValueChange = { it ->
            if (it.length <= INPUT_LENGTH) {
                mOnValueChanged(it.filter { it.isDigit() })
            }
                        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
        keyboardActions = mKeyboardActions,
        visualTransformation = MaskVisualTransformation(MASK),
        isError = mIsError,
        supportingText = {
            if (mIsError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = if (mValue.isEmpty()) requiredField else requiredFieldDescr,
                    color = MaterialTheme.colorScheme.error
                )
            }
        },
        trailingIcon = {
            if (mIsError)
                Icon(painterResource(R.drawable.ic_common_error), null, tint = MaterialTheme.colorScheme.error)
        }
    )
}

@Composable
fun TextFieldEmail(
    mValue: String,
    mOnValueChanged: (String) -> Unit,
    mFocusRequester: FocusRequester,
    mKeyboardActions: KeyboardActions,
    mIsError: Boolean

) {
    val requiredField = stringResource(R.string.booking_required_field)
    val requiredFieldDescr = stringResource(R.string.booking_provide_valid_email)

    OutlinedTextField(
        label = {
            Text(
                text = stringResource(R.string.booking_email),
                style = TextStyle(
                    color = colorResource(R.color.grey_text_light)
                )
            )
        },
        singleLine = true,
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(mFocusRequester),
        value = mValue,
        onValueChange = mOnValueChanged,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
        keyboardActions = mKeyboardActions,
        isError = mIsError,
        supportingText = {
            if (mIsError) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = if (mValue.isEmpty()) requiredField else requiredFieldDescr,
                    color = MaterialTheme.colorScheme.error
                )
            }
        },
        trailingIcon = {
            if (mIsError)
                Icon(painterResource(R.drawable.ic_common_error), null, tint = MaterialTheme.colorScheme.error)
        }
    )
}