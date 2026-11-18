const db = require("./db");
const insert = db.prepare("INSERT INTO events(title,capacity) VALUES(?,?) ");
insert.run("파이썬",20);
insert.run("spring",25);
console.log("입력완료@@@@")