/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function(version1, version2) {
    const [a, b] = [version1, version2].map(ver => ver.split('.'));
    const n1 = a.length;
    const n2 = b.length;
    
    for (let i = 0; Math.max(n1, n2) > i; ++i) {
        const i1 = i < n1 ? +a[i] : 0;
        const i2 = i < n2 ? +b[i] : 0;
        
        if (i1 !== i2) {
            return i1 > i2 ? 1 : -1;
        }
    }
    
    return 0;
};
