package com.demco.core

class InvalidUUIDException : Exception("errors.uuid.invalid")

class InvalidIntIdException : Exception("errors.id.invalid")

class MissingParameterException(name: String) : Exception("errors.parameters.missing.`$name`")

class InvalidCredentialsException : Exception("errors.credentials.invalid")