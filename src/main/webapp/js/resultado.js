//ARCHIVO DE PRUEBA. NO HACER CASO

/*function cuestion(pregunta_1, pregunta_2, pregunta_3, pregunta_4, pregunta_5, pregunta_6, pregunta_7, pregunta_8, pregunta_9, pregunta_10
    , pregunta_11, pregunta_12, pregunta_13, pregunta_14, pregunta_15, pregunta_16, pregunta_17, pregunta_18, pregunta_19, pregunta_20, action) {
    this.pregunta_1 = pregunta_1;
    this.pregunta_2 = pregunta_2;
    this.pregunta_3 = pregunta_3;
    this.pregunta_4 = pregunta_4;
    this.pregunta_5 = pregunta_5;
    this.pregunta_6 = pregunta_6;
    this.pregunta_7 = pregunta_7;
    this.pregunta_8 = pregunta_8;
    this.pregunta_9 = pregunta_9;
    this.pregunta_10 = pregunta_10;
    this.pregunta_11 = pregunta_11;
    this.pregunta_12 = pregunta_12;
    this.pregunta_13 = pregunta_13;
    this.pregunta_14 = pregunta_14;
    this.pregunta_15 = pregunta_15;
    this.pregunta_16 = pregunta_16;
    this.pregunta_17 = pregunta_17;
    this.pregunta_18 = pregunta_18;
    this.pregunta_19 = pregunta_19;
    this.pregunta_20 = pregunta_20;
    this.action = action;

}

cuestion.prototype.AddUser = function(){
    $.ajax({
        type: "POST",
        url: this.action,
        data: {
            pre_1 = this.pregunta_1,
            pre_2 = this.pregunta_2,
            pre_3 = this.pregunta_3,
            pre_4 = this.pregunta_4,
            pre_5 = this.pregunta_5,
            pre_6 = this.pregunta_6,
            pre_7 = this.pregunta_7,
            pre_8 = this.pregunta_8,
            pre_9 = this.pregunta_9,
            pre_10 = this.pregunta_10,
            pre_11 = this.pregunta_11,
            pre_12 = this.pregunta_12,
            pre_13 = this.pregunta_13,
            pre_14 = this.pregunta_14,
            pre_15 = this.pregunta_15,
            pre_16 = this.pregunta_16,
            pre_17 = this.pregunta_17,
            pre_18 = this.pregunta_18,
            pre_19 = this.pregunta_19,
            pre_20 = this.pregunta_20,
        },
        success: function (response) {
            if (response == 1) {
                alert("Resultados insertados");
            }
        }
    });
}
function guardarR() {
    var res1, res2, res3, res4, res5, res6, res7, res8, res9, res10, res11, res12, res13, res14, res15, res16, res17, res18, res19, res20;
*/
const mysql = require('mysql');
const squel = require('squel');

let conexion = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    passwors: 'n0m3l0',
    database: 'testResultados'
});

conexion.connect;

insertarR = squel.insert()
    .into("test")
    .setFieldsRows([
        { pregunta1: res1, 
            pregunta2: res2,
            pregunta3: res3,
            pregunta4: res4,
            pregunta5: res5,
            pregunta6: res6,
            pregunta7: res7,
            pregunta8: res8,
            pregunta9: res9,
            pregunta10: res10,
            pregunta11: res11,
            pregunta12: res12,
            pregunta13: res13,
            pregunta14: res14,
            pregunta15: res15,
            pregunta16: res16,
            pregunta17: res17,
            pregunta18: res18,
            pregunta19: res19,
            pregunta20: res20, }
    ])
    .toString()

//}
