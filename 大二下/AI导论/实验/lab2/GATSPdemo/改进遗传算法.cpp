#include<iostream>
#include<vector>
#include<cmath>
#include<algorithm>
#include<ctime>
#include<time.h>
using namespace std;

/*改进遗传算法的C++实现。种群初始化采用联赛竞争，保证种群基因优良；
轮盘赌选择略有改进；交叉变异概率自适应，相比固定的概率效果提升极为明显。
变异步长自适应，避免固定步长找不到最优解的风险。
用复杂变态多峰函数测试效果十分不错，相比二进制编码遗传算法精度优势明显。*/

//初始化种群的方法      加入了轮盘赌的思想
void Population::Initial_Population()
{
	//这里的随机函数rand()需要随机数种子，先写在这里，看后面需不要变动
	Pc_ = Pc;
	Pm_ = Pm;
	Generation_ = 0;
	std::vector<Individual> Genometemp;
	srand((unsigned int) time(NULL));
	vecPop_.clear();
	vecBestIndividual_.clear();
	Genometemp.clear();
	//vecParentsBabiesRoom_.clear();
	for (int i = 0; i < POPULATION_SIZE; ++i)                     //产生种群数目的个体
	{
		for (int i = 0; i < POPULATION_SIZE; ++i)  
		{
			Genometemp.push_back(Individual());                                //没这句会报vector subscript out of rang
			//vecParentsBabiesRoom_.push_back(Individual());
			//开始的时候直接用的等号赋值，不对的，对向量插入要用push_back   =用于修改
			Genometemp[i].Genome_.push_back((rand() / double(RAND_MAX)) * (GENOME1_RIGHT - GENOME1_LEFT) + GENOME1_LEFT);
			Genometemp[i].Genome_.push_back((rand() / double(RAND_MAX)) * (GENOME2_RIGHT - GENOME2_LEFT) + GENOME2_LEFT);
		}
		for (int i = 0; i < POPULATION_SIZE; ++i)
		{
			double x1 = Genometemp[i].Genome_[0];
			double x2 = Genometemp[i].Genome_[1];
		    Genometemp[i].Fitness_ = 21.5 + x1 * sin(4 * 3.1415926*x1) + x2 * sin(20 * 3.1415926*x2);
			//Genometemp[i].Fitness_ = 1 + x1*exp(-x1*x1 - x2*x2);
			//Genometemp[i].Fitness_ = 1 + sin(sqrt(x1*x1 + x2*x2)) / sqrt(x1*x1 + x2*x2);
			//Genometemp[i].Fitness_ = x1*x1 + x2*x2;
			//Genometemp[i].Fitness_ = pow(x1*x1+x2*x2,0.25)*(1+sin(50*pow(x1*x1 + x2*x2, 0.1))*sin(50 * pow(x1*x1 + x2*x2, 0.1)));
			//Genometemp[i].Fitness_ = x1*x1 - cos(18 * x1) + x2*x2 - cos(18 * x2) + 3;
			//Genometemp[i].Fitness_ = 0.5 - (sin(sqrt(x1*x1 + x2*x2))*sin(sqrt(x1*x1 + x2*x2)) - 0.5) / ((1 + 0.001*(x1*x1 + x2*x2))*(1 + 0.001*(x1*x1+ x2*x2)));
			//std::cout << "个体 " << i << "     基因位1： " << x1 << "   基因位2：  " << x2 <<"    适应度： "<< vecPop_[i].Fitness_ << std::endl;
		}
		sort(Genometemp.begin(), Genometemp.end());
		vecPop_.push_back(Genometemp[0]);
		Genometemp.clear();
	}
}


#if 1
//******************************************************************************************************
//轮盘法
//选中后新的个体就不会再参与下一轮选择了
//******************************************************************************************************
void Population::Selection()
{
	vecParentsBabiesRoom_.clear();
	for (int i = 0; i < (POPULATION_SIZE / 2); ++i)               //选择一半个体体进行繁衍
	{
		Seqencing(vecPop_);
		double sum = 0;
		double randomnumber = (rand() / (double)RAND_MAX)*totalfitness_;
		std::vector<Individual>::iterator it;
		for (it = vecPop_.begin(); it != vecPop_.end(); ++ it )      
		{
			sum += (*(it)).Fitness_;
			if (sum >= randomnumber)
			{
				vecParentsBabiesRoom_.push_back(*it);
			    vecPop_.erase(it);
				break;
			}
		}
	}
}
#endif

