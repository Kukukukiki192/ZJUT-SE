

//求解最优值
void LCSLength(int m，int n，char *x，char *y，int **c，int **b){  
    int i，j;
    for (i = 1; i <= m; i++) c[i][0] = 0; //处理j=0的情况
    for (i = 1; i <= n; i++) c[0][i] = 0; //处理i=0的情况
    for (i = 1; i <= m; i++) //处理i,j均不等于0的情况
        for (j = 1; j <= n; j++){
            if (x[i]==y[j]) { c[i][j]=c[i-1][j-1]+1; b[i][j]=1; }
            else if (c[i-1][j]>=c[i][j-1]) { c[i][j]=c[i-1][j]; b[i][j]=2; }
            else { c[i][j]=c[i][j-1]; b[i][j]=3; }
        }
}
/*
1) 数组c用于保存X和Y的最长 子序列长度；
2) 数组b[i][j]用于保存c[i][j]是由哪个子问题求解得到的；
3) 算法时间复杂度为：O(mn)
*/ 

//构造最长公共子序列
void LCS(int i，int j，char *x，int **b){
    if (i ==0 || j==0) return;
    if (b[i][j]== 1){ 
        LCS(i-1，j-1，x，b); cout<<x[i];
    } 
	else if (b[i][j]== 2) LCS(i-1，j，x，b);
    else LCS(i，j-1，x，b);
}
/*
1) 当b[i][j]=1时，表示Xi和Yj的最长公共子序列为Xi-1和Yj-1的最长公共子序列加上xi组成 
2) 当b[i][j]=2时，表示Xi和Yj的最长公共子序列与Xi-1和Yj的最长公共子序列相同；
3) 当b[i][j]=3时，表示Xi和Yj的最长公共子序列与Xi-和Yj-1的最长公共子序列相同；
4) LCS算法的时间复杂度为：O(m+n)。
*/
