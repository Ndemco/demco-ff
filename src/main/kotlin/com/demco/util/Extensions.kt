package com.demco.util

import com.demco.core.InvalidIntIdException
import com.demco.core.InvalidUUIDException
import com.demco.core.MissingParameterException
import io.ktor.server.application.ApplicationCall
import org.jetbrains.exposed.dao.UUIDEntity
import java.util.UUID


fun ApplicationCall.getParamOrNull(name: String): String? = parameters[name]

fun ApplicationCall.getParam(name: String): String = getParamOrNull(name) ?: throw MissingParameterException(name)

fun String.toUUIDOrNull() = try {
  UUID.fromString(this)
} catch(e: IllegalArgumentException) {
  null
}

fun String.toUUID(): UUID = try {
  UUID.fromString(this)
} catch(e: IllegalArgumentException) {
  throw InvalidUUIDException()
}

val UUIDEntity.uuid: UUID
  get() = id.value

fun ApplicationCall.getUUIDOrNull(name: String = "uuid"): UUID? = getParamOrNull(name)?.toUUIDOrNull()

fun ApplicationCall.getUUID(name: String = "uuid"): UUID = getUUIDOrNull(name) ?: throw InvalidUUIDException()

fun ApplicationCall.getIntId(name: String = "id"): Int = getParamOrNull(name)?.toInt() ?: throw InvalidIntIdException()