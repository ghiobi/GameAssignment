const http = require('http');
const cheerio = require('cheerio');
var fs = require('fs');

const requestGameById = function (id) {
    return new Promise((resolve, reject) => {
        http.get({
            hostname: 'thegamesdb.net',
            port: 80,
            path: '/game/' + id,
            agent: false
        }, (res) => {
            let body = '';

            if (res.statusCode !== 200) {
                resolve(null);
                return;
            }

            res.on('data', (chunk) =>
                body += chunk
            );
            res.on('end', () => {
                resolve(cheerio.load(body))
            });
        })
        .on('error', (e) => {
            resolve(null);
        });
    });
};


const extractGameInfo = function (body) {
    return body.then($ => {
        if (!$) {
            return null
        }

        const info = {};
        const $content = $('#gameWrapper');

        try {
            if ($("#gameWrapper #gameVitals").length) {
            		info['name'] = $content.find('#gameTitle h1').text();
                info['game_description'] = $content.find('#gameInfo > p').text();
                info['console'] = $content.find('#gameInfo > h2 > a').text();

                const game = $content.find('#gameVitals > p').text();
                info['num_player'] = game.match(/(Players:\s)(.+)(C)/)[2].trim();
                if (info['num_player'] === "N/A") {
                		info['num_player'] = 1;
                }
                info['coop'] = game.indexOf("No") === -1;
                	let genre = game.match(/(Genres:)(\s.+\s)(\n)/)[2].trim();
                if (genre === "N/A")
                		info['genre'] = null;
                else 
                		info['genre'] = genre;
                info['release_date'] = game.match(/\d+\/\d+\/\d+/)[0];
                info['developer'] = game.match(/(?:Developer:\s)(.+)(\n)/)[1].trim();
                info['publisher'] = game.match(/(?:Publisher:\s)(.+)(\n)/)[1].trim();
                
                if ($content.find("#gameCoversWrapper > p > a").length > 2) {
                    info['front_box_art'] = $content.find('#gameCoversWrapper > p > a:nth-child(3)').attr('href');
                    info['back_box_art'] = $content.find('#gameCoversWrapper > p > a:nth-child(5)').attr('href');
                } else {
                		info['front_box_art'] = $content.find('#gameCoversWrapper > p > a:nth-child(2)').attr('href')
                		info['back_box_art'] == null;
                }
                
                info['logo'] = $content.find('#gameInfo div > p > img:first-child').attr('src');
                info['developer_logo'] = $content.find('#gameVitals > p > img').last().attr('src');
                info['comments'] = null;

                console.log(info);
                return info;
            }
        } catch (err) { }

        return null;
    }, () => { })
};

let games = [];
for (let i = 100; i < 600; i++) {
    games.push(extractGameInfo(requestGameById(i)));
}


Promise.all(games).then(games => {
    let json = [];
    for (let game of games) {
        if (game) {
            json.push(game);
        }
    }
    const num = json.length;
    json = JSON.stringify(json);

    fs.writeFile("games.json", json, function(err) {
        if(err) {
            return console.log(err);
        }

        console.log("The file was saved!" + num);
    });

});

