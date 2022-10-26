import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

object Connect {
  private lateinit var dataSource: HikariDataSource

  val db by lazy {
    // TODO: params should be env vars
    dataSource = hikari()
    val db = Database.connect(dataSource)
//    val db = Database.connect("jdbc:postgresql://db:5432/demco_ff", driver = "org.postgresql.Driver",
//    user = "test", password = "password")
    val dbUrl = db.url
    println("=======> Connected to DB: $dbUrl")
  }

  private fun hikari(): HikariDataSource {
    val config = HikariConfig("/hikari.properties")
    config.validate()
    return HikariDataSource(config)
  }
}