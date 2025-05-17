package com.fooddelivery.ui.component.common_component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.arshtestproject.R
import com.fooddelivery.theme.Dimens

@Composable
fun SearchComponent(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = { newValue ->
            onValueChange.invoke(newValue)
        },
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.search_ic),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(20.dp)
            )

        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.what_are_you_craving),
                fontSize = Dimens.Sp14,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_regular)),
                color = colorResource(id = R.color.Greyscale_400)
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = colorResource(id = R.color.Greyscale_100),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 12.dp),
        singleLine = true,
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(resId = R.font.urbanist_regular)),
            fontSize = Dimens.Sp14,
            color = colorResource(id = R.color.Greyscale_400)
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = colorResource(id = R.color.Greyscale_100),
            unfocusedIndicatorColor = colorResource(id = R.color.Greyscale_100),
            focusedContainerColor = colorResource(id = R.color.Greyscale_100),
            unfocusedContainerColor = colorResource(id = R.color.Greyscale_100)
        )
    )

}