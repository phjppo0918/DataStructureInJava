class Sort{
  int i=0;
  public int partition(int a[], int begin, int end){
    int pivot, temp, L, R, t;

    L = begin;
    R = end;
    pivot = (begin + end)/2;
    System.out.printf("\n [퀵정렬 %d 단계 : pivot=%d ]\n", ++i, a[pivot]);
    while(L<R) {
      while((a[L]<a[pivot]) && (L<R)){
        L++;
      }
      while((a[R]>=a[pivot]) && (L<R)){
        R--;
      }

      if(L<R){
        temp = a[L];
        a[L] = a[R];
        a[R] = temp;


        if(L==pivot) { //L과 R 원소를 교환하여, 결과적으로 피봇 원소의 위치가 변경된 경우
          for(t=0; t<a.length;t++){
            System.out.printf("%3d ",a[t]);
          }
          System.out.println();
        
          return R;
        }
      }
    }

    //(L==R)이 된 경우
    temp = a[pivot];
    a[pivot] = a[R];
    a[R] = temp;
    for(t=0;t<a.length;t++){
      System.out.printf("%3d ", a[t]);
    }
    System.out.println();
    return R;
  }

  public void quickSort(int a[], int begin, int end){
    if(begin < end) {
      int p;
      p = partition(a, begin, end);
      quickSort(a,begin,p-1);
      quickSort(a, p+1, end);
    }
  }
}

public class Example3 {
  public static void main(String [] args){
    int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
    Sort S = new Sort();
    System.out.printf("\n 정렬할 원소 : ");
    for(int i=0; i<a.length; i++){
      System.out.printf("%3d", a[i]);
    }
    System.out.println();
    S.quickSort(a, 0, 7);
  }
}