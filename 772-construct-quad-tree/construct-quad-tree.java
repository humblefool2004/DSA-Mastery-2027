/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return makeQuadTree(0,0,grid.length,grid);
    }

    private Node makeQuadTree(int startI,int startJ,int size,int[][] grid){
        if(isLeaf(startI,startJ,size,grid)){
            return new Node(grid[startI][startJ]==1,true);
        }
        size/= 2;

        return new Node(true,
            false,
            makeQuadTree(startI,startJ,size,grid),
            makeQuadTree(startI,startJ+size,size,grid),
            makeQuadTree(startI+size,startJ,size,grid),
            makeQuadTree(startI+size,startJ+size,size,grid));
    }

    private boolean isLeaf(int startI,int startJ, int size,int[][] grid){
        int a=grid[startI][startJ];
        for(int i=startI;i<startI+size;i++){
            for(int j =startJ;j<startJ+size;j++){
                if(grid[i][j]!=a) return false; 
            }
        }
        return true;
    }
}