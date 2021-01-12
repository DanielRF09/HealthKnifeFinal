const mysql = require('mysql');

const connection = mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'n0m3l0',
    database:'testresultados'
})

connection.connect( (err) => {
    if (err) throw err
    console.log("Funcionando")
    
})

const insertarR = "INSERT INTO test (pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10, pregunta11, pregunta12, pregunta13, pregunta14, pregunta15, pregunta16, pregunta17, pregunta18, pregunta19, pregunta20) VALUES ('"+res1+"','"+res2+"',''"+res3+"','"+res4+"','"+res5+"','"+res6+"','"+res7+"','"+res8+"','"+res9+"','"+res10+"','"+res11+"','"+res12+"','"+res13+"','"+res14+"','"+res15+"','"+res16+"','"+res17+"','"+res18+"','"+res19+"','"+res20+"')"
connection.query(insertarR, (err) => {
    if (err) throw err
})

connection.end()