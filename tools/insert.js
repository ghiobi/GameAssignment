const fs = require('fs');
const mysql = require('mysql');

var connection = mysql.createConnection({
    host     : 'localhost',
    user     : 'root',
    password : '',
    database : 'games'
});

connection.connect();

const games = require('./games.json');

let promises = [];

for (let game of games) {
    promises.push(new Promise((resolve) => {
        connection.query('INSERT INTO games SET ?', game, function (error, results, fields) {
            if (error) throw error;
            resolve(true);
        });
    }));
}

Promise.all(promises);

connection.end();