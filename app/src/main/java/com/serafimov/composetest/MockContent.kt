package com.serafimov.composetest

fun getMockContent(): List<Owner> {
    return listOf(
        Owner(
            "LENZ SVEN", listOf(
                AccountGroup(
                    "SAVINGS", listOf(
                        Account("Savings account", "500.248.010", "-17'815.63", "")
                    )
                ),
                AccountGroup(
                    "PAYMENT", listOf(
                        Account("Current account", "500.248.303 (Ausbildung)", "160'473.14", ""),
                        Account("Current account", "500.248.311", "62'288.15", ""),
                        Account("Fremdwährungskonto", "500.248.320", "544'157.09", "EUR"),
                        Account("Fremdwährungskonto", "500.248.338", "105'264.93", "USD")
                    )
                ),
                AccountGroup(
                    "TOTAL INTEREST, SAVINGS/INVESTMENT OBLIGATIONS", listOf(
                        Account("Safekeeping account", "500.248.702", "96'366.22", ""),
                        Account("Safekeeping account", "500.248.710", "227'295.25", "")
                    )
                )
            )
        )//,
//        Owner(
//            "BACMAIER JOSEF", listOf(
//                AccountGroup(
//                    "PAYMENT", listOf(
//                        Account("Current account", "503.039.0913 (Privat)", "-451'829.51", "")
//                    )
//                )
//            )
//        ),
//        Owner(
//            "GRIMM JULIA", listOf(
//                AccountGroup(
//                    "PAYMENT", listOf(
//                        Account("Current account", "503.037.1920 (Ausbildung)", "10'432.40", "")
//                    )
//                ),
//                AccountGroup(
//                    "TOTAL INTEREST, SAVINGS/INVESTMENT OBLIGATIONS", listOf(
//                        Account("Safekeeping account", "500.303.7500 (Privat)", "7'974.08", "")
//                    )
//                )
//            )
//        )
    )
}