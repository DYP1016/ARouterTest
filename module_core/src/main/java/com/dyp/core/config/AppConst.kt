package com.dyp.core.config

interface AppConst {
    object ID {
        const val ACCOUNT_ID = "account_id"
    }

    interface Router {
        object Main {
            const val NAME = "/main/"
            const val A_MAIN = "${NAME}MainActivity"
            const val S_MAIN = "${NAME}MainService"
        }

        object Account {
            const val NAME = "/account/"
            const val S_ACCOUNT = "${NAME}AccountService"
            const val F_ACCOUNT_INFO = "${NAME}AccountInfo"
        }
    }
}