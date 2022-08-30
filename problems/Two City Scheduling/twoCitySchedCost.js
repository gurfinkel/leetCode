/**
 * @param {number[][]} costs
 * @return {number}
 */
var twoCitySchedCost = function(costs) {
    const n = Math.trunc(costs.length/2);
    let result = 0;

    costs.sort((a,b)=>a[0]-a[1]-(b[0]-b[1]));

    for (let idx = 0; n > idx; ++idx) {
        result += costs[idx][0] + costs[n + idx][1];
    }

    return result;
};
