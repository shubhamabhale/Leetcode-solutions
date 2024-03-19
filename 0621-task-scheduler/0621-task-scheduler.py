import heapq

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        pq = []
        
        counters = defaultdict(int)
        
        for char in tasks:
            counters[char] += 1
            
        currCycle = 1
        
        for key, val in counters.items():
            heapq.heappush(pq, (currCycle, val, key))
            
            
        while pq:
            # print(pq)
            curr, freq, char = heapq.heappop(pq)
            
            if curr <= currCycle:
                # print(char)
                if freq >= 1:
                    freq -= 1
                    
                    if freq != 0:
                        curr = curr + n + 1
                        heapq.heappush(pq, (curr, freq, char))
            else:
                # print("idle")
                heapq.heappush(pq, (curr, freq, char))
            currCycle += 1
            
            
        return currCycle - 1
            
                    
                    
        