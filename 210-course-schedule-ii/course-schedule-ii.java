class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] i : prerequisites){
            int u = i[0];
            int v = i[1];
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[numCourses];
        boolean[] rs = new boolean[numCourses];
        for(int i = 0; i <numCourses;i++){
            if(!vis[i]){
                if(CycleCheck(adj, vis, i , rs)){
                    return new int[] {};
                }
            }
        }
        Arrays.fill(vis,false);
        Stack<Integer> st = new Stack<>();
        for(int i =0 ; i<numCourses;i++){
            if(!vis[i]){
                dfs(adj,vis,i,st);
            }
        }
        // Collections.reverse(st);
        int[] result = new int[numCourses];
        int i = 0;
        while(!st.isEmpty()){
            result[i] = st.pop();
            i++;
        }
        // result = Arrays.reverse(result);
        return result;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i , Stack<Integer> st){
        vis[i] = true;
        for(Integer n : adj.get(i)){
            if(!vis[n]){
                dfs(adj,vis,n,st);
            }
        }
        st.push(i);
    }

    boolean CycleCheck(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int i , boolean[] rs){
        vis[i] = true;
        rs[i] = true;

        for(Integer n : adj.get(i)){
            if(!vis[n]){
                if(CycleCheck(adj,vis,n,rs)){
                    return true;
                }
            }else if(rs[n]) return true;
        }
        rs[i] = false;
        return false;
    }
}