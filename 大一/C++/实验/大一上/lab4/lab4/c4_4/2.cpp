extern int a;//��������a
int power(int m)
{ int i,c=1;//c�洢a^m��ֵ
	for(i=1;i<=m;++i)
		c*=a;
	return c;
}

