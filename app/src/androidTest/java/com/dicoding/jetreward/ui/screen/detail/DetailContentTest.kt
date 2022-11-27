package com.dicoding.jetreward.ui.screen.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.dicoding.jetreward.R
import com.dicoding.jetreward.model.OrderReward
import com.dicoding.jetreward.model.Reward
import com.dicoding.jetreward.ui.theme.JetRewardTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

class DetailContentTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeOrderReward = OrderReward(
        reward = Reward(4, R.drawable.reward_4, "Jacket Hoodie Dicoding", 7500),
        count = 0,
    )

    @Before
    fun setUp() {
        composeTestRule.setContent {
            JetRewardTheme {
                DetailContent(
                    image = fakeOrderReward.reward.image,
                    title = fakeOrderReward.reward.title,
                    basePoint = fakeOrderReward.reward.requiredPoint,
                    count = fakeOrderReward.count,
                    onBackClick = { },
                    onAddToCart = {},
                )
            }
        }
        composeTestRule.onRoot().printToLog("currentLabelExists")
    }
}