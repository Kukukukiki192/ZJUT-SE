extern int a;//声明对象a
int power(int m)
{ int i,c=1;//c存储a^m的值
	for(i=1;i<=m;++i)
		c*=a;
	return c;
}

