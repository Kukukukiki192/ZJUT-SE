#include<iostream>
#include<vector>
#include<cmath>
#include<algorithm>
#include<ctime>
#include<time.h>
using namespace std;

/*�Ľ��Ŵ��㷨��C++ʵ�֡���Ⱥ��ʼ������������������֤��Ⱥ����������
���̶�ѡ�����иĽ�����������������Ӧ����ȹ̶��ĸ���Ч��������Ϊ���ԡ�
���첽������Ӧ������̶������Ҳ������Ž�ķ��ա�
�ø��ӱ�̬��庯������Ч��ʮ�ֲ�����ȶ����Ʊ����Ŵ��㷨�����������ԡ�*/

//��ʼ����Ⱥ�ķ���      ���������̶ĵ�˼��
void Population::Initial_Population()
{
	//������������rand()��Ҫ��������ӣ���д������������費Ҫ�䶯
	Pc_ = Pc;
	Pm_ = Pm;
	Generation_ = 0;
	std::vector<Individual> Genometemp;
	srand((unsigned int) time(NULL));
	vecPop_.clear();
	vecBestIndividual_.clear();
	Genometemp.clear();
	//vecParentsBabiesRoom_.clear();
	for (int i = 0; i < POPULATION_SIZE; ++i)                     //������Ⱥ��Ŀ�ĸ���
	{
		for (int i = 0; i < POPULATION_SIZE; ++i)  
		{
			Genometemp.push_back(Individual());                                //û���ᱨvector subscript out of rang
			//vecParentsBabiesRoom_.push_back(Individual());
			//��ʼ��ʱ��ֱ���õĵȺŸ�ֵ�����Եģ�����������Ҫ��push_back   =�����޸�
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
			//std::cout << "���� " << i << "     ����λ1�� " << x1 << "   ����λ2��  " << x2 <<"    ��Ӧ�ȣ� "<< vecPop_[i].Fitness_ << std::endl;
		}
		sort(Genometemp.begin(), Genometemp.end());
		vecPop_.push_back(Genometemp[0]);
		Genometemp.clear();
	}
}


#if 1
//******************************************************************************************************
//���̷�
//ѡ�к��µĸ���Ͳ����ٲ�����һ��ѡ����
//******************************************************************************************************
void Population::Selection()
{
	vecParentsBabiesRoom_.clear();
	for (int i = 0; i < (POPULATION_SIZE / 2); ++i)               //ѡ��һ���������з���
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

//ʵ������
#if 1
void Population::crossover()
{
	Individual childgenome1 = Individual();          //��һ���Ӵ�Ⱦɫ��ľֲ�����
	Individual childgenome2 = Individual();          //����һ�Է����������Ӵ��ķ���
	double a1 = 0, a2 = 0, r1 = 0, r2 = 0;
	double genome11 = 0, genome12 = 0, genome21 = 0, genome22 = 0;
	std::vector<Individual>::iterator it;
	for (int i = 0; i <POPULATION_SIZE / 4; ++i)                                 //Ϊʲô�ǰ���?,32������ 16����ѡ�����������γ�8�Ը�ĸ
	{
		if ((rand() / (double)RAND_MAX) <= Pc_)           //�趨��70%�Ļ��򽻲���� ���淽���õ��� �ʺ�ʵ�����ںϽ���
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
		else //�������ʱ���Ӵ��ɸ�������ƫ��
		{
			vecParentsBabiesRoom_.push_back(vecParentsBabiesRoom_[2 * i]);
			vecParentsBabiesRoom_.push_back(vecParentsBabiesRoom_[2 * i + 1]);
		}
	}
}
#endif
