package cn.yy.test;

public class Sort {
    public static void main(String[] args) {

        int[] array={5,4,7,1,3,2,6};
//        int[] array={50,44,77,11,300,25,600};

//        maoPaoSort(array);
//        selectSort(array);
//        insertSort(array);
//        shellSort(array);
        heapSort(array);
        for(int a:array){
            System.out.println(a);
        }


    }

    /*
     * 写一个方法专门用来交换两个元素的位置
     * */
    public  static  void swap(int[] array,int i,int j){
        array[i]=array[i]+array[j];
        array[j]=array[i]-array[j];
        array[i]=array[i]-array[j];
    }

    /*
    * 冒泡排序
    * */
    public static int[] maoPaoSort(int[] array){
        int len=array.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1-i;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
        return array;
    }

    /*
     * 选择排序
     * */
    public static int[] selectSort(int[] array){
        int len=array.length;
        for(int i=0;i<len-1;i++){
            int minIndex=i;
            for(int j=i+1;j<len;j++){
                if(array[minIndex]>array[j]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                swap(array,i,minIndex);
            }
        }
        return array;
    }

    /*
     * 插入排序
     * */
    public static int[] insertSort(int[] array){
        int len=array.length;
        for(int i=1;i<len;i++){
            for(int j=i-1;j>=0;j--){
                if(array[i-1]<=array[i]){
                    break;
                }else if(array[j]>=array[i]){
                    if(j==0){
                        int temp=array[i];
                        for(int k=i;k>0;k--){
                            array[k]=array[k-1];
                        }
                        array[0]=temp;
                        break;
                    }
                    continue;
                }else if(array[j]<=array[i]){
                    int temp=array[i];
                    for(int k=i;k>j;k--){
                        array[k]=array[k-1];
                    }
                    array[j+1]=temp;
                    break;
                }
            }
        }
        return array;
    }


    /*
     * 希尔排序
     * */
    public static int[] shellSort(int[] array){
        int len=array.length;
        for(int gap=len/2;gap>0;gap=gap/2){
           for(int i=gap;i<len;i++){
               int j=i;
               while (j-gap>=0&&array[j]<array[j-gap]){
                   swap(array,j,j-gap);
                   j=j-gap;
               }
           }
        }
        return array;
    }


    /*
     * 堆排序
     * */
    public static int[] heapSort(int[] array){
        int len=array.length;
        //1.构建大顶堆，将刚刚开始的无序的数组根据堆排序思想构建成大顶堆。
        for(int i=len/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustMaxHeap(array,i,len);//这个方法能根据数组，根节点索引值，数组长度来调整结构，即根据根节点以及对应的左右子节点进行比较，并将最大的数字作为根节点（如果上面根节点的改变影响到了下面已经调整过的根节点，这个方法中也有措施能够解决）。
        }

        //2.调整堆结构+交换堆顶元素与末尾元素。在对数组进行过一次堆排序过后，开始进行根节点和数组最后一个元素替换并重新构建大顶堆直到排序完成。
        for(int j=array.length-1;j>0;j--){//注意j，即需要调整length-1次。
            swap(array,0,j);//将堆顶元素与末尾元素进行交换。注意这里的j，j一直在减小，因为每次根节点和最后一个元素交换过后，交换过的根节点就会被认为已经从数组中除去了。所以这里的长度一直在减少。
            adjustMaxHeap(array,0,j);//重新对堆进行调整
        }
        return array;
    }
    public static void adjustMaxHeap(int[] array,int root,int len){

        int temp=array[root];//先取出当前元素i
        for(int k=root*2+1;k<len;k=2*k+1){//从root结点的左子结点开始，也就是2*root+1处开始。k=root*2+1就是该根节点的左子节点；要小于数组长度；k目前是该根节点的左子节点，每循环一次，k就跳转到以这个左子节点为根的另一个小树结构的左子节点了。如果不懂，可以写一个数组，画图看看。
            if(k+1<len&&array[k]<array[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k=k+1;
            }
            if(array[k]>temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                array[root] = array[k];
                root=k;//将原本是根节点的左子节点的序号赋值给代表根节点序号的root，进行下一级别的调整
            }else {
                break;
            }
        }
        array[root]=temp;//将temp值放到最终的位置
    }

    /*
     * 自己写的堆排序
     *
    public static int[] heapSort2(int[] array){
        int len=array.length;
        //调整成为大顶堆
        for(int i=len/2-1;i>=0;i--){
            adjustMaxHeap2(array,i,len);
        }
        //进行排序
        int length=len;
        for(int i=len-1;i>0;i--){
            swap(array,0,i);
            if(i>1){
                for(int j=i/2-1;j>=0;j--){
                    adjustMaxHeap2(array,j,i);
                }
            }
        }
        return array;
    }
    public static void adjustMaxHeap2(int[] array,int root,int len){

        int k=2*root+1;
            if(k+1<len&&array[k]<array[k+1]){
                k=k+1;
            }
            if(array[k]>array[root]){
                swap(array,k,root);
                if(2*k+1<len){
                    adjustMaxHeap2(array,k,len);//如果下面还有子树，就递归
            }
        }
    }

    */



}
