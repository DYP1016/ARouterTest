package com.dyp.common.service

import android.content.Context
import android.util.LruCache
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.SerializationService
import java.lang.reflect.Type
import java.util.*

/**
 * 使用lru cache进行对象传输, 该方式下传输对象本身, 而不是序列化 -> 反序列化得到的新对象
 */
@Route(path = "/root/serialization")
class CacheServiceImpl : SerializationService {
    private val cacheInstance by lazy {
        val maxMemory = Runtime.getRuntime().maxMemory()
        val cacheSize = (maxMemory / 8).toInt()
        LruCache<String, Any>(cacheSize)
    }

    override fun init(context: Context?) {

    }

    override fun <T : Any?> json2Object(input: String?, clazz: Class<T>?): T? =
        parseObject(input, clazz)

    override fun object2Json(instance: Any?): String {
        val uuid = UUID.randomUUID().toString()
        cacheInstance.put(uuid, instance)
//        logI("put: $instance : $uuid")

        return uuid
    }

    override fun <T : Any?> parseObject(input: String?, clazz: Type?): T? {
//        logI("get: $input")

        val obj = cacheInstance.get(input)
        cacheInstance.remove(input)

        return obj as? T
    }
}