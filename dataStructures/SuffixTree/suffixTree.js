class Node {
    constructor() {
        this.transition = {};
        this.suffixLink = null;
    }
    
    addTransition(node, [start, end], t) {
        this.transition[t] = [node, start, end];
    }
    
    isLeaf() {
        return 0 === Object.keys(this.transition).length;
    }
}

class SuffixTree {
    constructor() {
        this.text = '';
        this.sentinel = '#';
        
        this.root = new Node();
        this.bottom = new Node();
        this.root.suffixLink = this.bottom;
        
        this.s = this.root;
        this.k = 0;
        this.i = -1;
    }
    
    
    addString(str) {
        var temp = this.text.length;
        this.text += (temp) ? this.sentinel + str : str;
        
        var [s, k, i] = [this.s, this.k, this.i];
        
        for (var j = temp; this.text.length > j; ++j) {
            this.bottom.addTransition(this.root, [j, j], this.text[j]);
        }
        
        while (this.text[i + 1]) {
            ++i;
            [s, k] = this.update(s, [k, i]);
            [s, k] = this.canonize(s, [k, i]);
        }
        
        [this.s, this.k, this.i] = [s, k, i];
        
        return this;
    }
    
    update(s, [k, i]) {
        var oldr = this.root;
        var [endPoint, r] = this.testAndSplit(s, [k, i - 1], this.text[i]);
        
        while(!endPoint) {
            r.addTransition(new Node(), [i, Infinity], this.text[i]);
            
            if(oldr !== this.root) {
                oldr.suffixLink = r;
            }
            
            oldr = r;
            [s, k] = this.canonize(s.suffixLink, [k, i - 1]);
            [endPoint, r] = this.testAndSplit(s, [k, i - 1], this.text[i]);
        }
        
        if(oldr !== this.root) {
            oldr.suffixLink = s;
        }
        
        return [s, k];
    }
    
    
    testAndSplit(s, [k, p], t) {
        if (k <= p) {
            var [s2, k2, p2] = s.transition[this.text[k]];
            
            if (t == this.text[k2 + p - k + 1]) {
                return [true, s];
            } else {
                var r = new Node();
                s.addTransition(r, [k2, k2 + p - k], this.text[k2]);
                r.addTransition(s2, [k2 + p - k + 1, p2], this.text[k2 + p - k + 1]);
                
                return [false, r];
            }
        } else {
            if(!s.transition[t]) {
                return [false, s];
            } else {
                return [true, s];
            }
        }
    }
    
    canonize(s, [k, p]) {
        if (p < k) {
            return [s, k];
        } else {
            var [s2, k2, p2] = s.transition[this.text[k]];
            
            while (p2 - k2 <= p - k) {
                k = k + p2 - k2 + 1;
                s = s2;
                
                if (k <= p) {
                    [s2, k2, p2] = s.transition[this.text[k]];
                }
            }
            
            return [s, k];
        }
    }
    
    findLongestCommonSubstring() {
        const [text, root] = [this.text, this.root];
        const indexOfSentinel = text.indexOf(this.sentinel);
        let commonSubstring = '';
        
        if (-1 === indexOfSentinel) {
            return commonSubstring;
        }
        
        (function traverse(node, curStr = '') {
            if (node.isLeaf()) return;
            
            for (const t in node.transition) {
                const [currentNode, startIndex, endIndex] = node.transition[t];
                
                let left = false;
                let right = false;
                
                for (const temp in currentNode.transition) {
                    const [s, a, b] = currentNode.transition[temp];
                    if (indexOfSentinel >= a) {
                        left = true;
                    }
                    if (indexOfSentinel < a) {
                        right = true;
                    }
                }
                
                if (!left || !right) {
                    continue;
                }
                
                if (!currentNode.isLeaf()) {
                    const curSubStr = text.substring(startIndex, endIndex + 1);
                    let curCurStr = curStr;
                    
                    curCurStr = (node === root) ? curSubStr : curCurStr + curSubStr;
                    
                    if (curCurStr.length > commonSubstring.length) {
                        commonSubstring = curCurStr;
                    }
                    
                    traverse(currentNode, curCurStr);
                }
            }
        })(root);
        
        return commonSubstring;
    }
    
    toString() {
        var text = this.text;
        
        function traverse(node, offset = '', ret = '') {
            for(var t in node.transition) {
                var [s, a, b] = node.transition[t];
                ret += offset + '["' + text.substring(a, b + 1) + '", ' + a + ', ' + b + ']' + '\r\n';
                ret += traverse(s, offset+'\t');
            }
            
            return ret;
        }
        
        var res = traverse(this.root);
        
        return res;
    }
    
    print() {
        console.log(this.toString());
    }
}

module.exports = SuffixTree;
