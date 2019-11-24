package com.serafimov.composetest

import androidx.compose.Model

@Model
data class Owner(
    val name: String,
    val accountGroups: List<AccountGroup>,
    var state: ExpandableState = ExpandableState.EXPANDED
)

@Model
data class AccountGroup(
    val name: String,
    val accounts: List<Account>,
    var state: ExpandableState = ExpandableState.EXPANDED
)

@Model
data class Account(
    val name: String,
    val accountNumber: String,
    val amount: String,
    val currency: String
)