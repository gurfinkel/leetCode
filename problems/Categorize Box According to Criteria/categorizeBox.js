/**
 * @param {number} length
 * @param {number} width
 * @param {number} height
 * @param {number} mass
 * @return {string}
 */
var categorizeBox = function(length, width, height, mass) {
    const volume = length*width*height;
    if ((10_000 <= length || 10_000 <= width || 10_000 <= height || 1_000_000_000 <= volume) && (100 <= mass)) {
        return "Both";
    } else if ((10_000 <= length || 10_000 <= width || 10_000 <= height || 1_000_000_000 <= volume) && (100 > mass)) {
        return "Bulky";
    } else if ((10_000 > length && 10_000 > width && 10_000 > height && 1_000_000_000 > volume) && (100 <= mass)) {
        return "Heavy";
    } else if (10_000 <= length || 10_000 <= width || 10_000 <= height || 1_000_000_000 <= volume) {
        return "Bulky";
    } else if (100 <= mass) {
        return "Heavy";
    }

    return "Neither";
};