//实数编码
#if 1
void Population::crossover()
{
	Individual childgenome1 = Individual();          //定一个子代染色体的局部变量
	Individual childgenome2 = Individual();          //采用一对夫器产两个子代的方法
	double a1 = 0, a2 = 0, r1 = 0, r2 = 0;
	double genome11 = 0, genome12 = 0, genome21 = 0, genome22 = 0;
	std::vector<Individual>::iterator it;
	for (int i = 0; i <POPULATION_SIZE / 4; ++i)                                 //为什么是八呢?,32个个体 16个被选择做父代，形成8对父母
	{
		if ((rand() / (double)RAND_MAX) <= Pc_)           //设定了70%的基因交叉概率 交叉方法用的是 适合实数的融合交叉
		{
			a1 = rand() / (double)RAND_MAX;
			a2 = rand() / (double)RAND_MAX;
			r1 = rand() / (double)RAND_MAX;
			r2 = rand() / (double)RAND_MAX;
			genome11 = a1*(vecParentsBabiesRoom_[2 * i].Genome_[0] - vecParentsBabiesRoom_[2 * i + 1].Genome_[0]) + r1*vecParentsBabiesRoom_[2 * i].Genome_[0] + (1 - r1)*vecParentsBabiesRoom_[2 * i + 1].Genome_[0];
			genome21 = a1*(vecParentsBabiesRoom_[2 * i].Genome_[0] - vecParentsBabiesRoom_[2 * i + 1].Genome_[0]) + r1*vecParentsBabiesRoom_[2 * i + 1].Genome_[0] + (1 - r1)*vecParentsBabiesRoom_[2 * i].Genome_[0];
			genome12 = a2*(vecParentsBabiesRoom_[2 * i].Genome_[1] - vecParentsBabiesRoom_[2 * i + 1].Genome_[1]) + r2*vecParentsBabiesRoom_[2 * i].Genome_[1] + (1 - r2)*vecParentsBabiesRoom_[2 * i + 1].Genome_[1];
			genome22 = a2*(vecParentsBabiesRoom_[2 * i].Genome_[1] - vecParentsBabiesRoom_[2 * i + 1].Genome_[1]) + r2*vecParentsBabiesRoom_[2 * i + 1].Genome_[1] + (1 - r2)*vecParentsBabiesRoom_[2 * i].Genome_[1];
			if (genome11 > 12.1 || genome11 < (-3.0) || genome21 > 12.1 || genome21 < (-3.0))
			{
				genome11 = r1*vecParentsBabiesRoom_[2 * i].Genome_[0] + (1 - r1)*vecParentsBabiesRoom_[2 * i + 1].Genome_[0];
				genome21 = r1*vecParentsBabiesRoom_[2 * i + 1].Genome_[0] + (1 - r1)*vecParentsBabiesRoom_[2 * i].Genome_[0];
			}
			if (genome12 > 5.8 || genome12 < 4.1 || genome22 > 5.8 || genome22 < 4.1)
			{
				genome12 = r2*vecParentsBabiesRoom_[2 * i].Genome_[1] + (1 - r2)*vecParentsBabiesRoom_[2 * i + 1].Genome_[1];
				genome22 = r2*vecParentsBabiesRoom_[2 * i + 1].Genome_[1] + (1 - r2)*vecParentsBabiesRoom_[2 * i].Genome_[1];
			}
			childgenome1.Genome_.push_back(genome11);
			childgenome1.Genome_.push_back(genome12);
			childgenome2.Genome_.push_back(genome21);
			childgenome2.Genome_.push_back(genome22);
			vecParentsBabiesRoom_.push_back(childgenome1);
			vecParentsBabiesRoom_.push_back(childgenome2);
            childgenome2.Genome_.clear();
            childgenome1.Genome_.clear();
		}
		else //不交叉的时候，子代由父代基因偏离
		{
			vecParentsBabiesRoom_.push_back(vecParentsBabiesRoom_[2 * i]);
			vecParentsBabiesRoom_.push_back(vecParentsBabiesRoom_[2 * i + 1]);
		}
	}
}
#endif
