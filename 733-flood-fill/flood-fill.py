class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        rows=len(image)
        cols=len(image[0])
        start=image[sr][sc]
        queue=deque([(sr,sc)])
        visited=set([(sr,sc)])
        direct = [(0,1),(0,-1),(1,0),(-1,0)]
        while queue:
            row,col=queue.popleft()
            if image[row][col]==start:
                image[row][col]=color
            for dr,dc in direct:
                newrow=dr+row
                newcol=dc+col
                if 0 <= newrow < rows and 0 <= newcol < cols and (newrow,newcol) not in visited and image[newrow][newcol]==start:
                    visited.add((newrow,newcol))
                    queue.append((newrow,newcol))
        return image



        