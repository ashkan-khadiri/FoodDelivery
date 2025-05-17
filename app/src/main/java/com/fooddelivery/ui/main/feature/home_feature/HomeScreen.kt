package com.fooddelivery.ui.main.feature.home_feature

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.arshtestproject.R
import com.fooddelivery.commen.AppConstant
import com.arshtestproject.core.models.CategoryListModel
import com.arshtestproject.core.models.MealListModel
import com.arshtestproject.core.models.MealModel
import com.arshtestproject.presentation.viewmodels.home.HomeViewModel
import com.fooddelivery.theme.Dimens
import com.fooddelivery.ui.component.common_component.SearchComponent
import com.fooddelivery.ui.component.common_item.CategoryItem
import com.fooddelivery.ui.component.common_item.DiscountGuaranteedItem
import com.fooddelivery.ui.component.common_item.RecommendedItem

@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<HomeViewModel>()

    viewModel.getCategoryUseCases()
    viewModel.getFoodByFilter(AppConstant.CHICKEN_CATEGORY)

    val data by viewModel.data.collectAsState()
    val categoryData by viewModel.categoryData.collectAsState()

    var searchValue by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 24.dp)
    ) {
        item {
            HomeHeader()

            SearchComponent(
                modifier = Modifier
                    .padding(top = 24.dp),
                value = searchValue,
                onValueChange = {
                    searchValue = it
                }
            )

            HomeSpecialOffers(
                modifier = Modifier
                    .padding(top = 24.dp)
            )

            HomeCategoryItem(
                modifier = Modifier
                    .padding(top = 24.dp)
            )

            HomeDiscountGuaranteed(
                modifier = Modifier
                    .padding(top = 24.dp),
                data = data ?: MealListModel(emptyList())
            )

            HomeRecommendedForYou(
                modifier = Modifier
                    .padding(top = 24.dp),
                data = categoryData ?: CategoryListModel(emptyList())
            )
        }

        items(data?.meals?.reversed() ?: emptyList()) {
            RecommendedItem(
                mealModel = it
            )
        }
    }
}

@Composable
private fun HomeHeader() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val (userIv, deliverTo, timesSquare, lockIc, aramIc) = createRefs()

        Card(
            modifier = Modifier
                .size(48.dp)
                .padding(2.dp)
                .constrainAs(userIv) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                },
            shape = CircleShape,
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_iv),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Text(
            text = stringResource(id = R.string.deliver_to),
            fontSize = Dimens.Sp16,
            fontFamily = FontFamily(Font(resId = R.font.urbanist_regular)),
            color = colorResource(id = R.color.Greyscale_600),
            modifier = Modifier
                .constrainAs(
                    ref = deliverTo,
                    constrainBlock = {
                        start.linkTo(userIv.end, 16.dp)
                        top.linkTo(userIv.top)
                    }
                )
        )

        Row(
            modifier = Modifier
                .constrainAs(
                    ref = timesSquare,
                    constrainBlock = {
                        top.linkTo(deliverTo.bottom, 6.dp)
                        end.linkTo(aramIc.start, 6.dp)
                        start.linkTo(userIv.end, 16.dp)

                        width = Dimension.fillToConstraints
                    }
                )
        ) {
            Text(
                text = stringResource(id = R.string.times_square),
                fontSize = Dimens.Sp20,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                color = colorResource(id = R.color.Greyscale_900)
            )

            Image(
                painter = painterResource(id = R.drawable.down_ic),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(20.dp)
            )
        }

        Card(
            modifier = Modifier
                .size(48.dp)
                .constrainAs(lockIc) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = colorResource(id = R.color.Greyscale_200)
                    ),
                    shape = CircleShape
                )
                .clip(
                    shape = CircleShape
                )
                .background(
                    color = colorResource(id = R.color.white)
                ),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_lock),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = colorResource(id = R.color.white)
                    )
            )
        }

        Card(
            modifier = Modifier
                .size(48.dp)
                .constrainAs(aramIc) {
                    end.linkTo(lockIc.start, 16.dp)
                    top.linkTo(parent.top)
                }
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = colorResource(id = R.color.Greyscale_200)
                    ),
                    shape = CircleShape
                )
                .clip(
                    shape = CircleShape
                )
                .background(
                    color = colorResource(id = R.color.white)
                ),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_alarm),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = colorResource(id = R.color.white)
                    )
            )
        }
    }
}

