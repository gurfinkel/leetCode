class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> store = new Stack<>();
        String[] components = path.split("/");
        
        for (String component : components) {
            if (component.equals(".") || component.isEmpty()) {
                continue;
            } else if (component.equals("..")) {
                if (!store.isEmpty()) {
                    store.pop();
                }
            } else {
                store.add(component);
            }
        }

        while (!store.isEmpty()) {
            sb.insert(0, store.pop());
            sb.insert(0, "/");
        }

        return 0 < sb.length() ? sb.toString() : "/";
    }
}
