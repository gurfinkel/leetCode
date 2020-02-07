const assert = require('assert');

const Trie = require('./trie');

function runSortHotelListTests() {
    const sortHotelList = function(keywords, hotelIds, reviews) {
        let result = [];

        if (!keywords || !reviews.length) {
            return result;
        }

        const arrKeys = keywords.split(' ');

        if (!arrKeys.length) {
            return result;
        }

        const trie = new Trie();

        for (const arrKey of arrKeys) {
            trie.insert(arrKey);
        }

        const dict = new Map();

        for (let i = 0; reviews.length > i; ++i) {
            const arrReviews = reviews[i].toLowerCase().match(/\b(\w+)\b/g);
            const count = arrReviews.reduce((total, item) => total + trie.search(item), 0);

            if (!dict.has(hotelIds[i])) {
                dict.set(hotelIds[i], count);
            } else {
                dict.set(hotelIds[i], dict.get(hotelIds[i]) + count);
            }
        }

        if (0 < dict.size) {
            result = [...dict.entries()].sort((a, b) => b[1] - a[1]).map(item => item[0]);
        }

        return result;
    };

    const keywords = 'breakfast beach citycenter location metro view staff price';
    const hotelIds = [1, 2, 1, 1, 2];
    const reviews = [
        'This hotel has a nice view of the citycenter. The location is perfect.',
        'The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.',
        'Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.',
        "They said I couldn't take my dog and there were other guests with dogs! That is not fair.",
        'Very friendly staff and good cost-benefit ration. Its location is a bit far from citycenter.'
    ];

    assert.deepEqual(sortHotelList(keywords, hotelIds, reviews), [2, 1], '1) Should be [2, 1]');
}

runSortHotelListTests();
