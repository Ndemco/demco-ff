import org.jetbrains.exposed.sql.Database

object Connect {
  val db by lazy {
    val db = Database.connect("jdbc:postgresql://db:5432/demco_ff", driver = "org.postgresql.Driver",
    user = "test", password = "password")
    val dbUrl = db.url
    println("=======> Connected to DB: $dbUrl")
  }
}