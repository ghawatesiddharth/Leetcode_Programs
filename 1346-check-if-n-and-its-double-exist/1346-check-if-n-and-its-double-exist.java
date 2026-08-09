class Solution {
    boolean isPresent(int[] arr,int d, int idx){
        for(int i = 0;i < arr.length; i++){
            if(arr[i]==d && i != idx)return true;
        }
        return false;
    }
    public boolean checkIfExist(int[] arr) {
        for(int i = 0;i < arr.length; i++){
            if(isPresent(arr,arr[i]*2,i))return true;
        }
        return  false;
    }
}