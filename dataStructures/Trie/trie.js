class TrieNode {
    constructor() {
        this.arr = new Array(26);
        this.isEnd = false;
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode();
    }

    insert(word) {
        const aCode = 'a'.charCodeAt();
        let currentNode = this.root;
        for (const letter of word) {
            const index = letter.charCodeAt() - aCode;
            if (!currentNode.arr[index]) {
                currentNode.arr[index] = new TrieNode();
            }
            currentNode = currentNode.arr[index];
        }
        currentNode.isEnd = true;
    }

    search(word) {
        const aCode = 'a'.charCodeAt();
        let currentNode = this.root;
        for (const letter of word) {
            const index = letter.charCodeAt() - aCode;
            if (currentNode.arr[index]) {
                currentNode = currentNode.arr[index];
            } else {
                return false;
            }
        }

        return currentNode.isEnd && this.root !== currentNode;
    }
}

module.exports = Trie;
