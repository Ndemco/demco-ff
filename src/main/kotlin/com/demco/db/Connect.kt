package com.demco.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

object Connect {
  private lateinit var dataSource: HikariDataSource

  val db by lazy {
    // TODO: params should be env vars
    dataSource = hikari()
    val db = Database.connect(dataSource)
    val dbUrl = db.url
    println("=======> Connected to DB: $dbUrl")
  }

  private fun hikari(): HikariDataSource {
    val config = HikariConfig("/hikari.properties")
    config.validate()
    return HikariDataSource(config)
  }
}