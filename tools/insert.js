const fs = require('fs');
const mysql = require('mysql');
const moment = require('moment');

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
    game.release_date = moment(game.release_date, "MM/DD/YYYY").format('YYYY/MM/DD');
    game.price = Math.floor(Math.random() * 20 + 5);
    game.discount = Math.random() < .10 ? Math.floor(Math.random() * game.price) :  null;
    delete game.comments;
    promises.push(new Promise((resolve) => {
        connection.query('INSERT INTO games SET ?', game, function (error, results, fields) {
            if (error) throw error;
            resolve(true);
        });
    }));
}

Promise.all(promises);

connection.end();