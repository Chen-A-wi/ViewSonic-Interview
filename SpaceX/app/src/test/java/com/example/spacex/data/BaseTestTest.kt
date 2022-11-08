package com.example.spacex.data

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.json.JSONObject
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.lang.reflect.Type

internal class BaseTestTest {
    private var jsonObjWithString = ""
    private var jsonObjWithList = ""
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    @BeforeEach
    fun setUp() {
        initJsonStringData()

    }

    private fun initJsonStringData() {
        val jsonObj = JSONObject()

        jsonObj.put("dataType", "data_string")
        jsonObj.put("data", "dataTest")

        jsonObjWithString = jsonObj.toString()
    }

    @Test
    fun stringTest() {
        val parameterizedType = Types.newParameterizedType(BaseTest::class.java, String::class.java)
        val jsonAdapter = moshi.adapter<BaseTest<String>>(parameterizedType)
        val fromJson = jsonAdapter.fromJson(jsonObjWithString)

        println("================= $fromJson")
    }

    @Test
    fun typeTest() {
        val moshi = Moshi.Builder()
            .add(DataAdapter())
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val parameterizedType = Types.newParameterizedType(BaseTest::class.java, Any::class.java)
        val jsonAdapter = moshi.adapter<BaseTest<*>>(parameterizedType)
        val fromJson = jsonAdapter.fromJson(jsonObjWithString)

        val data = fromJson?.data as String

        println("================= $data")
    }
}