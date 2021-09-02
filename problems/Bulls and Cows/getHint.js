/**
 * @param {string} secret
 * @param {string} guess
 * @return {string}
 */
var getHint = function(secret, guess) {
    const n = secret.length;
    const keepSecret = Array(10).fill(0);
    let bulls = 0;
    let cows = 0;

    for (let i = 0; n > i; ++i) {
        if(secret[i] === guess[i]) {
            ++bulls;
        } else {
            ++keepSecret[+secret[i]];
        }
    }

    for (let i = 0; n > i; ++i) {
        if (keepSecret[+guess[i]] && secret[i] !== guess[i]) {
            --keepSecret[+guess[i]];
            ++cows;
        }
    }

    return `${bulls}A${cows}B`;
};
