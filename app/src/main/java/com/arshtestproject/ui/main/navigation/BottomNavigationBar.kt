package com.arshtestproject.ui.main.navigation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arshtestproject.R
import com.arshtestproject.core.models.NavigationItemModel
import com.arshtestproject.theme.Dimens

@Composable
fun BottomNavigationBar(
    navController: NavController,
) {
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    val navigationItems = listOf(
        NavigationItemModel(
            title = stringResource(id = R.string.home),
            icon = R.drawable.home_ic,
            route = ScreenRouteModel.Home.rout
        ),

        NavigationItemModel(
            title = stringResource(id = R.string.orders),
            icon = R.drawable.order_ic,
            route = ScreenRouteModel.Profile.rout
        ),

        NavigationItemModel(
            title = stringResource(id = R.string.message),
            icon = R.drawable.message_ic,
            route = ScreenRouteModel.Cart.rout
        ),

        NavigationItemModel(
            title = stringResource(id = R.string.ewallet),
            icon = R.drawable.wallet_ic,
            route = ScreenRouteModel.Setting.rout
        ),

        NavigationItemModel(
            title = stringResource(id = R.string.profile),
            icon = R.drawable.profile_ic,
            route = ScreenRouteModel.Setting.rout
        )
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp)),
        containerColor = colorResource(id = R.color.white),
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (selectedNavigationIndex.intValue == index)
                            colorResource(id = R.color.Primary_500)
                        else
                            colorResource(id = R.color.Greyscale_500),
                        fontSize = Dimens.Sp10,
                        fontFamily =
                        if (selectedNavigationIndex.intValue == index)
                            FontFamily(Font(resId = R.font.urbanist_bold))
                        else
                            FontFamily(Font(resId = R.font.urbanist_medium))
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.Primary_500),
                    selectedTextColor = colorResource(id = R.color.Primary_500),
                    indicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.white)
                    ),

                )
        }
    }
}