@Composable
private fun HomeSpecialOffers(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.special_offers),
                fontSize = Dimens.Sp20,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                color = colorResource(id = R.color.Greyscale_900),
                modifier = Modifier
            )

            Text(
                text = stringResource(id = R.string.see_all),
                fontSize = Dimens.Sp16,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                color = colorResource(id = R.color.Primary_500),
                modifier = Modifier
            )
        }

        Image(
            painter = painterResource(id = R.drawable.special_offers_ic),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .height(181.dp)
        )
    }
}

@Composable
private fun HomeCategoryItem(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hamburger),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Text(
                    text = stringResource(id = R.string.hamburger),
                    fontSize = Dimens.Sp14,
                    fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                    color = colorResource(id = R.color.Greyscale_900),
                    modifier = Modifier
                )
            }

            Column(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pizza),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Text(
                    text = stringResource(id = R.string.pizza),
                    fontSize = Dimens.Sp14,
                    fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                    color = colorResource(id = R.color.Greyscale_900),
                    modifier = Modifier
                )
            }

            Column(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.noodles),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Text(
                    text = stringResource(id = R.string.noodles),
                    fontSize = Dimens.Sp14,
                    fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                    color = colorResource(id = R.color.Greyscale_900),
                    modifier = Modifier
                )
            }

            Column(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.meat),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Text(
                    text = stringResource(id = R.string.meat),
                    fontSize = Dimens.Sp14,
                    fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                    color = colorResource(id = R.color.Greyscale_900),
                    modifier = Modifier
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vegeta),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Text(
                    text = stringResource(id = R.string.vegeta),
                    fontSize = Dimens.Sp14,
                    fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                    color = colorResource(id = R.color.Greyscale_900),
                    modifier = Modifier
                )
            }

            Column(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dessert),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Text(
                    text = stringResource(id = R.string.dessert),
                    fontSize = Dimens.Sp14,
                    fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                    color = colorResource(id = R.color.Greyscale_900),
                    modifier = Modifier
                )
            }

            Column(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.drink),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Text(
                    text = stringResource(id = R.string.drink),
                    fontSize = Dimens.Sp14,
                    fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                    color = colorResource(id = R.color.Greyscale_900),
                    modifier = Modifier
                )
            }

            Column(
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.more),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(
                    modifier = Modifier
                        .height(12.dp)
                )

                Text(
                    text = stringResource(id = R.string.more),
                    fontSize = Dimens.Sp14,
                    fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                    color = colorResource(id = R.color.Greyscale_900),
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
private fun HomeDiscountGuaranteed(
    modifier: Modifier = Modifier,
    data: MealListModel,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.discount_guaranteed),
                fontSize = Dimens.Sp20,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                color = colorResource(id = R.color.Greyscale_900),
                modifier = Modifier
            )

            Text(
                text = stringResource(id = R.string.see_all),
                fontSize = Dimens.Sp16,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                color = colorResource(id = R.color.Primary_500),
                modifier = Modifier
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
        ) {
            items(data.meals) {
                DiscountGuaranteedItem(
                    mealModel = it
                )
            }
        }
    }
}

@Composable
private fun HomeRecommendedForYou(
    modifier: Modifier = Modifier,
    data: CategoryListModel,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.recommended_for_you),
                fontSize = Dimens.Sp20,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                color = colorResource(id = R.color.Greyscale_900),
                modifier = Modifier
            )

            Text(
                text = stringResource(id = R.string.see_all),
                fontSize = Dimens.Sp16,
                fontFamily = FontFamily(Font(resId = R.font.urbanist_bold)),
                color = colorResource(id = R.color.Primary_500),
                modifier = Modifier
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.done_ic),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(79.dp)
                        .height(38.dp)
                )

                Spacer(
                    modifier = Modifier
                        .width(6.dp)
                )
            }
            items(data.categories) {
                CategoryItem(
                    data = it
                )
            }
        }
    }
}