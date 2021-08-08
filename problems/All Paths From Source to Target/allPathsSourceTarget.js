/**
 * @param {number[][]} graph
 * @return {number[][]}
 */
var allPathsSourceTarget = function(graph) {
    const result = [];

    dfs(graph, [], result, 0);

    return result;
};

const dfs = function(graph, path, result, idx) {
    path.push(idx);

    if (graph.length == 1 + idx) {
        result.push(path);
    } else {
        for (const child of graph[idx]) {
            dfs(graph, [...path], result, child);
        }
    }
}
