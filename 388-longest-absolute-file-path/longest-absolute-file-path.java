class Solution {
    public int lengthLongestPath(String input) {
        
        Map<Integer, Integer> pathLen = new HashMap<>();
        pathLen.put(0, 0);
        int maxLen = 0;

       
        for (String line : input.split("\n")) {
           
            String name = line.replaceAll("^\t+", "");
            
            int depth = line.length() - name.length();

            if (name.contains(".")) {
                
                int currLen = pathLen.get(depth) + name.length();
                maxLen = Math.max(maxLen, currLen);
            } else {
               
                pathLen.put(depth + 1, pathLen.get(depth) + name.length() + 1); 
            }
        }
        return maxLen;
    }
}
