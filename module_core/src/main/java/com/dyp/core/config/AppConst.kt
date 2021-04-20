package com.dyp.core.config

interface AppConst {

    interface Router {
        object Main {
            const val NAME = "/main/"
            const val A_MAIN = "${NAME}MainActivity"
            const val S_MAIN = "${NAME}MainService"
        }

        object Account {
            const val NAME = "/account/"
        }
    }
}