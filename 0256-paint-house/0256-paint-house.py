class Solution:
    def recurse(self, index, costs, prevColor, dp):
        if index == len(costs):
            return 0
        
        if (index, prevColor) in dp:
            return dp[index, prevColor]
        
        temp = 1e9
        for currColor in range(3):
            if currColor != prevColor:    
                temp = min(temp, costs[index][currColor] + self.recurse(index + 1, costs, currColor, dp))
                
        dp[index, prevColor] = temp    
        return temp        
            
        
    def minCost(self, costs: List[List[int]]) -> int:        
        n = len(costs)
        
        dp = {}
        
        return self.recurse(0, costs, -1, dp)
        
        