class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }
    private Node dfs(Node node, Map<Node,Node> map){
      if(map.containsKey(node))return map.get(node);
      Node clone = new Node(node.val);
      map.put(node,clone);
      for(Node n:node.neighbors){
        clone.neighbors.add(dfs(n,map));
      }
      return clone;
    }

}