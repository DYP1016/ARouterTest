package com.dyp.common.base

import com.quvii.qvlib.util.LogUtil

/**
 * 公共工具方法
 */

fun Int.retSuccess(): Boolean {
    return this == 0
}

fun logD(info: String, tag: String = generateTag(getCallerStackTraceElement())) {
    LogUtil.d(tag, info)
}

fun logI(info: String, tag: String = generateTag(getCallerStackTraceElement())) {
    LogUtil.i(tag, info)
}

fun logE(info: String, tag: String = generateTag(getCallerStackTraceElement())) {
    LogUtil.e(tag, info)
}

fun logE(throwable: Throwable) {
    for (element in throwable.stackTrace) {
        logE("Error", element.toString())
    }
}

fun logTrace(info: String = "") {
    val stack = Thread.currentThread().stackTrace
    for (i in stack.indices) {
        if (i < 4) {
            continue
        }
        val fullClassName = stack[i].className
        val className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1)
        logI(
                "Qv_trace $info",
                fullClassName + ":" + stack[i].methodName + "(" + className + ".java:" + stack[i].lineNumber + ")"
        )
    }
}

fun getCallerStackTraceElement(): StackTraceElement {
    return Thread.currentThread().stackTrace[4]
}

private fun generateTag(caller: StackTraceElement): String {
    var tag = "%s.%s(L:%d)"
    var callerClazzName = caller.className
    callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1)
    tag = String.format(tag, callerClazzName, caller.methodName, caller.lineNumber)
    return tag
}