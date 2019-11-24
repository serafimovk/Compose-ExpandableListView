package com.serafimov.composetest

import androidx.compose.Composable
import androidx.compose.Recompose
import androidx.compose.unaryPlus
import androidx.ui.animation.Transition
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeTextStyle
import androidx.ui.text.style.TextOverflow

@Composable
fun AccountItem(account: Account) {
    Surface(color = Color.White) {
        Container(
            height = 70.dp,
            alignment = Alignment.TopCenter,
            padding = EdgeInsets(20.dp, 8.dp, 20.dp, 0.dp)
        ) {
            Column {
                FlexRow(crossAxisAlignment = CrossAxisAlignment.Center) {
                    expanded(1.0f) {
                        Text(account.name, style = +themeTextStyle { h6 })
                    }
                    inflexible {
                        Text(account.amount, style = +themeTextStyle { h6 })
                    }
                }
                HeightSpacer(4.dp)
                FlexRow(crossAxisAlignment = CrossAxisAlignment.Center) {
                    expanded(1.0f) {
                        Text(account.accountNumber, style = +themeTextStyle { subtitle2 })
                    }
                    inflexible {
                        Text(account.currency, style = +themeTextStyle { subtitle2 })
                    }
                }
                Padding(padding = EdgeInsets(20.dp, 8.dp, 0.dp, 0.dp)) {
                    Divider(color = Color(0xffefeff4), height = 1.dp)
                }
            }
        }
    }
}

@Composable
fun AccountGroupTitle(name: String) {
    Surface(color = Color.White) {
        Column {
            Container(
                height = 45.dp,
                expanded = true,
                alignment = Alignment.CenterLeft,
                padding = EdgeInsets(20.dp, 14.dp, 20.dp, 14.dp)
            ) {
                Text(
                    name,
                    style = +themeTextStyle { subtitle1 },
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Padding(padding = EdgeInsets(20.dp, 0.dp, 0.dp, 0.dp)) {
                Divider(color = Color(0xffefeff4), height = 1.dp)
            }
        }
    }
}

@Composable
fun AccountGroup(accountGroup: AccountGroup) {
    Column {
        Clickable(onClick = {
            accountGroup.state = ExpandableState.toggleState(accountGroup.state)
        }) {
            AccountGroupTitle(name = accountGroup.name)
        }
        Recompose {
            Transition(definition = definition, toState = accountGroup.state) { state ->
                Container(
                    alignment = Alignment.TopCenter,
                    height = 70.dp * accountGroup.accounts.size * state[y]
                ) {
                    Surface(color = Color.White) {
                        Column {
                            accountGroup.accounts.forEach { account ->
                                AccountItem(account = account)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AccountOwner(owner: Owner) {
    Column {
        Clickable(onClick = { owner.state = ExpandableState.toggleState(owner.state) }) {
            AccountOwnerTitle(name = owner.name)
        }
        Recompose {
            Transition(definition = definition, toState = owner.state) { state ->
                Container(
                    expanded = false,
                    alignment = Alignment.TopCenter,
                    height = getOwnerItemsHeight(owner) * state[y]
                ) {
                    Surface(color = Color.White) {
                        Column {
                            owner.accountGroups.forEach { accountGroup ->
                                AccountGroup(accountGroup = accountGroup)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AccountOwnerTitle(name: String) {
    Surface(color = Color(0xffefeff4)) {
        Container(
            expanded = true,
            alignment = Alignment.CenterLeft,
            padding = EdgeInsets(20.dp, 14.dp, 20.dp, 14.dp)
        ) {
            Text(
                name,
                style = +themeTextStyle { subtitle1 },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun AccountOwnersList(owners: List<Owner>) {
    Container(alignment = Alignment.TopCenter) {
        VerticalScroller {
            Column {
                owners.forEach { owner ->
                    AccountOwner(owner)
                }
            }
        }
    }
}

private fun getOwnerItemsHeight(owner: Owner): Dp {
    var height = 0.dp
    owner.accountGroups.forEach { accountGroup ->
        height += 45.dp + accountGroup.accounts.size * 70.dp
    }
    return height
}