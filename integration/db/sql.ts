import postgres from "postgres";

const sql = postgres({
  host: 'db',
  port: 5432,
  database: 'demco_ff',
  username: 'test',
  password: 'password'
});

export default sql