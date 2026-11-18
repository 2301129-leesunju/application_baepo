const {DatabaseSync}=require('node:sqlite');
/*
* {} : 구조 분해 할당
* const sqlite = require("node:sqlite");
* const DatabaseSync = sqlite.DatabaseSync;
*
*
* */
const db =new DatabaseSync("event.db");
console.log("db 연결 성공했다");
db.exec('CREATE TABLE IF NOT EXISTS events(id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT NOT NULL, capacity INTEGER NOT NULL)');
console.log("테이블 생성 완료했다");

module.exports = db;
