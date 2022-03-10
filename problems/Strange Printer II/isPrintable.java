class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        int tl[][] = new int[61][2];
        int br[][] = new int[61][2];
        HashSet<Integer> colorSet=new HashSet<>();

        for (int i = 0; 61 > i; ++i) {
            Arrays.fill(tl[i],61);
        }

        for (int i = 0; targetGrid.length > i; ++i) {
            for (int j = 0; targetGrid[0].length > j; ++j) {
                int color=targetGrid[i][j];

                colorSet.add(color);
                tl[color][0] = Math.min(tl[color][0],i);
                tl[color][1] = Math.min(tl[color][1],j);
                br[color][0] = Math.max(br[color][0],i);
                br[color][1] = Math.max(br[color][1],j);
            }
        }

        while (0 < colorSet.size()) {
            HashSet<Integer> next = new HashSet<>();

            for (int color : colorSet) {
                if(!canRemove(color,tl[color],br[color],targetGrid)) {
                    next.add(color);
                }
            }
            if (colorSet.size() == next.size()){
                return false;
            }
            colorSet = next;
        }

        return true;
    }

    boolean canRemove(int color,int tl[],int br[],int targetGrid[][]){
        for (int i = tl[0]; br[0] >= i; ++i) {
            for (int j = tl[1]; br[1] >= j; ++j) {
                if (0 != targetGrid[i][j] && color != targetGrid[i][j]) {
                    return false;
                }
            }
        }

        for (int i = tl[0]; br[0] >= i; ++i) {
            for (int j = tl[1]; br[1] >= j; ++j) {
                targetGrid[i][j] = 0;
            }
        }

        return true;
    }
}
