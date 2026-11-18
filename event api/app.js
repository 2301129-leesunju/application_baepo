const express = require("express");
const app = express();
//express 를 호출하여 웹 애플리케이션을 구성할 객체를 생성
const port = 3000;
app.get("/", (req, res) => {
    res.send("서버켜졌다@!!!");
});

const db = require("./db");
app.get("/events", (req, res) => {
    const events= db.prepare("SELECT * FROM events").all();
    res.json(events);

});
//특정 id의 행상 조회
app.get("/events/:id", (req, res) => {
    const id = Number(req.params.id);
    if (!Number.isSafeInteger(id)||id<=0) {
    return res.status(400).json({
        message:"올바른 번호 입력해"
    });
    }
    const event = db.prepare("SELECT * FROM events WHERE id=?").get(id);
    if (!event) {
        return res.status(404).json({
            message: "그런거 없다"
        });
    }
    res.json(event);
});
app.use(express.json()); //json 령식으로 전달된 요청 본문을 읽도록 설정
app.post("/events", (req, res) => {
    const {title, capacity} = req.body||{};
    if (typeof(title) !== 'string' || title.trim() ==="" || !Number.isSafeInteger(capacity) || capacity <= 0) {
        return res.status(400).json({
            message:"너 잘못입력함"
        });
    }
const insert = db.prepare("INSERT INTO events(title,capacity) VALUES(?,?)");
    const result = insert.run(title.trim(), capacity);
    res.status(201).json({
        id : Number(result.lastInsertRowid),
        title : title.trim(),
        capacity: capacity
    });
});
app.put("/events/:id", (req, res) => {
    const id = Number(req.params.id);
    const {title,capacity} = req.body||{};
    if (typeof(title) !== 'string'||
    title.trim() ==="" || !Number.isSafeInteger(capacity)) {
        return res.status(400).json({
            message:"똑바로 입력할 것"
        });
    }
    const update = db.prepare("UPDATE events SET title=?, title=? WHERE id=?")
    const result = update.run(title.trim(), capacity,id);
    if (result.changes===0) {
        return res.status(404).json({
            message:"행사번호를 찾을 수 없다!!!!"
        });
    }
    const event =db.prepare("SELECT * FROM events WHERE id=?").get(id);
    res.status(200).json({event});
})
app.delete("/events/:id", (req, res) => {
    const id = Number(req.params.id);
    if (typeof(title) !== 'string'||
        title.trim() ==="" || !Number.isSafeInteger(capacity)) {
        return res.status(400).json({
            message:"똑바로 입력할 것"
        });
    }
    const remove = db.prepare("DELETE FROM events WHERE id=?").get(id);
    const result = remove.run(id);
    if (result.changes===0) {
        return res.status(404).json({
            message:"404!!! 잘못 입력했습니다"
        })
    }
    res.status(200).json({message:"정상적 종료",id:id});
})
app.listen(port, () => {
    console.log(`서버켜졌다!!!! : ${port} `);
});
