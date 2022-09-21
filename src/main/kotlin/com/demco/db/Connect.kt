import org.jetbrains.exposed.sql.Database

object Connect {
  val db by lazy {
    Database.connect("jdbc:postgres://localhost:5432/demco-ff", driver = "org.postgresql.Driver",
    user = "test", password = "password")
    println("=======> Connected to DB")
  }
}