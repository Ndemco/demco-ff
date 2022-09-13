import org.jetbrains.exposed.sql.Database

object DbSettings {
  val db by lazy {
    Database.connect("jdbc:postgres://localhost:5432", driver = "org.postgresql.Driver",
    user = "test", password = "password")
  }
}